package com.example.xgenlms;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CourseGradesActivity extends AppCompatActivity {

    private TextView courseTitleTextView;
    private RecyclerView gradesRecyclerView;
    private List<Grade> gradesList;
    private GradesAdapter gradesAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_grades);

        // Initialize views
        courseTitleTextView = findViewById(R.id.courseTitleTextView);
        gradesRecyclerView = findViewById(R.id.gradesRecyclerView);

        // Get the course title from the intent
        String courseTitle = getIntent().getStringExtra("courseTitle");
        courseTitleTextView.setText(courseTitle);

        // Setup RecyclerView
        gradesRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        gradesAdapter = new GradesAdapter(new ArrayList<>()); // Initialize with an empty list
        gradesRecyclerView.setAdapter(gradesAdapter);

        // Fetch grades for the selected course
        fetchGradesForCourse(courseTitle);
    }

    private void fetchGradesForCourse(String courseTitle) {
        // Replace with API call to fetch actual grades for the selected course
        gradesList = new ArrayList<>();
        gradesList.add(new Grade("Assignment 1", 8, 10));
        gradesList.add(new Grade("Quiz 1", 7, 10));
        gradesList.add(new Grade("Assignment 2", 9, 10));

        // Update RecyclerView with the fetched grades
        gradesAdapter.updateGrades(gradesList);
    }
}
