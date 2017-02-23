package com.soully.oneapp.Gson.yuedu.ShortDetail;

/**
 * Created by amanda on 2017/2/16.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ShareList {

    @SerializedName("wx")
    @Expose
    private Wx wx;
    @SerializedName("weibo")
    @Expose
    private Weibo weibo;
    @SerializedName("qq")
    @Expose
    private Qq qq;

    public Wx getWx() {
        return wx;
    }

    public void setWx(Wx wx) {
        this.wx = wx;
    }

    public Weibo getWeibo() {
        return weibo;
    }

    public void setWeibo(Weibo weibo) {
        this.weibo = weibo;
    }

    public Qq getQq() {
        return qq;
    }

    public void setQq(Qq qq) {
        this.qq = qq;
    }

}
