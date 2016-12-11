package com.smashedcontrollers.sportsontv;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class Feedback extends AppCompatActivity {
    ProgressBar loadingProgressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        WebView newWebbView = (WebView)findViewById(R.id.webView);
        newWebbView.setWebViewClient(new WebViewClient());
        newWebbView.loadUrl("http://www.ticketmaster.co.uk/");
        newWebbView.getSettings().setSupportZoom(true);
        newWebbView.getSettings().setJavaScriptEnabled(true);

        newWebbView.setWebViewClient(new WebViewClient() {
        });

        loadingProgressBar=(ProgressBar)findViewById(R.id.progressBar3);

        newWebbView.setWebChromeClient(new WebChromeClient() {

            // this will be called on page loading progress

            @Override

            public void onProgressChanged(WebView view, int newProgress) {

                super.onProgressChanged(view, newProgress);


                loadingProgressBar.setProgress(newProgress);
                //loadingTitle.setProgress(newProgress);
                // hide the progress bar if the loading is complete

                if (newProgress == 100) {
                    loadingProgressBar.setVisibility(View.GONE);

                } else{
                    loadingProgressBar.setVisibility(View.VISIBLE);

                }

            }

        });

    }













}
