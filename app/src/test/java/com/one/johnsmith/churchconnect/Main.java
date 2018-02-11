package com.one.johnsmith.churchconnect;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

/**
 * Created by John Smith on 2/10/2018.
 */
public class Main {
    private long Time_milli;
    private String FormattedTime;

    //This takes in Epoch time
    public Main(long time) {
        Time_milli = time;
    }

    //This takes date format like Mon MMM DD HH:MM:SS EST YYYY in String
    public Main(String str) {
        FormattedTime = str;
    }

    //This turns String Mon MMM DD HH:MM:SS EST YYYY into milliseconds or epoch time
    public long setTime_milli(String str) {
        DateFormat dateFormat = new SimpleDateFormat("EEE MMM dd H:mm:ss z yyyy");
        long unixTime = 0;
        String time = str;
        dateFormat.setTimeZone(TimeZone.getTimeZone("EST-5:00")); //Specify your timezone
        try {
            unixTime = dateFormat.parse(time).getTime();
            //unixTime = unixTime ;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return unixTime;
    }

    //Returns the Milli seconds in the class
    public long getTime_milli() {
        return Time_milli;
    }

    //Returns the time into Mon MMM DD HH:MM:SS EST YYYY
    public String setFormattedTime() {
        SimpleDateFormat FormatTest = new SimpleDateFormat("EEE MMM dd H:mm:ss z yyyy");
        FormattedTime = FormatTest.format(Time_milli);

        return FormattedTime;
    }

    public long ChangeHours() {
        String thing = this.setFormattedTime();
        String answer = thing.substring(0, 10) + " 23:59:59 " + thing.substring(thing.length() - 8, thing.length());
        long RealAnswer = this.setTime_milli(answer);
        return RealAnswer;
    }
}