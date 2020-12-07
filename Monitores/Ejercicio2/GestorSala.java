import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class GestorSala {
    private int cantidadPersonas;
    private int cantidadMaximaDePersonasPermitidas;
    private int temperaturaUmbral;
    private ReentrantLock mutex;
    private Condition temperatura;
    private Condition prioridadJubilado;
    private Condition esperaAtencion;

    public GestorSala(){
        this.cantidadPersonas=0;
        this.cantidadMaximaDePersonasPermitidas=50;
        this.temperaturaUmbral=30;
        this.mutex=new ReentrantLock();
        this.prioridadJubilado=mutex.newCondition();
        this.esperaAtencion=mutex.newCondition();
        this.temperatura=mutex.newCondition();
    }

    public void entrarSala(boolean esJubilado)throws Exception{
        this.mutex.lock();
        this.puertaEntrada();
        this.cantidadPersonas++;
        if(esJubilado){
            this.prioridadJubilado.awaitNanos(1000);//Deberia liberar el lock otro hilo como por ejemplo personal.
        }else{
            this.esperaAtencion.awaitNanos(4000);
        }
        this.mutex.unlock();
    }
   
    public void salirSala()throws Exception{
        this.mutex.lock();
        this.cantidadPersonas--;
        this.temperatura.signal();
        this.mutex.unlock();
    }

    public void notificarTemperatura(int temperatura)throws Exception{ 
        this.mutex.lock();
        this.cantidadMaximaDePersonasPermitidas=(temperatura>this.temperaturaUmbral)?35:50;
        System.out.println("CANTIDAD MAXIMA -------------------------->"+this.cantidadMaximaDePersonasPermitidas);
        this.temperatura.signalAll(); //Correccion del 13-11.
        this.mutex.unlock();
    }

    private void puertaEntrada()throws Exception{
        if(this.cantidadPersonas>=this.cantidadMaximaDePersonasPermitidas){
            this.temperatura.await();
        }
    }
}
