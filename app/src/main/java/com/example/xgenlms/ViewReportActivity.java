package com.example.xgenlms;


import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class ViewReportActivity extends AppCompatActivity {

    private RecyclerView reportRecyclerView;
    private ReportAdapter reportAdapter;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_report);

        reportRecyclerView = findViewById(R.id.reportRecyclerView);
        reportRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Sample data
        List<AttendanceReport> reportList = new ArrayList<>();
        reportList.add(new AttendanceReport("John Doe", true));
        reportList.add(new AttendanceReport("Jane Smith", false));
        // Add more reports as needed

        reportAdapter = new ReportAdapter(reportList);
        reportRecyclerView.setAdapter(reportAdapter);
    }
}
