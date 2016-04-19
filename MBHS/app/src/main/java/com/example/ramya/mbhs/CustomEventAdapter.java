package com.example.ramya.mbhs;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Ramya on 3/25/2016.
 */
public class CustomEventAdapter extends ArrayAdapter<Event> {

    public CustomEventAdapter(Context context, Event[] values) {
        super(context, R.layout.custom_row_layout, values);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        //return super.getView(position, convertView, parent);

        LayoutInflater theInflater = LayoutInflater.from(getContext());
        View theView = theInflater.inflate(R.layout.custom_row_layout, parent, false);

        TextView eventName = (TextView) theView.findViewById(R.id.EventName);
        eventName.setText(getItem(position).title);

        TextView eventDescription = (TextView) theView.findViewById(R.id.EventDescription);
        eventDescription.setText(getItem(position).description);

        TextView eventLocation = (TextView) theView.findViewById(R.id.EventLocation);
        eventLocation.setText(getItem(position).location);

        TextView eventDate = (TextView) theView.findViewById(R.id.EventDate);
        eventDate.setText(getItem(position).startDate);

        TextView eventTime = (TextView) theView.findViewById(R.id.EventTime);
        eventTime.setText(getItem(position).startTime);

        //TODO add database values
        return theView;
    }

}

