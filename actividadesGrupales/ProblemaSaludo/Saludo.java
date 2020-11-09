
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Saludo {
    private ReentrantLock mutex;
    private Condition grupoCompleto;
    private Condition llegoJefe;
    private int llegadaEmpleado;
    private final int CANTIDAD_TOTAL;

    public Saludo(int unaCantidad) {
        this.mutex = new ReentrantLock();
        this.llegadaEmpleado = 0;
        this.CANTIDAD_TOTAL=unaCantidad;
        this.llegoJefe = mutex.newCondition();
        this.grupoCompleto=mutex.newCondition();
    }

    public void esperarEmpleados() throws Exception {
        this.mutex.lock();
        this.grupoCompleto.await();
        this.llegoJefe.signalAll();
        this.mutex.unlock();
    }
    public void esperarJefe() throws Exception {
        this.mutex.lock();
        this.llegadaEmpleado++;
        if(this.CANTIDAD_TOTAL<this.llegadaEmpleado){this.grupoCompleto.signal();};
        this.llegoJefe.await();  
        this.mutex.unlock();
        
    }
}