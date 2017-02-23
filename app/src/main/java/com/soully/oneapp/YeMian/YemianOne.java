package com.soully.oneapp.YeMian;

import android.os.Bundle;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Handler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.soully.oneapp.Gson.shouye.ShortDetail.ShortDetail;
import com.soully.oneapp.HttpUtil.HttpUtil;
import com.soully.oneapp.R;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by Soully on 2017/2/17.
 */

public class YemianOne extends AppCompatActivity{
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
        setContentView(R.layout.yemian_one);
//        title = (TextView) findViewById(R.id.yemian_one_hp_title);
//        writer = (TextView) findViewById(R.id.yemian_one_writer);
        webView = (WebView) findViewById(R.id.yemian_one_web_view);
//        bianji = (TextView) findViewById(R.id.yemian_one_bianji);
//        imageView = (ImageView) findViewById(R.id.yemian_one_image);
//        writerTwo = (TextView) findViewById(R.id.yemian_one_zuozhe);
//        jianjie = (TextView) findViewById(R.id.yemian_one_jianjie);
//        zuozhe = (TextView) findViewById(R.id.x);
        Bundle b = this.getIntent().getExtras();
        ID1 = b.getInt("idone1");
        ID2 = b.getInt("idone2");
        ID3 = b.getInt("idone3");
        ID4 = b.getInt("idone4");
        ID = ID1+ID2+ID3+ID4;
        HttpUtil.sendOkHttpRequest("http://v3.wufazhuce.com:8000/api/essay/"+ID,
                new okhttp3.Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String responseData = response.body().string();
                Gson gson = new Gson();
                ShortDetail shortDetail = gson.fromJson(responseData,ShortDetail.class);
//                final String hp_title = shortDetail.getData().getHpTitle();
//                final String hp_author = shortDetail.getData().getHpAuthor();
//                final String introduce = shortDetail.getData().getHpAuthorIntroduce();
//                final String image = shortDetail.getData().getWbImgUrl();
                final String image = shortDetail.getData().getWebUrl();
//                final String content = shortDetail.getData().getHpContent();
//                final String summary = shortDetail.getData().getAuthor().get(0).getSummary();
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
//                        Glide.with(YemianOne.this).load(image).into(imageView);
//                        jianjie.setText(summary);
//                        zuozhe.setText("作者");
//                        webView.loadDataWithBaseURL(null,content,"html","UTF-8",null);
                    }
                });
            }
        });
    }
}
