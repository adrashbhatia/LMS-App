package com.example.xgenlms;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class attendance_teacher extends Fragment {

    private Spinner courseSpinner;
    private EditText dateInput;
    private AppCompatButton markAttendanceButton;
    private AppCompatButton viewReportButton;

    public attendance_teacher() {
        // Required empty public constructor
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_attendance_teacher, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Initialize views
        courseSpinner = view.findViewById(R.id.courseSpinner);
        dateInput = view.findViewById(R.id.dateInput);
        markAttendanceButton = view.findViewById(R.id.markAttendanceButton);
        viewReportButton = view.findViewById(R.id.viewReportButton);

        // Populate Spinner with courses
        List<String> courses = getCourses();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item, courses);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        courseSpinner.setAdapter(adapter);

        // Set Date Picker dialog
        dateInput.setOnClickListener(v -> showDatePicker());

        // Mark Attendance Button Click
        markAttendanceButton.setOnClickListener(v -> {
            String selectedCourse = courseSpinner.getSelectedItem().toString();
            String selectedDate = dateInput.getText().toString();
            if (selectedCourse.isEmpty() || selectedDate.isEmpty()) {
                Toast.makeText(getActivity(), "Please select course and date", Toast.LENGTH_SHORT).show();
            } else {
                Intent intent = new Intent(getActivity(), activity_mark_attendance1.class);
                intent.putExtra("course", selectedCourse);
                intent.putExtra("date", selectedDate);
                startActivity(intent);
            }
        });

        // View Report Button Click
        viewReportButton.setOnClickListener(v -> {
            String selectedCourse = courseSpinner.getSelectedItem().toString();
            if (selectedCourse.isEmpty()) {
                Toast.makeText(getActivity(), "Please select a course", Toast.LENGTH_SHORT).show();
            } else {
                Intent intent = new Intent(getActivity(), ViewReportActivity.class);
                intent.putExtra("course", selectedCourse);
                startActivity(intent);
            }
        });
    }

    private void showDatePicker() {
        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(),
                (view, year1, month1, dayOfMonth) -> {
                    // Format selected date and set it to the EditText
                    String date = dayOfMonth + "/" + (month1 + 1) + "/" + year1;
                    dateInput.setText(date);
                }, year, month, day);
        datePickerDialog.show();
    }

    private List<String> getCourses() {
        // Replace this with actual data fetching logic (e.g., from a database or API)
        List<String> courses = new ArrayList<>();
        courses.add("web");
        courses.add("powerbi");
        courses.add("it");
        // Add more courses as needed
        return courses;
    }
}
