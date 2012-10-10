package net.hogedriven.junit.matcher;

import java.util.Arrays;

import org.hamcrest.Description;
import org.junit.internal.matchers.TypeSafeMatcher;

public class ObjectArrayMatcher<T> extends TypeSafeMatcher<T[]> {

    private final T[] expected;

    public ObjectArrayMatcher(T[] expected) {
        this.expected = expected;
    }

    public void describeTo(Description description) {
        description.appendText(Arrays.toString(expected));
    }

    @Override
    public boolean matchesSafely(T[] item) {
        return Arrays.equals(item, expected);
    }

}
