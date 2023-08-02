package com.example.groupcalendar;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        // 설정 페이지의 UI 구현
        // 해당 부분은 activity_settings.xml 파일을 참조하여 구현하시면 됩니다.
        // 설정 페이지의 UI 요소들을 findViewById를 통해 가져와서 처리합니다.
        // 예시로 TextView를 추가하여 "설정 페이지"라는 텍스트를 표시하는 방법을 보여드리겠습니다.
        TextView textView = findViewById(R.id.textView);
        textView.setText("설정 페이지");
    }
}

