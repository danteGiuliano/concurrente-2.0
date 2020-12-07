import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Buffer {
    private final int CANTIDAD_MAX_IMPRESORAS_A;
    private final int CANTIDAD_MAX_IMPRESORAS_B;
    private int impresorasAEnUso;
    private int impresorasBenUso;
    private ReentrantLock mutex;
    private Condition imprimirA;
    private Condition imprimirB;

    public Buffer(int cantidadMaximaImpresorasA, int cantidadMaximasImpresorasB) {
        this.CANTIDAD_MAX_IMPRESORAS_A = cantidadMaximaImpresorasA;
        this.CANTIDAD_MAX_IMPRESORAS_B = cantidadMaximasImpresorasB;
        this.impresorasAEnUso = this.impresorasBenUso = 0;
        this.mutex = new ReentrantLock();
        this.imprimirA = mutex.newCondition();
        this.imprimirB = mutex.newCondition();
    }
    public void imprimir(char unTipo)throws Exception{
        this.mutex.lock();
        switch(unTipo){
            case 'A'->this.impresoraADisponible();
            case 'B'->this.impresoraBDisponible();
            default ->this.prioridad();
        }
        this.mutex.unlock();
    }
    private synchronized void impresoraADisponible()throws Exception{
        if(this.impresorasAEnUso<this.CANTIDAD_MAX_IMPRESORAS_A){
            this.impresorasAEnUso++;
        }else{
            this.imprimirA.await();
            this.impresoraADisponible();
        }

    }
    private synchronized void impresoraBDisponible()throws Exception{
        if(this.impresorasBenUso<this.CANTIDAD_MAX_IMPRESORAS_B){
            this.impresorasBenUso++;
        }else{
            this.imprimirB.await();
            this.impresoraBDisponible();
        }
    }
    private synchronized void prioridad(){

    }

}
