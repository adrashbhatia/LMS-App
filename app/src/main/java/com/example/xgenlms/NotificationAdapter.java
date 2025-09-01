package com.example.xgenlms;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.NotificationViewHolder> {

    private final List<NotificationEntity> notificationList;
    private final OnNotificationClickListener clickListener;

    // Interface to handle click events
    public interface OnNotificationClickListener {
        void onNotificationClick(NotificationEntity notification);
    }

    // Constructor for the adapter
    public NotificationAdapter(List<NotificationEntity> notificationList, OnNotificationClickListener clickListener) {
        this.notificationList = notificationList;
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public NotificationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.notification_item, parent, false);
        return new NotificationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NotificationViewHolder holder, int position) {
        NotificationEntity notification = notificationList.get(position);
        holder.bind(notification);

        // Set click listener on item
        holder.itemView.setOnClickListener(v -> {
            // Mark as read and remove unread badge
            notification.setRead(true);
            notifyItemChanged(position); // Refresh the item view

            clickListener.onNotificationClick(notification);
        });
    }

    @Override
    public int getItemCount() {
        return notificationList.size();
    }

    // ViewHolder class to hold views for each notification item
    static class NotificationViewHolder extends RecyclerView.ViewHolder {
        private final TextView titleTextView;
        private final TextView messageTextView;
        private final TextView timestampTextView;
        private final View unreadBadgeView; // Badge for unread notifications

        public NotificationViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.notificationTitle);
            messageTextView = itemView.findViewById(R.id.notificationMessage);
            timestampTextView = itemView.findViewById(R.id.notificationTimestamp);
            unreadBadgeView = itemView.findViewById(R.id.unreadBadge); // Unread badge view
        }

        // Bind data to the views
        public void bind(NotificationEntity notification) {
            titleTextView.setText(notification.getTitle());
            messageTextView.setText(notification.getMessage());
            timestampTextView.setText(notification.getTimestamp());

            // Show the unread badge if the notification is unread
            if (!notification.isRead()) {
                unreadBadgeView.setVisibility(View.VISIBLE);
            } else {
                unreadBadgeView.setVisibility(View.GONE);
            }
        }
    }
}
