package com.example.ion_2023;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MoodRedirectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mood_redirect);
    }

    public void goToMood(View view) {
        Intent intent = new Intent(this, MoodActivity.class);
        startActivity(intent);
    }
}