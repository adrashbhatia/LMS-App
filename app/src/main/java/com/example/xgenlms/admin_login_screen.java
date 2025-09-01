package com.example.xgenlms;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class admin_login_screen extends AppCompatActivity {

    private static final String BASE_URL = "http://192.168.18.26:3000"; // Update with your server URL

    private EditText emailEditText;
    private EditText passwordEditText;

    // Track whether the password is visible
    private boolean isPasswordVisible = false;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_login_screen);

        emailEditText = findViewById(R.id.editTextTextEmailAddress);
        passwordEditText = findViewById(R.id.editTextTextPassword);
        Button loginButton = findViewById(R.id.login3);
        Button forgotPasswordButton = findViewById(R.id.Forgot11);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService apiService = retrofit.create(ApiService.class);

        forgotPasswordButton.setOnClickListener(v -> {
            Intent intent = new Intent(admin_login_screen.this, forgot_password_screen.class);
            startActivity(intent);
        });

        loginButton.setOnClickListener(v -> {
            String email = emailEditText.getText().toString();
            String password = passwordEditText.getText().toString();

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(admin_login_screen.this, "Please enter email and password", Toast.LENGTH_SHORT).show();
                return;
            }

            LoginRequest loginRequest = new LoginRequest(email, password);
            Call<LoginResponse> call = apiService.login(loginRequest);

            call.enqueue(new Callback<LoginResponse>() {
                @Override
                public void onResponse(@NonNull Call<LoginResponse> call, @NonNull Response<LoginResponse> response) {
                    if (response.isSuccessful()) {
                        // Handle successful login, e.g., save token or navigate to another screen
                        Intent intent = new Intent(admin_login_screen.this, wellcomeadmin.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(admin_login_screen.this, "Login failed: " + response.message(), Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(@NonNull Call<LoginResponse> call, @NonNull Throwable t) {
                    Toast.makeText(admin_login_screen.this, "Login error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
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
