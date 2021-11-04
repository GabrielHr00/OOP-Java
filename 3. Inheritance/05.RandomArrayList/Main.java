package inheritance;

public class Main {
    public static void main(String[] args) {
        RandomArrayList<Integer> list = new RandomArrayList<>();
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        System.out.println(list.getRandomElement());


    }
}
