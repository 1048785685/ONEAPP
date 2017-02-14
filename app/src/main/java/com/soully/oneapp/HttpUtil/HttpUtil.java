package com.soully.oneapp.HttpUtil;

import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by Soully on 2017/2/9.
 */

public class HttpUtil {
    public static void sendOkHttpRequest(String address,okhttp3.Callback  callback){
        OkHttpClient  client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(address)
                .build();
        client.newCall(request).enqueue(callback);
    }
}
