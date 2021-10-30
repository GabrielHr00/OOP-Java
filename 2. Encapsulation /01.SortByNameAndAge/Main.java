import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    public static void main(String[] args) throws InterruptedException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        List<Person> people = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] input = reader.readLine().split(" ");
            people.add(new Person(input[0], input[1], Integer.parseInt(input[2])));
        }
        Collections.sort(people, (firstPerson, secondPerson) -> {
            int sComp = firstPerson.getFirstName().compareTo(secondPerson.getFirstName());
            if (sComp != 0) {
                return sComp;
            } else {
                return Integer.compare(firstPerson.getAge(), secondPerson.getAge());
            }
        });
        for (Person person : people) {
            System.out.println(person.toString());
        }
//        new Thread(() -> {
//            System.out.println("Thread is run!");
//        }).start();
//
//        Runnable r = () -> {
//            System.out.println("Thread 2 is run too!");
//        };
//        new Thread(r).start();
//
//        System.out.println();
//        Thread.sleep(2000);

//        TestThread c = new TestThread();
//        Runnable r = () -> {
//            for (int i = 0; i <5 ; i++) {
//                synchronized (c){
//                    c.increment();
//                }
//            }
//        };
//
//        Thread t = new Thread(r);
//        Thread t1 = new Thread(r);
//
//        t.start();
//        t1.start();
//
//        t.join();
//        t1.join();
//
//        System.out.println(c.getC());

//        LockTest t  = new LockTest();
//
//        Thread t1 = new Thread(() -> {
//            for (int i = 0; i < 10; i++) {
//                try {
//                    t.get();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//        Thread t2 = new Thread(() -> {
//            for (int i = 0; i < 15; i++) {
//                try {
//                    t.put();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//
//        t1.start();
//        t2.start();
////        t1.join();
////        t2.join();

    }
}
