package com.example.ion_2023;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MoodActivity extends AppCompatActivity {

    private LottieAnimationView happyAnimation;
    private LottieAnimationView sadAnimation;
    private LottieAnimationView angryAnimation;
    private LottieAnimationView calmAnimation;
    private LottieAnimationView lovestruckAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mood);

        happyAnimation = findViewById(R.id.happy_animation);
        sadAnimation = findViewById(R.id.sad_animation);
        angryAnimation = findViewById(R.id.angry_animation);
        calmAnimation = findViewById(R.id.calm_animation);
        lovestruckAnimation = findViewById(R.id.lovestruck_animation);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavBar);
        bottomNavigationView.setSelectedItemId(R.id.moodItem);

        happyAnimation.setOnClickListener(v -> {
            happyAnimation.playAnimation();
            sadAnimation.cancelAnimation();
            angryAnimation.cancelAnimation();
            calmAnimation.cancelAnimation();
            lovestruckAnimation.cancelAnimation();
        });

        sadAnimation.setOnClickListener(v -> {
            happyAnimation.cancelAnimation();
            sadAnimation.playAnimation();
            angryAnimation.cancelAnimation();
            calmAnimation.cancelAnimation();
            lovestruckAnimation.cancelAnimation();
        });

        angryAnimation.setOnClickListener(v -> {
            happyAnimation.cancelAnimation();
            sadAnimation.cancelAnimation();
            angryAnimation.playAnimation();
            calmAnimation.cancelAnimation();
            lovestruckAnimation.cancelAnimation();
        });

        calmAnimation.setOnClickListener(v -> {
            happyAnimation.cancelAnimation();
            sadAnimation.cancelAnimation();
            angryAnimation.cancelAnimation();
            calmAnimation.playAnimation();
            lovestruckAnimation.cancelAnimation();
        });

        lovestruckAnimation.setOnClickListener(v -> {
            happyAnimation.cancelAnimation();
            sadAnimation.cancelAnimation();
            angryAnimation.cancelAnimation();
            calmAnimation.cancelAnimation();
            lovestruckAnimation.playAnimation();
        });



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
                        startActivity(new Intent(getApplicationContext(),
                                ArticleActivity.class));
                        return true;
                    case R.id.moodItem:
                        return true;
                }
                return false;
            }
        });
    }

    public void goToLogin(View view) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}