package Clases;

import java.io.*;
import java.util.Objects;
import java.util.Scanner;

import Clases.Alimentos;


public class Registro {

    public static void guardar(String Fnombre, double FHC, double FPr, double FL) throws IOException {

        //Siempre creo registro.txt para evitar errores innecesarios
        File file = new File("registro.txt");
        if (!file.exists()) {file.createNewFile();}

        //E ingresa en el registro con los datos de los parámetros
        try (FileWriter writer = new FileWriter(file, true);
             BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
            bufferedWriter.write(Fnombre + "," + FHC + "," + FPr + "," + FL + "\n");
        }
    }

    /**
     * Lectura busca un nombre de alimento dentro del archivo y devuelve un objeto Alimentos
     * @param nombre nombre del alimento buscado
     * @return objeto Alimentos
     * @throws IOException
     */
    public static Alimentos lectura(String nombre) throws IOException {
        Alimentos alimento = null;
        boolean Encontrado = false;

        File file = new File("registro.txt");
        if (!file.exists()) {
            return null;
        }

        try (FileReader reader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(reader)) {
            String linea;
            while ((linea = bufferedReader.readLine()) != null) {
                String[] datos = linea.split(",");

                if (datos[0].equals(nombre)) {
                    alimento = new Alimentos();
                    alimento.setNombreAlimento(datos[0]);
                    alimento.setHidratos(Double.parseDouble(datos[1]));
                    alimento.setProteina(Double.parseDouble(datos[2]));
                    alimento.setLipidos(Double.parseDouble(datos[3]));
                    Encontrado = true;
                    break;
                }
            }

            if (!Encontrado){
                alimento = new Alimentos();
            }
        }

        return alimento;
    }

    /**
     * Lecturaíndice muestra todos los datos del archivo registro.
     */
    public static void lecturaIndice() {

        try (FileReader reader = new FileReader("registro.txt");
             BufferedReader bufferedReader = new BufferedReader(reader)) {
            String linea;
            while ((linea = bufferedReader.readLine()) != null) {
                String[] datos = linea.split(",");
                System.out.println(datos[0]);
                System.out.println(datos[1]);
                System.out.println(datos[2]);
                System.out.println(datos[3]);
                break;
            }
        } catch (Exception e) {
            System.out.println("Error al leer el archivo " + e);
        }
    }


    public static void borrar(String nombre) throws IOException {
        File file = new File("registro.txt");
        File tempFile = new File("registro.tmp");

        BufferedReader reader = new BufferedReader(new FileReader(file));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

        String linea;
        while ((linea = reader.readLine()) != null) {
            if (!linea.equals(nombre)) {
                writer.write(linea + "\n");
            }
        }

        reader.close();
        writer.close();

        file.delete();
        tempFile.renameTo(file);
    }

    public static void actualizar() throws IOException {
        Scanner sc = new Scanner(System.in);
        Alimentos aux = new Alimentos();
        String NombreNuevo;
        double HC, Pr, L;

        System.out.println("¿Qué alimento quisiera actualizar?");
        Alimentos viejo = lectura(sc.nextLine());
        //Esto debería devolver el objeto correspondiente al alimento que se quiere actualizar

        //Guardo todos los nuevos datos en aux,
        System.out.println("Ingrese el nuevo nombre del alimento");
        NombreNuevo = sc.nextLine();
        System.out.printf("Hidratos de carbono: %f \n Ingrese nuevo valor:", Objects.requireNonNull(viejo).getHidratos());
        HC = Double.parseDouble(sc.next());
        System.out.printf("Proteínas: %f \n Ingrese nuevo valor:", viejo.getProteinas());
        Pr = Double.parseDouble(sc.next());
        System.out.printf("Lípidos: %f \n Ingrese nuevo valor:", viejo.getLipidos());
        L = Double.parseDouble(sc.next());

        //Borramos el viejo
        borrar(viejo.getNombreAlimento());
        //Sumamos el nuevo
        guardar(NombreNuevo, HC, Pr, L);
    }


}