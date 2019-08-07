package com.tavisca.assignments;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

    static int[] stringToIntegerTime(String simpleFormattedTime){
        String[] time = simpleFormattedTime.split(":");
        return new int[]{Integer.parseInt(time[0]),Integer.parseInt(time[1]),Integer.parseInt(time[2])};
    }

    static String getValidTimeInString(int hours, int minutes, int seconds){
        if(seconds >= 60){
            minutes += seconds/60;
            seconds %= 60;
        }
        if(minutes >= 60){
            hours += minutes/60;
            minutes %= 60;
        }
        if(hours >= 23){
            hours %= 24;
        }

        return getStringTime(hours, minutes, seconds);

    }

    static String getLexiSmallestTime(int startTimeHours, int startTimeMinutes, int startTimeSeconds,  int endTimeHours, int endTimeMinutes, int endTimeSeconds){
        String endTime = getValidTimeInString(endTimeHours, endTimeMinutes, endTimeSeconds);
        int currentTimeHours = startTimeHours, currentTimeMinutes = startTimeMinutes, currentTimeSeconds = startTimeSeconds;
        String currentTime = getValidTimeInString(currentTimeHours, currentTimeMinutes, currentTimeSeconds);
        String leastTime = currentTime;
        while(!currentTime.equals(endTime)){
            if(currentTime.compareTo(leastTime) < 0){
                leastTime = currentTime;
            }
            currentTime = getValidTimeInString(currentTimeHours, currentTimeMinutes, currentTimeSeconds++);
        }
        return leastTime;
    }

    static String[] getCommonTimeSpan(String startTime1, String endTime1, String startTime2, String endTime2){
        DateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        Date parsedStartTime1 = null, parsedStartTime2 = null, parsedEndTime1 = null, parsedEndTime2 = null;
        try {
            parsedStartTime1 = simpleDateFormat.parse(startTime1);
            parsedStartTime2 = simpleDateFormat.parse(startTime2);
            parsedEndTime1 = simpleDateFormat.parse(endTime1);
            parsedEndTime2 = simpleDateFormat.parse(endTime2);

            String sendStartTime = "", sendEndTime = "";

            if(parsedStartTime1.before(parsedStartTime2)){
                sendStartTime = startTime2;
            }
            else{
                sendStartTime = startTime1;
            }

            if(parsedEndTime1.before(parsedEndTime2)){
                sendEndTime = endTime1;
            }
            else{
                sendEndTime = endTime2;
            }

            Date parsedSendStartTime = simpleDateFormat.parse(sendStartTime);
            Date parsedSendEndTime = simpleDateFormat.parse(sendEndTime);

            if(parsedSendStartTime.before(parsedSendEndTime)){
                return new String[]{sendStartTime, sendEndTime};
            }
            else{
                return new String[]{};
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return new String[]{};
    }
}
