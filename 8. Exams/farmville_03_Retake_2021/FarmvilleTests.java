package farmville;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FarmvilleTests {
    private Farm farm;

    @Before
    public void setUp(){
        farm = new Farm("benny", 2);
    }

    @Test
    public void testNameSet(){
        Farm farm1 = new Farm("benny", 10);
        String res = farm1.getName();
        Assert.assertEquals(res, "benny");
    }

    @Test(expected = NullPointerException.class)
    public void testNameSetThrows(){
        Farm farm1 = new Farm("  ", 10);
    }

    @Test(expected = NullPointerException.class)
    public void testNameSetThrows1(){
        Farm farm1 = new Farm(null, 10);
    }

    @Test
    public void testCapacitySet(){
        Farm farm1 = new Farm("benny", 10);
        int res = farm1.getCapacity();
        Assert.assertEquals(res, 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCapacitySetThrows(){
        Farm farm1 = new Farm("benny", -2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddCapacityTooSmall() {
        farm.add(new Animal("az", 8.9));
        farm.add(new Animal("sum", 8.9));
        farm.add(new Animal("tuk", 8.9));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddAnotherObjectSame() {
        farm.add(new Animal("az", 8.9));
        farm.add(new Animal("az", 8.9));
    }

    @Test
    public void testAddWorksProper() {
        Animal a1 = new Animal("az", 8.9);
        Animal a2 = new Animal("sum", 9.9);
        farm.add(a1);
        farm.add(a2);
        int result = farm.getCount();
        Assert.assertEquals(result, 2);
    }

    @Test
    public void testRemoveWorksProper() {
        Animal a1 = new Animal("az", 8.9);
        Animal a2 = new Animal("sum", 9.9);
        farm.add(a1);
        farm.add(a2);
        boolean res = farm.remove("az");
        Assert.assertTrue(res);
    }

    @Test
    public void testRemoveReturnFalse() {
        Animal a1 = new Animal("az", 8.9);
        Animal a2 = new Animal("sum", 9.9);
        farm.add(a1);
        farm.add(a2);
        boolean res = farm.remove("tukaaaa");
        Assert.assertFalse(res);
    }

}
