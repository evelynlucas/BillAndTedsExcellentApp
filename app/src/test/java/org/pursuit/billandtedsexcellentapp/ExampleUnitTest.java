package org.pursuit.billandtedsexcellentapp;

import org.junit.Test;
import org.pursuit.billandtedsexcellentapp.fragment.QuestionFragment;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void getMaxCountTest() {
        int tedCounter = 3;
        int napoleonCounter = 1;
        int deathCounter = 0;
        int stationCounter = 0;

        assertEquals(QuestionFragment.getMaxCount(tedCounter, napoleonCounter, deathCounter, stationCounter), 3);
    }
}