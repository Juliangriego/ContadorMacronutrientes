import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import java.util.Scanner;
import Clases.*;

public class Principal {
    public static void main (String[] args){
        Alimentos comida = new Alimentos();
        Scanner sc = new Scanner(System.in);
        boolean flag=false; //Dummie para opciones
        int op = 0; //Dummie para opciones
        Clases.Registro.lista(comida); //Iniciamos la lista de comidas, se guarda en un txt.
        do {
            Clases.Registro.NuevoIngreso();
            System.out.println("¿Desea ingresar otro alimento? Ingrese número \n1.-Si\t2.-No\n3.-Tal vez...");
            op = sc.nextInt();
            if (op == 3){
               System.out.println("Conque sos el famoso «listill@»...");
               op=2;
            }
        } while (op != 2);
        
    }
}
