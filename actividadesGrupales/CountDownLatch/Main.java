import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class Main{
    public static void main(String[] args) {
        CountDownLatch lanzador = new CountDownLatch(0);
        CyclicBarrier barrera = new CyclicBarrier(0);
        CyclicBarrier barrera = new CyclicBarrier(0,"unaRutina de Runnable");
    }
}