package lock_unlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class main {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Thread thread1 = new Thread(new PairePrinter(lock, 2));
        Thread thread2 = new Thread(new ImpairPrinter(lock));
        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Le seuil a été atteint.");
    }}