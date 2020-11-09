
public class Empleado extends Personal {

    public Empleado(Saludo unSaludo, String unNombre) {
        super(unSaludo, unNombre);
    }

    public void saludo()throws Exception {
        this.saludo.esperarJefe();
        System.out.println(this.nombre + " Buenos dias Jefe!");

    }
}
