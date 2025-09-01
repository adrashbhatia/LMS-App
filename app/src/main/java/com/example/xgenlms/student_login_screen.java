package com.example.xgenlms;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class student_login_screen extends AppCompatActivity {

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private CheckBox rememberMeCheckBox;
    private EditText emailEditText, passwordEditText;
    private boolean isPasswordVisible = false;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_login_screen);

        rememberMeCheckBox = findViewById(R.id.remembermecheckbox);
        emailEditText = findViewById(R.id.editTextTextEmailAddress);
        passwordEditText = findViewById(R.id.editTextTextPassword);

        // Initialize SharedPreferences
        sharedPreferences = getSharedPreferences("loginPrefs", MODE_PRIVATE);
        editor = sharedPreferences.edit();

        // Password visibility toggle
        passwordEditText.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                final int DRAWABLE_RIGHT = 2;  // Assuming the eye icon is on the right side of EditText
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    if (event.getRawX() >= (passwordEditText.getRight() - passwordEditText.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                        if (isPasswordVisible) {
                            passwordEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());
                            passwordEditText.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.lock, 0, R.drawable.ic_eye_closed, 0);
                        } else {
                            passwordEditText.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                            passwordEditText.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.lock, 0, R.drawable.ic_eye_closed, 0);
                        }
                        isPasswordVisible = !isPasswordVisible;
                        return true;
                    }
                }
                return false;
            }
        });

        // Find the "Forgot Password" TextView
        TextView forgotPasswordTextView = findViewById(R.id.Forgot13);
        forgotPasswordTextView.setOnClickListener(v -> {
            // Navigate to the Forgot Password screen
            Intent intent = new Intent(student_login_screen.this, forgot_password_screen.class);
            startActivity(intent);
        });

        // Login as Admin
        TextView LoginAsAdmin = findViewById(R.id.admin);
        LoginAsAdmin.setOnClickListener(v -> {
            Intent intent = new Intent(student_login_screen.this, admin_login_screen.class);
            startActivity(intent);
        });

        // Login as Teacher
        TextView LoginAsTeacher = findViewById(R.id.teacher);
        LoginAsTeacher.setOnClickListener(v -> {
            Intent intent = new Intent(student_login_screen.this, teacher_login_screen.class);
            startActivity(intent);
        });

        // Check if "Remember Me" is checked and load saved login details
        loadLoginDetails();

        // Handle login button click
        Button btns7 = findViewById(R.id.btn3);
        btns7.setOnClickListener(v -> {
            // Call the loginUser function to perform login
            loginUser();
        });
    }

    private void loginUser() {
        // Get email and password from EditText fields
        String email = emailEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        // Check if email or password fields are empty
        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Please fill in both fields", Toast.LENGTH_SHORT).show();
            return;
        }

        // Here, you will call your backend API to authenticate the user
        // Add the API call to check the credentials with your backend server

        // If API call is successful, handle the login:
        if (rememberMeCheckBox.isChecked()) {
            editor.putBoolean("rememberMe", true);
            editor.putString("email", email);
            editor.putString("password", password);
            editor.apply(); // Save preferences
        }

        // If login is successful, navigate to the next activity
        Intent intent = new Intent(student_login_screen.this, Navbotdailog.class);
        startActivity(intent);
        finish();
    }

    // Function to handle successful login
    private void handleSuccessfulLogin(String userId) {
        // You can handle the transition to the next screen here
        Intent intent = new Intent(student_login_screen.this, Navbotdailog.class);
        intent.putExtra("userId", userId);
        startActivity(intent);
        finish();
    }

    // Function to handle login failure
    private void handleLoginFailure(String message) {
        Toast.makeText(this, "Login failed: " + message, Toast.LENGTH_SHORT).show();
    }

    // Load login details if "Remember Me" was checked previously
    private void loadLoginDetails() {
        boolean rememberMe = sharedPreferences.getBoolean("rememberMe", false);
        if (rememberMe) {
            String savedEmail = sharedPreferences.getString("email", "");
            String savedPassword = sharedPreferences.getString("password", "");
            emailEditText.setText(savedEmail);
            passwordEditText.setText(savedPassword);
            rememberMeCheckBox.setChecked(true);
        }
    }
}
