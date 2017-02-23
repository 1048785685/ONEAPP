package com.soully.oneapp.YeMian;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.google.gson.Gson;
import com.soully.oneapp.Gson.shouye.Question.Question;
import com.soully.oneapp.HttpUtil.HttpUtil;
import com.soully.oneapp.R;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by Soully on 2017/2/18.
 */

public class YemianSix extends AppCompatActivity{
//   WebView title;
//    TextView writer;
    WebView webView;
//    TextView bianji;


    int ID1;
    int ID2;
    int ID3;
    int ID4;
    int ID;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.yemian_six);
       webView = (WebView) findViewById(R.id.yemian_six_web_view);
//        writer = (TextView) findViewById(R.id.yemian_six_writer);
//        webView = (WebView) findViewById(R.id.yemian_six_web_view);
//        bianji = (TextView) findViewById(R.id.yemian_six_bianji);

        Bundle b = this.getIntent().getExtras();
        ID1 = b.getInt("idsix1");
        ID2 = b.getInt("idsix2");
        ID3 = b.getInt("idsix3");
        ID4 = b.getInt("idsix4");
        ID = ID1+ID2+ID3+ID4;
        HttpUtil.sendOkHttpRequest("http://v3.wufazhuce.com:8000/api/question/"+ID,
                new okhttp3.Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                    }
                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        String responseData = response.body().string();
                        Gson gson = new Gson();
                        Question question = gson.fromJson(responseData,Question.class);
                        final String image = question.getData().getWebUrl();
//                        final String hp_title = question.getData().getQuestionTitle();
//                        final String hp_author = question.getData().getQuestionContent();
//                        final String introduce = question.getData().getChargeEdt();
//                        final String content = question.getData().getAnswerContent();
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                webView.getSettings().setJavaScriptEnabled(true);
                                webView.setWebViewClient(new WebViewClient());
                                webView.loadUrl(image);
//                                title.setText(hp_title);
//                                writer.setText(hp_author);
//                                bianji.setText(introduce);
//                                webView.loadDataWithBaseURL(null,content,"html","UTF-8",null);
                            }
                        });
                    }
                });
    }
}
