package com.example.ramya.mbhs;

import android.graphics.Color;

import java.util.Calendar;

public class CalendarDayEvent {

    public String title;
    public String description;
    public String location;
    public String startDate;
    public String endDate;
    public String startTime;
    public String endTime;
    public long timeInMillis;
    public int color;
    public Event linkedEvent;

//    private final Image icon;

    public CalendarDayEvent(final long timeInMillis, final int color, final String n, final String d, String l) {
        this.timeInMillis = timeInMillis;
        this.color = color;
        this.title = n;
        this.description = d;
        this.location = l;
    }

    public CalendarDayEvent (Event e) {
        this.timeInMillis =  Calendar.getInstance().getTimeInMillis();
        this.title = e.title;
        this.description = e.description;
        this.startDate = e.startDate;
        this.endDate = e.endDate;
        this.startTime = e.startTime;
        this.endTime = e.endTime;
        this.color = Color.DKGRAY;
        this.linkedEvent = e;
    }

    public long getTimeInMillis() {
        return timeInMillis;
    }

    public int getColor() {
        return color;
    }

    public String getName() {
        return title;
    }

    public String getDesc() {
        return description;
    }

//    public Image getIcon() {
//        return icon;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CalendarDayEvent event = (CalendarDayEvent) o;

        if (color != event.color) return false;
        if (timeInMillis != event.timeInMillis) return false;
        if (!description.equals(event.description)) return false;
        if (!title.equals(event.title)) return false;
//      if (!icon) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (timeInMillis ^ (timeInMillis >>> 32));
        result = 31 * result + color;
        return result;
    }

    @Override
    public String
    toString() {
        return title + "\n" + description;
    }
}