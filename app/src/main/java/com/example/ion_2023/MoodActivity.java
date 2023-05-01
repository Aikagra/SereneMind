package com.example.ion_2023;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.Arrays;

public class MoodActivity extends AppCompatActivity {

    private LottieAnimationView happyAnimation;
    private LottieAnimationView sadAnimation;
    private LottieAnimationView angryAnimation;
    private LottieAnimationView calmAnimation;
    private LottieAnimationView lovestruckAnimation;
    ListView listView;
    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mood);

        happyAnimation = findViewById(R.id.happy_animation);
        sadAnimation = findViewById(R.id.sad_animation);
        angryAnimation = findViewById(R.id.angry_animation);
        calmAnimation = findViewById(R.id.calm_animation);
        lovestruckAnimation = findViewById(R.id.lovestruck_animation);
        linearLayout = findViewById(R.id.linearLayoutHide);
        listView = findViewById(R.id.listViewV);
        String[] songs = {
                "Bohemian Rhapsody",
                "Stairway to Heaven",
                "Hotel California",
                "Sweet Child O' Mine",
                "Back in Black",
                "Smells Like Teen Spirit",
                "November Rain",
                "Imagine",
                "Billie Jean",
                "Thriller",
                "Beat It",
                "Yesterday",
                "Let It Be",
                "Hey Jude",
                "Don't Stop Believin'",
                "Livin' on a Prayer",
                "Sweet Caroline",
                "I Will Always Love You",
                "Wonderwall",
                "The Scientist"
        };


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavBar);
        bottomNavigationView.setSelectedItemId(R.id.moodItem);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, songs);
        listView.setAdapter(adapter);

        happyAnimation.setOnClickListener(v -> {
            happyAnimation.playAnimation();
            happyAnimation.addAnimatorListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animation) {
                    // Animation started, do nothing
                }

                @Override
                public void onAnimationEnd(Animator animation) {
                    linearLayout.setVisibility(View.GONE);
                    listView.setVisibility(View.VISIBLE);

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
            sadAnimation.cancelAnimation();
            angryAnimation.cancelAnimation();
            calmAnimation.cancelAnimation();
            lovestruckAnimation.cancelAnimation();
        });

        sadAnimation.setOnClickListener(v -> {
            sadAnimation.addAnimatorListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animation) {
                    // Animation started, do nothing
                }

                @Override
                public void onAnimationEnd(Animator animation) {
                    linearLayout.setVisibility(View.GONE);
                    listView.setVisibility(View.VISIBLE);

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
            happyAnimation.cancelAnimation();
            sadAnimation.playAnimation();
            angryAnimation.cancelAnimation();
            calmAnimation.cancelAnimation();
            lovestruckAnimation.cancelAnimation();
        });

        angryAnimation.setOnClickListener(v -> {
            angryAnimation.addAnimatorListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animation) {
                    // Animation started, do nothing
                }

                @Override
                public void onAnimationEnd(Animator animation) {
                    linearLayout.setVisibility(View.GONE);
                    listView.setVisibility(View.VISIBLE);

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
            happyAnimation.cancelAnimation();
            sadAnimation.cancelAnimation();
            angryAnimation.playAnimation();
            calmAnimation.cancelAnimation();
            lovestruckAnimation.cancelAnimation();
        });

        calmAnimation.setOnClickListener(v -> {
            calmAnimation.addAnimatorListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animation) {
                    // Animation started, do nothing
                }

                @Override
                public void onAnimationEnd(Animator animation) {
                    linearLayout.setVisibility(View.GONE);
                    listView.setVisibility(View.VISIBLE);

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
            happyAnimation.cancelAnimation();
            sadAnimation.cancelAnimation();
            angryAnimation.cancelAnimation();
            calmAnimation.playAnimation();
            lovestruckAnimation.cancelAnimation();
        });

        lovestruckAnimation.setOnClickListener(v -> {
            lovestruckAnimation.addAnimatorListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animation) {
                    // Animation started, do nothing
                }

                @Override
                public void onAnimationEnd(Animator animation) {
                    linearLayout.setVisibility(View.GONE);
                    listView.setVisibility(View.VISIBLE);

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