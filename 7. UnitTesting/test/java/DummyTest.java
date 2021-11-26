import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class DummyTest {

    @Test
    public void testDummyLosesHealthIfAttacked(){
        Dummy dummy = new Dummy(100, 50);
        dummy.takeAttack(10);
        Assert.assertEquals(90, dummy.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void testDummyThrowsExceptionIfAttacked(){
        Dummy dummy = new Dummy(0, 50);
        dummy.takeAttack(10);
    }

    @Test
    public void testDeadDummyCanGiveXP(){
        Dummy dummy = new Dummy(0, 50);
        int xp = dummy.giveExperience();
        Assert.assertEquals(50, xp);
    }

    @Test(expected = IllegalStateException.class)
    public void testAliveDummyThrowsWhenGivingXp(){
        Dummy dummy = new Dummy(100, 50);
        dummy.giveExperience();
    }

    @Test
    public void testMockThrowsWhenGivingXp(){
        // make an fake object of dummy - imitate
        Dummy mock = Mockito.mock(Dummy.class);
        // set the method return the specific value
        Mockito.when(mock.isDead()).thenReturn(true);

        // then use the object as a normal one
    }

}