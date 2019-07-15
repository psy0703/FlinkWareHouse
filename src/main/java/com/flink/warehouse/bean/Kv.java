package com.flink.warehouse.bean;

/**
 * @Author: Cedaris
 * @Date: 2019/7/15 16:49
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Kv {

    @SerializedName("entry")
    @Expose
    private String entry;
    @SerializedName("newsid")
    @Expose
    private String newsid;
    @SerializedName("news_staytime")
    @Expose
    private String newsStaytime;
    @SerializedName("loading_time")
    @Expose
    private String loadingTime;
    @SerializedName("action")
    @Expose
    private String action;
    @SerializedName("showtype")
    @Expose
    private String showtype;
    @SerializedName("category")
    @Expose
    private String category;
    @SerializedName("type1")
    @Expose
    private String type1;
    @SerializedName("extend2")
    @Expose
    private String extend2;
    @SerializedName("extend1")
    @Expose
    private String extend1;
    @SerializedName("type")
    @Expose
    private Integer type;
    @SerializedName("loading_way")
    @Expose
    private String loadingWay;
    @SerializedName("ap_time")
    @Expose
    private String apTime;
    @SerializedName("content")
    @Expose
    private String content;
    @SerializedName("errorDetail")
    @Expose
    private String errorDetail;
    @SerializedName("errorBrief")
    @Expose
    private String errorBrief;
    @SerializedName("course_id")
    @Expose
    private Integer courseId;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("add_time")
    @Expose
    private String addTime;
    @SerializedName("userid")
    @Expose
    private Integer userid;
    @SerializedName("target_id")
    @Expose
    private Integer targetId;

    public String getEntry() {
        return entry;
    }

    public void setEntry(String entry) {
        this.entry = entry;
    }

    public String getNewsid() {
        return newsid;
    }

    public void setNewsid(String newsid) {
        this.newsid = newsid;
    }

    public String getNewsStaytime() {
        return newsStaytime;
    }

    public void setNewsStaytime(String newsStaytime) {
        this.newsStaytime = newsStaytime;
    }

    public String getLoadingTime() {
        return loadingTime;
    }

    public void setLoadingTime(String loadingTime) {
        this.loadingTime = loadingTime;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getShowtype() {
        return showtype;
    }

    public void setShowtype(String showtype) {
        this.showtype = showtype;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getType1() {
        return type1;
    }

    public void setType1(String type1) {
        this.type1 = type1;
    }

    public String getExtend2() {
        return extend2;
    }

    public void setExtend2(String extend2) {
        this.extend2 = extend2;
    }

    public String getExtend1() {
        return extend1;
    }

    public void setExtend1(String extend1) {
        this.extend1 = extend1;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getLoadingWay() {
        return loadingWay;
    }

    public void setLoadingWay(String loadingWay) {
        this.loadingWay = loadingWay;
    }

    public String getApTime() {
        return apTime;
    }

    public void setApTime(String apTime) {
        this.apTime = apTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getErrorDetail() {
        return errorDetail;
    }

    public void setErrorDetail(String errorDetail) {
        this.errorDetail = errorDetail;
    }

    public String getErrorBrief() {
        return errorBrief;
    }

    public void setErrorBrief(String errorBrief) {
        this.errorBrief = errorBrief;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getTargetId() {
        return targetId;
    }

    public void setTargetId(Integer targetId) {
        this.targetId = targetId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("entry", entry).append("newsid", newsid).append("newsStaytime", newsStaytime).append("loadingTime", loadingTime).append("action", action).append("showtype", showtype).append("category", category).append("type1", type1).append("extend2", extend2).append("extend1", extend1).append("type", type).append("loadingWay", loadingWay).append("apTime", apTime).append("content", content).append("errorDetail", errorDetail).append("errorBrief", errorBrief).append("courseId", courseId).append("id", id).append("addTime", addTime).append("userid", userid).append("targetId", targetId).toString();
    }

}