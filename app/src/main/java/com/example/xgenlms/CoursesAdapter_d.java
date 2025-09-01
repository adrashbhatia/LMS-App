package com.example.xgenlms;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CoursesAdapter_d extends RecyclerView.Adapter<CoursesAdapter_d.CourseViewHolder> {

    private List<Course_Model_Class_d> coursesList;

    public CoursesAdapter_d(List<Course_Model_Class_d> coursesList) {
        this.coursesList = coursesList;
    }

    @NonNull
    @Override
    public CourseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.course_list_item_d, parent, false);
        return new CourseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseViewHolder holder, int position) {
        Course_Model_Class_d course = coursesList.get(position);
        holder.courseTitle.setText(course.getTitle());
        holder.courseDescription.setText(course.getDescription());

        // Open MaterialDetailActivity when an item is clicked
        holder.itemView.setOnClickListener(v -> {
            Context context = holder.itemView.getContext();
            Intent intent = new Intent(context, MaterialDetailActivity.class);
            intent.putExtra("courseTitle", course.getTitle());
            intent.putExtra("courseDescription", course.getDescription());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return coursesList.size();
    }

    public static class CourseViewHolder extends RecyclerView.ViewHolder {
        TextView courseTitle;
        TextView courseDescription;

        public CourseViewHolder(@NonNull View itemView) {
            super(itemView);
            courseTitle = itemView.findViewById(R.id.course_name);
            courseDescription = itemView.findViewById(R.id.courseDescription);
        }
    }
}
