package com.app.airmenu.utils;

import android.util.Log;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.SimpleTimeZone;
import java.util.TimeZone;

/**
 * Helper class for handling a most common subset of ISO 8601 strings
 * (in the following format: "2008-03-01T13:00:00+01:00"). It supports
 * parsing the "Z" timezone, but many other less-used features are
 * missing.
 */
public final class ISO8601 {

    public static final String TAG = ISO8601.class.getSimpleName();

    /** Transform Calendar to ISO 8601 string. */
    public static String fromCalendar(final Calendar calendar) {
        Date date = calendar.getTime();
        String formatted = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .format(date);
        return formatted.substring(0, 22) + ":" + formatted.substring(22);
    }

    /** Get current date and time formatted as ISO 8601 string. */
    public static String now() {
        return fromCalendar(GregorianCalendar.getInstance());
    }

    /** Transform ISO 8601 string to Calendar. */
    public static long toCalendar(final String iso8601string)
            throws ParseException {
        Calendar calendar = GregorianCalendar.getInstance();
        String s = iso8601string.replace("Z", "+00:00");
        try {
            s = s.substring(0, 22) + s.substring(23);  // to get rid of the ":"
        } catch (IndexOutOfBoundsException e) {
            throw new ParseException("Invalid length", 0);
        }

        String[] firstSplit = s.split("T");

        String[] secondSplit = firstSplit[1].toString().split("\\+");



        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT -0400"));
        Date date = sdf.parse(firstSplit[0]+"_"+secondSplit[0]);

      //  calendar.setTime(date);
        return date.getTime();
    }

//    public static long toCalendarGmt(final String iso8601string)
//            throws ParseException {
//
//
//
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.getDefault());
//        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
//
//        Log.e("TAG", "sdf zone is : "+sdf.getTimeZone().getDisplayName()+"$$$$"+ sdf.getTimeZone().getID()+"$$$$"+sdf.getTimeZone().getRawOffset());
//        Date date = sdf.parse(iso8601string);
//
//      //  calendar.setTime(date);
//        return date.getTime();
//    }

    public static long toCalendarGmt(final String iso8601string) throws ParseException {
        Date date = new Date();
        String NEW_PATTERN = "yyyy-MM-dd'T'HH:mm:ss'Z'";
        String OLD_PATTERN = "yyyy-MM-dd'T'HH:mm:ssZ";

        try {
            SimpleDateFormat sdf = new SimpleDateFormat(OLD_PATTERN, Locale.getDefault());
            sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
         //   Log.e("TAG", "sdf zone is : " + sdf.getTimeZone().getDisplayName() + "$$$$" + sdf.getTimeZone().getID() + "$$$$" + sdf.getTimeZone().getRawOffset());
            date = sdf.parse(iso8601string);

        } catch (Exception e) {
            Log.e(TAG, "toCalendarGmt: " + e.getMessage());
            SimpleDateFormat sdf = new SimpleDateFormat(NEW_PATTERN, Locale.getDefault());
            sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
            date = sdf.parse(iso8601string);
        }

        return date.getTime();
    }

    public static String formatDate(long milliseconds) /* This is your topStory.getTime()*1000 */ {
        DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy' 'HH:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(milliseconds);
        TimeZone tz = TimeZone.getDefault();
        sdf.setTimeZone(tz);
        return sdf.format(calendar.getTime());
    }
}