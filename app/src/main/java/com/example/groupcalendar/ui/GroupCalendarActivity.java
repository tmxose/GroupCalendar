package com.example.groupcalendar.ui;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.groupcalendar.R;
import com.example.groupcalendar.adapters.GroupEventAdapter;
import com.example.groupcalendar.models.GroupEvent;

import java.util.ArrayList;
import java.util.List;

public class GroupCalendarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_calendar);

        // 그룹 캘린더 UI 구현 및 이벤트 리스트 추가
        // ListView를 사용하여 이벤트 리스트를 표시하고 GroupEventAdapter를 이용하여 데이터를 연결
        List<GroupEvent> events = new ArrayList<>();
        events.add(new GroupEvent("1", "회의", "2023-08-10", "14:00", "회의실 A", "중요한 회의입니다.", false));
        events.add(new GroupEvent("2", "점심 약속", "2023-08-15", "12:30", "레스토랑 B", "친구와 함께 점심 약속입니다.", false));

        ListView eventListView = findViewById(R.id.eventListView);
        GroupEventAdapter adapter = new GroupEventAdapter(this, events);
        eventListView.setAdapter(adapter);

    }
}
