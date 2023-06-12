package TP2;

import java.util.*;

import javax.swing.SingleSelectionModel;

public class puntoUno {
    public static void main(String[] args) {
        /*
         * Algoritmo que carga un arreglo de caracteres
         * con longitud n, y luego permite al usuario
         * imprimirlo derecho o al revés.
         */

        // Decl
        Scanner sc = new Scanner(System.in);
        char[] arrChar;
        int largo = 0;
        short opcion = 0;
        Boolean stop = false;
        ////////////

        // Carga longitud
        System.out.println("Ingrese la longitud del arreglo. ");
        largo = sc.nextInt();
        arrChar = new char[largo];
        /////////////

        // Menú
        do {
            opcion = menu();
            switch (opcion) {
                case 1:
                    cargArr(arrChar);
                    break;
                case 2:
                    mostrArr(arrChar);
                    break;
                case 3:
                    mostrArrInverso(arrChar);
                    break;
                case 4:
                    stop = true;
                    break;
                default:
                    System.out.println("Ingreso inválido.\n\rIntente de nuevo.");
                    break;
            }
        } while (!stop);

    }

    public static short menu() {
        // Muestra el menú, retorna opción elegida.
        // decl
        short opcion = 0;
        Scanner sc = new Scanner(System.in);
        ///////////
        // Salida
        System.out.println("1. Cargar el arreglo.\r\n2. Imprimir el arreglo derecho.");
        System.out.println("3. Imprimir el arreglo al revés.\r\n4. Terminar.");
        //////////
        opcion = sc.nextShort();
        return opcion;
    }

    public static void cargArr(char[] arreglo) {
        // Método que carga un arreglo.
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < arreglo.length; i++) {
            System.out.println("Ingrese el elemento " + (i + 1) + " del arreglo.");
            arreglo[i] = sc.next().charAt(0);
        }
    }

    public static void mostrArr(char[] arreglo) {
        // Método que muestra un arreglo al derecho.
        for (int i = 0; i < arreglo.length; i++) {
            System.out.print("|" + arreglo[i]);
        }
        System.out.println("|");
    }

    public static void mostrArrInverso(char[] arreglo) {
        // Método que muestra un arreglo al derecho.
        for (int i = 0; i < arreglo.length; i++) {
            System.out.print("|" + arreglo[arreglo.length - 1 - i]);
        }
        System.out.println("|");
    }
}
