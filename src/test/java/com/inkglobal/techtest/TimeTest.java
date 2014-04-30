package com.inkglobal.techtest;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class TimeTest {

    @Test
    public void should_parse_the_0AM_input_string() {
        // given
        String input = "00:00:00";

        // when
        Time time = new Time(input);

        // then
        assertThat(time.getHours(), is(equalTo(0)));
        assertThat(time.getMinutes(), is(equalTo(0)));
        assertThat(time.getSeconds(), is(equalTo(0)));
    }

    @Test
    public void should_parse_the_13_17_01_input_string() {
        // given
        String input = "13:17:01";

        // when
        Time time = new Time(input);

        // then
        assertThat(time.getHours(), is(equalTo(13)));
        assertThat(time.getMinutes(), is(equalTo(17)));
        assertThat(time.getSeconds(), is(equalTo(1)));
    }

    @Test
    public void should_parse_the_24_00_00_input_string() {
        // given
        String input = "24:00:00";

        // when
        Time time = new Time(input);

        // then
        assertThat(time.getHours(), is(equalTo(24)));
        assertThat(time.getMinutes(), is(equalTo(0)));
        assertThat(time.getSeconds(), is(equalTo(0)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_invalid_arg_exception_for_invalid_output() {
        // given
        String input = "13:17:01:21";

        // when
        Time time = new Time(input);

        // then: exception should be thrown
    }
}
