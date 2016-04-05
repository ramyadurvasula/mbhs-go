package com.example.ramya.mbhs;

/**
 * Created by Ramya on 3/25/2016.
 */
public class Event {

    public String title;
    public String description;
    public String location;
    public String startDate;
    public String endDate;
    public String startTime;
    public String endTime;

    //default constructor
    public Event() {};

    //constructor
    public Event(String t, String d, String l, String sD, String eD, String sT, String eT) {
        title = t;
        description = d;
        location = l;
        startDate = sD;
        endDate = eD;
        startTime = sT;
        endTime = eT;
    }

}
