import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
import Clases.*;

public class Principal {
    public static void main (String[] args){

        //Inicializamos todo lo necesario
        Alimentos comida = new Alimentos();
        Scanner sc = new Scanner(System.in);
        boolean flag=false; //Dummie para opciones
        int opSwitch = 0;
        ArrayList<Alimentos> listaAlimentos = new ArrayList<Alimentos>();

        boolean flagNoEncontrado2 = true; // Para 2.a.
        boolean flagNoEncontrado3 = true; // Para 3.
        boolean flagNoEncontrado4 = true; // Para 4.

    
        /*
         * 1. Crear alimento
         * 1.a. Guardar en base de datos
         * 1.b. ¿Crear varias bases de datos?
         * 2. Leer alimento
         * 2.a. Revisar alimento individual
         * 2.b. Revisar todos los alimentos
         * 3. Actualizar alimento individual
         * 4. Borrar alimento individual
         * 5. Cálculo de nutrientes
         */

        do{
            Clases.Menues.MenuPrincipal();
            System.out.print("Ingrese la opción deseada \t");
            opSwitch = sc.nextInt();
            switch(opSwitch){
                case 1:
                     /* 1. Crear alimento */
                    /* 1.a Guardar en base de datos */
                    listaAlimentos.add(comida);
                    Nuevo(comida);
                    break;
                case 2:
                    /* 2. Leer alimento */
                    System.out.println("¿Desea revisar... \n1. un alimento en particular? \t2. todos los alimentos?");
                    switch(sc.nextInt()){
                        case 1: //2.a. Búsqueda individual
                            System.out.println("Ingrese el nombre del alimento a buscar");
                            String nombre = sc.nextLine().toLowerCase();//Para que no se tengan problemas con mayusculas y minusculas
                            for (Alimentos busqueda : listaAlimentos) {
                                if (busqueda.getNombreAlimento().equals(nombre)){
                                    System.out.printf("\n Nombre: %s \n --------------- \n Hidratos: %f \t Proteínas: %f \t Lípidos: %f \n --------------- ", busqueda.getNombreAlimento(), busqueda.getHidratos(), busqueda.getProteinas(), busqueda.getLipidos());
                                    flagNoEncontrado2 = false;
                                }
                            }
                                if (flagNoEncontrado2) {System.out.println("Alimento no encontrado");}
                            break;
                        case 2: //2.b. Búsqueda general
                            System.out.println("Lista de alimentos registrados");
                            for (Alimentos busqueda : listaAlimentos){
                                System.out.printf("\n Nombre: %s \n --------------- \n Hidratos: %f \t Proteínas: %f \t Lípidos: %f \n --------------- ", busqueda.getNombreAlimento(), busqueda.getHidratos(), busqueda.getProteinas(), busqueda.getLipidos());
                            }
                            break;
                        default: //Opción incorrecta
                            System.out.println("Opción incorrecta");
                        break;
                        }
                    break;
                case 3:
                /* 3. Actualizar alimento individual */
                    System.out.println("Ingrese el nombre del alimento a actualizar");
                        String nombre = sc.nextLine().toLowerCase();//Para que no se tengan problemas con mayusculas y minusculas
                        for (Alimentos busqueda : listaAlimentos) {
                            if (busqueda.getNombreAlimento().equals(nombre)){
                                Actualizado(busqueda);
                                flagNoEncontrado3 = false;
                            }
                        }
                        if (flagNoEncontrado3) {System.out.println("Alimento no encontrado");}
                    break;
                case 4:
                         /* 4. Borrar alimento individual */
                        System.out.println("Ingrese el nombre del alimento que quiere eliminar");
                        String borrado = sc.nextLine();
                        for (Alimentos alimentos : listaAlimentos) {
                            if (alimentos.getNombreAlimento().equalsIgnoreCase(borrado)){
                                listaAlimentos.remove(borrado);
                                flagNoEncontrado4 = false;
                            }
                        if (flagNoEncontrado4) {System.out.println("Alimento no encontrado");}
                        }
                    break;
                case 5:
                    /* 5. Cálculo de nutrientes */
                    Calculo(listaAlimentos);
                    break;
                default:
                    break;
        }
        } while (opSwitch<6);          
    } //Fin Main

    //Subprocesos

    public static void Nuevo(Alimentos Fcomida){
        Scanner sc = new Scanner (System.in);
        System.out.println("Ingrese el nombre del alimento");
            Fcomida.setNombreAlimento(sc.nextLine());
            System.out.println("Ingrese los gramos de hidratos de carbono cada 100 gramos");
            Fcomida.setHidratos(Double.parseDouble(sc.nextLine()));
            System.out.println("Ingrese los gramos de proteína cada 100 gramos");
            Fcomida.setProteina(Double.parseDouble(sc.nextLine()));
            System.out.println("Ingrese los gramos de lípidos cada 100 gramos");
            Fcomida.setLipidos(Double.parseDouble(sc.nextLine()));
            //return Fcomida;
    }
    
    public static void Actualizado(Alimentos Fcomida){
        Scanner sc = new Scanner (System.in);
        System.out.println("Ingrese el nuevo nombre del alimento");
            Fcomida.setNombreAlimento(sc.nextLine());
            System.out.printf("Hidratos de carbono: %f \n Ingrese nuevo valor:", Fcomida.getHidratos());
            Fcomida.setHidratos(sc.nextDouble());
            System.out.printf("Proteínas: %f \n Ingrese nuevo valor:", Fcomida.getProteinas());
            Fcomida.setProteina(sc.nextDouble());
            System.out.printf("Lípidos: %f \n Ingrese nuevo valor:", Fcomida.getLipidos());
            Fcomida.setLipidos(sc.nextDouble());
    }
    
    public static void Calculo(ArrayList<Alimentos> FlistaAlimentos){
        Scanner sc = new Scanner(System.in);
        boolean flagNoEncontradoCalculo = true;
        boolean flagSalidaDoCalculo = true;

        //Acumuladores
        double acum_hidrato=0, acum_proteina=0, acum_lipido=0;

        do {
            System.out.println("Ingrese el nombre del alimento");
            String Fcomida=sc.nextLine();

            for (Alimentos busqueda : FlistaAlimentos) {
                if (busqueda.getNombreAlimento().equals(Fcomida)){
                    acum_hidrato+=busqueda.getHidratos();acum_lipido+=busqueda.getLipidos();acum_proteina+=busqueda.getProteinas();
                    flagNoEncontradoCalculo = false;
                }
            }
            if (flagNoEncontradoCalculo) {System.out.println("Alimento no encontrado");}
            System.out.println("¿Desea ingresar otro alimento?");
            if (sc.nextLine() == "no") {
                flagSalidaDoCalculo = false; // ¿¿¿
            }

            if (flagSalidaDoCalculo){
                System.out.printf("Total de \nHidratos de carbono: %f \nProteínas: %f \nLípidos: %f.", acum_hidrato,acum_proteina, acum_lipido);
            }

        } while (flagSalidaDoCalculo);
        
    }

}