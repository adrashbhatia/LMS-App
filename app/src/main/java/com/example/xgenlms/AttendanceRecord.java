package com.example.xgenlms;

public class AttendanceRecord {
    private String date;
    private String status;

    public AttendanceRecord(String date, String status) {
        this.date = date;
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public String getStatus() {
        return status;
    }
}
