package com.tavisca.assignments;

public class DateFunctionsHelper {

    static String getStringTime(int hours, int minutes, int seconds){
        String date = "";
        if((""+hours).length() == 1){
            date += "0";
        }
        date += hours+":";
        if((""+minutes).length() == 1){
            date += "0";
        }
        date += minutes + ":";
        if((""+seconds).length() == 1){
            date += "0";
        }
        date += seconds;
        return date;
    }

    static String getValidTimeInString(int hours, int minutes, int seconds){
        if(seconds >= 60){
            seconds %= 60;
            minutes += 1;
        }
        if(minutes >= 60){
            minutes %= 60;
            hours += 1;
        }
        if(hours >= 23){
            hours %= 24;
        }

        return getStringTime(hours, minutes, seconds);

    }

    String getLexiSmallestTime(String startTime, String endTime){
        return "";
    }
}
