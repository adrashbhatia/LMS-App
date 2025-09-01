package com.example.xgenlms;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MycourseDetailActivity extends AppCompatActivity {

    private ImageView detailIcon;
    private TextView detailCourseName;
    private TextView detailSchedule;
    private TextView detailVenue;
    private ProgressBar progressBarCompletion;
    private TextView textViewProgressPercentage;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mycourse_detail);

        // Initialize views
        detailIcon = findViewById(R.id.imageViewDetailIcon);
        detailCourseName = findViewById(R.id.textViewDetailCourseName);
        detailSchedule = findViewById(R.id.textViewDetailSchedule);
        detailVenue = findViewById(R.id.textViewDetailVenue);
        progressBarCompletion = findViewById(R.id.progressBarCompletion);
        textViewProgressPercentage = findViewById(R.id.textViewProgressPercentage);

        // Get data from Intent
        Intent intent = getIntent();
        String courseName = intent.getStringExtra("courseName");
        String schedule = intent.getStringExtra("schedule");
        String venue = intent.getStringExtra("venue");
        int progress = intent.getIntExtra("progress", 89);  // Default to 0 if not provided

        // Set data to views
        detailCourseName.setText(courseName);
        detailSchedule.setText(schedule);
        detailVenue.setText(venue);
        detailIcon.setImageResource(R.drawable.baseline_menu_book_24);  // Set your icon resource here

        // Set progress bar
        progressBarCompletion.setMax(100); // Set maximum progress value (100%)
        progressBarCompletion.setProgress(progress); // Set current progress value
        textViewProgressPercentage.setText(progress + "% Completed");
    }
}
