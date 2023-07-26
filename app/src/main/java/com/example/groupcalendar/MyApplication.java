package com.example.groupcalendar;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import timber.log.Timber;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        // 로깅 라이브러리 초기화
        initLoggingLibrary();

        // 앱 설정 초기화
        initAppSettings();
    }

    private void initLoggingLibrary() {
        // 로깅 라이브러리 초기화 작업 수행
        Timber.plant(new Timber.DebugTree());
    }

    private void initAppSettings() {
        // 앱 설정 초기화 작업 수행
        // 예: SharedPreferences를 사용하여 앱 설정을 초기화
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        boolean isAppInitialized = preferences.getBoolean("APP_INITIALIZED", false);

        if (!isAppInitialized) {
            // 앱이 처음 실행되었을 때의 처리
            // 예: 기본 설정값을 저장하고 초기화를 완료했음을 표시
            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean("APP_INITIALIZED", true);
            editor.apply();
        }
    }
    // 추가적인 메서드를 정의하여 앱의 설정이나 초기화 작업을 수행할 수 있습니다.
    // 예: 특정 설정 값 반환, 데이터 초기화 등
}
