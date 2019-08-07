package com.tavisca.assignments;

import org.junit.Test;

import static org.junit.Assert.*;

public class GetCurrentTimeTest {
    @Test
    public void testCase1(){
        String[] exactPostTime = new String[]{"12:12:12"};
        String[] showPostTime = new String[]{"few seconds ago"};

        ForumPostEasy forumPostEasy = new ForumPostEasy();
        assertEquals("12:12:12",forumPostEasy.getCurrentTime(exactPostTime, showPostTime));
    }

    @Test
    public void testCase2(){
        String[] exactPostTime = new String[]{"23:23:23","23:23:23"};
        String[] showPostTime = new String[]{"59 minutes ago","59 minutes ago"};

        ForumPostEasy forumPostEasy = new ForumPostEasy();
        assertEquals("00:22:23",forumPostEasy.getCurrentTime(exactPostTime, showPostTime));
    }

    @Test
    public void testCase3(){
        String[] exactPostTime = new String[]{"00:10:10","00:10:10"};
        String[] showPostTime = new String[]{"59 minutes ago","1 hours ago"};

        ForumPostEasy forumPostEasy = new ForumPostEasy();
        assertEquals("impossible",forumPostEasy.getCurrentTime(exactPostTime, showPostTime));
    }

    @Test
    public void testCase4(){
        String[] exactPostTime = new String[]{"11:59:13","11:13:23","12:25:15"};
        String[] showPostTime = new String[]{"few seconds ago","46 minutes ago","23 hours ago"};

        ForumPostEasy forumPostEasy = new ForumPostEasy();
        assertEquals("11:59:23",forumPostEasy.getCurrentTime(exactPostTime, showPostTime));
    }

}
