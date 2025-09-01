package com.example.xgenlms;

import android.content.Intent;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class NotificationsFragment extends Fragment {

    private RecyclerView recyclerView;
    private NotificationAdapter adapter;
    private List<NotificationEntity> notificationList;

    public NotificationsFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notifications, container, false);

        recyclerView = view.findViewById(R.id.notificationRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Initialize the notification list with dummy data
        notificationList = new ArrayList<>();
        notificationList.add(new NotificationEntity("New Announcement", "Classwork for Monday has been uploaded.", "2024-08-28 10:00 AM", false));
        notificationList.add(new NotificationEntity("Grade Posted", "Your grade for Assignment 1 has been posted.", "2024-08-28 12:00 PM", false));
        notificationList.add(new NotificationEntity("Classwork Due", "Reminder: Classwork is due tomorrow.", "2024-08-28 02:00 PM", false));

        // Set up the adapter
        adapter = new NotificationAdapter(notificationList, new NotificationAdapter.OnNotificationClickListener() {
            @Override
            public void onNotificationClick(NotificationEntity notification) {
                // Start NotificationDetailActivity and pass notification data
                Intent intent = new Intent(getContext(), NotificationDetailActivity.class);
                intent.putExtra("title", notification.getTitle());
                intent.putExtra("message", notification.getMessage());
                intent.putExtra("timestamp", notification.getTimestamp());
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(adapter);

        // Add swipe functionality
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                // Handle swipe to remove
                int position = viewHolder.getAdapterPosition();
                notificationList.remove(position);
                adapter.notifyItemRemoved(position);
            }

            @Override
            public void onChildDraw(@NonNull Canvas c, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder,
                                    float dX, float dY, int actionState, boolean isCurrentlyActive) {
                super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
            }
        });

        itemTouchHelper.attachToRecyclerView(recyclerView);

        return view;
    }
}
