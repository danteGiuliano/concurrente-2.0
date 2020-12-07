
import java.util.concurrent.*;

public class Deposito {
    private final int CANTIDAD_MAXIMA_LUGARES;
    private int ocupacionAutos;
    private Semaphore esperaBarco;
    private Semaphore ordenAuto;
    private Semaphore comenzarViaje;
    private Semaphore mutex;

    public Deposito(int cantidadMaxima) {
        this.ocupacionAutos=0;
        this.comenzarViaje = new Semaphore(0);
        this.esperaBarco=new Semaphore(0);
        this.ordenAuto=new Semaphore(0,true);
        CANTIDAD_MAXIMA_LUGARES = cantidadMaxima;
        this.mutex=new Semaphore(1);
    }

    // LOGICA AUTO--------------------------

    public void esperaMuelle() throws Exception {
        this.esperaBarco.acquire(); //Los autos esperan en el muelle al barco.
    }
    public void subeAuto()throws Exception{
        this.mutex.acquire();
        this.ocupacionAutos++;
        this.ocupacionActual(); //DEBUG
        if(ocupacionAutos==CANTIDAD_MAXIMA_LUGARES){
            comenzarViaje.release();
        }
        this.mutex.release();
        ordenAuto.acquire(); //El orden de entrada al barco.
    }
    public void bajaAuto()throws Exception{
        mutex.acquire();
        ocupacionAutos--;
        this.ocupacionActual(); //DEBUG
        if(this.ocupacionAutos==0){
            this.comenzarViaje.release();
        }
        mutex.release();
    }

    // LOGICA BARCO:------------------------------

    public void esperarAutos() throws Exception {
        this.esperaBarco.release(CANTIDAD_MAXIMA_LUGARES);
        this.comenzarViaje.acquire();
    }

    public void llegadaADestino() throws Exception {
        System.out.println("BARCO A DESTINO:");
        this.ordenAuto.release(CANTIDAD_MAXIMA_LUGARES);
        this.comenzarViaje.acquire();
        System.out.println("BARCO COMIENZA DE NUEVO");
    }
    ////////////////////////////////// METODOS DE
    ////////////////////////////////// DEBUG///////////////////////////////
   private void ocupacionActual(){
       System.out.println(Thread.currentThread().getName()+" OCUPACION ACTUAL :"+this.ocupacionAutos+" / "+CANTIDAD_MAXIMA_LUGARES);
   }

}
