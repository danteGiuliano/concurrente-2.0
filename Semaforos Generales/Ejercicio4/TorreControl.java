import java.util.concurrent.Semaphore;

public class TorreControl {
    private Semaphore permisos;
    private ReentrantLock mutex;
    private String prioridad;
    private String nuevaPrioridad;
    private int cantidad;

    public TorreControl(int cantidad) {
        this.cantidad=cantidad;
        this.prioridad = "despegue";
        this.prioridad = "aterrizaje";
        this.permisos = new Semaphore(cantidad);
        this.mutex=new ReentrankLock();
    }
    public synchronized boolean permisoPista(String estado){
       boolean flag=true;
        if(!this.prioridad.equals(estado)&&!permisos.tryAcquire()){
            flag=false;
        }
        if(flag){
            if(this.permisos.availablePermits()==0){
                this.cambiarPriodidad();
        }
        return flag;
    }
}
    private void abandonoLaPista()throws Exception{
        this.mutex.lock();
        if(this.permisoPista.availablePermits()==0){
            this.permisos.release(this.cantidad);
        }
        this.mutex.unlock();
    }

    private void cambiarPriodidad() {
        String aux = this.prioridad;
        this.prioridad = nuevaPrioridad;
        this.nuevaPrioridad = aux;
    }
}
