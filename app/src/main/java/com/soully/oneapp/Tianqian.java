package com.soully.oneapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.soully.oneapp.HttpUtil.HttpUtil;
import com.soully.oneapp.RecyclerViewAdapter.Tianqi_Adapter;
import com.soully.oneapp.RecyclerViewData.TianqiRecyclerData;

import org.json.JSONArray;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by Soully on 2017/2/23.
 */

public class Tianqian extends AppCompatActivity {
    String pic;
    String current_wendu;
    String current_tianqi;
    String[] date = new String[10];
    String[] max = new String[10];
    String[] txt_d = new String[10];
    String[] min = new String[10];
    ACache aCache;
    String city;
    private ViewPager myViewPager;//要使用的Viewpager
    private RecyclerView recyclerView;
    private Tianqi_Adapter adapter;
    private List<TianqiRecyclerData> dataList = new ArrayList<>();
    private LinearLayoutManager linearLayoutManager;
    private TextView citytextview;
    private ImageView imageView;
    private TextView wendu;
    private TextView tianqi;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tianqi);
        aCache = ACache.get(this);
        String a = aCache.getAsString("currentcity");
        city = a.substring(0,a.length()-1);
        Log.d("GGGGG",city);
        loadPic();//获取背景图片地址
        initData();//获取天气数据
    }
    private void loadPic(){
        HttpUtil.sendOkHttpRequest("http://guolin.tech/api/bing_pic",new okhttp3.Callback(){

            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();

            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                pic = response.body().string();
                Log.d("123456book", "网络连接成功");
            }
        });
    }
    private void initData(){
        HttpUtil.sendOkHttpRequest("https://free-api.heweather.com/v5/forecast?city="+city+"&key=dade51f03a8449c98624c8a6d4a99d39",
                new okhttp3.Callback(){

                    @Override
                    public void onFailure(Call call, IOException e) {
                        e.printStackTrace();
                    }
                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        Log.d("123book", "网络连接成功");
                        String htmlStr = response.body().string();//成功！！
                        Gson gson = new Gson();
                        com.soully.oneapp.Gson.Tianqi.Gson.Gson gson1 = gson.fromJson(htmlStr,
                                com.soully.oneapp.Gson.Tianqi.Gson.Gson.class);
                        city =gson1.getHeWeather5().get(0).getBasic().getCity();
                        current_wendu = gson1.getHeWeather5().get(0).getDailyForecast().get(0).getTmp().getMax();
                        current_tianqi = gson1.getHeWeather5().get(0).getDailyForecast().get(0).getCond().getTxtD();

                        for(int i=0;i < gson1.getHeWeather5().get(0).getDailyForecast().size();i++){
                            date[i]=gson1.getHeWeather5().get(0).getDailyForecast().get(i).getDate();
                            txt_d[i]=gson1.getHeWeather5().get(0).getDailyForecast().get(i).getCond().getTxtD();
                            max[i]=gson1.getHeWeather5().get(0).getDailyForecast().get(i).getTmp().getMax();
                            min[i]=gson1.getHeWeather5().get(0).getDailyForecast().get(i).getTmp().getMin();
                            Log.d("XXXXX",date.toString());
                        }
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                for (int i = 0; i < max.length; i++) {
                                    TianqiRecyclerData dataOne = new TianqiRecyclerData();
                                    dataOne.setDate(date[i]);
                                    dataOne.setMax(max[i]);
                                    dataOne.setMin(min[i]);
                                    dataOne.setTxt_d(txt_d[i]);
                                    dataList.add(dataOne);
                                }
                                citytextview = (TextView)findViewById(R.id.tianqi_city);
                                wendu = (TextView) findViewById(R.id.tianqi_current_wendu);
                                tianqi = (TextView) findViewById(R.id.tianqi_current_qingtian);
                                imageView = (ImageView)findViewById(R.id.tianqi_one_view);
                                Glide.with(Tianqian.this).load(pic).into(imageView);
                                citytextview.setText(city);
                                wendu.setText(current_wendu+"℃");
                                tianqi.setText(current_tianqi);
                                recyclerView = (RecyclerView)findViewById(R.id.tianqi_recyclerView);
                                linearLayoutManager = new LinearLayoutManager(Tianqian.this);//指定布局样式
                                recyclerView.setLayoutManager(linearLayoutManager);//将布局加入到recyclerView中
                                adapter = new Tianqi_Adapter(dataList);//将数据传入Adapter中去
                                recyclerView.setAdapter(adapter);//数据源和RecyclerView的绑定
                            }
                        });
                    }
                });
    }
}
