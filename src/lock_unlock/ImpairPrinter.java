package lock_unlock;

import java.util.concurrent.locks.Lock;

public class ImpairPrinter implements Runnable{
    private static final int SEUIL = 10;
    private final Lock lock ;

    public ImpairPrinter(Lock lock) {
        this.lock = lock;
    }

    public void print() {
        while (PairePrinter.count < SEUIL) {
            lock.lock();
            try {
                if (PairePrinter.count % 2 != 0) {
                    System.out.println("Impair: " + PairePrinter.count);
                    PairePrinter.count++;
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
