package net.hogedriven.junit.matcher;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.hamcrest.Description;
import org.junit.internal.matchers.TypeSafeMatcher;

public class SqlTimestampMatcher extends TypeSafeMatcher<Timestamp> {

    private static DateFormat defaultDateFormat = new SimpleDateFormat(
        "yyyy-MM-dd HH:mm:ss");

    private final Timestamp timestamp;

    public SqlTimestampMatcher(String source, DateFormat dateFormat)
            throws ParseException {
        this.timestamp = new Timestamp(dateFormat.parse(source).getTime());
    }

    public SqlTimestampMatcher(String source) throws ParseException {
        this(source, defaultDateFormat);
    }

    public void describeTo(Description description) {
        description.appendValue(timestamp);
    }

    @Override
    public boolean matchesSafely(Timestamp item) {
        return item.equals(timestamp);
    }

    public static void setDefaultDateFormat(DateFormat dateFormat) {
        defaultDateFormat = dateFormat;
    }
}
