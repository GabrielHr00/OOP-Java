package p01_Database;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {
    private Integer[] els;
    private Database db;
    private Integer el;
    private Integer broken;

    @Before
    public void setUp() throws Exception {
        this.els = new Integer[15];
        this.db = new Database(els);
        this.el = 4;
    }
    @Test
    public void testConstructor() throws OperationNotSupportedException {
        Integer[] nums = {1,2,3,4};
        db = new Database(nums);
        Integer[] dbEl = db.getElements();

        Assert.assertArrayEquals(dbEl, nums);
        Assert.assertEquals(dbEl.length, nums.length);
        for (int i = 0; i < nums.length; i++) {
            Assert.assertEquals("We have diff elements",dbEl[i],nums[i]);
        }
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddThrowsMoreThan16Elements() throws OperationNotSupportedException {
        db.add(broken);
        db.add(broken);
    }

    @Test
    public void testAddNormal() throws OperationNotSupportedException {
        db.add(el);
        Assert.assertEquals(16, db.getElements().length);
    }


    @Test(expected = OperationNotSupportedException.class)
    public void testAddThrowsLessThan1Elements() throws OperationNotSupportedException {
        els = new Integer[0];
        db = new Database(els);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddThrowsAddNullElement() throws OperationNotSupportedException {
        db.add(broken);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testRemoveThrows() throws OperationNotSupportedException {
        Integer[] nums = new Integer[0];
        db = new Database(nums);
        db.remove();
    }

    @Test
    public void testRemove() throws OperationNotSupportedException {
        db.remove();
        Assert.assertEquals(els.length - 1, db.getElements().length);
    }


}