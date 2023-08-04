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
        // 해당 부분은 activity_default_calendar.xml 파일을 참조하여 구현
        // 여기에 원하는 기능을 추가하세요.
        // 예시로 TextView를 추가하여 "기본 캘린더 선택 페이지"라는 텍스트를 표시하는 방법을 보여드리겠습니다.
        TextView textView = findViewById(R.id.textView);
        textView.setText("기본 캘린더 선택 페이지");

        // 기능 추가 예시: 여기에 원하는 기능을 추가하세요.
    }
}
