package lock_unlock;

import java.util.concurrent.locks.Lock;

public class PairePrinter  implements Runnable{
    private static final int SEUIL = 10;
    private final Lock lock ;
    static int count;

    public PairePrinter(Lock lock, int count) {
        this.lock = lock;
        this.count = 0;
    }

    public void print() {
        while (count <= SEUIL) {
            lock.lock();
            try {
                if (count % 2 == 0) {
                    System.out.println("Pair: " + count);
                    count++;
                }
            } finally {
                lock.unlock();
            }
        }
    }

    @Override
    public void run() {
        print();
    }
}
