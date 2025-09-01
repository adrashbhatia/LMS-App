package com.example.xgenlms;

public class Material {
    private String url;
    private String description;

    public Material(String url, String description) {
        this.url = url;
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public String getDescription() {
        return description;
    }
}
