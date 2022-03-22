import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrier1 {
    private static  Integer a = 0;
    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(1000000);

    public static void play() throws BrokenBarrierException, InterruptedException {
        cyclicBarrier.await();
        synchronized(a){
            a++;
            System.out.println(" a:"+a);
        }

    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i=0;i<1000000;i++){
            executorService.execute(()->{
                try {
                    play();
                } catch (BrokenBarrierException | InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }


}