package com.example.xgenlms;



import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class ReportAdapter extends RecyclerView.Adapter<ReportAdapter.ReportViewHolder> {

    private final List<AttendanceReport> reportList;

    public ReportAdapter(List<AttendanceReport> reportList) {
        this.reportList = reportList;
    }

    @NonNull
    @Override
    public ReportViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_report, parent, false);
        return new ReportViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ReportViewHolder holder, int position) {
        AttendanceReport report = reportList.get(position);
        holder.reportStudentName.setText(report.getStudentName());
        holder.reportAttendanceStatus.setText(report.isPresent() ? "Present" : "Absent");
    }

    @Override
    public int getItemCount() {
        return reportList.size();
    }

    static class ReportViewHolder extends RecyclerView.ViewHolder {
        TextView reportStudentName;
        TextView reportAttendanceStatus;

        ReportViewHolder(View itemView) {
            super(itemView);
            reportStudentName = itemView.findViewById(R.id.reportStudentName);
            reportAttendanceStatus = itemView.findViewById(R.id.reportAttendanceStatus);
        }
    }
}
