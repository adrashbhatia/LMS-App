package com.example.xgenlms;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class forgot_password_screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password_screen);

        Button btnS5 = findViewById(R.id.submitemail);
        btnS5.setOnClickListener(v -> {
            Intent intent = new Intent(forgot_password_screen.this, OTPScreen.class);
            startActivity(intent);
        });
    }
}
