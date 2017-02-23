package com.soully.oneapp.Gson.yinyue.MusicDate;

/**
 * Created by amanda on 2017/2/20.
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AuthorList {

    @SerializedName("user_id")
    @Expose
    private String userId;
    @SerializedName("user_name")
    @Expose
    private String userName;
    @SerializedName("desc")
    @Expose
    private String desc;
    @SerializedName("wb_name")
    @Expose
    private String wbName;
    @SerializedName("is_settled")
    @Expose
    private String isSettled;
    @SerializedName("settled_type")
    @Expose
    private String settledType;
    @SerializedName("summary")
    @Expose
    private String summary;
    @SerializedName("fans_total")
    @Expose
    private String fansTotal;
    @SerializedName("web_url")
    @Expose
    private String webUrl;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getWbName() {
        return wbName;
    }

    public void setWbName(String wbName) {
        this.wbName = wbName;
    }

    public String getIsSettled() {
        return isSettled;
    }

    public void setIsSettled(String isSettled) {
        this.isSettled = isSettled;
    }

    public String getSettledType() {
        return settledType;
    }

    public void setSettledType(String settledType) {
        this.settledType = settledType;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getFansTotal() {
        return fansTotal;
    }

    public void setFansTotal(String fansTotal) {
        this.fansTotal = fansTotal;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

}