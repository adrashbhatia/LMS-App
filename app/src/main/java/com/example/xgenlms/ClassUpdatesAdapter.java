package com.example.xgenlms;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ClassUpdatesAdapter extends RecyclerView.Adapter<ClassUpdatesAdapter.ClassUpdateViewHolder> {

    private List<String> classUpdates;
    private OnItemClickListener listener;
    private boolean isTeacher; // Flag to determine if the current user is a teacher

    public interface OnItemClickListener {
        void onEditClick(int position);
        void onDeleteClick(int position);
    }

    public ClassUpdatesAdapter(List<String> classUpdates, OnItemClickListener listener, boolean isTeacher) {
        this.classUpdates = classUpdates;
        this.listener = listener;
        this.isTeacher = isTeacher; // Initialize the flag
    }

    @NonNull
    @Override
    public ClassUpdateViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_class_update, parent, false);
        return new ClassUpdateViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ClassUpdateViewHolder holder, int position) {
        holder.classUpdateTextView.setText(classUpdates.get(position));

        // Show or hide edit and delete buttons based on user role
        if (isTeacher) {
            holder.editButton.setVisibility(View.VISIBLE);
            holder.deleteButton.setVisibility(View.VISIBLE);

            holder.editButton.setOnClickListener(v -> {
                if (listener != null) {
                    listener.onEditClick(position);
                }
            });

            holder.deleteButton.setOnClickListener(v -> {
                if (listener != null) {
                    listener.onDeleteClick(position);
                }
            });
        } else {
            holder.editButton.setVisibility(View.GONE);
            holder.deleteButton.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return classUpdates.size();
    }

    public static class ClassUpdateViewHolder extends RecyclerView.ViewHolder {
        public TextView classUpdateTextView;
        public Button editButton, deleteButton;

        public ClassUpdateViewHolder(@NonNull View itemView) {
            super(itemView);
            classUpdateTextView = itemView.findViewById(R.id.classUpdateTextView);
            editButton = itemView.findViewById(R.id.editButton);
            deleteButton = itemView.findViewById(R.id.deleteButton);
        }
    }
}
