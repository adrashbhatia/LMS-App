package com.example.xgenlms;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class AnnouncementsAdapter extends RecyclerView.Adapter<AnnouncementsAdapter.AnnouncementViewHolder> {

    private List<String> announcements;

    public AnnouncementsAdapter(List<String> announcements) {
        this.announcements = announcements;
    }

    @NonNull
    @Override
    public AnnouncementViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_teacher_announcement, parent, false);
        return new AnnouncementViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AnnouncementViewHolder holder, int position) {
        holder.announcementTextView.setText(announcements.get(position));
    }

    @Override
    public int getItemCount() {
        return announcements.size();
    }

    static class AnnouncementViewHolder extends RecyclerView.ViewHolder {
        TextView announcementTextView;

        AnnouncementViewHolder(View itemView) {
            super(itemView);
            announcementTextView = itemView.findViewById(R.id.teacher_announcement_text);
        }
    }
}
