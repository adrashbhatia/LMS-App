package com.example.xgenlms;

import android.app.AlertDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Home_teacher extends Fragment {

    private RecyclerView classUpdatesRecyclerView;
    private RecyclerView announcementsRecyclerView;
    private ClassUpdatesAdapter classUpdatesAdapter;
    private AnnouncementsAdapter announcementsAdapter;
    private List<String> classUpdatesList;
    private List<String> announcementsList;
    private EditText classUpdateInput;
    private Button postUpdateButton;
    private TextView announcementTextView;
    private TextView emptyStateTextView;
    private boolean isTeacher = true; // Set this based on the actual user role
    private AlertDialog dialog; // Add a dialog reference to manage dialogs

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home_teacher, container, false);

        // Initialize views
        classUpdatesRecyclerView = view.findViewById(R.id.classUpdatesRecyclerView);
        announcementsRecyclerView = view.findViewById(R.id.announcementsRecyclerView);
        classUpdateInput = view.findViewById(R.id.classUpdateInput);
        postUpdateButton = view.findViewById(R.id.postUpdateButton);
        announcementTextView = view.findViewById(R.id.announcementTextView);
        emptyStateTextView = view.findViewById(R.id.emptyStateTextView);

        // Initialize class updates list and adapter
        classUpdatesList = new ArrayList<>();
        classUpdatesAdapter = new ClassUpdatesAdapter(classUpdatesList, new ClassUpdatesAdapter.OnItemClickListener() {
            @Override
            public void onEditClick(int position) {
                showEditPopup(position);
            }

            @Override
            public void onDeleteClick(int position) {
                showDeleteConfirmation(position);
            }
        }, isTeacher);

        // Initialize announcements list and adapter
        announcementsList = new ArrayList<>();
        announcementsAdapter = new AnnouncementsAdapter(announcementsList);

        // Set up RecyclerViews with LayoutManagers and Adapters
        classUpdatesRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        classUpdatesRecyclerView.setAdapter(classUpdatesAdapter);

        announcementsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        announcementsRecyclerView.setAdapter(announcementsAdapter);

        // Post update button click listener
        postUpdateButton.setOnClickListener(v -> postUpdate());

        // Load initial class updates and announcements
        loadClassUpdates();
        loadAnnouncements();

        return view;
    }

    private void loadClassUpdates() {
        // Sample data for testing removed; load from actual data source
        classUpdatesAdapter.notifyDataSetChanged();
        updateEmptyState();
    }

    private void loadAnnouncements() {
        // Sample data for testing
        announcementsList.add("Holiday on Friday.");
        announcementsList.add("New course material uploaded.");
        updateAnnouncementSection();
    }

    private void postUpdate() {
        String updateText = classUpdateInput.getText().toString().trim();
        if (TextUtils.isEmpty(updateText)) {
            Toast.makeText(getContext(), "Please write a class update!", Toast.LENGTH_SHORT).show();
            return;
        }

        Log.d("Home_teacher", "Post update button clicked");

        if (dialog == null || !dialog.isShowing()) {
            Log.d("Home_teacher", "Showing post update confirmation dialog");

            dialog = new AlertDialog.Builder(getContext())
                    .setTitle("Confirm Post")
                    .setMessage("Are you sure you want to post this update?")
                    .setPositiveButton("Post", (dialog, which) -> {
                        classUpdatesList.add(updateText);
                        classUpdatesAdapter.notifyItemInserted(classUpdatesList.size() - 1);
                        classUpdateInput.setText(""); // Clear input
                        Toast.makeText(getContext(), "Class update posted!", Toast.LENGTH_SHORT).show();
                        updateEmptyState(); // Update the empty state
                    })
                    .setNegativeButton("Cancel", (dialog, which) -> {
                        Log.d("Home_teacher", "Post update dialog cancelled");
                    })
                    .create();
            dialog.show();
        } else {
            Log.d("Home_teacher", "Dialog already showing, ignoring show request");
        }
    }

    private void showEditPopup(int position) {
        if (position >= 0 && position < classUpdatesList.size()) {
            String currentUpdate = classUpdatesList.get(position);

            Log.d("Home_teacher", "Showing edit popup for position " + position);

            if (dialog == null || !dialog.isShowing()) {
                final EditText input = new EditText(getContext());
                input.setText(currentUpdate);

                dialog = new AlertDialog.Builder(getContext())
                        .setTitle("Edit Update")
                        .setView(input)
                        .setPositiveButton("Save", (dialog, which) -> {
                            String newUpdate = input.getText().toString().trim();
                            if (!TextUtils.isEmpty(newUpdate)) {
                                classUpdatesList.set(position, newUpdate);
                                classUpdatesAdapter.notifyItemChanged(position);
                                Toast.makeText(getContext(), "Update edited!", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(getContext(), "Update cannot be empty!", Toast.LENGTH_SHORT).show();
                            }
                            updateEmptyState(); // Update the empty state after editing
                        })
                        .setNegativeButton("Cancel", (dialog, which) -> Log.d("Home_teacher", "Edit update dialog cancelled"))
                        .create();
                dialog.show();
            }
        } else {
            Toast.makeText(getContext(), "Invalid update position!", Toast.LENGTH_SHORT).show();
        }
    }

    private void showDeleteConfirmation(int position) {
        if (position >= 0 && position < classUpdatesList.size()) {
            Log.d("Home_teacher", "Showing delete confirmation dialog for position " + position);

            if (dialog == null || !dialog.isShowing()) {
                dialog = new AlertDialog.Builder(getContext())
                        .setTitle("Confirm Delete")
                        .setMessage("Are you sure you want to delete this update?")
                        .setPositiveButton("Delete", (dialog, which) -> {
                            classUpdatesList.remove(position);
                            classUpdatesAdapter.notifyItemRemoved(position);
                            Toast.makeText(getContext(), "Update deleted!", Toast.LENGTH_SHORT).show();
                            updateEmptyState(); // Update empty state after deletion
                        })
                        .setNegativeButton("Cancel", (dialog, which) -> {
                            Log.d("Home_teacher", "Delete confirmation dialog cancelled");
                        })
                        .create();
                dialog.show();
            }
        } else {
            Toast.makeText(getContext(), "Invalid update position!", Toast.LENGTH_SHORT).show();
        }
    }

    private void updateAnnouncementSection() {
        if (announcementsList.isEmpty()) {
            announcementTextView.setText("Announcements: No new announcements");
            announcementTextView.setVisibility(View.VISIBLE);
            announcementsRecyclerView.setVisibility(View.GONE);
        } else {
            announcementTextView.setText("Announcements:");
            announcementTextView.setVisibility(View.VISIBLE);
            announcementsRecyclerView.setVisibility(View.VISIBLE);
            announcementsAdapter.notifyDataSetChanged();
        }
    }

    private void updateEmptyState() {
        if (classUpdatesList.isEmpty()) {
            emptyStateTextView.setVisibility(View.VISIBLE);
            classUpdatesRecyclerView.setVisibility(View.GONE);
        } else {
            emptyStateTextView.setVisibility(View.GONE);
            classUpdatesRecyclerView.setVisibility(View.VISIBLE);
        }
    }
}