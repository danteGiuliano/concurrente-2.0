public class Mascota extends Thread{
 private String tipo;
 private Comedor unComedero;
 //Ejercicio 2.
 private int raciones;
 public Mascota(Comedor unComedor,String unTipo,int raciones){
     this.tipo=unTipo;
     this.unComedero=unComedor;
     //Ejercicio 2.
     this.raciones=raciones;
}
public void run(){
    try{
        System.out.println(Thread.currentThread().getName()+" Iniciado");
        Thread.sleep(100);
        while(true){
            if(unComedero.puedeEntrar(tipo)&&unComedero.puedeComer(raciones)){
                System.out.println(this.tipo+" :"+Thread.currentThread().getName()+" Comiendo.");
                Thread.sleep(100);
                unComedero.cambioTurno();
            }else{
                unComedero.colaEspera();
            }
            Thread.sleep(100);
        }
    }catch(Exception e){
        System.out.println("ERROR :"+tipo+" "+e+Thread.currentThread().getName());
    }
}
}