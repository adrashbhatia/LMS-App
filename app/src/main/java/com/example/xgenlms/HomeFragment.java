package com.example.xgenlms;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class HomeFragment extends Fragment {

    private TextView titleText;
    private TextView upcomingEventsTitle;
    private LinearLayout upcomingEventsLayout;
    private TextView announcementsTitle;
    private ScrollView announcementsScrollView;
    private LinearLayout announcementsLayout;
    private TextView recentActivityTitle;
    private LinearLayout recentActivityLayout;

    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString("ARG_PARAM1", param1);
        args.putString("ARG_PARAM2", param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        // Initialize UI components
        titleText = view.findViewById(R.id.title_text);
        upcomingEventsTitle = view.findViewById(R.id.important_notices_title);

        upcomingEventsLayout = view.findViewById(R.id.important_notices);
        announcementsTitle = view.findViewById(R.id.announcements_title);
        announcementsScrollView = view.findViewById(R.id.announcements_scrollview);
        announcementsLayout = view.findViewById(R.id.announcements);
        recentActivityTitle = view.findViewById(R.id.recent_activity_title);
        recentActivityLayout = view.findViewById(R.id.recent_activity);


        // Add sample data (replace with actual data later)
        addSampleData();

        return view;
    }

    private void addSampleData() {
        // Sample data for upcoming events
        addEvent("2024-09-01", "Sample notice Description 1");
        addEvent("2024-09-02", "Sample notice Description 2");
        addEvent("2024-09-02", "Sample notice Description 3");

        // Sample data for announcements
        addAnnouncement("Sample Announcement Text 1");
        addAnnouncement("Sample Announcement Text 2");
        addAnnouncement("Sample Announcement Text 3");

        // Sample data for recent activities
        addRecentActivity("2024-09-01", "Sample Activity Description 1");
        addRecentActivity("2024-09-02", "Sample Activity Description 2");
        addRecentActivity("2024-09-02", "Sample Activity Description 3");
    }

    private void addEvent(String date, String description) {
        View eventView = LayoutInflater.from(getContext()).inflate(R.layout.item_event, upcomingEventsLayout, false);
        TextView eventDate = eventView.findViewById(R.id.event_date);
        TextView eventDescription = eventView.findViewById(R.id.event_description);
        eventDate.setText(date);
        eventDescription.setText(description);
        upcomingEventsLayout.addView(eventView);
    }

    private void addAnnouncement(String text) {
        View announcementView = LayoutInflater.from(getContext()).inflate(R.layout.item_announcement, announcementsLayout, false);
        TextView announcementText = announcementView.findViewById(R.id.announcement_text);
        announcementText.setText(text);
        announcementsLayout.addView(announcementView);
    }

    private void addRecentActivity(String date, String description) {
        View activityView = LayoutInflater.from(getContext()).inflate(R.layout.item_recent_activity, recentActivityLayout, false);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView activityDate = activityView.findViewById(R.id.activitydate);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView activityDescription = activityView.findViewById(R.id.activitydescription);
        activityDate.setText(date);
        activityDescription.setText(description);
        recentActivityLayout.addView(activityView);
    }
}

