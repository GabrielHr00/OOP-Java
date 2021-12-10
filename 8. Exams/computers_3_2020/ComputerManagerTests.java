package computers;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class ComputerManagerTests {
    private ComputerManager manager;

    @Before
    public void setUp(){
        manager = new ComputerManager();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testUnmodifiableCollection(){
        manager.getComputers().clear();
    }


    @Test(expected = IllegalArgumentException.class)
    public void testAddNull(){
        manager.addComputer(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddAlreadyThere(){
        manager.addComputer(new Computer("az", "modela",23.0));
        manager.addComputer(new Computer("az", "modela",23.0));
    }

    @Test
    public void testAddNormalPlusCount(){
        Computer c = new Computer("az", "modela",230.0);
        manager.addComputer(c);
        Assert.assertEquals(manager.getComputers().get(0), c);
        Assert.assertEquals(manager.getCount(), 1);
    }

    @Test
    public void testRemoveNormalPlusCount(){
        Computer c = new Computer("az", "modela",230.0);
        manager.addComputer(c);
        Computer res = manager.removeComputer("az", "modela");
        Assert.assertEquals(res, c);
        Assert.assertEquals(manager.getCount(), 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testgetComputerNull(){
        manager.getComputer("az", null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testgetComputerNull1(){
        manager.getComputer(null, "az");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testgetComputerNotThere(){
        Computer c = new Computer("az", "modela",230.0);
        manager.addComputer(c);
        manager.getComputer("az", "bin");
    }

    @Test
    public void testgetComputerProper(){
        Computer c = new Computer("az", "modela",230.0);
        manager.addComputer(c);
        Computer res = manager.getComputer("az", "modela");
        Assert.assertEquals(res, c);
    }

    @Test
    public void testGetComputerManufacturers(){
        Computer c = new Computer("az", "modela",230.0);
        Computer c1 = new Computer("az", "modela1",2690.0);
        Computer c2 = new Computer("az", "modela2",2990.0);

        manager.addComputer(c);
        manager.addComputer(c1);
        manager.addComputer(c2);

        List<Computer> az = manager.getComputersByManufacturer("az");
        Assert.assertEquals(az.size(), 3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetComputerManufacturersNull(){
        Computer c = new Computer("az", "modela",230.0);
        Computer c1 = new Computer("az", "modela1",2690.0);
        Computer c2 = new Computer("az", "modela2",2990.0);

        manager.addComputer(c);
        manager.addComputer(c1);
        manager.addComputer(c2);

        manager.getComputersByManufacturer(null);
    }
}