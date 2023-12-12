package NotifywaitPI;

public class ImpairPrinter implements Runnable {
    private static final int SEUIL = 10;
    static int count;

    public ImpairPrinter() {
        this.count = 1;
    }

    public synchronized void printImpair() {
        try {
            while(count >=SEUIL) {
                wait();  // Attend que l'autre thread imprime
            }
            while (count <= SEUIL) {
                if (count%2!=0) {
                    System.out.println("Impair: " + count);
                    count++;
                }
                notify();  // Réveille l'autre thread
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
