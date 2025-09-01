package com.example.xgenlms;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.xgenlms.databinding.ActivityDetailedBinding;

public class detailed extends AppCompatActivity {

    private ActivityDetailedBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailedBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = getIntent();
        if (intent != null) {
            String name = intent.getStringExtra("name");
            String duration = intent.getStringExtra("duration");
            String time = intent.getStringExtra("time");
            String venue = intent.getStringExtra("venue");
            String description = intent.getStringExtra("description");
            String content = intent.getStringExtra("content");
            int image = intent.getIntExtra("image", R.drawable.baseline_menu_book_24);
            int completion = intent.getIntExtra("completion", 0);

            binding.detailedName.setText(name);

            String classDetails = "Duration: " + duration + "\nTime: " + time + "\nVenue: " + venue;
            binding.detailCourseDuration.setText(classDetails);

            binding.detailCourseDescription.setText(description);
            binding.detailCourseContent.setText(content);
            binding.detailedimage.setImageResource(image);

            binding.courseCompletionProgress.setProgress(completion);
        }

        // For AttendanceFragment
        binding.Attendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AttendanceFragment attendanceFragment = new AttendanceFragment();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, attendanceFragment) // Replace with the ID of your FrameLayout
                        .addToBackStack(null) // Allows you to return to the previous fragment
                        .commit();
            }
        });

        // For DownloadMaterialsFragment
        binding.Assessment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DownloadMaterialsFragment downloadMaterialsFragment = new DownloadMaterialsFragment();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, downloadMaterialsFragment) // Replace with the ID of your FrameLayout
                        .addToBackStack(null) // Allows you to return to the previous fragment
                        .commit();
            }
        });
    }
}
