package shopAndGoods;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class ShopTest {
    private Shop shop;

    @Before
    public void setUp() {
        this.shop = new Shop();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testMapGetUnsupported(){
        shop.getShelves().clear();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddGoodsTrowIfNotThere() throws OperationNotSupportedException {
        shop.addGoods("sheff1", null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddGoodsTrowIfNotNull() throws OperationNotSupportedException {
        Goods good = new Goods("test", "testi");
        shop.addGoods("Shelves1", good);
        shop.addGoods("Shelves1", good);
    }

    @Test
    public void testAddGoods() throws OperationNotSupportedException {
        Goods g = new Goods("shelfi", "001");
        String result = shop.addGoods("Shelves1", g);
        Assert.assertEquals("Goods: 001 is placed successfully!", result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveGoodsTrowIfNotThere() throws OperationNotSupportedException {
        shop.removeGoods("sheff1", null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveGoodsTrowIfNotNull() throws OperationNotSupportedException {
        Goods good = new Goods("im", "here");
        Goods go = new Goods("imhere", "here1");
        shop.addGoods("Shelves1", good);
        shop.removeGoods("sheff1", go);
    }

    @Test
    public void testRemoveGoods() throws OperationNotSupportedException {
        Goods g = new Goods("shelfi", "001");
        shop.addGoods("Shelves1", g);
        String result = shop.removeGoods("Shelves1", g);
        Assert.assertEquals("Goods: 001 is removed successfully!", result);
    }


    @Test
    public void shouldSetGoodToNull() throws OperationNotSupportedException {
        Goods g = new Goods("shelfi", "001");
        shop.addGoods("Shelves1", g);
        String result = shop.removeGoods("Shelves1", g);
        Goods temp = shop.getShelves().get("Shelves1");
        Assert.assertNull(temp);
    }




}