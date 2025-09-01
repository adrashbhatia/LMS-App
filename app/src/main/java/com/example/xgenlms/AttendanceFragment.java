package com.example.xgenlms;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class AttendanceFragment extends Fragment {

    private TextView courseDropdown;
    private Button viewCombinedAttendanceButton;
    private List<Course_Model_Class_d> registeredCoursesList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_attendance, container, false);

        // Initializing views
        courseDropdown = view.findViewById(R.id.courseDropdownAttendance);
        viewCombinedAttendanceButton = view.findViewById(R.id.btn_view_combined_attendance);

        // Simulating data fetching from backend
        registeredCoursesList = getRegisteredCourses();  // Sample data, replace with API call later

        // Set up click listener for custom dropdown
        courseDropdown.setOnClickListener(v -> showPopupMenu());

        // Set up click listener for combined attendance button
        viewCombinedAttendanceButton.setOnClickListener(v -> {
            Intent intent = new Intent(getContext(), CombinedAttendanceActivity.class);
            startActivity(intent);
        });

        return view;
    }

    // Show PopupMenu when TextView is clicked
    private void showPopupMenu() {
        PopupMenu popupMenu = new PopupMenu(getContext(), courseDropdown);
        popupMenu.getMenuInflater().inflate(R.menu.course_menu, popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(item -> {
            courseDropdown.setText(item.getTitle());
            for (Course_Model_Class_d course : registeredCoursesList) {
                if (course.getTitle().equals(item.getTitle())) {
                    Intent intent = new Intent(getContext(), AttendanceDetailActivity.class);
                    intent.putExtra("COURSE_NAME", course.getTitle());
                    startActivity(intent);
                    break;
                }
            }
            return true;
        });

        popupMenu.show();
    }

    // Simulate data fetching for registered courses
    private List<Course_Model_Class_d> getRegisteredCourses() {
        List<Course_Model_Class_d> courses = new ArrayList<>();
        courses.add(new Course_Model_Class_d("Course 1", "Description of Course 1"));
        courses.add(new Course_Model_Class_d("Course 2", "Description of Course 2"));
        courses.add(new Course_Model_Class_d("Course 3", "Description of Course 3"));
        return courses;
    }
}
