package com.example.xgenlms;

public class ListData {
    String name;           // Course Name
    String duration;       // Course Duration
    String description;    // Course Description
    String content;        // Course Content
    int image;             // Course Image

    public ListData(String name, String s, String string, String s1, String string1, String s2, int image, int i) {
        this.name = name;
        this.duration = duration;
        this.description = description;
        this.content = content;
        this.image = image;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getDuration() {
        return duration;
    }

    public String getDescription() {
        return description;
    }

    public String getContent() {
        return content;
    }

    public int getImage() {
        return image;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setImage(int image) {
        this.image = image;
    }
}