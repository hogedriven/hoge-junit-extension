package net.hogedriven.junit.matcher;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class ByteArrayMatcherTest {

    @Test
    public void match() throws Exception {
        ByteArrayMatcher matcher = new ByteArrayMatcher(new byte[] { 1, 2, 3 });
        boolean result = matcher.matches(new byte[] { 1, 2, 3 });
        assertThat(result, is(true));
    }

    @Test
    public void unmatch() throws Exception {
        ByteArrayMatcher matcher = new ByteArrayMatcher(new byte[] { 1, 2, 3 });
        boolean result = matcher.matches(new byte[] { 1, 2, 3, 4 });
        assertThat(result, is(false));
    }

}
