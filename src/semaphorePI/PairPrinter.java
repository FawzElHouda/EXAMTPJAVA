package semaphorePI;

import java.util.concurrent.Semaphore;

public class PairPrinter implements Runnable {
    int count = 2 ; //initialisation du  premier nombre paire
    private Semaphore pairsem ;
    private Semaphore imppairsem ;

    public PairPrinter(Semaphore pairsem, Semaphore imppairsem) {
        this.pairsem = pairsem;
        this.imppairsem = imppairsem;
    }

    @Override
    public void run() {
        while (count<=10){
            try{
                pairsem.acquire();
                if(count%2==0)
                    System.out.println("Pair: " +count);
                    //System.out.println(Thread.currentThread().getName() + ": " + count);
                count+=2;
            }catch (InterruptedException e){
                throw new RuntimeException(e);
            } finally {
                imppairsem.release();
            }

        }
    }
}
