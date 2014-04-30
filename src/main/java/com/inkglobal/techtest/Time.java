package com.inkglobal.techtest;

import org.joda.time.LocalTime;

public class Time {
    private int seconds;
    private int minutes;
    private int hours;

    public Time(String format) {
        // JodaTime doesn't recognize 24:00:00 as a valid time
        // so we have to "parse" it manually.
        if (format.equals("24:00:00")){
            this.hours = 24;
        } else {
            LocalTime localTime = new LocalTime(format);
            this.seconds = localTime.getSecondOfMinute();
            this.minutes = localTime.getMinuteOfHour();
            this.hours = localTime.getHourOfDay();
        }
    }

    public int getSeconds() {
        return seconds;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getHours() {
        return hours;
    }
}

