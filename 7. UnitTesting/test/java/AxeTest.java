import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AxeTest {
    private Dummy dummy;
    private Axe axe;
    private Axe broken;

    //only once
    // called before every test
    @Before
    public void setUp(){
        this.dummy = new Dummy(100,100);
        this.axe = new Axe(10,10);
        this.broken = new Axe(10,0);
    }

    @Test
    public void testWeaponLosesDurabilityAfterAttack() {
        axe.attack(dummy);
        Assert.assertEquals(9, axe.getDurabilityPoints());
    }

    @Test(expected = IllegalStateException.class)
    public void testAxeAttackThrowsIfAxeIsBroken(){
        broken.attack(dummy);
    }

}
