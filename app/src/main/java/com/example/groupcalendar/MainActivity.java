package com.example.groupcalendar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.github.sundeepk.compactcalendarview.domain.Event;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_CREATE_EVENT = 1;
    private List<Event> personalEventsList; // Personal 이벤트 목록
    private List<Event> groupEventsList; // Group 이벤트 목록
    private EventAdapter eventAdapter;
    private CustomCalendarView customCalendarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        customCalendarView = findViewById(R.id.customCalendarView);

        // Personal 이벤트와 Group 이벤트를 저장할 목록 초기화
        personalEventsList = new ArrayList<>();
        groupEventsList = new ArrayList<>();

        // Set up RecyclerView for displaying events
        RecyclerView recyclerView = findViewById(R.id.eventRecyclerView);
        eventAdapter = new EventAdapter(personalEventsList); // Personal 이벤트 목록을 어댑터에 설정
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(eventAdapter);

        // Initialize the CustomCalendarView and add events
        customCalendarView = findViewById(R.id.customCalendarView);
        customCalendarView.addPersonalEvents(personalEventsList);
        customCalendarView.addGroupEvents(groupEventsList);

        // Set up the "Add Event" button
        Button addEventButton = findViewById(R.id.addEventButton);
        addEventButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CreateEventActivity.class);
                startActivityForResult(intent, REQUEST_CODE_CREATE_EVENT);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_CREATE_EVENT && resultCode == RESULT_OK) {
            // CreateEventActivity에서 새 이벤트를 받아옴
            Event newEvent = data.getParcelableExtra(CreateEventActivity.EXTRA_EVENT);
            List<String> selectedGroups = data.getStringArrayListExtra("selectedGroups");

            if (selectedGroups != null && !selectedGroups.isEmpty()) {
                for (String group : selectedGroups) {
                    newEvent = new Event(newEvent.getColor(), newEvent.getTimeInMillis(), false);
                    groupEventsList.add(newEvent); // Group 이벤트 목록에 추가
                    customCalendarView.addGroupEvents(Collections.singletonList(newEvent)); // CustomCalendarView에 Group 이벤트 추가
                }
            } else {
                personalEventsList.add(newEvent); // Personal 이벤트 목록에 추가
                customCalendarView.addPersonalEvents(Collections.singletonList(newEvent)); // CustomCalendarView에 Personal 이벤트 추가
            }

            // Update the RecyclerView with the new event
            eventAdapter.notifyDataSetChanged();
        }
    }

    // Add this method to handle adding group events
    public void addGroupEvents(List<Event> events) {
        groupEventsList.addAll(events); // Group 이벤트 목록에 추가
        customCalendarView.addGroupEvents(events); // CustomCalendarView에 Group 이벤트 추가
        eventAdapter.notifyDataSetChanged(); // RecyclerView에 변경된 이벤트 목록을 업데이트
    }
}
