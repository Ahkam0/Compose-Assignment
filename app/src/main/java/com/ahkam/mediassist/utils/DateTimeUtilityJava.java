package com.ahkam.mediassist.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateTimeUtilityJava {
    private final static long TWENTY_4_HOURS = 24 * 60 * 60 * 1000;

    public static String getDate(long timeStamp)
    {
        Date date = new Date(timeStamp); // *1000 is to convert seconds to milliseconds
        SimpleDateFormat sdf = new SimpleDateFormat("d MMMM, yyyy", Locale.ENGLISH); // the format of your date
        return sdf.format(date);
    }

    public static String getTime(long timeStamp)
    {
        Date date = new Date(timeStamp); // *1000 is to convert seconds to milliseconds
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm a"); // the format of your date
        return sdf.format(date);
    }

}

