package actividadesGrupales.ProblemaSaludo;

import java.util.ArrayList;

public class TestSaludo {

    public static void main(String[] args) {
        ArrayList<Thread> empleados = new ArrayList<Thread>();
        Saludo unSaludo = new Saludo();
        String nombres[] = { "Diego", "Anabela", "Dana", "Marito", "Bin" };

        for (String unNombre : nombres) {
            empleados.add(new Thread(new Empleado(unSaludo, unNombre)));
        }
        empleados.add(new Thread(new Jefe(unSaludo, "El PEPE", 4)));//Empieza en el empleado 0

        //Un bloque en Java usando expresiones lamdas.
        empleados.forEach(e -> {
            try {
                e.start();
            } catch (Exception aException) {
                System.out.println("ERROR: " + aException);
            }
        });
    }
}
