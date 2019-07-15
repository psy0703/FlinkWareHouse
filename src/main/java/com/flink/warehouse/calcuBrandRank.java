package com.flink.warehouse;

import com.flink.warehouse.bean.MyRecord;
import com.google.gson.Gson;
import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.CheckpointingMode;
import org.apache.flink.streaming.api.TimeCharacteristic;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.windowing.ProcessAllWindowFunction;
import org.apache.flink.streaming.api.windowing.assigners.SlidingProcessingTimeWindows;
import org.apache.flink.streaming.api.windowing.assigners.TumblingProcessingTimeWindows;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.apache.flink.streaming.api.windowing.windows.TimeWindow;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer011;
import org.apache.flink.util.Collector;

import java.sql.Timestamp;
import java.util.Comparator;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;

/**
 * @Author: Cedaris
 * @Date: 2019/7/15 16:39
 */
public class calcuBrandRank {
    public static void main(String[] args) {

        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.setParallelism(1);
        //以processingTime作为时间语义
        env.setStreamTimeCharacteristic(TimeCharacteristic.ProcessingTime);
        env.enableCheckpointing(5000);
        env.getCheckpointConfig().setCheckpointingMode(CheckpointingMode.EXACTLY_ONCE);

        //TODO:从kafka获取数据
        String topic = "omall_test";
        Properties props = new Properties();
        props.setProperty("bootstrap.servers", "psy831:9092");
        FlinkKafkaConsumer011<String> consumer011 = new FlinkKafkaConsumer011<String>(
                topic, new SimpleStringSchema(), props
        );
        consumer011.setStartFromEarliest();

        DataStreamSource<String> stream = env.addSource(consumer011);

        SingleOutputStreamOperator<MyRecord> records = stream.map(new LineSpliter());
        DataStream<Tuple2<String, Integer>> flatMap = records.flatMap(new Recorders());
        DataStream<Tuple2<String, Integer>> brandCount = flatMap.keyBy(0)
                .window(SlidingProcessingTimeWindows.of(Time.seconds(600), Time.seconds(5)))
                .sum(1);

        brandCount.windowAll(TumblingProcessingTimeWindows.of(Time.seconds(5)))
                .process(new BrandRankFuntion(3))
                .print();


        try {
            env.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class LineSpliter implements org.apache.flink.api.common.functions.MapFunction<String, MyRecord> {
        public MyRecord map(String s) throws Exception {
            String[] words = s.split("\\|");
            String time = words[0];
            String jsonRecord = words[1];
            Gson gson = new Gson();
            MyRecord myRecord = gson.fromJson(jsonRecord, MyRecord.class);
            return myRecord;
        }
    }

    private static class Recorders implements FlatMapFunction<MyRecord,Tuple2<String, Integer>>{
        @Override
        public void flatMap(MyRecord myRecord, Collector<Tuple2<String, Integer>> collector) throws Exception {
            String brand = myRecord.getCm().getBa();
            Tuple2<String, Integer> tuple2 = new Tuple2<>(brand, 1);
            collector.collect(tuple2);
        }
    }

    private static class BrandRankFuntion extends ProcessAllWindowFunction<Tuple2<String,Integer>,String, TimeWindow> {

        private int topSize = 3;
        public BrandRankFuntion(int topSize){
            this.topSize = topSize;
        }

        @Override
        public void process(Context context, Iterable<Tuple2<String, Integer>> iterable, Collector<String> collector) throws Exception {

            TreeMap<Integer, Tuple2<String, Integer>> treeMap = new TreeMap<>(
                    new Comparator<Integer>() {
                        @Override
                        public int compare(Integer o1, Integer o2) {
                            return (o1 < o2) ? -1 : 1;
                        }
                    }
            );//treemap按照key降序排列，相同count值不覆盖

            for (Tuple2<String, Integer> ele : iterable) {
                treeMap.put(ele.f1,ele);
                if (treeMap.size() > topSize){
                    //只保留前面N个元素
                    treeMap.pollLastEntry();
                }
            }
            for (Map.Entry<Integer, Tuple2<String, Integer>> entry : treeMap.entrySet()) {
                collector.collect("=================访问手机品牌榜:\n" + new Timestamp(System.currentTimeMillis()) + entry.toString() + "\n===============\n");
            }
        }
    }
}
