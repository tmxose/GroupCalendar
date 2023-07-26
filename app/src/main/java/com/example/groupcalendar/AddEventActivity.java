// AddEventActivity.java
package com.example.groupcalendar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddEventActivity extends AppCompatActivity {

    private EditText titleEditText;
    private EditText descriptionEditText;
    private Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);

        titleEditText = findViewById(R.id.titleEditText);
        descriptionEditText = findViewById(R.id.descriptionEditText);
        saveButton = findViewById(R.id.saveButton);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 사용자가 입력한 이벤트 정보를 저장하고 메인 액티비티로 전달
                String title = titleEditText.getText().toString();
                String description = descriptionEditText.getText().toString();

                // 이벤트 정보를 메인 액티비티로 전달하는 코드 작성
                Intent intent = new Intent();
                intent.putExtra("title", title);
                intent.putExtra("description", description);
                setResult(RESULT_OK, intent);

                // 액티비티 종료
                finish();
            }
        });
    }
}
