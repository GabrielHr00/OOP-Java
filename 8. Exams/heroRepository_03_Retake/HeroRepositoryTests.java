package heroRepository;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class HeroRepositoryTests {
    private HeroRepository repo;

    @Before
    public void setUp(){
        repo = new HeroRepository();
    }


    @Test(expected = UnsupportedOperationException.class)
    public void testTheUnmodifiableCollection(){
        repo.getHeroes().clear();
    }


    @Test(expected = NullPointerException.class)
    public void testCreateNull(){
        repo.create(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateAlreadyThere(){
        repo.create(new Hero("hero", 4));
        repo.create(new Hero("hero", 4));
    }

    @Test
    public void testCreateNormal(){
        String res = repo.create(new Hero("hero", 4));
        Assert.assertEquals(res, "Successfully added hero hero with level 4");
        Assert.assertEquals(repo.getCount(), 1);
    }

    @Test(expected = NullPointerException.class)
    public void testRemoveNull(){
        repo.remove(null);
    }

    @Test(expected = NullPointerException.class)
    public void testRemoveEmpty(){
        repo.remove("  ");
    }

    @Test
    public void testRemoveNormal(){
        boolean res = repo.remove("hero");
        Assert.assertFalse(res);
        repo.create(new Hero("hero", 4));
        boolean res1 = repo.remove("hero");
        Assert.assertTrue(res1);
    }

    @Test
    public void testCount(){
        repo.create(new Hero("hero", 5));
        repo.create(new Hero("hero1", 5));
        repo.create(new Hero("hero2", 5));
        Assert.assertEquals(3, repo.getCount());
    }

    @Test
    public void testGetHighestLevel(){
        Hero hero = repo.getHeroWithHighestLevel();
        Assert.assertNull(hero);

        Hero actual = new Hero("hero", 4);
        repo.create(actual);
        Hero actual2 = new Hero("hero1", 8);
        repo.create(actual2);

        Hero res = repo.getHeroWithHighestLevel();
        Assert.assertEquals(actual2, res);
    }

    @Test
    public void testGetHero(){
        Hero hero = repo.getHero("hero");
        Assert.assertNull(hero);

        Hero actual = new Hero("hero", 4);
        repo.create(actual);
        Hero actual2 = new Hero("hero1", 8);
        repo.create(actual2);

        Hero res = repo.getHero("hero");
        Assert.assertEquals(actual, res);
    }

    @Test
    public void testGetCollection(){
        Collection<Hero> heroes = repo.getHeroes();
        Assert.assertNotNull(heroes);
    }




}
