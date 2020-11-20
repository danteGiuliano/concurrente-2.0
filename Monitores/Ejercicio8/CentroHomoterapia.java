import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class CentroHomoterapia {
    private ReentrantLock mutex;
    private Condition esperaLeyendo, esperaViendoTele, atencionPaciente;
    private int cantidadCamillas, cantidadRevistas;
    private static int CANTIDAD_MAXIMA_CAMILLAS, CANTIDAD_MAXIMA_REVISTAS;

    public CentroHomoterapia(int unaCantidadDeCamillas, int unaCantidadDeRevistas) {
        this.mutex = new ReentrantLock();
        this.esperaLeyendo = mutex.newCondition();
        this.esperaViendoTele = mutex.newCondition();
        this.atencionPaciente = mutex.newCondition();
        this.cantidadCamillas = 0;
        this.cantidadRevistas = 0;
        CANTIDAD_MAXIMA_CAMILLAS = unaCantidadDeCamillas;
        CANTIDAD_MAXIMA_REVISTAS = unaCantidadDeRevistas;
    }

    // logica de la clase Persona.
    public void entradaCentro() throws Exception {
        this.mutex.lock();
        while (this.cantidadRevistas == CANTIDAD_MAXIMA_REVISTAS) {
            this.esperaViendoTele.await();
        }
        this.cantidadRevistas++;
        this.esperaLeyendo.await();
        this.mutex.unlock();
    }

    public void atencionMedico() throws Exception {
        this.mutex.lock();
        this.atencionPaciente.await();
        this.mutex.unlock();
    }

    // logica de la clase Medico.

    public boolean hayPacientes() {
        return (this.cantidadRevistas != 0);
    }

    public void llamaAPaciente() throws Exception {
        this.mutex.lock();
        if (this.cantidadCamillas < CANTIDAD_MAXIMA_CAMILLAS) {
            this.cantidadCamillas++;
            this.cantidadRevistas--;
            this.esperaLeyendo.signal();
            this.esperaViendoTele.signalAll();
        }
        this.mutex.unlock();
    }

    public void personaAtendida() {
        this.mutex.lock();
        this.atencionPaciente.signal();
        this.cantidadCamillas--;
        this.mutex.unlock();
    }

}
