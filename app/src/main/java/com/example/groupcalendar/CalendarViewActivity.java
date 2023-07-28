package com.example.groupcalendar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.github.sundeepk.compactcalendarview.domain.Event;
import com.github.sundeepk.compactcalendarview.CompactCalendarView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
public class CalendarViewActivity extends AppCompatActivity {
    private List<Event> personalEventsList;
    private List<Event> groupEventsList;
    private static final int REQUEST_CODE_CREATE_EVENT = 1;
    private CustomCalendarView customCalendarView;
    private EventAdapter eventAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar_view);

        // 캘린더 뷰를 처리하는 코드 추가
        customCalendarView = findViewById(R.id.customCalendarView);
        // 이벤트 리스트 초기화
        personalEventsList = new ArrayList<>();
        groupEventsList = new ArrayList<>();

        // Set up RecyclerView for displaying events
        RecyclerView recyclerView = findViewById(R.id.eventRecyclerView);
        eventAdapter = new EventAdapter(personalEventsList); // Personal 이벤트 목록을 어댑터에 설정
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(eventAdapter);

        // 이벤트 추가 버튼과 관련된 코드 추가
        Button addEventButton = findViewById(R.id.addEventButton);
        addEventButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 이벤트 추가 버튼을 누르면 CreateEventActivity로 이동
                Intent intent = new Intent(CalendarViewActivity.this, CreateEventActivity.class);
                startActivityForResult(intent, REQUEST_CODE_CREATE_EVENT);
            }
        });

        // 날짜를 클릭했을 때의 동작 처리
        customCalendarView.setListener(new CompactCalendarView.CompactCalendarViewListener() {
            @Override
            public void onDayClick(Date dateClicked) {
                // 선택한 날짜에 해당하는 이벤트를 표시하는 기능 추가
                List<Event> eventsOnDate = getEventsOnDate(dateClicked);
                eventAdapter.setEvents(eventsOnDate);
                eventAdapter.notifyDataSetChanged();
            }

            @Override
            public void onMonthScroll(Date firstDayOfNewMonth) {
                // 달력의 월이 변경되었을 때 처리할 코드 추가
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
                // 그룹 캘린더에 이벤트 추가
                for (String group : selectedGroups) {
                    newEvent = new Event(newEvent.getColor(), newEvent.getTimeInMillis(), false);
                    groupEventsList.add(newEvent);
                    customCalendarView.addGroupEvent(newEvent);
                }
            } else {
                // 개인 캘린더에 이벤트 추가
                personalEventsList.add(newEvent);
                customCalendarView.addPersonalEvent(newEvent);
            }

            // 이벤트 목록을 업데이트
            eventAdapter.notifyDataSetChanged();
        }
    }

    // 선택한 날짜에 해당하는 이벤트 목록을 가져오는 메서드
    private List<Event> getEventsOnDate(Date date) {
        List<Event> eventsOnDate = new ArrayList<>();
        for (Event event : personalEventsList) {
            if (isSameDate(event.getTimeInMillis(), date.getTime())) {
                eventsOnDate.add(event);
            }
        }
        for (Event event : groupEventsList) {
            if (isSameDate(event.getTimeInMillis(), date.getTime())) {
                eventsOnDate.add(event);
            }
        }
        return eventsOnDate;
    }

    // 두 날짜가 같은 날짜인지 확인하는 메서드
    private boolean isSameDate(long date1, long date2) {
        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        cal1.setTimeInMillis(date1);
        cal2.setTimeInMillis(date2);
        return cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) &&
                cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH) &&
                cal1.get(Calendar.DAY_OF_MONTH) == cal2.get(Calendar.DAY_OF_MONTH);
    }

    // 이벤트를 삭제하는 메서드
    private void deleteEvent(Event event) {
        if (event.equals(event)) {
            personalEventsList.remove(event);
            customCalendarView.removePersonalEvent(event);
        } else {
            groupEventsList.remove(event);
            customCalendarView.removeGroupEvent(event);
        }

        // 이벤트 목록을 업데이트
        eventAdapter.notifyDataSetChanged();
    }
}