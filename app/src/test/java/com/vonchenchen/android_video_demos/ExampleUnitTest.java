package com.vonchenchen.android_video_demos;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        //assertEquals(4, 2 + 2);

        Set<Integer> mRequestConnPortsSet = new HashSet<>();
        mRequestConnPortsSet.add(12345);

        System.out.println(mRequestConnPortsSet.contains(12345 ));
    }
}