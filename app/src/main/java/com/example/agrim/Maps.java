package com.example.agrim;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Maps extends AppCompatActivity {

    private WebView Webview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        Webview=(WebView) findViewById(R.id.Webview);
        Webview.setWebViewClient(new WebViewClient());
        Webview.loadUrl("https://www.google.co.in/maps/search/kisan+kendra/@13.1342943,77.7422613,16z/data=!3m1!4b1");
        WebSettings webSettings =Webview.getSettings();
        webSettings.setJavaScriptEnabled(true);
    }
    @Override
    public void onBackPressed()
    {
        if(Webview.canGoBack()){
            Webview.goBack();
        }
        else {
            super.onBackPressed();
        }
    }
}
