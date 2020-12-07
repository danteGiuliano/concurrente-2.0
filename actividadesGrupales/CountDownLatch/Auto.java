public class Auto implements Runnable{
    
    private Deposito unDeposito;

    public Auto(Deposito unDeposito){
        this.unDeposito=unDeposito;
    }
    public void run(){
        try{
            System.out.println("AUTO : "+Thread.currentThread().getName()+" Iniciado");
            Thread.sleep(1000);
        }catch(Exception aException){
            System.out.println("ERROR : "+aException+" EN "+Thread.currentThread().getName());
        }
    }
}
