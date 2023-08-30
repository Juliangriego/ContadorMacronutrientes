package Clases;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;

import Clases.Alimentos;


public class Registro {

    public static void Escritura(String Fnombre, double FHC, double FPr, double FL){
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter("registro.txt"));

                bw.write("\n{" + Fnombre + "\n" + FHC + "\n" + FPr + "\n" + FL + "}");
                bw.close();

        } catch (FileNotFoundException fnfe){System.out.println("Archivos no encontrados");}
        catch (IOException ioe){System.out.println("Error en la lectura o escritura");}
    }

    public static void Lectura(){
        try{
            BufferedReader br = new BufferedReader(new FileReader("lista.txt"));
            String linea = "";

            while (linea != null ){
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
