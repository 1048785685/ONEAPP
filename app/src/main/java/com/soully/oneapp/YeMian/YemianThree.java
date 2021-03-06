package com.soully.oneapp.YeMian;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.soully.oneapp.Gson.shouye.SerialDetail.SerialDetail;
import com.soully.oneapp.Gson.shouye.ShortDetail.ShortDetail;
import com.soully.oneapp.HttpUtil.HttpUtil;
import com.soully.oneapp.R;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by Soully on 2017/2/17.
 */

public class YemianThree extends AppCompatActivity{
    TextView title;
    TextView writer;
    WebView webView;
    TextView bianji;
    ImageView imageView;
    TextView writerTwo;
    TextView jianjie;
    TextView zuozhe;
    int ID1;
    int ID2;
    int ID3;
    int ID4;
    int ID;
//    private Handler handler = new Handler(){
//        @Override
//        public void handleMessage(Message msg) {
//            super.handleMessage(msg);
//        }
//    };
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.yemian_three);
//        title = (TextView) findViewById(R.id.yemian_one_3_hp_title);
//        writer = (TextView) findViewById(R.id.yemian_one_3_writer);
        webView = (WebView) findViewById(R.id.yemian_one_3_web_view);
//        bianji = (TextView) findViewById(R.id.yemian_one_3_bianji);
//        imageView = (ImageView) findViewById(R.id.yemian_one_3_image);
//        writerTwo = (TextView) findViewById(R.id.yemian_one_3_zuozhe);
//        jianjie = (TextView) findViewById(R.id.yemian_one_3_jianjie);
//        zuozhe = (TextView) findViewById(R.id.x_3);
        Bundle b = this.getIntent().getExtras();
        ID1 = b.getInt("idthree1");
        ID2 = b.getInt("idthree2");
        ID3 = b.getInt("idthree3");
        ID4 = b.getInt("idthree4");
        ID = ID1+ID2+ID3+ID4;
        HttpUtil.sendOkHttpRequest("http://v3.wufazhuce.com:8000/api/serialcontent/"+ID,
                new okhttp3.Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String responseData = response.body().string();
                Gson gson = new Gson();
                SerialDetail serialDetail = gson.fromJson(responseData,SerialDetail.class);
//                final String hp_title = serialDetail.getData().getTitle();
//                final String hp_author = serialDetail.getData().getAuthor().getUserName();
//                final String introduce = serialDetail.getData().getChargeEdt();
                final String image = serialDetail.getData().getWebUrl();
//                final String content = serialDetail.getData().getContent();
//                final String summary = serialDetail.getData().getAuthor().getDesc();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        webView.getSettings().setJavaScriptEnabled(true);
                        webView.setWebViewClient(new WebViewClient());
                        webView.loadUrl(image);
//                        title.setText(hp_title);
//                        writer.setText(hp_author);
//                        writerTwo.setText("走走");
//                        bianji.setText(introduce);
//                        Glide.with(YemianThree.this).load(image).into(imageView);
//                        jianjie.setText(summary);
//                        zuozhe.setText("作者");
//                        webView.loadDataWithBaseURL(null,content,"html","UTF-8",null);
                    }
                });
            }
        });
    }
}
