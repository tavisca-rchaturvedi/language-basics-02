package com.tavisca.assignments;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ForumPostEasy {
    String getCurrentTime(String[] exactPostTimes, String[] showPostTimes){
        Pattern timePattern = Pattern.compile("([0-9]{2}):([0-9]{2}):([0-9]{2})");
        int hours = 0, minutes = 0, seconds = 0;
        String commonStartTime = "", commonEndTime = "";
        for (int i = 0; i < exactPostTimes.length; i++) {
            Matcher timeMatcher = timePattern.matcher(exactPostTimes[i]);
            String startTime = "", endTime = "";

            if(timeMatcher.matches()){
                hours = Integer.parseInt(timeMatcher.group(1));
                minutes = Integer.parseInt(timeMatcher.group(2));
                seconds = Integer.parseInt(timeMatcher.group(3));
            }

            if(showPostTimes[i].equals("few seconds ago")){
                startTime = DateFunctionsHelper.getValidTimeInString(hours, minutes, seconds);
                endTime = DateFunctionsHelper.getValidTimeInString(hours, minutes, seconds+59);
            }
            else if(showPostTimes[i].contains(" minutes ago")){
                int noOfMinutes = Integer.parseInt(showPostTimes[i].split(" ")[0]);
                startTime = DateFunctionsHelper.getValidTimeInString(hours, minutes+noOfMinutes, seconds);
                endTime = DateFunctionsHelper.getValidTimeInString(hours, minutes+noOfMinutes, seconds+59);
            }
            else if(showPostTimes[i].contains(" hours ago")){
                int noOfHours = Integer.parseInt(showPostTimes[i].split(" ")[0]);
                startTime = DateFunctionsHelper.getValidTimeInString(hours + noOfHours, minutes, seconds);
                endTime = DateFunctionsHelper.getValidTimeInString(hours + noOfHours, minutes+59, seconds+59);
            }
            if(i > 0){
                String[] timeSpan = DateFunctionsHelper.getCommonTimeSpan(startTime, endTime, commonStartTime, commonEndTime);
                if(timeSpan.length == 0){
                    return "impossible";
                }
                else{
                    commonStartTime = timeSpan[0];
                    commonEndTime = timeSpan[1];
                }
            }
            else{
                commonStartTime = startTime;
                commonEndTime = endTime;
            }
        }

        int[] startTime = DateFunctionsHelper.stringToIntegerTime(commonStartTime);
        int[] endTime = DateFunctionsHelper.stringToIntegerTime(commonEndTime);
        return DateFunctionsHelper.getLexiSmallestTime(startTime[0], startTime[1], startTime[2], endTime[0], endTime[1], endTime[2]);
    }


}
