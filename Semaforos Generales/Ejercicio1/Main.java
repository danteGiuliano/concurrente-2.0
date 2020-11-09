public class Main {
     static Comedor unComedor = new Comedor(4,"perro","gato");
    public static void main(String[] args) {
        iniciarHilos(4, "perro",1);
        iniciarHilos(4,"gato",1);
    }
    private static void iniciarHilos(int cantidad,String tipo,int raciones){
        Mascota unasMascotas[]= new Mascota[cantidad];
        for(int i=0;i<unasMascotas.length;i++){
            unasMascotas[i]= new Mascota(unComedor,tipo,raciones);
            unasMascotas[i].start();
        }

    }

}