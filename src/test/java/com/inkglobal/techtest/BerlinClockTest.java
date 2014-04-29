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
}
