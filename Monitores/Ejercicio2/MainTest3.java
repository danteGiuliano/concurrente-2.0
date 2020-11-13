import java.util.ArrayList;

public class MainTest3{
    public static void main(String[] args) {
        ArrayList<Thread> hilos = new ArrayList<Thread>();
        GestorSala unGestor = new GestorSala();
        hilos.add(new Thread(new Termometro(unGestor)));
        int i=0;
        while(i<100){//Crea el doble de hilos.
            hilos.add(new Thread(new Persona(true,unGestor)));
            hilos.add(new Thread(new Persona(false,unGestor)));
            i++;
        }
        hilos.forEach(e-> e.start());
    
    }
}