package p03_IteratorTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class ListIteratorTest {
    private static String[] names;
    private ListIterator iter;

    @Before
    public void setUp() throws Exception {
        this.iter = new ListIterator(new String[]{"a", "b", "c"});
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorThrows() throws OperationNotSupportedException {
        new ListIterator(null);
    }

    @Test
    public void testConstructor() throws OperationNotSupportedException {
        ListIterator iter = new ListIterator(new String[]{"a", "b"});
    }

    @Test
    public void testHasNext() throws OperationNotSupportedException {
        Assert.assertTrue(iter.hasNext());
        iter.move();
        Assert.assertTrue(iter.hasNext());
        iter.move();
        Assert.assertFalse(iter.hasNext());
    }

    @Test
    public void testMove() throws OperationNotSupportedException {
        Assert.assertTrue(iter.move());
        Assert.assertTrue(iter.move());
        Assert.assertFalse(iter.move());
    }

    @Test(expected = IllegalStateException.class)
    public void testPrintThrows() throws OperationNotSupportedException {
        iter = new ListIterator();
        iter.print();
    }

    @Test
    public void testPrint() throws OperationNotSupportedException {
        String current = iter.print();
        Assert.assertEquals("a", current);
    }
}