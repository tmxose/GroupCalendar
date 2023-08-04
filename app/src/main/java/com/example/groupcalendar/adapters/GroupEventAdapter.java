package com.example.groupcalendar.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.groupcalendar.models.GroupEvent;
import com.example.groupcalendar.R;

import java.util.List;

public class GroupEventAdapter extends ArrayAdapter<GroupEvent> {

    private Context context;
    private List<GroupEvent> groupEvents;

    public GroupEventAdapter(Context context, List<GroupEvent> groupEvents) {
        super(context, 0, groupEvents);
        this.context = context;
        this.groupEvents = groupEvents;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(context).inflate(R.layout.list_item_group_event, parent, false);
        }

        GroupEvent currentEvent = groupEvents.get(position);

        TextView titleTextView = listItemView.findViewById(R.id.titleTextView);
        TextView dateTextView = listItemView.findViewById(R.id.dateTextView);
        TextView timeTextView = listItemView.findViewById(R.id.timeTextView);

        titleTextView.setText(currentEvent.getTitle());
        dateTextView.setText(currentEvent.getDate());
        timeTextView.setText(currentEvent.getTime());

        return listItemView;
    }
}
