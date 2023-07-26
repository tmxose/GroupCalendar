package com.example.groupcalendar;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 캘린더 이벤트 예시
        CalendarEvent event1 = new CalendarEvent("이벤트 1", "2023-06-20", "10:00", "11:00");
        CalendarEvent event2 = new CalendarEvent("이벤트 2", "2023-06-21", "14:00", "15:30");

        CalendarManager.getInstance().addEvent(event1);
        CalendarManager.getInstance().addEvent(event2);
    }
}
