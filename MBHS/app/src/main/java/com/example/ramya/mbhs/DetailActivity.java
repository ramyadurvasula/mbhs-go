package com.example.ramya.mbhs;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

/**
 * Created by Ramya on 4/6/2016.
 */
public class DetailActivity extends ToolbarActivity {

    protected void onCreate(Bundle savedInstanceState) {

        //create the main view
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //toolbar stuff
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        String[] newEvent;
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                newEvent= null;
            } else {
                newEvent= extras.getStringArray("thisEvent");
            }
        } else {
            newEvent = (String[]) savedInstanceState.getSerializable("thisEvent");
        }

        TextView eventName = (TextView) findViewById(R.id.thisEventName);
        eventName.setText(newEvent[0]);

        TextView eventDescription = (TextView) findViewById(R.id.thisEventDescription);
        eventDescription.setText(newEvent[1]);

        TextView eventLocation = (TextView) findViewById(R.id.thisEventLocation);
        eventLocation.setText(newEvent[2]);

        TextView eventDate = (TextView) findViewById(R.id.thisEventDateTime);
        eventDate.setText(newEvent[7]);

    }

}
