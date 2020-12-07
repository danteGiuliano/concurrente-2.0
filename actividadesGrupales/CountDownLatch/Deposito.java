import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Deposito {

    private final int CANTIDAD_MAXIMA_AUTOS;
    private Semaphore esperaAsubir;
   
    private CountDownLatch esperaViaje;

    public Deposito(int cantidadMaximaAutos){

        CANTIDAD_MAXIMA_AUTOS=cantidadMaximaAutos;

        

        esperaViaje = new CountDownLatch(CANTIDAD_MAXIMA_AUTOS);
    }

    public void puedeSubir(){
        //logica de subir.
    }


}
