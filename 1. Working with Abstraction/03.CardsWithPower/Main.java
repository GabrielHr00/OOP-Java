import org.w3c.dom.css.Rect;

import java.util.Scanner;

public class Main{
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);

        CardRank rank = CardRank.valueOf(sc.nextLine());
        CardSuits suits = CardSuits.valueOf(sc.nextLine());

        Card c = new Card(rank, suits);
        System.out.println(c.toString());

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
