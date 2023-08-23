import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class LecturaDeAarchivos2 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.print("Introduzca el nombre del archivo: ");
        String nombreDeArchivo = s.nextLine();

        try{
            BufferedReader br = new BufferedReader(new FileReader(nombreDeArchivo));
            String linea = "0";
            int i = 0;
            double suma = 0;

            while (linea != null){
                i ++;
                suma += Double.parseDouble(linea);
                linea = br.readLine();
            }
            // Al comenzar el bucle while, nuestro contador suma un
            // numero que no se encuentra en el archivo (linea = "0")
            // por lo tanto restamos 1 al contador para poder
            // calcular correctamente el promedio
            i --; 
            br.close();

            System.out.println("El promedio es: " + suma / (double)i);

        } catch (FileNotFoundException fnfe){
            System.out.println("No se encentra el archivo " + nombreDeArchivo);
        } catch (IOException ioe){
            System.out.println("No se puede leer el archivi " + nombreDeArchivo);
        }
    }
}
