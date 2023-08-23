import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class LecturaDeArchivos {
    public static void main(String[] args){
        try{ //El bloque try "intenta" ejecutar el programa en busqueda de excepciones
            // Creamos el objeto del tipo BufferedReader para almacenar la informacion del archivo
            // Tenemos que enviar como argumento el archivo mediante el objeto FileReader
            BufferedReader br = new BufferedReader(new FileReader("lista.txt")); 
            String linea = "";

        while (linea != null ){ //Mientras la variable linea contenga elementos, se ejecuta el bloque while
            System.out.println(linea);
            linea = br.readLine();
        }
        br.close();
        //Los bloques catch capturan las excepciones y ejecutan una secuencia de codigo dependiendo de la excepcion encontrada
        } catch (FileNotFoundException noEncontrado){
            System.out.println("No se encuentra el archivo lista.txt");
        } catch (IOException corrupto){
            System.out.println("No se puede leer el archivo lista.txt");
        }
    }
}
