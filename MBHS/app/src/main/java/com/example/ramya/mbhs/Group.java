package com.example.ramya.mbhs;

/**
 * Created by Ramya on 3/25/2016.
 */
public class Group {

    public String name;
    public String description;
    public String contact;

    //default constructor
    public Group() {};

    //constructor
    public Group(String n, String d, String c) {
        name = n;
        description = d;
        contact = c;
    }

    public String[] toStringArray() {

        String[] thisGroup = new String[3];

        thisGroup[0] = this.name;
        thisGroup[1] = this.description;
        thisGroup[2] = this.contact;

        return thisGroup;

    }

}
