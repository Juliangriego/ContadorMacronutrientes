import Clases.Alimentos;

import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
    public static void main (String[] args){

        //Inicializamos todo lo necesario
        Alimentos comida = new Alimentos();
        Scanner sc = new Scanner(System.in);
        boolean flag=false; //Dummie para opciones
        int opSwitch;
        ArrayList<Alimentos> listaAlimentos = new ArrayList<>();

        boolean flagNoEncontrado2 = true; // Para 2.a.
        boolean flagNoEncontrado3 = true; // Para 3.
        boolean flagNoEncontrado4 = true; // Para 4.


        // * 1. Crear alimento
        // * 1.a. Guardar en base de datos
        // * 1.b. ¿Crear varias bases de datos?
        // * 2. Leer alimento
        // * 2.a. Revisar alimento individual
        // * 2.b. Revisar todos los alimentos
        // * 3. Actualizar alimento individual
        // * 4. Borrar alimento individual
        // * 5. Cálculo de nutrientes

        do{
            Clases.Menues.MenuPrincipal();
            System.out.print("Ingrese la opción deseada \t");
            opSwitch = sc.nextInt();
            switch (opSwitch) {
                case 1 ->
                    /* 1. Crear alimento */
                    /* 1.a Guardar en base de datos */
                        listaAlimentos.add(Nuevo());
                case 2 -> {
                    /* 2. Leer alimento */
                    System.out.println("¿Desea revisar... \n1. un alimento en particular? \t2. todos los alimentos?");
                    switch (sc.nextInt()) {
                        case 1: //2.a. Búsqueda individual
                            System.out.println("Ingrese el nombre del alimento a buscar");
                            String nombre = sc.next();
                            for (Alimentos busqueda : listaAlimentos) {
                                String auxBusqueda = busqueda.getNombreAlimento();
                                if (auxBusqueda.equals(nombre)) {
                                    System.out.printf("\n Nombre: %s \n --------------- \n Hidratos: %f \t Proteínas: %f \t Lípidos: %f \n --------------- ", busqueda.getNombreAlimento(), busqueda.getHidratos(), busqueda.getProteinas(), busqueda.getLipidos());
                                    flagNoEncontrado2 = false;
                                }
                            }
                            if (flagNoEncontrado2) {
                                System.out.println("Alimento no encontrado");
                            }
                            break;
                        case 2: //2.b. Búsqueda general
                            System.out.println("Lista de alimentos registrados");
                            for (Alimentos busqueda : listaAlimentos) {
                                System.out.printf("\n Nombre: %s \n --------------- \n Hidratos: %f \t Proteínas: %f \t Lípidos: %f \n --------------- ", busqueda.getNombreAlimento(), busqueda.getHidratos(), busqueda.getProteinas(), busqueda.getLipidos());
                            }
                            break;
                        default: //Opción incorrecta
                            System.out.println("Opción incorrecta");
                            break;
                    }
                }
                case 3 -> {
                    /* 3. Actualizar alimento individual */
                    System.out.println("Ingrese el nombre del alimento a actualizar");
                    String nombre = sc.next();
                    for (Alimentos alimentos : listaAlimentos) {
                        String auxBusqueda = alimentos.getNombreAlimento();
                        if (auxBusqueda.equals(nombre)) {
                            int posicion = listaAlimentos.indexOf(alimentos);
                            listaAlimentos.add(Actualizado(listaAlimentos.get(posicion), listaAlimentos, posicion));
                            flagNoEncontrado3 = false;
                        }
                    }
                    if (flagNoEncontrado3) {
                        System.out.println("Alimento no encontrado");
                    }
                }
                case 4 -> {
                    /* 4. Borrar alimento individual */
                    System.out.println("Ingrese el nombre del alimento que quiere eliminar");
                    String borrado = sc.next();
                    for (Alimentos alimentos : listaAlimentos) {
                        String auxBusqueda = alimentos.getNombreAlimento();
                        if (auxBusqueda.equals(borrado)) {
                            int posicion = listaAlimentos.indexOf(alimentos);
                            listaAlimentos.remove(posicion);
                            flagNoEncontrado4 = false;
                        }
                    }
                    if (flagNoEncontrado4) {
                        System.out.println("Alimento no encontrado");
                    }
                }
                case 5 ->
                    /* 5. Cálculo de nutrientes */
                        Calculo(listaAlimentos);
                default -> {
                }
            }
        } while (opSwitch<6);          
    } //Fin Main

    //Subprocesos

    public static Alimentos Nuevo(){
        Scanner sc = new Scanner (System.in);
        String Fnombre;
        double FHC,FPr,FL;
        System.out.println("Ingrese el nombre del alimento");
            Fnombre=sc.next();
            System.out.println("Ingrese los gramos de hidratos de carbono cada 100 gramos");
            FHC=Double.parseDouble(sc.next());
            System.out.println("Ingrese los gramos de proteína cada 100 gramos");
            FPr=Double.parseDouble(sc.next());
            System.out.println("Ingrese los gramos de lípidos cada 100 gramos");
            FL=Double.parseDouble(sc.next());
        return new Alimentos(Fnombre,FHC,FPr,FL);
    }
    
    public static Alimentos Actualizado(Alimentos Fcomida,ArrayList<Alimentos> FlistaAlimentos, int Fposicion){
        Scanner sc = new Scanner (System.in);
        String Fnombre;
        double FHC,FPr,FL;
        System.out.println("Ingrese el nuevo nombre del alimento");
        Fnombre=sc.next();
            System.out.printf("Hidratos de carbono: %f \n Ingrese nuevo valor:", Fcomida.getHidratos());
        FHC=Double.parseDouble(sc.next());
            System.out.printf("Proteínas: %f \n Ingrese nuevo valor:", Fcomida.getProteinas());
        FPr=Double.parseDouble(sc.next());
            System.out.printf("Lípidos: %f \n Ingrese nuevo valor:", Fcomida.getLipidos());
        FL=Double.parseDouble(sc.next());
        FlistaAlimentos.remove(Fposicion);
        Fcomida = new Alimentos(Fnombre,FHC,FPr,FL);
        return Fcomida;
    }
    
    public static void Calculo(ArrayList<Alimentos> FlistaAlimentos){
        Scanner sc = new Scanner(System.in);
        boolean flagNoEncontradoCalculo = true;
        boolean flagSalidaDoCalculo = true;

        //Acumuladores
        double acum_hidrato=0, acum_proteina=0, acum_lipido=0;

        do {
            System.out.println("Ingrese el nombre del alimento");
            String Fcomida=sc.next();

            for (Alimentos alimentos : FlistaAlimentos) {
                String auxBusqueda = alimentos.getNombreAlimento();
                if (auxBusqueda.equals(Fcomida)){
                    int posicion=FlistaAlimentos.indexOf(alimentos);
                    acum_hidrato+=FlistaAlimentos.get(posicion).getHidratos();
                    acum_proteina+=FlistaAlimentos.get(posicion).getProteinas();
                    acum_lipido+=FlistaAlimentos.get(posicion).getLipidos();
                    flagNoEncontradoCalculo = false;
                }
            }

            if (flagNoEncontradoCalculo) {System.out.println("Alimento no encontrado");}

            System.out.println("¿Desea ingresar otro alimento?");
            if (sc.next().equals("no")) {
                flagSalidaDoCalculo = false; // ¿¿¿
            }



        } while (flagSalidaDoCalculo);

    }

}