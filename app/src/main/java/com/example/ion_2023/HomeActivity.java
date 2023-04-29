package com.example.ion_2023;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavBar);


        bottomNavigationView.setSelectedItemId(R.id.homeItem);

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