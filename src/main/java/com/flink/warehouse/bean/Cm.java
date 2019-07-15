package com.flink.warehouse.bean;

/**
 * @Author: Cedaris
 * @Date: 2019/7/15 16:45
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Cm {

    @SerializedName("ln")
    @Expose
    private String ln;
    @SerializedName("sv")
    @Expose
    private String sv;
    @SerializedName("os")
    @Expose
    private String os;
    @SerializedName("g")
    @Expose
    private String g;
    @SerializedName("mid")
    @Expose
    private String mid;
    @SerializedName("nw")
    @Expose
    private String nw;
    @SerializedName("l")
    @Expose
    private String l;
    @SerializedName("vc")
    @Expose
    private String vc;
    @SerializedName("hw")
    @Expose
    private String hw;
    @SerializedName("ar")
    @Expose
    private String ar;
    @SerializedName("uid")
    @Expose
    private String uid;
    @SerializedName("t")
    @Expose
    private String t;
    @SerializedName("la")
    @Expose
    private String la;
    @SerializedName("md")
    @Expose
    private String md;
    @SerializedName("vn")
    @Expose
    private String vn;
    @SerializedName("ba")
    @Expose
    private String ba;
    @SerializedName("sr")
    @Expose
    private String sr;

    public String getLn() {
        return ln;
    }

    public void setLn(String ln) {
        this.ln = ln;
    }

    public String getSv() {
        return sv;
    }

    public void setSv(String sv) {
        this.sv = sv;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getG() {
        return g;
    }

    public void setG(String g) {
        this.g = g;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getNw() {
        return nw;
    }

    public void setNw(String nw) {
        this.nw = nw;
    }

    public String getL() {
        return l;
    }

    public void setL(String l) {
        this.l = l;
    }

    public String getVc() {
        return vc;
    }

    public void setVc(String vc) {
        this.vc = vc;
    }

    public String getHw() {
        return hw;
    }

    public void setHw(String hw) {
        this.hw = hw;
    }

    public String getAr() {
        return ar;
    }

    public void setAr(String ar) {
        this.ar = ar;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getT() {
        return t;
    }

    public void setT(String t) {
        this.t = t;
    }

    public String getLa() {
        return la;
    }

    public void setLa(String la) {
        this.la = la;
    }

    public String getMd() {
        return md;
    }

    public void setMd(String md) {
        this.md = md;
    }

    public String getVn() {
        return vn;
    }

    public void setVn(String vn) {
        this.vn = vn;
    }

    public String getBa() {
        return ba;
    }

    public void setBa(String ba) {
        this.ba = ba;
    }

    public String getSr() {
        return sr;
    }

    public void setSr(String sr) {
        this.sr = sr;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("ln", ln).append("sv", sv).append("os", os).append("g", g).append("mid", mid).append("nw", nw).append("l", l).append("vc", vc).append("hw", hw).append("ar", ar).append("uid", uid).append("t", t).append("la", la).append("md", md).append("vn", vn).append("ba", ba).append("sr", sr).toString();
    }

}
