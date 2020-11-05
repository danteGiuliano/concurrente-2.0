
import java.util.concurrent.Semaphore;

public class Comedor {
    private Semaphore platos;
    private int cantidad;
    private Semaphore espera;
    private String turno;
    private String siguienteTurno;

public Comedor(int cantidad,String turno,String siguieneTurno){
    this.cantidad=cantidad;
    this.platos=new Semaphore(cantidad);
    this.espera=new Semaphore(0);
    this.turno=turno;
    this.siguienteTurno=siguieneTurno;
}
public synchronized boolean puedeEntrar(String tipo){
    boolean flag=true;
    if(!this.turno.equals(tipo)){
        flag=false;
    }
    return flag;
}
public void colaEspera()throws Exception{
    this.espera.acquire();
}
public synchronized void cambioTurno(){
    if(this.platos.availablePermits()==0){
        //Debe producirse un cambio de turno
        System.out.println("Cambiando de turno!");
        String aux = this.turno;
        this.turno=this.siguienteTurno;
        this.siguienteTurno=aux;
        this.platos.release(this.cantidad);
        this.espera.release(this.espera.getQueueLength());
    }
}
public boolean puedeComer(int raciones)throws Exception{
    return this.platos.tryAcquire(raciones);
}

}

