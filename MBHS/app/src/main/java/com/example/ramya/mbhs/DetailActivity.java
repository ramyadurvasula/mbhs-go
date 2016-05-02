package com.example.ramya.mbhs;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.TextView;

/**
 * Created by Ramya on 4/6/2016.
 */
public class DetailActivity extends AppCompatActivity {

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

        //TODO: Fix date/time string
        //TODO: Modify spacing on detail activity page

        TextView eventName = (TextView) findViewById(R.id.thisEventName);
        eventName.setText(newEvent[0]);

        TextView eventDescription = (TextView) findViewById(R.id.thisEventDescription);
        eventDescription.setText(newEvent[1]);

        TextView eventLocation = (TextView) findViewById(R.id.thisEventLocation);
        eventLocation.setText(newEvent[2]);

        TextView eventDate = (TextView) findViewById(R.id.thisEventDateTime);
        eventDate.setText(newEvent[3]);

    }

    @Override
    //TODO: Add this to a superclass of basic activities
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home_page, menu);
        return true;
    }

}
