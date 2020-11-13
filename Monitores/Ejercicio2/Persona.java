public class Persona implements Runnable {
    private boolean esJubilado;
    private GestorSala unGestor;

    public Persona(boolean esJubilado, GestorSala unGestor) {
        this.esJubilado = esJubilado;
        this.unGestor = unGestor;
    }

    public void run() {
        try {
            System.out.println("Personna :" + Thread.currentThread().getName() + " Listo");
            Thread.sleep(100);
            // Rutina de proceso
            while (true) {
                this.unGestor.entrarSala(esJubilado);
                //Logica de la atencion----------------
                if(esJubilado){
                    System.out.println("Jubilado : "+Thread.currentThread().getName()+" Recibiendo atencion ");
                }else{
                    System.out.println("No Jubilado:"+Thread.currentThread().getName()+" Recibiendo atencion ");
                }                
                this.unGestor.salirSala();
                Thread.sleep(10000);
            }

        } catch (Exception e) {
            System.out.println("ERROR " + Thread.currentThread().getName());
        }
    }
}
