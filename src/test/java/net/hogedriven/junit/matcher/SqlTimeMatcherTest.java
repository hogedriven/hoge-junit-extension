package net.hogedriven.junit.matcher;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.sql.Time;

import org.junit.Test;

public class SqlTimeMatcherTest {

    @Test
    public void match() throws Exception {
        SqlTimeMatcher matcher = new SqlTimeMatcher("12:34:56");
        Time date = Time.valueOf("12:34:56");
        boolean result = matcher.matches(date);
        assertThat(result, is(true));
    }

    @Test
    public void unmatch() throws Exception {
        SqlTimeMatcher matcher = new SqlTimeMatcher("12:34:56");
        Time date = Time.valueOf("12:34:57");
        boolean result = matcher.matches(date);
        assertThat(result, is(false));
    }

}
