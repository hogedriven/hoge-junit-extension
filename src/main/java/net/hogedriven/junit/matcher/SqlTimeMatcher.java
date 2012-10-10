package net.hogedriven.junit.matcher;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.hamcrest.Description;
import org.junit.internal.matchers.TypeSafeMatcher;

public class SqlTimeMatcher extends TypeSafeMatcher<Time> {

    private static DateFormat defaultDateFormat = new SimpleDateFormat(
        "HH:mm:ss");

    private final Time time;

    public SqlTimeMatcher(String source, DateFormat dateFormat)
            throws ParseException {
        this.time = new Time(dateFormat.parse(source).getTime());
    }

    public SqlTimeMatcher(String source) throws ParseException {
        this(source, defaultDateFormat);
    }

    public void describeTo(Description description) {
        description.appendValue(time);
    }

    @Override
    public boolean matchesSafely(Time item) {
        return item.equals(time);
    }

    public static void setDefaultDateFormat(DateFormat dateFormat) {
        defaultDateFormat = dateFormat;
    }
}
