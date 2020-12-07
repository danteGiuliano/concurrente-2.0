public class Auto implements Runnable{
private Puente unPuente;
private String unSentido;

public Auto(Puente unPuente,String unSentido){
    this.unPuente=unPuente;
    this.unSentido=unSentido;
}
public void run(){
    try{
        System.out.println("Auto :"+Thread.currentThread().getName());
        //Rutina de cruzar el puente:

    }catch (Exception aException){
        System.out.println("ERROR :"+aException+Thread.currentThread().getName());
    }
}
}