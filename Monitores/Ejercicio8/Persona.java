public class Persona implements Runnable {

    private CentroHemoterapia unCentro;

    public Persona(CentroHemoterapia unCentro) {
        this.unCentro = unCentro;
    }

    public void run() {
        try {
            System.out.println("Persosna " + Thread.currentThread().getName() + " Iniciado.");
            Thread.sleep(100);
            // Rutina de Persona
            this.unCentro.entradaCentro(this);
            System.out.println(Thread.currentThread().getName() + " Esperando atencion");
            this.unCentro.atencionMedico();
            System.out.println(Thread.currentThread().getName() + " Atendido se va!");
        } catch (Exception e) {
            System.out.println("ERROR " + e + " " + Thread.currentThread().getName());
        }
    }

}