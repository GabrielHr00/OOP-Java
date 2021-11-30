package p04_BubbleSortTest;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class BubbleTest {

    @Test
    public void testSorting(){
        int[] notSorted = {-2,7,1,3,5,-3,10};
        int[] sorted = {-3,-2,1,3,5,7,10};

        Bubble bb = new Bubble();
        bb.sort(notSorted);
        Assert.assertEquals(-3, notSorted[0]);
        Assert.assertArrayEquals(notSorted, sorted);
    }

}