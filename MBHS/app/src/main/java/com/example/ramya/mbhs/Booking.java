package com.example.ramya.mbhs;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by heroed on 4/21/2016.
 */
public class Booking {
    private String title;
    private Date date;
    private String description;

    public Booking(String title, Date date, String desc) {
        this.title = title;
        this.date = date;
        this.description = desc;
    }


    @Override
    public String toString() {
        DateFormat df = new SimpleDateFormat("HH:mm", Locale.US);
        return title + "\n" + description + "   " + df.format(date);
    }

    public String getTitle() {
        return title;
    }
}