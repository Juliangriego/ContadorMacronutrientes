import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;

public class LecturaYescrituraCombinadas {
    public static void main (String[] args){
        try{
            BufferedReader br1 = new BufferedReader(new FileReader("archivo1.txt"));
            BufferedReader br2 = new BufferedReader(new FileReader("archivo2.txt"));
            BufferedWriter bw = new BufferedWriter(new FileWriter("mezcla.txt"));

            String linea1 = "";
            String linea2 = "";

            while ((linea1 != null) || (linea2 != null)){
                linea1 = br1.readLine();
                linea2 = br2.readLine();
                if (linea1 != null){
                    bw.write(linea1 + "\n");
                }
                if (linea2 != null){
                    bw.write(linea2 + "\n");
                }
            }
            br1.close();
            br2.close();
            bw.close();

            System.out.println("El archivo mezcla.txt fue creado satisfactoriamente");

        } catch (FileNotFoundException fnfe){
            System.out.println("Archivos no encontrados");
        } catch (IOException ioe){
            System.out.println("Error en la lectura o escritura");
        }
    }
}
