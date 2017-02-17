package com.soully.oneapp.Gson.shouye;

/**
 * Created by Soully on 2017/2/15.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Shouyetuwen {

    @SerializedName("res")
    @Expose
    private Integer res;
    @SerializedName("data")
    @Expose
    private Data data;

    public Integer getRes() {
        return res;
    }

    public void setRes(Integer res) {
        this.res = res;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

}