package net.hogedriven.junit.matcher;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.sql.Timestamp;

import org.junit.Test;

public class SqlTimestampMatcherTest {

    @Test
    public void match() throws Exception {
        SqlTimestampMatcher matcher =
            new SqlTimestampMatcher("1234-05-06 07:08:09");
        Timestamp date = Timestamp.valueOf("1234-05-06 07:08:09");
        boolean result = matcher.matches(date);
        assertThat(result, is(true));
    }

    @Test
    public void unmatch() throws Exception {
        SqlTimestampMatcher matcher =
            new SqlTimestampMatcher("1234-05-06 07:08:09");
        Timestamp date = Timestamp.valueOf("1234-05-06 07:08:10");
        boolean result = matcher.matches(date);
        assertThat(result, is(false));
    }

}
