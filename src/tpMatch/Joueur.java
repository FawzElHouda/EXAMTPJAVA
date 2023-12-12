package tpMatch;

import java.util.Random;

public class Joueur implements Runnable{
    private int somme=0;
    private int nbr ;

    public Joueur(int nbr)
    {
        this.nbr=nbr;
    }

    public int getSomme() {
        return somme;
    }

    public synchronized void jouer()
    {
        Random random=new Random();
        int nbr=random.nextInt(10)+1;
        this.somme+=nbr;
    }


    @Override
    public void run() {
        for (int i=0;i<5;i++)
        {
            jouer();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {

            Joueur joueur1=new Joueur(1);
        Joueur joueur2=new Joueur(2);
        Thread thread1=new Thread(joueur1);
        Thread thread2=new Thread(joueur2);
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
            System.out.println("Somme joueur 1: "+joueur1.getSomme());
            System.out.println("Somme joueur 2: "+joueur2.getSomme());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if(joueur1.getSomme() > joueur2.getSomme())
            System.out.println("Joueur 1 a gagné");
        else if(joueur1.getSomme() < joueur2.getSomme())
            System.out.println("Joueur 2 a gagné");
        else
            System.out.println("Match null");
    }
}
