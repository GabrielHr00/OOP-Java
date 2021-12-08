package aquarium;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AquariumTests {
    private Aquarium aq;

    @Before
    public void setUp(){
        this.aq = new Aquarium("jumbo", 3);
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameNull(){
        Aquarium aq1 = new Aquarium(null, 10);
    }

    @Test
    public void testSetNameSuccess(){
        Aquarium aq1 = new Aquarium("nemoe", 10);
        String na = aq1.getName();
        Assert.assertEquals(na, "nemoe");
    }

    @Test
    public void testSetCaSuccess(){
        Aquarium aq1 = new Aquarium("nemoe", 10);
        int na = aq1.getCapacity();
        Assert.assertEquals(na, 10);
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameNull1(){
        Aquarium aq1 = new Aquarium(" ", 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetCapNull1(){
        Aquarium aq1 = new Aquarium("imher", -1);
    }

    @Test
    public void testCount(){
        int count = aq.getCount();
        Assert.assertEquals(0, count);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddMethodThrows(){
        Fish f1 = new Fish("fili");
        Fish f2 = new Fish("nemo");
        Fish f3 = new Fish("doris");
        Fish f4 = new Fish("doris1");
        aq.add(f1);
        aq.add(f2);
        aq.add(f3);
        aq.add(f4);
    }

    @Test
    public void testAddMethodProperly(){
        Fish f1 = new Fish("fili");
        Fish f2 = new Fish("nemo");
        aq.add(f1);
        aq.add(f2);
        Assert.assertEquals(aq.getCount(), 2);
    }

    @Test
    public void testRemoveMethodProperly(){
        Fish f1 = new Fish("fili");
        Fish f2 = new Fish("nemo");
        aq.add(f1);
        aq.add(f2);
        aq.remove("fili");
        Assert.assertEquals(aq.getCount(), 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveMethodThrows(){
        Fish f1 = new Fish("fili");
        Fish f2 = new Fish("nemo");
        aq.add(f1);
        aq.add(f2);
        aq.remove("penio");
    }

    @Test
    public void testReportStringProper(){
        Fish f1 = new Fish("fili");
        Fish f2 = new Fish("nemo");
        aq.add(f1);
        aq.add(f2);
        String result = aq.report();
        String actual = "Fish available at jumbo: fili, nemo";
        Assert.assertEquals(actual, result);
    }

    @Test
    public void testRequestFishProper(){
        Fish f1 = new Fish("fili");
        Fish f2 = new Fish("nemo");
        aq.add(f1);
        aq.add(f2);
        Fish result = aq.sellFish("fili");
        boolean res = result.isAvailable();
        Assert.assertEquals(result, f1);
        Assert.assertEquals(res, false);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSellFishThrow(){
        Fish f1 = new Fish("fili");
        Fish f2 = new Fish("nemo");
        aq.add(f1);
        aq.add(f2);
        Fish result = aq.sellFish("filiiiii");
    }
}

