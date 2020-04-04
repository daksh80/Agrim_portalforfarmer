package com.example.agrim;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Weather extends AppCompatActivity {
    private WebView webview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        webview=(WebView) findViewById(R.id.webview);
        webview.setWebViewClient(new WebViewClient());
        webview.loadUrl("https://weather.com/en-IN/weather/today/l/28.61,77.08?par=google&temp=c");
        WebSettings webSettings =webview.getSettings();
        webSettings.setJavaScriptEnabled(true);
    }
    @Override
    public void onBackPressed()
    {
        if(webview.canGoBack()){
            webview.goBack();
        }
        else {
            super.onBackPressed();
        }
    }
}
