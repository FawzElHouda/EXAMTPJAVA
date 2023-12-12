package NotifywaitPI;

public class PairPrinter implements Runnable {
    private static final int SEUIL = 10;

    public synchronized void printPair() {
        try {
            while (ImpairPrinter.count >= SEUIL) {
                wait();  // Attend que l'autre thread imprime
            }
            while (ImpairPrinter.count <= SEUIL) {
                if(ImpairPrinter.count%2==0){
                    System.out.println("Pair: " + ImpairPrinter.count);
                    ImpairPrinter.count ++;
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
            printPair();
        }
    }

}
