package net.hogedriven.junit.matcher;

import java.util.Arrays;

import org.hamcrest.Description;
import org.junit.internal.matchers.TypeSafeMatcher;

public class ByteArrayMatcher extends TypeSafeMatcher<byte[]> {

    private final byte[] expected;

    public ByteArrayMatcher(byte[] expected) {
        this.expected = expected;
    }

    public void describeTo(Description description) {
        description.appendText(Arrays.toString(expected));
    }

    @Override
    public boolean matchesSafely(byte[] item) {
        return Arrays.equals(item, expected);
    }

}
