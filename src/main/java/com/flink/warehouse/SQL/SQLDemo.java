package com.flink.warehouse.SQL;

import com.flink.warehouse.bean.MyRecord;
import com.google.gson.Gson;
import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.streaming.api.CheckpointingMode;
import org.apache.flink.streaming.api.TimeCharacteristic;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer011;
import org.apache.flink.table.api.Table;
import org.apache.flink.table.api.java.StreamTableEnvironment;
import org.apache.flink.util.Collector;
import scala.Tuple3;

import java.util.Properties;

/**
 * @Author: Cedaris
 * @Date: 2019/7/15 17:27
 */
public class SQLDemo {
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
        SingleOutputStreamOperator<Tuple3<String, String, String>> flatMap =
                stream.flatMap(new CommentMsg());

        StreamTableEnvironment tableEnv = StreamTableEnvironment.create(env);
        Table table = tableEnv.fromDataStream(flatMap, "time,mid,uid");
        Table result = tableEnv.sqlQuery("select count(uid) from" + table);

        result.printSchema();

        try {
            env.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static class CommentMsg implements FlatMapFunction<String, Tuple3<String,String,String>>{

        @Override
        public void flatMap(String input, Collector<Tuple3<String, String, String>> output) throws Exception {
            String[] words = input.split("\\|");
            String record = words[1];
            Gson gson = new Gson();
            MyRecord myRecord = gson.fromJson(record, MyRecord.class);
            Tuple3<String, String, String> out = new Tuple3<>(words[0],
                    myRecord.getCm().getMid(), myRecord.getCm().getUid());

            output.collect(out);
        }
    }
}
