package com.soully.oneapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.soully.oneapp.Gson.shouye.Shouyetuwen;
import com.soully.oneapp.Gson.shouye.ShouyetuwenId;
import com.soully.oneapp.Gson.shouye.yuedi.Shouyeyuedu;
import com.soully.oneapp.HttpUtil.HttpUtil;
import com.soully.oneapp.ViewPagerFragment.ViewPagerFragmentOne;
import com.soully.oneapp.db.Shouyedb.Tuwen.Tuwendb;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by Soully on 2017/2/16.
 */

public class FirstActivity extends AppCompatActivity{
    String[] shouyeID = new String [10];
    ACache aCache;
    JSONArray jsonArrayhpcontent = new JSONArray();
    JSONArray jsonArrayhpImfUrl = new JSONArray();
    JSONArray jsonArrayhpAuthor = new JSONArray();
    JSONArray jsonArrayhpTextAuthors= new JSONArray();
    JSONArray jsonArraypraisenum = new JSONArray();
    JSONArray jsonArraysharenum = new JSONArray();
    JSONArray jsonArrayshouyeessayID = new JSONArray();
    JSONArray jsonArrayshouyeessaytitle = new JSONArray();
    //JSONArray jsonArrayshouyeessaytime = new JSONArray();
    JSONArray jsonArrayshouyeessayword = new JSONArray();
    JSONArray jsonArrayshouyeessayzuozhe = new JSONArray();
    JSONArray jsonArrayshouyeessayzuozheimage = new JSONArray();
    JSONArray jsonArrayshouyeserialId = new JSONArray();
    JSONArray jsonArrayshouyeserialtitle = new JSONArray();
    JSONArray jsonArrayshouyeserialword = new JSONArray();
    // JSONArray jsonArrayshouyeserialreadnum = new JSONArray();
    //JSONArray jsonArrayshouyeserialtime = new JSONArray();
    JSONArray jsonArrayshouyeserialname = new JSONArray();
    JSONArray jsonArrayshouyeserialuserimage = new JSONArray();
    JSONArray jsonArrayshouyequestionid = new JSONArray();
    JSONArray jsonArrayshouyequestiontitle = new JSONArray();
    JSONArray jsonArrayshouyequestioncontent = new JSONArray();
    //JSONArray jsonArrayshouyequestiontime = new JSONArray();
    JSONArray jsonArrayshouyequestionname = new JSONArray();
    JSONArray jsonArrayshouyequestionimage = new JSONArray();

//    String[] hpcontent = new String [10];
//    String[] hpImfUrl = new String[10];
//    String[] hpAuthor = new String[10];
//    String[] hpTextAuthors = new String[10];
//    int[] praisenum = new int[10];
//    int[] sharenum = new int[10];
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first);
        aCache = ACache.get(FirstActivity.this);

        Timer timer = new Timer();
        TimerTask tast = new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent();
                intent.setClass(FirstActivity.this, MainActivity.class);
                startActivity(intent);
            }
        };
        timer.schedule(tast, 5000);
        HttpUtil.sendOkHttpRequest("http://v3.wufazhuce.com:8000/api/hp/idlist/0", new okhttp3.Callback() {

            @Override
            public void onFailure(Call call, IOException e) {

            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String responseData = response.body().string();
                Log.d("XXXX",responseData);
                Gson gson = new Gson();
                ShouyetuwenId shouyetuwenId = gson.fromJson(responseData,ShouyetuwenId.class);
                Log.d("首页图文ID",shouyetuwenId.getData().get(0));
                for (int i=0;i<shouyetuwenId.getData().size();i++){
                    shouyeID[i] = shouyetuwenId.getData().get(i);
                }
//                aCache.put("shouyetuwenID",shouyeID);
                Log.d("XXXXXXX", String.valueOf(shouyetuwenId.getData().size()));
                String x = String.valueOf(shouyetuwenId.getData().size());
                aCache.put("shouyetuwenshumu",x);
                getone();
                get();
            }
        });
    }
    private void getone(){
        HttpUtil.sendOkHttpRequest("http://v3.wufazhuce.com:8000/api/reading/index", new okhttp3.Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String responsData = response.body().string();
                Gson gson = new Gson();
                Shouyeyuedu shouyeyuedu = gson.fromJson(responsData,Shouyeyuedu.class);

                for (int i = 0 ;i < shouyeyuedu.getData().getEssay().size();i++){
                    jsonArrayshouyeessayID.put(shouyeyuedu.getData().getEssay().get(i).getContentId());
                    jsonArrayshouyeessaytitle.put(shouyeyuedu.getData().getEssay().get(i).getHpTitle());
//                    jsonArrayshouyeessaytime.put(shouyeyuedu.getData().getEssay().get(i).getHpMakettime());
                    jsonArrayshouyeessayword.put(shouyeyuedu.getData().getEssay().get(i).getGuideWord());
                    jsonArrayshouyeessayzuozhe.put(shouyeyuedu.getData().getEssay().get(i).getAuthor()
                            .get(0).getUserName());
                    jsonArrayshouyeessayzuozheimage.put(shouyeyuedu.getData().getEssay().get(i)
                            .getAuthor().get(0).getWebUrl());
                    Log.d("首页阅读列表",shouyeyuedu.getData().getEssay().get(i).getHpTitle());
                    Log.d("首页阅读列表",shouyeyuedu.getData().getEssay().get(i).getGuideWord());
                }
                for ( int i = 0;i<shouyeyuedu.getData().getSerial().size();i++){

                    jsonArrayshouyeserialId.put(shouyeyuedu.getData().getSerial().get(i).getSerialId());
                    jsonArrayshouyeserialtitle.put(shouyeyuedu.getData().getSerial().get(i).getTitle());
                    jsonArrayshouyeserialword.put(shouyeyuedu.getData().getSerial().get(i).getExcerpt());
//                    jsonArrayshouyeserialreadnum.put(shouyeyuedu.getData().getSerial().get(i).getReadNum());
//                    jsonArrayshouyeserialtime.put(shouyeyuedu.getData().getSerial().get(i).getMaketime());
                    jsonArrayshouyeserialname.put(shouyeyuedu.getData().getSerial().get(i).getAuthor().getUserName());
                    jsonArrayshouyeserialuserimage.put(shouyeyuedu.getData().getSerial().get(i).getAuthor().getWebUrl());

                }
                for (int i=0;i<shouyeyuedu.getData().getQuestion().size();i++){

                    jsonArrayshouyequestionid.put(shouyeyuedu.getData().getQuestion().get(i)
                            .getQuestionId());
                    jsonArrayshouyequestiontitle.put(shouyeyuedu.getData().getQuestion().get(i)
                            .getQuestionTitle());
                    jsonArrayshouyequestioncontent.put(shouyeyuedu.getData().getQuestion().get(i)
                            .getAnswerContent());
//                    jsonArrayshouyequestiontime.put(shouyeyuedu.getData().getQuestion().get(i)
//                            .getQuestionMakettime());
                    jsonArrayshouyequestionimage.put(shouyeyuedu.getData().getQuestion().get(i)
                            .getAuthorList().get(0).getWebUrl());
                    jsonArrayshouyequestionname.put(shouyeyuedu.getData().getQuestion().get(i)
                            .getAuthorList().get(0).getUserName());
                    try {
                        Log.d("nihao ",jsonArrayshouyequestionimage.get(i).toString());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                aCache.put("shouyeessayid",jsonArrayshouyeessayID);
                aCache.put("shouyeessaytitle", jsonArrayshouyeessaytitle);
                aCache.put("shouyeessayword",jsonArrayshouyeessayword);
                aCache.put("shouyeessayzuozhe",jsonArrayshouyeessayzuozhe);
                aCache.put("shouyeessayzuozheimage",jsonArrayshouyeessayzuozheimage);
                aCache.put("shouyeserialid",jsonArrayshouyeserialId);
                aCache.put("shouyeserialtitle",jsonArrayshouyeserialtitle);
                aCache.put("shouyeserialword",jsonArrayshouyeserialword);
                aCache.put("shouyeserialname",jsonArrayshouyeserialname);
                aCache.put("shouyeserialuserimage",jsonArrayshouyeserialuserimage);
                aCache.put("shouyequestionid",jsonArrayshouyequestionid);
                aCache.put("shouyequestioncontent",jsonArrayshouyequestioncontent);
                aCache.put("shouyequestiontitle",jsonArrayshouyequestiontitle);
                aCache.put("shouyequestionimage",jsonArrayshouyequestionimage);
                aCache.put("shouyequestionname",jsonArrayshouyequestionname);

//                aCache.put("shouyeessaytime", jsonArrayshouyeessaytime);
//                aCache.put("shouyeserialreadnum",jsonArrayshouyeserialreadnum);
//                aCache.put("shouyeserialtime",jsonArrayshouyeserialtime);
            }
        });
    }
    private void get(){
        int num = Integer.parseInt(aCache.getAsString("shouyetuwenshumu"));
        for (int i =0;i < num ; i++){
            final int finalI = i;
            HttpUtil.sendOkHttpRequest("http://v3.wufazhuce.com:8000/api/hp/detail/"+shouyeID[i], new okhttp3.Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    e.printStackTrace();
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    String responsData = response.body().string();
                    Log.d("XXXXXXXX", responsData);
                    Gson gson = new Gson();
                    Shouyetuwen shouyetuwen = gson.fromJson(responsData, Shouyetuwen.class);
                    Log.d("首页图文详细信息", shouyetuwen.getData().getHpImgUrl());
                    Log.d("首页图文详细信息", shouyetuwen.getData().getHpAuthor());
                    Log.d("首页图文详细信息", shouyetuwen.getData().getHpContent());
                    Log.d("首页图文详细信息", shouyetuwen.getData().getTextAuthors());

//                    hpcontent[finalI] = shouyetuwen.getData().getHpContent();
//                    hpImfUrl[finalI] = shouyetuwen.getData().getHpImgUrl();
//                    hpAuthor[finalI] = shouyetuwen.getData().getHpAuthor();
//                    hpTextAuthors[finalI] = shouyetuwen.getData().getTextAuthors();
//                    praisenum[finalI] = shouyetuwen.getData().getPraisenum();
//                    sharenum[finalI] = shouyetuwen.getData().getSharenum();
                    jsonArrayhpcontent.put(shouyetuwen.getData().getHpContent());
                    jsonArrayhpImfUrl.put(shouyetuwen.getData().getHpImgUrl());
                    jsonArrayhpAuthor.put(shouyetuwen.getData().getHpAuthor());
                    jsonArrayhpTextAuthors.put(shouyetuwen.getData().getTextAuthors());
                    if (finalI == 9) {
//                        SharedPreferences.Editor editor =getSharedPreferences("data",MODE_PRIVATE).edit();
//                        editor.putString("hpcontent", String.valueOf(jsonArrayhpcontent));
//                        editor.putString("hpimfurl", String.valueOf(jsonArrayhpImfUrl));
//                        editor.putString("hpauthor", String.valueOf(jsonArrayhpAuthor));
//                        editor.putString("hptextauthors", String.valueOf(jsonArrayhpTextAuthors));
                       aCache.put("hpcontent",jsonArrayhpcontent);
                        aCache.put("hpimfurl",jsonArrayhpImfUrl);
                        aCache.put("hpauthor",jsonArrayhpAuthor);
                        aCache.put("hptextauthors",jsonArrayhpTextAuthors);
                    }
                }
            });
        }
    }
}
