package com.example.ion_2023;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class ArticleActivity extends AppCompatActivity {
    private WebView webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);

        webview = findViewById(R.id.webViewArticle);
        final LottieAnimationView lottieAnimationView = findViewById(R.id.lottieLoading);
        webview.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                lottieAnimationView.setVisibility(View.VISIBLE);
                
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                lottieAnimationView.setVisibility(View.GONE);
            }
        });
        webview.loadUrl("https://www.nami.org/Personal-Stories/Improve-Your-Own-Mental-Health");


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavBar);
        bottomNavigationView.setSelectedItemId(R.id.articleItem);


        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.chatItem:
                        startActivity(new Intent(getApplicationContext(),
                                ChatActivity.class));
                        return true;
                    case R.id.homeItem:
                        startActivity(new Intent(getApplicationContext(),
                                HomeActivity.class));
                        return true;
                    case R.id.articleItem:
                        return true;
                    case R.id.moodItem:
                        startActivity(new Intent(getApplicationContext(),
                                MoodActivity.class));
                        return true;
                }
                return false;
            }
        });



    }

    @Override
    public void onBackPressed() {
        if (webview.canGoBack()){
            webview.goBack();
        } else {
        super.onBackPressed();
        }
    }
}