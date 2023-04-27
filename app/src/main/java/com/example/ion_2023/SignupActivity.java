package com.example.ion_2023;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SignupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
    }

    public void signupUser(View view) {
    }

    public void loginFromSignup(View view) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}