package actividadesGrupales.ProblemaSaludo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Saludo {
    private ReentrantLock mutex;
    private Condition grupoCompleto;
    private Condition llegoJefe;
    private int llegadaEmpleado;

    public Saludo() {
        this.mutex = new ReentrantLock(true);
        this.llegadaEmpleado = 0;
        this.llegoJefe = mutex.newCondition();
        this.grupoCompleto=mutex.newCondition();
    }

    public void esperarEmpleados(int unaCantidadEmpleados) throws Exception {
        this.mutex.lock();
        while (this.llegadaEmpleado <= unaCantidadEmpleados) {
            this.grupoCompleto.await();
        }
        this.llegoJefe.signalAll();
        this.mutex.unlock();
    }
    public void esperarJefe() throws Exception {
        this.mutex.lock();
        this.llegadaEmpleado++;
        this.grupoCompleto.signal();
        this.llegoJefe.await();  
        this.mutex.unlock();
        
    }
}