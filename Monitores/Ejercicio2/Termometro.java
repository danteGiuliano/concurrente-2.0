import java.util.Random;

public class Termometro implements Runnable {
    private int temperaturaActual;
    private Random factor;
    private GestorSala unGestor;
    public Termometro(GestorSala unGestor){
        this.temperaturaActual=20;
        this.factor=new Random();
        this.unGestor=unGestor;
    } 
    public void run(){
        try{
            System.out.println("Termometro iniciado");
            Thread.sleep(100);
            //Rutina de medicion de temperatura;
            while(true){
                System.out.println("TEMPERATURA ACTUAL ------------------------------------------------:"+this.temperaturaActual);
                this.unGestor.notificarTemperatura(this.temperaturaActual);

                Thread.sleep(10000);
                this.medirTemperatura();
            }
        }catch(Exception e){
            System.out.println("EROR :"+e+" Fallo en Hilo Termometro.");
        }
    }
    private void medirTemperatura(){
        int aux=(factor.nextBoolean())?1:-1;
        this.temperaturaActual=this.temperaturaActual+(aux*(int)(10*factor.nextDouble()));
    }
}
