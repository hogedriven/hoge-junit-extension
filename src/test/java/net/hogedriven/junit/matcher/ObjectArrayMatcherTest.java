package net.hogedriven.junit.matcher;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class ObjectArrayMatcherTest {

    @Test
    public void match() throws Exception {
        ObjectArrayMatcher<String> matcher =
            new ObjectArrayMatcher<String>(new String[] { "a", "b", "c" });
        boolean result = matcher.matches(new String[] { "a", "b", "c" });
        assertThat(result, is(true));
    }

    @Test
    public void unmatch() throws Exception {
        ObjectArrayMatcher<String> matcher =
            new ObjectArrayMatcher<String>(new String[] { "a", "b", "c" });
        boolean result = matcher.matches(new String[] { "a", "b", "c", "d" });
        assertThat(result, is(false));
    }

}
