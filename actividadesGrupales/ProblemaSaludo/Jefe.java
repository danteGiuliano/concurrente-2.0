package actividadesGrupales.ProblemaSaludo;

public class Jefe extends Personal {
    private int numeroEmpleados;

    public Jefe(Saludo unSaludo, String unNombre, int unNumeroDeEmpleados) {
        super(unSaludo, unNombre);
        this.numeroEmpleados = unNumeroDeEmpleados;
    }

    public void saludo()throws Exception {
        this.saludo.esperarEmpleados(this.numeroEmpleados);
        System.out.println(this.nombre+" Bienvenidxs");
    }

}