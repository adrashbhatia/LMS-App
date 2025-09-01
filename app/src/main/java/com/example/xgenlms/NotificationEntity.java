package com.example.xgenlms;

public class NotificationEntity {
    private String title;
    private String message;
    private String timestamp;
    private boolean isRead;

    public NotificationEntity(String title, String message, String timestamp, boolean isRead) {
        this.title = title;
        this.message = message;
        this.timestamp = timestamp;
        this.isRead = isRead;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
