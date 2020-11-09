
public class Jefe extends Personal {

    public Jefe(Saludo unSaludo, String unNombre) {
        super(unSaludo, unNombre);
    }

    public void saludo()throws Exception {
        this.saludo.esperarEmpleados();
        System.out.println(this.nombre+" Bienvenidxs");
    }

}