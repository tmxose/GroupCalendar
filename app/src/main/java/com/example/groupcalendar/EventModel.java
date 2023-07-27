package com.example.groupcalendar;

public class EventModel {
    private String title;
    private String description;
    private boolean isPersonal; // 개인 이벤트 여부를 나타내는 플래그

    public EventModel(String title, String description, boolean isPersonal) {
        this.title = title;
        this.description = description;
        this.isPersonal = isPersonal;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public boolean isPersonal() {
        return isPersonal;
    }
}
