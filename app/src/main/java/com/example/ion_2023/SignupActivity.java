package com.example.ion_2023;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity {

    TextView backBtnSignup;
    ImageButton signupBtn;
    EditText passwordSignup, nameSignup, emailSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        backBtnSignup = findViewById(R.id.backBtnSignup);
        signupBtn = findViewById(R.id.signupBtn);
        passwordSignup = findViewById(R.id.passwordSignup);
        nameSignup = findViewById(R.id.nameSignup);
        emailSignup = findViewById(R.id.emailSignup);

        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerUser();
            }

            private void registerUser() {
                String name = nameSignup.getText().toString().trim();
                String email = emailSignup.getText().toString().trim();
                String password = passwordSignup.getText().toString().trim();


                 if (name.isEmpty()){
                    nameSignup.setError("Full Name is required");
                    nameSignup.requestFocus();
                    return;
                }

                else if (name.length() > 10){
                    passwordSignup.setError("Name cannot be longer than 10 characters");
                    passwordSignup.requestFocus();
                    return;
                }

                else if (email.isEmpty()){
                    emailSignup.setError("Email is required");
                    emailSignup.requestFocus();
                    return;
                }
                else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                    emailSignup.setError("Provide a valid email");
                    emailSignup.requestFocus();
                    return;
                }

                else if (password.isEmpty()){
                    passwordSignup.setError("Password is Required");
                    passwordSignup.requestFocus();
                    return;
                }

                else if (password.length() < 6){
                    passwordSignup.setError("Provide a password with atleast 6 characters");
                    passwordSignup.requestFocus();
                    return;
                }

                else{
                    successfulRegistration();
                }
            }
        });

    }

    public void loginFromSignup(View view) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    private void successfulRegistration(){
        Intent intent = new Intent(this, SuccessfulSignupActivity.class);
        startActivity(intent);
    }
}