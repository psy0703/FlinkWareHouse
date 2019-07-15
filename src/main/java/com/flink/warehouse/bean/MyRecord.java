package com.flink.warehouse.bean;

/**
 * @Author: Cedaris
 * @Date: 2019/7/15 16:49
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;

public class MyRecord {

    @SerializedName("cm")
    @Expose
    private Cm cm;
    @SerializedName("ap")
    @Expose
    private String ap;
    @SerializedName("et")
    @Expose
    private List<Et> et = null;

    public Cm getCm() {
        return cm;
    }

    public void setCm(Cm cm) {
        this.cm = cm;
    }

    public String getAp() {
        return ap;
    }

    public void setAp(String ap) {
        this.ap = ap;
    }

    public List<Et> getEt() {
        return et;
    }

    public void setEt(List<Et> et) {
        this.et = et;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("cm", cm).append("ap", ap).append("et", et).toString();
    }

}
