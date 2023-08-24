package Clases;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import Clases.Alimentos;

import java.util.ArrayList;
import java.util.Scanner;

public class Registro {

    public static ArrayList<Alimentos> FlistaAlimentos (){
        //Creo una lista de objetos que sea listaAlimentos.
        ArrayList<Alimentos> FlistaAlimentos = new ArrayList<Alimentos>();
        return FlistaAlimentos;
    }

    /**
     * En NuevoIngreso vamos a ingresar un nuevo alimento en la lista. \n
     * Primero ingresamos el nombre del alimento y se inicializan en 0 todos los valores. \n
     * Luego se guarda como texto separado por comas.
     * Contrato.
     * Ingresa: * Nombre del alimento. (opcional) * Valores nutricionales.
     * Sale: * Inclusión en lista. * Creación del objeto Alimentos. * Ingreso de valores.
     */
    public static void NuevoIngreso(ArrayList<Alimentos> FlistaAlimentos){
        Scanner sc = new Scanner (System.in);
        System.out.println("Nombre del alimento: ");

        // Ingreso el nombre del alimento
        String auxnomAlim = sc.nextLine();

        // Declaro los valores como doubles y los inicializo por default en 0. Hacer métodos particulares.
        double valorHC = 0;
        double valorProt = 0;
        double valorLip = 0;

        /*Creo ahora el alimento. 
        Después de ingresar los valores, así aprovecho el constructor, y antes de ingresarlo en lista.
        También lo agrego a la lista de Alimentos*/
        Alimentos comida = new Alimentos(auxnomAlim,valorHC,valorProt,valorLip);
        FlistaAlimentos.add(comida);

        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter("comidas.txt", true));
            bw.write(comida.getNombreAlimento() + ",");
            bw.write(comida.getHidratos() + ",");
            bw.write(comida.getProteinas() + ",");
            bw.write(comida.getLipidos() + ";");
            bw.close();
            } catch (IOException ioe){
                System.out.println("No se puede escribir el archivo");
            }
    }
    
    /**
     * El método IngresoHidratos guarda en el objeto Alimentos los gramos de hidratos de carbono cada 100 gramos de alimento
     * @param comida Alimento en particular
     */
    public static void IngresoHidratos(Alimentos comida){
        Scanner sc = new Scanner (System.in);
            System.out.println("Ingrese la cantidad de hidratos de carbono cada 100 gramos de alimento");
            comida.setHidratos(sc.nextInt());
    }

    /**
     *  El método IngresoProteinas guarda en el objeto Alimentos los gramos de proteínas cada 100 gramos de alimento
     * @param comida Alimento en particular
     */
    public static void IngresoProteinas(Alimentos comida){
        Scanner sc = new Scanner (System.in);
        System.out.println("Introduce el nombre del alimento");
            comida.setNombreAlimento(sc.nextLine());
            System.out.println("Ingrese la cantidad de hidratos de carbono cada 100 gramos de alimento");
            comida.setProteina(sc.nextInt());
    }

    /**
     * El método IngresoLipidos guarda en el objeto Alimentos los gramos de lípidos cada 100 gramos de alimento
     * @param comida Alimento en particular
     */
    public static void IngresoLipidos(Alimentos comida){
        Scanner sc = new Scanner (System.in);
            System.out.println("Ingrese la cantidad de lípidos cada 100 gramos de alimento");
            comida.setLipidos(sc.nextInt());
    }


public static void ConsultaAlimentos(ArrayList<Alimentos> FlistaAlimentos){
    Scanner sc=new Scanner (System.in);
    String comidaConsulta;
    System.out.println("¿Qué alimento desea buscar?");
    comidaConsulta = sc.nextLine();

    if (FlistaAlimentos.contains(comidaConsulta)){
        System.out.println("El alimento está ingresado");
    } else {
        System.out.println("El alimento no está ingresado");
    }
}

}
