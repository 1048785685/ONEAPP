package com.soully.oneapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by Soully on 2017/2/21.
 */

public class Change_three extends AppCompatActivity {
    Bundle bundle;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_three);
        bundle = this.getIntent().getExtras();
        String url = bundle.getString("url");
        WebView webView = (WebView) findViewById(R.id.three_webview);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(url);
    }
}
