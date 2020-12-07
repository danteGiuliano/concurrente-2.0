import java.util.concurrent.Semaphore;

public class Puente {
    private String unSentido,proximoSentido;
    private Semaphore colaEspera;
    
    public Puente (String unSentido,String proximoSentido){
        this.unSentido=unSentido;
        this.proximoSentido=proximoSentido;
        this.colaEspera=new Semaphore(0);
    }

    public synchronized void entradaPuente(String unSentido)throws Exception{
        if(unSentido.equals(this.proximoSentido)){
            this.colaEspera.acquire();
        }
    }





}
