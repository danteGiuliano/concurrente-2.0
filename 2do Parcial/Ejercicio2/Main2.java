import java.util.*;
public class Main2 {
    public static void main(String[] args) {
        Deposito unDeposito=new Deposito(10);

        ArrayList<Thread> hilos= new ArrayList<Thread>();

        for(int i=0;i<30;i++){ //Autos creados
            hilos.add(new Thread(new Auto(unDeposito)));
        }
        hilos.add(new Thread(new Barco(unDeposito)));

        hilos.forEach(e ->e.start());
    }
}
