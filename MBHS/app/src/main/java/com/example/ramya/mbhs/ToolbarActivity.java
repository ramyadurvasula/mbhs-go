package com.example.ramya.mbhs;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class ToolbarActivity extends AppCompatActivity {

    SQLConnection connectClass;

    //TODO add icons to the action bar instead of words

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        connectClass = new SQLConnection();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home_page, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.home_page) {
            Intent intent = new Intent(this, MainActivity.class);
            this.startActivity(intent);
        }

        else if (id == R.id.explore) {
            Intent intent = new Intent(this, ExploreActivity.class);
            this.startActivity(intent);
        }

        else if (id == R.id.settings) {
            Intent intent = new Intent(this, SettingsActivity.class);
            this.startActivity(intent);
        }

        return super.onOptionsItemSelected(item);

    }

}
