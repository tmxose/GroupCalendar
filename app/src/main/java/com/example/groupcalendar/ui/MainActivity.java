package com.example.groupcalendar.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import com.example.groupcalendar.R;
import com.example.groupcalendar.helpers.GroupManager;

public class MainActivity extends AppCompatActivity {

    private GroupManager groupManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        groupManager = new GroupManager();

        // 기본 캘린더 선택 버튼 처리
        Button defaultCalendarButton = findViewById(R.id.defaultCalendarButton);
        defaultCalendarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DefaultCalendarActivity.class);
                startActivity(intent);
            }
        });

        // 그룹/개인 캘린더 선택 버튼 처리
        Button groupCalendarButton = findViewById(R.id.groupCalendarButton);
        groupCalendarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CalendarViewActivity.class);
                startActivity(intent);
            }
        });

        // 설정 버튼 처리
        Button settingsButton = findViewById(R.id.settingsButton);
        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(intent);
            }
        });

        // 그룹 생성 버튼 처리
        Button createGroupButton = findViewById(R.id.createGroupButton);
        createGroupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createGroup();
            }
        });
    }

    private void createGroup() {
        // 그룹 생성 시 호출될 메서드
        // 예시로 임시 그룹 이름을 "테스트 그룹"으로 지정하겠습니다.
        groupManager.createGroup("테스트 그룹");
    }
}
