package com.soully.oneapp.Gson.shouye.yuedi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AskerList {

    @SerializedName("user_id")
    @Expose
    private String userId;
    @SerializedName("user_name")
    @Expose
    private String userName;
    @SerializedName("web_url")
    @Expose
    private String webUrl;
    @SerializedName("summary")
    @Expose
    private String summary;
    @SerializedName("desc")
    @Expose
    private String desc;
    @SerializedName("is_settled")
    @Expose
    private String isSettled;
    @SerializedName("settled_type")
    @Expose
    private String settledType;
    @SerializedName("fans_total")
    @Expose
    private String fansTotal;
    @SerializedName("wb_name")
    @Expose
    private String wbName;

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

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
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

    public String getFansTotal() {
        return fansTotal;
    }

    public void setFansTotal(String fansTotal) {
        this.fansTotal = fansTotal;
    }

    public String getWbName() {
        return wbName;
    }

    public void setWbName(String wbName) {
        this.wbName = wbName;
    }

}