
public class Barco implements Runnable {
    private Deposito unDeposito;


    public Barco(Deposito unDeposito){
        this.unDeposito=unDeposito;
    }
    public void run(){
        try{
            System.out.println("BARCO: "+Thread.currentThread().getName());
            Thread.sleep(100);
            while(true){ //Se supone que el Barco ya esta en el muelle. (Deberia ser el primer hilo en iniciar.)
                this.unDeposito.esperarAutos();
                Thread.sleep(1000);//Simulacion de viaje....
                this.unDeposito.llegadaADestino();
                Thread.sleep(1000);//Simulacion de viaje de nuevo.
                //LLego al inicio , repite el ciclo.
            }
            
            
        }catch (Exception aException){
            System.out.println("ERROR "+aException+" "+Thread.currentThread().getName());
        }
    }
}

