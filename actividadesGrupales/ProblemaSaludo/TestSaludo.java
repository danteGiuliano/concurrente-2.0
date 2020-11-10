
import java.util.ArrayList;

public class TestSaludo {

    public static void main(String[] args) {
        ArrayList<Thread> empleados = new ArrayList<Thread>();
        String nombres[] = { "Diego", "Anabela", "Dana", "Marito", "Bin" };
        Saludo unSaludo = new Saludo(nombres.length-1);

        for (String unNombre : nombres) {
            empleados.add(new Thread(new Empleado(unSaludo, unNombre)));
        }
        empleados.add(new Thread(new Jefe(unSaludo, "El PEPE")));// Empieza en el empleado 0

        // Un bloque en Java usando expresiones lambdas-introduccion a programacion funcional.
        empleados.forEach(e -> e.start());
        empleados.forEach(e -> {
            try {
                e.join();
            } catch (Exception aException) {
                System.out.println("ERROR: " + aException);
            }
        });
        System.out.println("Todos saludaron A TRABAJAR");
    }
}
