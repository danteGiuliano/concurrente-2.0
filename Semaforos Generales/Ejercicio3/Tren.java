
import java.util.concurrent.Semaphore;

public class Tren {
    private Semaphore obtenerTicket;
    private Semaphore esperaEstacion;
    private int cantidad;

public Tren(int cantidadTickets){
    this.cantidad=cantidadTickets;
    this.obtenerTicket=new Semaphore(this.cantidad);
    this.esperaEstacion=new Semaphore(0);
}
public synchronized boolean obtenerPasaje(){
    return this.obtenerTicket.tryAcquire();
}
public  void esperarTren()throws Exception{
    this.esperaEstacion.acquire();
}
public synchronized void subirATren(){
    if(this.obtenerTicket.availablePermits()==0){
        System.out.println("El tren vendio los tickets emprende su viaje.");
        //El tren cierra las puertas 
        //Logica de tren viajando ---
        //El tren volvio. los pasajeros bajan.
        this.obtenerTicket.release(this.cantidad);
        this.esperaEstacion.release(this.esperaEstacion.getQueueLength());
    }
}
public synchronized boolean controlGuardia(){
    boolean flag =true;
    if(this.obtenerTicket.availablePermits()==0){
        flag=false;
    }
  return flag;
}
}
