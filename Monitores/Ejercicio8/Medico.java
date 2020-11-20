public class Medico implements Runnable {
    private CentroHomoterapia unCentroDeSalud;

    public Medico(CentroHomoterapia unCentro) {
        this.unCentroDeSalud = unCentro;
    }

    public void run() {
        try {
            System.out.println("Medico :" + Thread.currentThread().getName() + " Inicado.");
            Thread.sleep(100);
            // rutina Medico
            while (true) {
                if (this.unCentroDeSalud.hayPacientes()) {
                    this.unCentroDeSalud.llamaAPaciente();
                    System.out.println("Medico :" + Thread.currentThread().getName() + " LLamo a un paciente");
                    Thread.sleep(1000);
                    System.out.println("Medico :" + Thread.currentThread().getName() + " Atendio a un paciente");
                    this.unCentroDeSalud.personaAtendida();
                }
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            System.out.println("ERROR :" + e + " " + Thread.currentThread().getName() + " MEDICO");
        }

    }

}
