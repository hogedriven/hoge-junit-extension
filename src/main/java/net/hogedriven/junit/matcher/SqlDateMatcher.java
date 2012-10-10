package net.hogedriven.junit.matcher;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.hamcrest.Description;
import org.junit.internal.matchers.TypeSafeMatcher;

public class SqlDateMatcher extends TypeSafeMatcher<Date> {

    private static DateFormat defaultDateFormat = new SimpleDateFormat(
        "yyyy-MM-dd");

    private final Date date;

    public SqlDateMatcher(String source, DateFormat dateFormat)
            throws ParseException {
        this.date = new Date(dateFormat.parse(source).getTime());
    }

    public SqlDateMatcher(String source) throws ParseException {
        this(source, defaultDateFormat);
    }

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
