package com.example.ramya.mbhs;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class ExploreActivity extends ToolbarActivity {

    //TODO move these to the main activity so that they can be accessed from all pages
    private Group[] arrayOfGroups = new Group[] {
            new Group("Yoga Club", "Best club", "mbhsyoga@gmail.com"),
            new Group("Puzzle Lords", "PPZ VI is SECONDS AWAY!!", "Follow us on Twitter!"),
            new Group("Puzzle Lords", "PPZ VI is SECONDS AWAY!!", "Follow us on Twitter!"),
            new Group("Puzzle Lords", "PPZ VI is SECONDS AWAY!!", "Follow us on Twitter!")
    };

    private String[] groupNames = new String[] {"Yoga Club, Tennis Team, MBHS SGA, Puzzle Lords"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explore);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ListView listView = (ListView) findViewById(R.id.groupListView);
        //listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, groupNames));
        ListAdapter groupAdapter = new CustomGroupAdapter(this, arrayOfGroups);
        listView.setAdapter(groupAdapter);

        //TODO write and connect to the groupActivity class
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View v, int position,
                                    long arg3) {
                Group value = (Group) adapter.getItemAtPosition(position);
                //Intent i = new Intent(getContext(), DetailActivity.class);
                //i.putExtra("thisEvent", arrayOfEvents[position].toStringArray());
                //getContext().startActivity(i);

            }
        });

    }

}
