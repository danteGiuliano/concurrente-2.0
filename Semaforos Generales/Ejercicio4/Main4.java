import java.util.Random;

public class Main4 {
    public static void main(String[] args) {
        TorreControl unaTorre= new TorreControl(10);
         Avion aviones[]=new Avion[4];
         String estado []= {"despegue","aterriza"};
         Random rd = new Random();
         for(int i=0;i<aviones.length;i++){
            aviones[i]= new Avion(unaTorre,estado[rd.nextInt(2)]);
        }
    }
}
