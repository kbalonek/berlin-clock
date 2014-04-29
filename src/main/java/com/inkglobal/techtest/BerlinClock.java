package com.inkglobal.techtest;

import org.joda.time.LocalTime;

public class BerlinClock {
    public static final int UPPER_ROWS_LENGTH = 4;
    public static final int HIGHEST_REPRESENTABLE_HOUR = 23;
    private final LocalTime time;

    /**
     *
     * @param input current time in format "HH:MM:SS"
     * @throws IllegalArgumentException when the input cannot be parsed
     */
    public BerlinClock(String input) {
        this.time = new LocalTime(input);
    }

    public LocalTime getTime() {
        return time;
    }

    public String getTopLamp() {
        final boolean isEven = getTime().getSecondOfMinute() % 2 == 0;
        return isEven ? "Y" : "O";
    }


    public String getFirstRow() {
        int hour = getTime().getHourOfDay();
        int numberOfRedLamps = hour / UPPER_ROWS_LENGTH;
        return constructRow(numberOfRedLamps, UPPER_ROWS_LENGTH);
    }

    private String constructRow(int numberOfRedLamps, int numberOfLampsTotal) {
        StringBuilder builder = new StringBuilder();
        for (int i=0; i < numberOfRedLamps; i++){
            builder.append("R");
        }
        for (int i=numberOfRedLamps; i < numberOfLampsTotal; i++) {
            builder.append("O");
        }
        return builder.toString();
    }

    public String getSecondRow() {
        int hour = getTime().getHourOfDay();
        int numberOfHoursPer1stRowLamp = HIGHEST_REPRESENTABLE_HOUR / UPPER_ROWS_LENGTH;
        int numberOfRedLamps = hour % numberOfHoursPer1stRowLamp;
        return constructRow(numberOfRedLamps, UPPER_ROWS_LENGTH);
    }
}
