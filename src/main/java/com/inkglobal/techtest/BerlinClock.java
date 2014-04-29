package com.inkglobal.techtest;

import org.joda.time.LocalTime;

public class BerlinClock {
    private final LocalTime time;

    /**
     *
     * @param time in format "HH:MM:SS"
     *
     */
    public BerlinClock(String input) {
        this.time = new LocalTime(input);
    }

    public LocalTime getTime() {
        return time;
    }
}
