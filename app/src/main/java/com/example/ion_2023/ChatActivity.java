package com.example.ion_2023;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class ChatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavBar);

        try {
            bottomNavigationView.setSelectedItemId(R.id.chatItem);
        } catch (Exception e) {
            e.printStackTrace();
        }


        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.chatItem:
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
                        startActivity(new Intent(getApplicationContext(),
                                MoodActivity.class));
                        return true;
                }
                return false;
            }
        });
    }
}