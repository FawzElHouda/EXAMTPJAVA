package NotifywaitPI;

public class main {
    public static void main(String[] args) {
        PairPrinter pairPrinter = new PairPrinter();
        ImpairPrinter impairPrinter = new ImpairPrinter();

        Thread pairThread = new Thread(pairPrinter, "Thread Paire");
        Thread impairThread = new Thread(impairPrinter, "Thread Impaire");

        impairThread.start();  // Démarrer d'abord le thread impair
        pairThread.start();

        try {
            pairThread.join();
            impairThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Le seuil a été atteint.");
    }
}
