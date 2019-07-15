package com.flink.warehouse.bean;

/**
 * @Author: Cedaris
 * @Date: 2019/7/15 16:48
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Et {

    @SerializedName("ett")
    @Expose
    private String ett;
    @SerializedName("en")
    @Expose
    private String en;
    @SerializedName("kv")
    @Expose
    private Kv kv;

    public String getEtt() {
        return ett;
    }

    public void setEtt(String ett) {
        this.ett = ett;
    }

    public String getEn() {
        return en;
    }

    public void setEn(String en) {
        this.en = en;
    }

    public Kv getKv() {
        return kv;
    }

    public void setKv(Kv kv) {
        this.kv = kv;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("ett", ett).append("en", en).append("kv", kv).toString();
    }

}