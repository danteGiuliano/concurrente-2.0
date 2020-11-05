
public class Pasajero extends Thread{

    private Tren unTren;

public Pasajero(Tren aTren){
    this.unTren=aTren;
}
public void run(){
    try{
        System.out.println(Thread.currentThread().getName()+" Iniciado");
        Thread.sleep(100);
        while(true){
            if(this.unTren.controlGuardia()&&this.unTren.obtenerPasaje()){
                System.out.println(Thread.currentThread().getName()+" Subio al tren");
                this.unTren.subirATren();
            }else{
                this.unTren.esperarTren();
            }
            Thread.sleep(100);
        }

    }catch (Exception e){
        System.out.println("ERROR :"+e+" "+Thread.currentThread().getName());
    }
}

}