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

    public String[] toStringArray() {

        String[] thisEvent = new String[8];

        thisEvent[0] = this.title;
        thisEvent[1] = this.description;
        thisEvent[2] = this.location;
        thisEvent[3] = this.startDate;
        thisEvent[4] = this.endDate;
        thisEvent[5] = this.startTime;
        thisEvent[6] = this.endTime;

        //TODO make sure startDate and startTime CANNOT be null!
        String dateString = new String();
        dateString += startDate + " " + startTime;
        if (endTime.equals(null)) endTime = "";
        if (endDate.equals(null)) endDate = "";
        //one day only
        if (startDate.equals(endDate)) {
            if (!startTime.equals(endTime)) {
                dateString += " - " + endDate + " " + endTime;
            }
        }
        //multiple days
        else {
            dateString += " - " + endDate + " " + endTime;
        }

        thisEvent[7] = dateString;

        return thisEvent;

    }

}
