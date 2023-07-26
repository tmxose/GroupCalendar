package com.example.groupcalendar;

public class CalendarEvent {
    private String eventName;
    private String eventDate;
    private String startTime;
    private String endTime;

    public CalendarEvent(String eventName, String eventDate, String startTime, String endTime) {
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    // 필요에 따라 게터와 세터를 추가합니다.
}
