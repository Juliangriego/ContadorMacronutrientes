import Clases.Alimentos;
import Clases.Registro;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException {

        Alimentos comida = new Alimentos();
        Scanner sc = new Scanner(System.in);
        int opSwitch;
        //ArrayList<Alimentos> listaAlimentos = new ArrayList<>();

        // * Machete:
        // * 1. Crear alimento
        // * 1.a. Guardar en base de datos
        // * 1.b. ¿Crear varias bases de datos?
        // * 2. Leer alimento
        // * 2.a. Revisar alimento individual
        // * 2.b. Revisar todos los alimentos
        // * 3. Actualizar alimento individual
        // * 4. Borrar alimento individual
        // * 5. Cálculo de nutrientes

        do {
            Clases.Menues.MenuPrincipal();
            System.out.print("Ingrese la opción deseada \t");
            opSwitch = sc.nextInt();

            switch (opSwitch) {
                case 1 -> Nuevo();
                case 2 -> {
                    System.out.println("¿Desea revisar... \n1. un alimento en particular? \t2. todos los alimentos?");
                    switch (sc.nextInt()) {
                        case 1 -> {
                            System.out.println("Ingrese el nombre del alimento a buscar");
                            Alimentos a = Clases.Registro.lectura(sc.nextLine());
                            assert a != null;
                            System.out.printf("Nombre del alimento: %s\nHidratos de carbono: %d\tProteinas:%d\tLìpidos: %d\n---------------",
                                    a.getNombreAlimento(),a.getHidratos(),a.getProteinas(),a.getLipidos());
                        }
                        case 2 -> {
                            Clases.Registro.lecturaIndice();}
                        default -> System.out.println("Opción incorrecta");
                    }
                }
                case 3 -> {
                    Actualizado();
                }
                case 4 -> {
                    System.out.println("Ingrese el nombre del alimento que quiere eliminar");
                    Clases.Registro.lectura(sc.next());
                }
                case 5 -> Calculo();
                default -> {
                }
            }
        } while (opSwitch < 6);
    } //Fin Main

    //Subprocesos

    /**
     * En Nuevo() se guarda en variables auxiliares los datos que provee el usuario y se guarda() en el registro.
     * @throws IOException
     */
    public static void Nuevo() throws IOException {
        Scanner sc = new Scanner(System.in);
        String Fnombre;
        double FHC, FPr, FL;

        System.out.println("Ingrese el nombre del alimento");
        Fnombre = sc.next();
        System.out.println("Ingrese los gramos de hidratos de carbono cada 100 gramos");
        FHC = Double.parseDouble(sc.next());
        System.out.println("Ingrese los gramos de proteína cada 100 gramos");
        FPr = Double.parseDouble(sc.next());
        System.out.println("Ingrese los gramos de lípidos cada 100 gramos");
        FL = Double.parseDouble(sc.next());
        Clases.Registro.guardar(Fnombre, FHC, FPr, FL);
    }

    /**
     * Actualizado: pide el nobmre de un alimento, lee() y muestra las características registradas del mismo,
     * y se ingresan nuevos valores del alimento en variables auxiliares.
     * Por último se borra() en registro.txt el alimento, y se guarda() el alimento nuevo.
     */
    public static void Actualizado() throws IOException {
        Scanner sc = new Scanner(System.in);
        String Fnombre;
        double FHC, FPr, FL;
        System.out.println("Ingrese el nuevo nombre del alimento");
        Alimentos a = Clases.Registro.lectura(sc.next());
        Fnombre = a.getNombreAlimento();
        System.out.printf("Hidratos de carbono: %f \n Ingrese nuevo valor:", a.getHidratos());
        FHC = Double.parseDouble(sc.next());
        System.out.printf("Proteínas: %f \n Ingrese nuevo valor:", a.getProteinas());
        FPr = Double.parseDouble(sc.next());
        System.out.printf("Lípidos: %f \n Ingrese nuevo valor:", a.getLipidos());
        FL = Double.parseDouble(sc.next());
        Clases.Registro.borrar(Fnombre);
        Clases.Registro.guardar(Fnombre, FHC, FPr, FL);
    }

    /**
     * En Calculo() se pide en cada ciclo el nombre de alimentos que se quiere comer y se guarda en acumuladores
     * tanto los nombres de los alimentos como sus macronutrientes.
     * Por ahora no lo calculo dependiendo de la cantidad de comida que se coma.
     * @throws IOException
     */
    public static void Calculo() throws IOException {
        Scanner sc = new Scanner(System.in);
        boolean flagSalidaDoCalculo = true;

        //Acumuladores
        double acum_hidrato = 0, acum_proteina = 0, acum_lipido = 0;
        String acum_nombres = "";

        do {
            System.out.println("Ingrese el nombre del alimento");
            String buscado = sc.next();
            Alimentos aux = Clases.Registro.lectura(buscado);

            acum_hidrato += Objects.requireNonNull(aux).getHidratos();
            acum_proteina += aux.getProteinas();
            acum_lipido += aux.getLipidos();
            acum_nombres = acum_nombres + ", ";

            System.out.printf("Totales \nHidratos: %f \tProteínas: %f \tLipidos: %f \nAlimentos ingresados: %d",
                    acum_hidrato, acum_proteina, acum_lipido, acum_nombres);

            System.out.println("¿Desea ingresar otro alimento?");
            if (sc.next().equals("no")) {
                flagSalidaDoCalculo = false; // ¿¿
            }
        } while (flagSalidaDoCalculo);

    }
}