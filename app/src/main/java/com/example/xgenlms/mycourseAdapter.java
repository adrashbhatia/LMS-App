package com.example.xgenlms;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class mycourseAdapter extends RecyclerView.Adapter<mycourseAdapter.CourseViewHolder> {

    private List<mycoursemodel> courses;
    private Context context;

    public mycourseAdapter(Context context, List<mycoursemodel> courses) {
        this.courses = courses;
        this.context = context; // Ensure context is initialized
    }

    @NonNull
    @Override
    public CourseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_mycourse, parent, false);
        return new CourseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseViewHolder holder, int position) {
        mycoursemodel course = courses.get(position);
        holder.courseName.setText(course.getName());
        holder.schedule.setText(course.getSchedule());
        holder.venue.setText(course.getVenue());
        holder.icon.setImageResource(R.drawable.baseline_menu_book_24); // Set your icon resource here

        holder.itemView.setOnClickListener(v -> {
            if (context != null) {
                Intent intent = new Intent(context, MycourseDetailActivity.class);
                intent.putExtra("courseName", course.getName());
                intent.putExtra("schedule", course.getSchedule());
                intent.putExtra("venue", course.getVenue());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return courses.size();
    }

    class CourseViewHolder extends RecyclerView.ViewHolder {
        TextView courseName;
        TextView schedule;
        TextView venue;
        ImageView icon;

        CourseViewHolder(View itemView) {
            super(itemView);
            courseName = itemView.findViewById(R.id.textViewCourseName);
            schedule = itemView.findViewById(R.id.textViewSchedule);
            venue = itemView.findViewById(R.id.textViewVenue);
            icon = itemView.findViewById(R.id.imageViewIcon);
        }
    }
}
