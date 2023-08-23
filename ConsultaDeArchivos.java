import java.io.File;

public class ConsultaDeArchivos{
    public static void main (String[] args){
        File f = new File(".");
        String[] listaArchivos = f.list();
        for (String nombreDeArchivo : listaArchivos){
            System.out.println(nombreDeArchivo);
        }
    }
}