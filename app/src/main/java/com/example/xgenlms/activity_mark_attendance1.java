package com.example.xgenlms;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class activity_mark_attendance1 extends AppCompatActivity {

    private RecyclerView studentRecyclerView;
    private StudentAdapter studentAdapter;
    private AppCompatButton saveAttendanceButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mark_attendance1);

        studentRecyclerView = findViewById(R.id.studentRecyclerView);
        saveAttendanceButton = findViewById(R.id.savebtn);

        if (saveAttendanceButton == null) {
            throw new NullPointerException("Button with id savebtn not found in the layout");
        }

        studentRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("John Doe", false));
        studentList.add(new Student("Jane Smith", false));

        studentAdapter = new StudentAdapter(studentList);
        studentRecyclerView.setAdapter(studentAdapter);

        saveAttendanceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveAttendance();
            }
        });
    }

    private void saveAttendance() {
        // Show a toast message
        Toast.makeText(this, "Attendance Saved", Toast.LENGTH_SHORT).show();

        // Here you would normally handle the actual saving of attendance, such as calling a database or API

        // Finish the activity and go back to the previous screen
        finish();
    }
}
