package com.example.ramya.mbhs;

public class CalendarDayEvent {

    private final long timeInMillis;
    private final int color;
    private final String name;
    private final String desc;
//    private final Image icon;

    public CalendarDayEvent(final long timeInMillis, final int color, final String n, final String d) {
        this.timeInMillis = timeInMillis;
        this.color = color;
        this.name = n;
        this.desc = d;
//        this.icon = i;
    }

    public long getTimeInMillis() {
        return timeInMillis;
    }

    public int getColor() {
        return color;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
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
        if (!desc.equals(event.desc)) return false;
        if (!name.equals(event.name)) return false;
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
        return name + "\n" + desc;
    }
}