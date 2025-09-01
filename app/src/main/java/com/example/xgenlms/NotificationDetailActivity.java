package com.example.xgenlms;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class NotificationDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_detail);

        // Get notification details from intent
        String title = getIntent().getStringExtra("title");
        String message = getIntent().getStringExtra("message");
        String timestamp = getIntent().getStringExtra("timestamp");

        // Initialize views
        TextView titleTextView = findViewById(R.id.detailTitle);
        TextView messageTextView = findViewById(R.id.detailMessage);
        TextView timestampTextView = findViewById(R.id.detailTimestamp);
        Button dismissButton = findViewById(R.id.dismissButton);

        // Set notification details to views
        titleTextView.setText(title);
        messageTextView.setText(message);
        timestampTextView.setText(timestamp);

        // Handle dismiss button click
        dismissButton.setOnClickListener(v -> finish());

        // Optional: Apply animations (e.g., fade-in effect)
        applyFadeInAnimation(titleTextView);
        applyFadeInAnimation(messageTextView);
        applyFadeInAnimation(timestampTextView);
    }

    private void applyFadeInAnimation(View view) {
        view.setAlpha(0f);
        view.setVisibility(View.VISIBLE);
        view.animate()
                .alpha(1f)
                .setDuration(500)
                .start();
    }
}
