import Clases.Alimentos;

import java.io.IOException;
import java.util.ArrayList;
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
                case 1 -> listaAlimentos.add(Nuevo());
                case 2 -> {
                    System.out.println("¿Desea revisar... \n1. un alimento en particular? \t2. todos los alimentos?");
                    switch (sc.nextInt()) {
                        case 1 -> {
                            System.out.println("Ingrese el nombre del alimento a buscar");
                            String buscado = sc.next();
                            System.out.printf("\n " +
                                            "Nombre: %s \n --------------- \n " +
                                            "Hidratos: %f \t Proteínas: %f \t Lípidos: %f \n " +
                                            "--------------- ",
                                    Clases.Registro.lectura(buscado).getNombreAlimento(),
                                    Clases.Registro.lectura(buscado).getHidratos(),
                                    Clases.Registro.lectura(buscado).getProteinas(),
                                    Clases.Registro.lectura(buscado).getLipidos());
                        }
                        case 2 -> {
                            System.out.println("Lista de alimentos registrados");
                            for (Alimentos aux : listaAlimentos) {
                                System.out.printf("\n Nombre: %s \n --------------- \n Hidratos: %f \t Proteínas: %f \t Lípidos: %f \n --------------- ", aux.getNombreAlimento(), aux.getHidratos(), aux.getProteinas(), aux.getLipidos());
                            }
                        }
                        default -> System.out.println("Opción incorrecta");
                    }
                }
                case 3 -> {
                    System.out.println("Ingrese el nombre del alimento a actualizar");
                    String buscado = sc.next();
                    listaAlimentos.add(Actualizado(Clases.Registro.lectura(buscado), listaAlimentos));
                }
                case 4 -> {
                    System.out.println("Ingrese el nombre del alimento que quiere eliminar");
                    String buscado = sc.next();
                    listaAlimentos.remove(Clases.Registro.lectura(buscado));
                }
                case 5 -> Calculo(listaAlimentos);
                default -> {
                }
            }
        } while (opSwitch < 6);
    } //Fin Main

    //Subprocesos

    public static Alimentos Nuevo() throws IOException {
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
        return new Alimentos(Fnombre, FHC, FPr, FL);
    }

    public static Alimentos Actualizado(Alimentos Fcomida, ArrayList<Alimentos> FlistaAlimentos) {
        Scanner sc = new Scanner(System.in);
        String Fnombre;
        double FHC, FPr, FL;
        System.out.println("Ingrese el nuevo nombre del alimento");
        Fnombre = sc.next();
        System.out.printf("Hidratos de carbono: %f \n Ingrese nuevo valor:", Fcomida.getHidratos());
        FHC = Double.parseDouble(sc.next());
        System.out.printf("Proteínas: %f \n Ingrese nuevo valor:", Fcomida.getProteinas());
        FPr = Double.parseDouble(sc.next());
        System.out.printf("Lípidos: %f \n Ingrese nuevo valor:", Fcomida.getLipidos());
        FL = Double.parseDouble(sc.next());
        FlistaAlimentos.remove(Fposicion);
        Fcomida = new Alimentos(Fnombre, FHC, FPr, FL);
        return Fcomida;
    }

    public static void Calculo(ArrayList<Alimentos> FlistaAlimentos) throws IOException {
        Scanner sc = new Scanner(System.in);
        boolean flagSalidaDoCalculo = true;

        //Acumuladores
        double acum_hidrato = 0, acum_proteina = 0, acum_lipido = 0;

        do {
            System.out.println("Ingrese el nombre del alimento");
            String buscado = sc.next();
            Alimentos aux = Clases.Registro.lectura(buscado);

            acum_hidrato += aux.getHidratos();
            acum_proteina += aux.getProteinas();
            acum_lipido += aux.getLipidos();

            System.out.printf("Totales \nHidratos: %f \tProteínas: %f \tLipidos: %f \n", acum_hidrato, acum_proteina, acum_lipido);

            System.out.println("¿Desea ingresar otro alimento?");
            if (sc.next().equals("no")) {
                flagSalidaDoCalculo = false; // ¿¿¿
            }
        } while (flagSalidaDoCalculo);

    }
}