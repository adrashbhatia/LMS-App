package com.example.xgenlms;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class AttendanceDetailActivity extends AppCompatActivity {

    private TextView courseTitleTextView;
    private ListView attendanceListView;
    private ArrayList<AttendanceRecord> attendanceRecords;
    private AttendanceAdapter attendanceAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance_detail);

        courseTitleTextView = findViewById(R.id.text_course_title);
        attendanceListView = findViewById(R.id.attendance_list_view);

        // Get the course name from the intent
        String courseName = getIntent().getStringExtra("COURSE_NAME");

        if (courseName != null) {
            if (courseName.equals("all")) {
                courseTitleTextView.setText("Attendance for All Courses");
                // Fetch all courses' attendance data
                loadAllCoursesAttendance();
            } else {
                courseTitleTextView.setText("Attendance for " + courseName);
                // Fetch the selected course's attendance data
                loadCourseAttendance(courseName);
            }
        }

        // Set up the adapter for the ListView
        attendanceAdapter = new AttendanceAdapter(this, attendanceRecords);
        attendanceListView.setAdapter(attendanceAdapter);
    }

    private void loadCourseAttendance(String courseName) {
        // Here, you will load real data from your database or API
        // For now, we're using dummy data

        attendanceRecords = new ArrayList<>();
        attendanceRecords.add(new AttendanceRecord("2024-09-01", "Present"));
        attendanceRecords.add(new AttendanceRecord("2024-09-02", "Absent"));
        attendanceRecords.add(new AttendanceRecord("2024-09-03", "Present"));
        // Add more data as needed...
    }

    private void loadAllCoursesAttendance() {
        // Here, you will load real data from your database or API for all courses
        // For now, we're using dummy data

        attendanceRecords = new ArrayList<>();
        attendanceRecords.add(new AttendanceRecord("Maths - 2024-09-01", "Present"));
        attendanceRecords.add(new AttendanceRecord("Science - 2024-09-01", "Absent"));
        attendanceRecords.add(new AttendanceRecord("History - 2024-09-01", "Present"));
        // Add more data as needed...
    }
}
