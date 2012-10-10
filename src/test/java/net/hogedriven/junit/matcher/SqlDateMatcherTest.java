package net.hogedriven.junit.matcher;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Test;

public class SqlDateMatcherTest {

    @Test
    public void match() throws Exception {
        SqlDateMatcher matcher = new SqlDateMatcher("1234-05-06");
        Date date = Date.valueOf("1234-05-06");
        boolean result = matcher.matches(date);
        assertThat(result, is(true));
    }

    @Test
    public void unmatch() throws Exception {
        SqlDateMatcher matcher = new SqlDateMatcher("1234-05-06");
        Date date = Date.valueOf("1234-05-07");
        boolean result = matcher.matches(date);
        assertThat(result, is(false));
    }

}
