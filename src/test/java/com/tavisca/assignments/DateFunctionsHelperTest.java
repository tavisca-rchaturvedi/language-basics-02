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
        assertEquals("00:00:00", DateFunctionsHelper.getValidTimeInString(23, 59, 60));
        assertEquals("23:59:05", DateFunctionsHelper.getValidTimeInString(23, 58, 65));
    }

}
