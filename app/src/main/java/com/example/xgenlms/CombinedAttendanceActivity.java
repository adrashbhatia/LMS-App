package com.example.xgenlms;

import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class CombinedAttendanceActivity extends AppCompatActivity {

    private TableLayout tableLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_combined_attendance);

        tableLayout = findViewById(R.id.tableLayout);

        // Simulating data fetching for all courses' attendance
        List<CourseAttendanceC> attendanceList = getAllCoursesAttendance();

        // Dynamically adding rows to the table
        for (CourseAttendanceC attendance : attendanceList) {
            TableRow row = new TableRow(this);

            // Create and format "Course Name" column
            TextView courseName = new TextView(this);
            courseName.setText(attendance.getCourseName());
            TableRow.LayoutParams params = new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 1f);
            courseName.setLayoutParams(params);
            courseName.setGravity(android.view.Gravity.CENTER);
            courseName.setPadding(8, 8, 8, 8);
            courseName.setTextColor(getResources().getColor(android.R.color.black));
            row.addView(courseName);

            // Create and format "Present Count" column
            TextView presentCount = new TextView(this);
            presentCount.setText(String.valueOf(attendance.getPresentCount()));
            presentCount.setLayoutParams(params);
            presentCount.setGravity(android.view.Gravity.CENTER);
            presentCount.setPadding(8, 8, 8, 8);
            presentCount.setTextColor(getResources().getColor(android.R.color.black));
            row.addView(presentCount);

            // Create and format "Absent Count" column
            TextView absentCount = new TextView(this);
            absentCount.setText(String.valueOf(attendance.getAbsentCount()));
            absentCount.setLayoutParams(params);
            absentCount.setGravity(android.view.Gravity.CENTER);
            absentCount.setPadding(8, 8, 8, 8);
            absentCount.setTextColor(getResources().getColor(android.R.color.black));
            row.addView(absentCount);

            // Add the row to the TableLayout
            tableLayout.addView(row);
        }
    }

    // Simulated method to fetch all courses' attendance data
    private List<CourseAttendanceC> getAllCoursesAttendance() {
        List<CourseAttendanceC> list = new ArrayList<>();

        // Add sample data (replace with actual data fetching logic)
        list.add(new CourseAttendanceC("Course 1", 20, 5));
        list.add(new CourseAttendanceC("Course 2", 18, 7));
        list.add(new CourseAttendanceC("Course 3", 15, 10));
        list.add(new CourseAttendanceC("Course 4", 22, 3));

        return list;
    }
}

