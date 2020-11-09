public class Main {
    public static void main(String[] args) {
        Tren unTren = new Tren(4);
        Pasajero pasajeros[]= new Pasajero[10];
        for(int i=0;i<pasajeros.length;i++){
            pasajeros[i]= new Pasajero(unTren);
            pasajeros[i].start();
        }
    }
}
