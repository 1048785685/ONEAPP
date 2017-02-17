package com.soully.oneapp.Gson.shouye;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ShouyetuwenId {

    @SerializedName("res")
    @Expose
    private Integer res;
    @SerializedName("data")
    @Expose
    private List<String> data = null;

    public Integer getRes() {
        return res;
    }

    public void setRes(Integer res) {
        this.res = res;
    }

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }

}