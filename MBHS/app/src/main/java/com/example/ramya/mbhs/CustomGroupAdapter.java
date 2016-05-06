package com.example.ramya.mbhs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by Ramya on 3/25/2016.
 */
public class CustomGroupAdapter extends ArrayAdapter<Group> {

    public CustomGroupAdapter(Context context, Group[] values) {
        super(context, R.layout.group_row_layout, values);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        //return super.getView(position, convertView, parent);

        LayoutInflater theInflater = LayoutInflater.from(getContext());
        View theView = theInflater.inflate(R.layout.group_row_layout, parent, false);

        //TODO add database values
        TextView groupName = (TextView) theView.findViewById(R.id.GroupName);
        groupName.setText(getItem(position).name);

        return theView;
    }

}

