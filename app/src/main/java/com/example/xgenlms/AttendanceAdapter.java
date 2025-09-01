package com.example.xgenlms;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class AttendanceAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<AttendanceRecord> attendanceRecords;

    public AttendanceAdapter(Context context, ArrayList<AttendanceRecord> attendanceRecords) {
        this.context = context;
        this.attendanceRecords = attendanceRecords;
    }

    @Override
    public int getCount() {
        return attendanceRecords.size();
    }

    @Override
    public Object getItem(int position) {
        return attendanceRecords.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.attendance_list_item, parent, false);
        }

        AttendanceRecord record = attendanceRecords.get(position);

        TextView dateTextView = convertView.findViewById(R.id.attendance_date);
        TextView statusTextView = convertView.findViewById(R.id.attendance_status);

        dateTextView.setText(record.getDate());
        statusTextView.setText(record.getStatus());

        return convertView;
    }
}
