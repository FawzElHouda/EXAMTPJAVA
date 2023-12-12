package Compteth;

public class CompteBancaire {
    static double solde;
    public CompteBancaire(){}
    public CompteBancaire(double solde )
    {
        this.solde=solde;
    }

    public double getSolde() {
        return solde;
    }

    synchronized void retirer(double solde)
    {

        while (solde>this.solde)
        {
            try {
                System.out.println("error le solde insuffusant");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.solde -= solde;
        notify();

    }
    synchronized   void deposer(double solde)
    {
        this.solde+=solde;
        notify();
    }
}
