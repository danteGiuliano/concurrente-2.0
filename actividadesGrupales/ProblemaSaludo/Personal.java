package actividadesGrupales.ProblemaSaludo;

abstract class Personal implements Runnable{
    protected String nombre;
    protected Saludo saludo;

    private final String  DEBUG=getClass().getSimpleName()+" :"+Thread.currentThread().getName();

    public Personal(Saludo unSaludo,String unNombre){
        this.saludo=unSaludo;
        this.nombre=unNombre;
    }

    public void run(){
        try{
            System.out.println(DEBUG+" "+this.nombre+" Iniciado");
            Thread.sleep(100);
            //rutina de saludo.
            this.saludo();

        }catch(Exception e){
            System.err.println("ERROR :"+e+" "+DEBUG+" "+this.nombre);
        }
    }
    abstract void saludo()throws Exception;

}