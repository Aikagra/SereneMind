package com.example.ion_2023;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class HomeActivity extends AppCompatActivity {

    LottieAnimationView happyAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavBar);


        bottomNavigationView.setSelectedItemId(R.id.homeItem);
        happyAnimation = findViewById(R.id.happy_animation_home);

        happyAnimation.setOnClickListener(v -> {
            happyAnimation.playAnimation();
            happyAnimation.addAnimatorListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animation) {
                    // Animation started, do nothing
                }

                @Override
                public void onAnimationEnd(Animator animation) {
                    // Animation ended, redirect to MoodRedirectActivity
                    Intent intent = new Intent(HomeActivity.this, MoodRedirectActivity.class);
                    startActivity(intent);
                }

                @Override
                public void onAnimationCancel(Animator animation) {
                    // Animation cancelled, do nothing
                }

                @Override
                public void onAnimationRepeat(Animator animation) {
                    // Animation repeated, do nothing
                }
            });
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
                        return true;
                    case R.id.articleItem:
                        startActivity(new Intent(getApplicationContext(),
                                ArticleActivity.class));
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
    public void goToLogin(View view) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}