package com.example.xgenlms;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MaterialDetailActivity extends AppCompatActivity {

    private TextView courseTitle;
    private TextView courseDescription;
    private RecyclerView materialsRecyclerView;
    private MaterialAdapter materialAdapter;
    private List<Material> materialList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.materialdetailactivity);

        // Initializing Views
        courseTitle = findViewById(R.id.courseTitle);
        courseDescription = findViewById(R.id.courseDescription);
        materialsRecyclerView = findViewById(R.id.materialsRecyclerView);

        // Getting data from Intent
        String title = getIntent().getStringExtra("courseTitle");
        String description = getIntent().getStringExtra("courseDescription");

        // Setting data to TextViews
        courseTitle.setText(title);
        courseDescription.setText(description);

        // Initializing RecyclerView
        materialList = new ArrayList<>();
        // Populate this list with data
        materialList.add(new Material("https://github.com/project", "File 1 Description"));
        materialList.add(new Material("https://github.com/explore", "File 2 Description"));
        materialList.add(new Material("https://github.com/explore", "File 3 Description"));
        materialList.add(new Material("https://github.com/explore", "File 4 Description"));
        materialList.add(new Material("https://github.com/explore", "File 5 Description"));
        materialList.add(new Material("https://github.com/explore", "File 6 Description"));
        materialList.add(new Material("https://github.com/explore", "File 7 Description"));
        materialAdapter = new MaterialAdapter(materialList);
        materialsRecyclerView.setAdapter(materialAdapter);
        materialsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
