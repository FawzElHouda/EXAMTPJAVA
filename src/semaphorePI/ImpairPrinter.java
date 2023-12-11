package semaphorePI;

import java.util.concurrent.Semaphore;

public class ImpairPrinter implements Runnable {
     int count = 1 ;
    private Semaphore pairsem ;
    private Semaphore imppairsem ;

    public ImpairPrinter(Semaphore pairsem, Semaphore imppairsem) {
        this.pairsem = pairsem;
        this.imppairsem = imppairsem;
    }

    @Override
    public void run() {
        while (count<=10){
            try {
                imppairsem.acquire();
                if (count%2!=0)
                      System.out.println("Impair: "+count);
                  //  System.out.println(Thread.currentThread().getName() + ": " + count);
                count+=2;
            } catch (InterruptedException e) {
              throw new RuntimeException(e);
            }finally {
                pairsem.release();
            }

        }


    }
}
