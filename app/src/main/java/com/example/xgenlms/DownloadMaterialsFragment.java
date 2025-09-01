package com.example.xgenlms;

import android.content.Intent;
import android.net.Uri;
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

public class DownloadMaterialsFragment extends Fragment {

    private TextView courseDropdown;
    private Button videoButton;
    private List<Course_Model_Class_d> registeredCoursesList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_download_materials, container, false);

        // Initializing TextView and Button
        courseDropdown = view.findViewById(R.id.courseDropdownMatrial);
        videoButton = view.findViewById(R.id.videoButton);

        // Simulating data fetching from backend
        registeredCoursesList = getRegisteredCourses();  // Sample data, replace with API call later

        // Set up click listener for custom dropdown
        courseDropdown.setOnClickListener(v -> showPopupMenu());

        // Video button click listener
        videoButton.setOnClickListener(v -> {
            // Open video lectures link (this should be fetched from backend)
            String videoLink = "https://www.youtube.com/@xgen.mediaproduction";  // Replace with dynamic URL from backend
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(videoLink));
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
            // Find the selected course based on the title and pass details to the next activity
            for (Course_Model_Class_d course : registeredCoursesList) {
                if (course.getTitle().equals(item.getTitle())) {
                    Intent intent = new Intent(getContext(), MaterialDetailActivity.class);
                    intent.putExtra("courseTitle", course.getTitle());
                    intent.putExtra("courseDescription", course.getDescription());
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
        courses.add(new Course_Model_Class_d("Course 4", "Description of Course 4"));
        courses.add(new Course_Model_Class_d("Course 5", "Description of Course 5"));
        // Sample data. Replace this with an API call to fetch actual data.
        return courses;
    }
}
