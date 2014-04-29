package com.inkglobal.techtest;

import org.joda.time.LocalTime;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class BerlinClockTest {

    @Test
    public void should_parse_the_0AM_input_string() {
        // given
        String input = "00:00:00";

        // when
        BerlinClock clock = new BerlinClock(input);

        // then
        LocalTime expectedTime = new LocalTime(input);
        assertThat(clock.getTime(), is(equalTo(expectedTime)));
        assertThat(clock.getTime().getHourOfDay(), is(equalTo(0)));
        assertThat(clock.getTime().getMinuteOfHour(), is(equalTo(0)));
        assertThat(clock.getTime().getSecondOfMinute(), is(equalTo(0)));
    }

    @Test
    public void should_parse_the_13_17_01_input_string() {
        // given
        String input = "13:17:01";

        // when
        BerlinClock clock = new BerlinClock(input);

        // then
        LocalTime expectedTime = new LocalTime(input);
        assertThat(clock.getTime(), is(equalTo(expectedTime)));
        assertThat(clock.getTime().getHourOfDay(), is(equalTo(13)));
        assertThat(clock.getTime().getMinuteOfHour(), is(equalTo(17)));
        assertThat(clock.getTime().getSecondOfMinute(), is(equalTo(1)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_invalid_arg_exception_for_invalid_output() {
        // given
        String input = "13:17:01:21";

        // when
        BerlinClock clock = new BerlinClock(input);

        // then: exception should be thrown
    }

    @Test
    public void should_light_the_top_lamp_for_even_seconds(){
        // given
        String input = "13:17:12";

        // when
        BerlinClock clock = new BerlinClock(input);
        String topLamp = clock.getTopLamp();

        // then
        assertThat(topLamp, is(equalTo("Y")));
    }

    @Test
    public void should_dim_the_top_lamp_for_odd_seconds(){
        // given
        String input = "13:17:11";

        // when
        BerlinClock clock = new BerlinClock(input);
        String topLamp = clock.getTopLamp();

        // then
        assertThat(topLamp, is(equalTo("O")));
    }

    @Test
    public void should_light_the_correct_number_of_lamps_in_1st_row_for_11am(){
        // given
        String input = "11:00:00";

        // when
        BerlinClock clock = new BerlinClock(input);
        String firstRow = clock.getFirstRow();

        // then
        assertThat(firstRow, is(equalTo("RROO")));
    }

    @Test
    public void should_light_the_correct_number_of_lamps_in_2nd_row_for_11am(){
        // given
        String input = "11:00:00";

        // when
        BerlinClock clock = new BerlinClock(input);
        String firstRow = clock.getSecondRow();

        // then
        assertThat(firstRow, is(equalTo("ROOO")));
    }
}
