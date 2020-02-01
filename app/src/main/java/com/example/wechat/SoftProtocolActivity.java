package com.example.wechat;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

public class SoftProtocolActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft_protocol);
        //进入一个外部webview
        WebView webView=(WebView)findViewById(R.id.soft_protocol_wv);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://work.weixin.qq.com/nl/eula");//协议网址

    }

    //当按系统返回键时返回上一个界面
    @Override
    protected void onPause() {
        super.onPause();
        //界面跳转
        startActivity(new Intent(SoftProtocolActivity.this,RegisterActivity.class));
        //淡入
        overridePendingTransition(android.R.anim.fade_out, 0);
        finish();
    }


}
