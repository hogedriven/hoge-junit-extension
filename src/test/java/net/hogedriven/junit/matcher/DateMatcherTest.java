package net.hogedriven.junit.matcher;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

public class DateMatcherTest {

    @Test
    public void match() throws Exception {
        DateMatcher matcher = new DateMatcher("1234-05-06 07:08:09");
        Date date =
            new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                .parse("1234-05-06 07:08:09");
        boolean result = matcher.matches(date);
        assertThat(result, is(true));
    }

    @Test
    public void unmatch() throws Exception {
        DateMatcher matcher = new DateMatcher("1234-05-06 07:08:09");
        Date date =
            new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                .parse("1234-05-06 07:08:10");
        boolean result = matcher.matches(date);
        assertThat(result, is(false));
    }

}
