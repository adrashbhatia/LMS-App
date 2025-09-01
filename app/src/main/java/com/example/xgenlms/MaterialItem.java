package com.example.xgenlms;

public class MaterialItem {
    private String description;
    private String link;

    public MaterialItem(String description, String link) {
        this.description = description;
        this.link = link;
    }

    public String getDescription() {
        return description;
    }

    public String getLink() {
        return link;
    }
}
