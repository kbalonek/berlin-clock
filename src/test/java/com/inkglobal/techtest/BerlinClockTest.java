package com.inkglobal.techtest;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class BerlinClockTest {

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
    public void should_light_the_correct_number_of_lamps_in_1st_row_for_1pm(){
        // given
        String input = "13:00:00";

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

    @Test
    public void should_light_the_correct_number_of_lamps_in_3rd_row_for_11_53_am(){
        // given
        String input = "11:53:00";

        // when
        BerlinClock clock = new BerlinClock(input);
        String thirdRow = clock.getThirdRow();

        // then
        assertThat(thirdRow, is(equalTo("YYRYYRYYRYO")));
    }

    @Test
    public void should_light_the_correct_number_of_lamps_in_4th_row_for_11_53_am(){
        // given
        String input = "11:53:00";

        // when
        BerlinClock clock = new BerlinClock(input);
        String thirdRow = clock.getFourthRow();

        // then
        assertThat(thirdRow, is(equalTo("YYYO")));
    }

    @Test
    public void should_return_correct_text_representation_for_00_00_00() {
        String input = "00:00:00";
        String expectedResult = "Y\n"
                + "OOOO\n"
                + "OOOO\n"
                + "OOOOOOOOOOO\n"
                + "OOOO";
        // when
        BerlinClock clock = new BerlinClock(input);
        String result = clock.getTextRepresentation();

        // then
        assertThat(result, is(equalTo(expectedResult)));
    }

    @Test
    public void should_return_correct_text_representation_for_13_17_01() {
        String input = "13:17:01";
        String expectedResult = "O\n"
                + "RROO\n"
                + "RRRO\n"
                + "YYROOOOOOOO\n"
                + "YYOO";
        // when
        BerlinClock clock = new BerlinClock(input);
        String result = clock.getTextRepresentation();

        // then
        assertThat(result, is(equalTo(expectedResult)));
    }

    @Test
    public void should_return_correct_text_representation_for_23_59_59() {
        String input = "23:59:59";
        String expectedResult = "O\n"
                + "RRRR\n"
                + "RRRO\n"
                + "YYRYYRYYRYY\n"
                + "YYYY";
        // when
        BerlinClock clock = new BerlinClock(input);
        String result = clock.getTextRepresentation();

        // then
        assertThat(result, is(equalTo(expectedResult)));
    }

    @Test
    public void should_return_correct_text_representation_for_24_00_00() {
        String input = "24:00:00";
        String expectedResult = "Y\n"
                + "RRRR\n"
                + "RRRR\n"
                + "OOOOOOOOOOO\n"
                + "OOOO";
        // when
        BerlinClock clock = new BerlinClock(input);
        String result = clock.getTextRepresentation();

        // then
        assertThat(result, is(equalTo(expectedResult)));
    }
}
