public class Avion extends Thread {
    private TorreControl unaTorre;
    private String estado;
    public Avion(TorreControl unaTorre,String estado){
        this.estado=estado;
        this.unaTorre= unaTorre;
    }

    public void run(){
        try{
            System.out.println(Thread.currentThread().getName()+" Iniciado");
            Thread.sleep(100);
            while(true){
                if(this.unaTorre.permisoPista(this.estado)){
                    //Aqui usaria la pista tomandose su tiempo, notifica que abandona la pista
                    this.unaTorre.abandonoLaPista();
                }
                Thread.sleep(100);
            }

        }catch (Exception e){
            System.out.println("ERROR :"+e+" "+Thread.currentThread().getName());
        }
    }

    private void esperar()throws Exception{
        Thread.sleep(10000);
    }
}
