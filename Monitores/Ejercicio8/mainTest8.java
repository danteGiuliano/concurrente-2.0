import java.util.ArrayList;

public class mainTest8 {

    public static void main(String[] args) {

        CentroHomoterapia unCentro = new CentroHomoterapia(4, 9);

        ArrayList<Thread> hilos = new ArrayList<Thread>();
        for (int i = 0; i < 10; i++) {
            hilos.add(new Thread(new Medico(unCentro)));
        }
        for (int i = 0; i < 100; i++) {
            hilos.add(new Thread(new Persona(unCentro)));
        }
        hilos.forEach(e -> e.start());
    }
}