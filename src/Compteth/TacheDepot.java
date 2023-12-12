package Compteth;

public class TacheDepot implements Runnable{
    CompteBancaire compteBancaire;
    double solde;
    public TacheDepot(double solde,CompteBancaire compteBancaire)
    {
        this.compteBancaire=compteBancaire;
        this.solde=solde;
    }
    @Override
    public void run() {
        compteBancaire.deposer(solde);
        System.out.println(Thread.currentThread().getName()+"- Dépôt de "+solde +"| Nouveau Solde "+ compteBancaire.getSolde());

    }
}