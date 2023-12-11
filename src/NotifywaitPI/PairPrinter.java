package NotifywaitPI;

public class PairPrinter implements Runnable {
    private static final int SEUIL = 10;
    private int count;

    public PairPrinter() {
        this.count = 0;
    }

    public synchronized void printPair() {
        try {
            while (count <= SEUIL) {
                System.out.println("Pair: " + count);
                count += 2;
                notify();  // Réveille l'autre thread
                if (count <= SEUIL) {
                    wait();  // Attend que l'autre thread imprime
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        synchronized (this) {
            printPair();
        }
    }

}
