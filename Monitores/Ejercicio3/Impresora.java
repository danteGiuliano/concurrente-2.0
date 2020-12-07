public class Impresora implements Runnable{

    private String tipo;
    private Buffer solicitud;
    private final String DEBUG;
    public Impresora(String unTipo,Buffer unaSolicitud){
        this.tipo=unTipo;
        this.solicitud=unaSolicitud;
        DEBUG = this.getClass().getSimpleName()+" "+this.tipo;
    }

    public void run(){
        try{
            System.out.println(DEBUG+" iniciado");
            Thread.sleep(100);
            //Rutina de impresion.
            while(buffer.imprimir(tipo)){
                Thread.sleep(1997);
            }
        }catch (Exception e){
            System.out.println("ERROR :"+e+" "+DEBUG);
        }

    }




}