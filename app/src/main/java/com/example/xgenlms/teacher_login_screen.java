package com.example.xgenlms;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class teacher_login_screen extends AppCompatActivity {

    private EditText emailEditText;
    private EditText passwordEditText;
    private Button loginButton;
    private Button forgotPasswordButton;

    // Track whether the password is visible
    private boolean isPasswordVisible = false;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_login_screen);

        emailEditText = findViewById(R.id.editTextTextEmailAddress);
        passwordEditText = findViewById(R.id.editTextTextPassword);
        loginButton = findViewById(R.id.btn3);
        forgotPasswordButton = findViewById(R.id.Forgot12);

        forgotPasswordButton.setOnClickListener(v -> {
            Intent intent = new Intent(teacher_login_screen.this, forgot_password_screen.class);
            startActivity(intent);
        });

        loginButton.setOnClickListener(v -> {
            String email = emailEditText.getText().toString();
            String password = passwordEditText.getText().toString();

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(teacher_login_screen.this, "Please enter email and password", Toast.LENGTH_SHORT).show();
            } else {
                // Here you can add a simple intent to go to the teacher's dashboard
                Toast.makeText(teacher_login_screen.this, "Login Successful", Toast.LENGTH_SHORT).show();

               Intent intent = new Intent(teacher_login_screen.this, navbotdailog_teacher.class);
               startActivity(intent);
            }
        });

        // Password visibility toggle
        passwordEditText.setOnTouchListener((v, event) -> {
            final int DRAWABLE_RIGHT = 2; // Right-side drawable

            if (event.getAction() == MotionEvent.ACTION_UP) {
                if (event.getRawX() >= (passwordEditText.getRight() - passwordEditText.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                    // Toggle password visibility
                    if (isPasswordVisible) {
                        passwordEditText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                        passwordEditText.setCompoundDrawablesWithIntrinsicBounds(R.drawable.lock, 0, R.drawable.ic_eye_closed, 0);
                    } else {
                        passwordEditText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                        passwordEditText.setCompoundDrawablesWithIntrinsicBounds(R.drawable.lock, 0, R.drawable.ic_eye_closed, 0);
                    }
                    isPasswordVisible = !isPasswordVisible;

                    // Move the cursor to the end of the text
                    passwordEditText.setSelection(passwordEditText.length());
                    return true;
                }
            }
            return false;
        });
    }
}
