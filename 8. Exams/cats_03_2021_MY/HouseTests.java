package cats;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HouseTests {
    private House house;

    @Before
    public void setUp(){
        house = new House("home", 2);
    }

    @Test
    public void testGetMethod1(){
        House newh = new House("home1", 5);
        String res = newh.getName();
        Assert.assertEquals(res, "home1");
    }

    @Test
    public void testGetMethod2(){
        House newh = new House("home1", 5);
        int res = newh.getCapacity();
        Assert.assertEquals(res, 5);
    }

    @Test(expected = NullPointerException.class)
    public void testsetMethod1(){
        House house1 = new House(null, 3);
    }

    @Test(expected = NullPointerException.class)
    public void testsetMethod2(){
        House house1 = new House("  " , 3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testsetMethod3(){
        House house1 = new House("home" , -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addCatFull(){
        Cat c = new Cat("cat1");
        Cat c2 = new Cat("cat2");
        Cat c3 = new Cat("cat3");

        house.addCat(c);
        house.addCat(c2);
        house.addCat(c3);
    }

    @Test
    public void addCatNormal() {
        Cat c = new Cat("cat1");
        Cat c2 = new Cat("cat2");

        house.addCat(c);
        house.addCat(c2);

        Assert.assertEquals(house.getCount(), 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeCatNotThere() {
        Cat c = new Cat("cat1");
        Cat c2 = new Cat("cat2");

        house.addCat(c);
        house.addCat(c2);
        house.removeCat("kitty");
    }

    @Test
    public void removeNormal() {
        Cat c = new Cat("cat1");
        Cat c2 = new Cat("cat2");

        house.addCat(c);
        house.addCat(c2);
        house.removeCat("cat1");
        Assert.assertEquals(1, house.getCount());
    }


    @Test
    public void catForSale() {
        Cat c = new Cat("cat1");
        Cat c2 = new Cat("cat2");

        house.addCat(c);
        house.addCat(c2);
        Cat res = house.catForSale("cat1");
        Assert.assertEquals(res, c);
        Assert.assertFalse(res.isHungry());
    }

    @Test(expected = IllegalArgumentException.class)
    public void catForSaleNull() {
        Cat c = new Cat("cat1");
        Cat c2 = new Cat("cat2");

        house.addCat(c);
        house.addCat(c2);
        Cat res = house.catForSale("kitten");
    }

    @Test
    public void testStatistics() {
        Cat c = new Cat("cat1");
        Cat c2 = new Cat("cat2");

        house.addCat(c);
        house.addCat(c2);
        String res = house.statistics();
        Assert.assertEquals(res, "The cat cat1, cat2 is in the house home!");
    }



}
