package com.inkglobal.techtest;

import org.joda.time.LocalTime;

public class BerlinClock {
    // the name of this constant isn't 100% correct - the clock can represent 24:00:00,
    // but I believe considering this edge case in the naming and logic below
    // would obscure the concept
    public static final int HIGHEST_REPRESENTABLE_HOUR = 23;
    private static final int HIGHEST_REPRESENTABLE_MINUTE = 59;

    public static final String THIRD_ROW_PATTERN = "YYRYYRYYRYY";
    private static final String FOURTH_ROW_PATTERN = "YYYY";
    public static final String FIRST_ROW_PATTERN = "RRRR";
    public static final String SECOND_ROW_PATTERN = "RRRR";


    private final Time time;

    /**
     * @param input current time in format "HH:MM:SS"
     * @throws IllegalArgumentException when the input cannot be parsed
     */
    public BerlinClock(String input) {
        this.time = new Time(input);
    }

    public Time getTime() {
        return time;
    }

    public String getTopLamp() {
        final boolean isEven = time.getSeconds() % 2 == 0;
        return isEven ? "Y" : "O";
    }


    public String getFirstRow() {
        int hour = time.getHours();
        int numberOfHoursPer1stRowLamp = HIGHEST_REPRESENTABLE_HOUR / FIRST_ROW_PATTERN.length();
        int numberOfRedLamps = hour / numberOfHoursPer1stRowLamp;
        return constructRow(numberOfRedLamps, FIRST_ROW_PATTERN);
    }

    public String getSecondRow() {
        int hour = time.getHours();
        int numberOfHoursPer1stRowLamp = HIGHEST_REPRESENTABLE_HOUR / SECOND_ROW_PATTERN.length();
        int numberOfRedLamps = hour % numberOfHoursPer1stRowLamp;
        return constructRow(numberOfRedLamps, SECOND_ROW_PATTERN);
    }

    public String getThirdRow() {
        int minute = time.getMinutes();
        int numberOfMinutesPer3rdRowLamp = HIGHEST_REPRESENTABLE_MINUTE / THIRD_ROW_PATTERN.length();
        int numberOfLampsOn = minute / numberOfMinutesPer3rdRowLamp;
        return constructRow(numberOfLampsOn, THIRD_ROW_PATTERN);
    }

    public String getFourthRow() {
        int minute = time.getMinutes();
        int numberOfMinutesPer3rdRowLamp = HIGHEST_REPRESENTABLE_MINUTE / THIRD_ROW_PATTERN.length();
        int numberOfLampsOn = minute % numberOfMinutesPer3rdRowLamp;
        return constructRow(numberOfLampsOn, FOURTH_ROW_PATTERN);
    }

    private String constructRow(int numberOfLampsOn, String fullRowPattern) {
        StringBuilder builder = new StringBuilder();
        builder.append(fullRowPattern.substring(0, numberOfLampsOn));
        for (int i=numberOfLampsOn; i < fullRowPattern.length(); i++) {
            builder.append("O");
        }
        return builder.toString();
    }
    public String getTextRepresentation() {
        StringBuilder builder = new StringBuilder();
        builder.append(getTopLamp());
        builder.append("\n");
        builder.append(getFirstRow());
        builder.append("\n");
        builder.append(getSecondRow());
        builder.append("\n");
        builder.append(getThirdRow());
        builder.append("\n");
        builder.append(getFourthRow());
        return builder.toString();
    }
}
