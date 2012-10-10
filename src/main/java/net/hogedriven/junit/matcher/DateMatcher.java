package net.hogedriven.junit.matcher;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hamcrest.Description;
import org.junit.internal.matchers.TypeSafeMatcher;

public class DateMatcher extends TypeSafeMatcher<Date> {

    private static DateFormat defaultDateFormat = new SimpleDateFormat(
        "yyyy-MM-dd HH:mm:ss");

    private final Date date;

    public DateMatcher(String source, DateFormat dateFormat)
            throws ParseException {
        this.date = dateFormat.parse(source);
    }

    public DateMatcher(String source) throws ParseException {
        this(source, defaultDateFormat);
    }

    @Override
    public void describeTo(Description description) {
        description.appendValue(date);
    }

    @Override
    public boolean matchesSafely(Date item) {
        return item.equals(date);
    }

    public static void setDefaultDateFormat(DateFormat dateFormat) {
        defaultDateFormat = dateFormat;
    }
}
