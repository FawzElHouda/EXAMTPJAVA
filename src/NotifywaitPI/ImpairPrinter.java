package NotifywaitPI;

public class ImpairPrinter implements Runnable {
    private static final int SEUIL = 10;
    private int count;

    public ImpairPrinter() {
        this.count = 1;
    }

    public synchronized void printImpair() {
        try {
            while (count <= SEUIL) {
                System.out.println("Impair: " + count);
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
            printImpair();
        }
    }
}
