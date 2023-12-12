package Compteth;

public class main {
    public static void main(String[] args) {
        CompteBancaire compteBancaire =new CompteBancaire(1000);
        TacheDepot tacheDepot =new TacheDepot(150, compteBancaire);
        TacheRetrait tacheRetrait= new TacheRetrait(1100,compteBancaire);
        System.out.println("Le solde initial est "+compteBancaire.getSolde());
        Thread t1 =new Thread(tacheRetrait);
        Thread t2 =new Thread(tacheDepot);
        t1.setName("Thread-Retrait");
        t2.setName("Thread-Dépot");
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
            System.out.println("Fin des transctions");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
    //2 eme sol°
    /*
     -on peut  utliser deux class comme producer c'est de deposer et consumer pour reterait
      la solde de compteBanquaire avec et dans ces class on utlise syncronaized pour les methodes consume et produce
      et on utlise notify() et wait()
      avec l'architecture
      1-action
      2-notify
      3-while(condition)
      4-wait
     */
}
