package com.example.groupcalendar;

import android.os.Parcel;
import android.os.Parcelable;

public class Event implements Parcelable {
    private String title;
    private String description;
    private boolean isPersonal; // 이벤트가 개인 이벤트인지 여부를 나타내는 플래그

    public Event(String title, String description, boolean isPersonal) {
        this.title = title;
        this.description = description;
        this.isPersonal = isPersonal;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public boolean isPersonal() {
        return isPersonal;
    }

    // Parcelable 구현
    protected Event(Parcel in) {
        title = in.readString();
        description = in.readString();
        isPersonal = in.readByte() != 0;
    }

    public static final Creator<Event> CREATOR = new Creator<Event>() {
        @Override
        public Event createFromParcel(Parcel in) {
            return new Event(in);
        }

        @Override
        public Event[] newArray(int size) {
            return new Event[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(description);
        dest.writeByte((byte) (isPersonal ? 1 : 0));
    }

    // equals 메서드 오버라이드
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Event event = (Event) obj;
        return isPersonal == event.isPersonal &&
                title.equals(event.title) &&
                description.equals(event.description);
    }
}
