package com.example.xgenlms;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class GradesAdapter extends RecyclerView.Adapter<GradesAdapter.GradeViewHolder> {

    private List<Grade> grades;

    public GradesAdapter(List<Grade> grades) {
        this.grades = grades;
    }

    @NonNull
    @Override
    public GradeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_grade, parent, false);
        return new GradeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GradeViewHolder holder, int position) {
        Grade grade = grades.get(position);
        holder.assignmentNameTextView.setText(grade.getAssignmentName());
        holder.marksTextView.setText(grade.getFormattedMarks());
    }

    @Override
    public int getItemCount() {
        return grades.size();
    }

    public void updateGrades(List<Grade> newGrades) {
        grades.clear();
        grades.addAll(newGrades);
        notifyDataSetChanged();
    }

    static class GradeViewHolder extends RecyclerView.ViewHolder {

        TextView assignmentNameTextView;
        TextView marksTextView;

        public GradeViewHolder(@NonNull View itemView) {
            super(itemView);
            assignmentNameTextView = itemView.findViewById(R.id.assignmentNameTextView);
            marksTextView = itemView.findViewById(R.id.marksTextView);
        }
    }
}
