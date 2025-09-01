package com.example.xgenlms;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import androidx.fragment.app.Fragment;

import com.example.xgenlms.databinding.FragmentCoursesBinding;

import java.util.ArrayList;

public class CoursesFragment extends Fragment {

    FragmentCoursesBinding binding;
    ListAdapter listAdapter;
    ArrayList<ListData> dataArrayList = new ArrayList<>();
    ListData listData;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentCoursesBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        int[] imageList = {
                R.drawable.baseline_menu_book_24,
                R.drawable.baseline_menu_book_24,
                R.drawable.baseline_menu_book_24,
                R.drawable.baseline_menu_book_24,
                R.drawable.baseline_menu_book_24,
                R.drawable.baseline_menu_book_24,
                R.drawable.baseline_menu_book_24
        };

        String[] nameList = {"Java Basics", "OOP in Java", "Data Structures", "Web Development", "Database Systems", "Android Development", "Algorithms"};
        String[] durationList = {"3 months", "2 months", "2 months", "3 months", "4 months", "2 months", "1 month"};
        String[] timeList = {"10 AM - 12 PM", "12 PM - 2 PM", "2 PM - 4 PM", "3 PM - 5 PM", "4 PM - 6 PM", "1 PM - 3 PM", "11 AM - 1 PM"};
        String[] venueList = {"Room 101", "Room 102", "Room 103", "Room 104", "Room 105", "Room 106", "Room 107"};
        String[] descriptionList = {
                "Introduction to Java programming.",
                "Object-Oriented Programming concepts in Java.",
                "Basic to advanced data structures.",
                "Introduction to Web Development using HTML, CSS, and JavaScript.",
                "Fundamentals of database management.",
                "Building Android applications from scratch.",
                "Basic to advanced algorithms."
        };
        String[] contentList = {
                "1. Basics of Java\n2. Variables\n3. Data types\n4. Control statements",
                "1. Classes and Objects\n2. Inheritance\n3. Polymorphism\n4. Encapsulation",
                "1. Arrays\n2. Linked Lists\n3. Stacks\n4. Queues",
                "1. HTML\n2. CSS\n3. JavaScript\n4. Responsive Design",
                "1. SQL Basics\n2. ER Models\n3. Query Optimization\n4. Transactions",
                "1. Android Studio Basics\n2. Activities and Fragments\n3. Intents\n4. SQLite",
                "1. Sorting Algorithms\n2. Searching Algorithms\n3. Graph Algorithms\n4. Dynamic Programming"
        };
        int[] completionList = {75, 60, 85, 90, 50, 95, 40};

        for (int i = 0; i < imageList.length; i++) {
            listData = new ListData(nameList[i], durationList[i], timeList[i], venueList[i], descriptionList[i], contentList[i], imageList[i], completionList[i]);
            dataArrayList.add(listData);
        }

        listAdapter = new ListAdapter(getContext(), dataArrayList);
        binding.listview.setAdapter(listAdapter);

        binding.listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getContext(), detailed.class);
                intent.putExtra("name", nameList[position]);
                intent.putExtra("duration", durationList[position]);
                intent.putExtra("time", timeList[position]);
                intent.putExtra("venue", venueList[position]);
                intent.putExtra("description", descriptionList[position]);
                intent.putExtra("content", contentList[position]);
                intent.putExtra("image", imageList[position]);
                intent.putExtra("completion", completionList[position]);
                startActivity(intent);
            }
        });

        return view;
    }
}
