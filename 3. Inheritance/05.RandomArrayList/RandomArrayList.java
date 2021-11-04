package inheritance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class RandomArrayList<E> extends ArrayList<E> {

    public E getRandomElement(){
        Random rand = new Random();
        int index = rand.nextInt((this.size() - 0) + 1) + 0;
        return this.remove(index);
    }
}
