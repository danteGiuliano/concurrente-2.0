public class Barco implements Runnable {

    private Deposito unDeposito;

    public Barco(Deposito unDeposito) {
        this.unDeposito = unDeposito;
    }

    public void run() {
        try {
            System.out.println("BARCO : " + Thread.currentThread().getName() + " Iniciado");
            Thread.sleep(1000);
        } catch (Exception aException) {
            System.out.println("ERROR : " + aException + " EN " + Thread.currentThread().getName());
        }
    }
}
