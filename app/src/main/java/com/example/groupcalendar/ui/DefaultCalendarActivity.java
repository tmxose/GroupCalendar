package com.example.groupcalendar.ui;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.groupcalendar.R;

public class DefaultCalendarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_default_calendar);

        // 기본 캘린더 선택 페이지의 UI 구현
        TextView textView = findViewById(R.id.textView);
        textView.setText("기본 캘린더 선택 페이지");
    }
}
