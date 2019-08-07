package com.tavisca.assignments;

import org.junit.Test;
import static org.junit.Assert.*;

public class DateFunctionsHelperTest {

    @Test
    public void getStringTimeTest(){
        int hours = 22, minutes = 33, seconds = 55;
        String expected = "22:33:55";
        assertEquals(expected, DateFunctionsHelper.getStringTime(hours, minutes, seconds));
    }

    @Test
    public void getValidTimeInStringTest(){
        assertEquals("23:05:55", DateFunctionsHelper.getValidTimeInString(22, 65, 55));
        assertEquals("00:03:00", DateFunctionsHelper.getValidTimeInString(23, 62, 60));
        assertEquals("23:59:05", DateFunctionsHelper.getValidTimeInString(23, 58, 65));
    }

    @Test
    public void getLexiSmallestTimeTest(){
        assertEquals("12:00:00", DateFunctionsHelper.getLexiSmallestTime(12,00,00,12,00,50));
        assertEquals("11:59:30", DateFunctionsHelper.getLexiSmallestTime(11,59,30,12,00,50));
    }

    @Test
    public void getCommonTimeSpanTest(){
        assertArrayEquals(new String[]{"11:10:12","11:15:10"}, DateFunctionsHelper.getCommonTimeSpan("11:10:12", "11:20:40", "11:00:00", "11:15:10"));
        assertArrayEquals(new String[]{"11:00:00","11:15:10"}, DateFunctionsHelper.getCommonTimeSpan("10:10:12", "11:20:40", "11:00:00", "11:15:10"));
        assertArrayEquals(new String[]{}, DateFunctionsHelper.getCommonTimeSpan("10:10:12", "10:20:40", "11:00:00", "11:15:10"));

    }
}
