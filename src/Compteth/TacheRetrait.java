package Compteth;

public class TacheRetrait implements Runnable{
    CompteBancaire compteBancaire;
    double solde ;
    public TacheRetrait(double solde,CompteBancaire compteBancaire)
    {
        this.compteBancaire=compteBancaire;
        this.solde=solde;
    }
    @Override
    public void run() {

        compteBancaire.retirer(solde);
        System.out.println(Thread.currentThread().getName()+"- Retrait de "+solde +"| Solde restant "+ compteBancaire.getSolde());
    }



}