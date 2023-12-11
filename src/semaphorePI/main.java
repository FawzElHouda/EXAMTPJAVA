package semaphorePI;

import java.util.concurrent.Semaphore;

public class main {
    public static void main(String[] args) {
        //creation of semaphores
        Semaphore pairsem = new Semaphore(1,true);
        Semaphore impairsem = new Semaphore(0,true);
        //creation of the instances of the classes
        ImpairPrinter impairPrinter = new ImpairPrinter(pairsem, impairsem) ;
        PairPrinter pairPrinter = new PairPrinter(pairsem, impairsem) ;
        //creation des thread convenable
        Thread impaire = new Thread(impairPrinter, "Thread Impaire");
        Thread paire = new Thread(pairPrinter, "Thread Paire");

        //demarrage des thread
        paire.start();
        impaire.start();

        try {
            // Attente que les threads se terminent
            impaire.join();
            paire.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Le seuil a été atteint.");
    }

}
