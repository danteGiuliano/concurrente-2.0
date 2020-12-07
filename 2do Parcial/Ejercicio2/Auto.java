
public class Auto implements Runnable {
    Deposito unDeposito;

    public Auto(Deposito unDeposito) {
        this.unDeposito = unDeposito;
    }

    public void run() {
        try {
            System.out.println("AUTO: " + Thread.currentThread().getName());
            Thread.sleep(100);
                this.unDeposito.esperaMuelle();
                this.unDeposito.subeAuto();
                this.unDeposito.bajaAuto();
    
            // Una vez que entra. espera hasta llegar al destino. luego muere.

        } catch (Exception aException) {
            System.out.println("ERROR " + aException + " " + Thread.currentThread().getName());
        }
    }
}
