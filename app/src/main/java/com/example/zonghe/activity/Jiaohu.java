package com.example.zonghe.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.Button;

import com.example.zonghe.R;

public class Jiaohu extends AppCompatActivity {

    private WebView webview;
    private Button butt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jiaohu);
        webview = findViewById(R.id.webview);
        butt = findViewById(R.id.butt);
        webview.getSettings().setJavaScriptEnabled(true);
        webview.setWebChromeClient(new WebChromeClient());;
        webview.loadUrl("file:///android_asset/aa.html");
        butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webview.post(new Runnable() {
                    @Override
                    public void run() {
                        webview.loadUrl("javascript:callJS()");
                    }
                });
            }
        });
    }
}
