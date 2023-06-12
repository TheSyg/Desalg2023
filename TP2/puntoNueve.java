package TP2;

import java.util.*;

public class puntoNueve {
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
                    buscaCaracter(arrChar);
                    break;
                case 5:
                    cuentaCaracter(arrChar);
                    break;
                case 6:
                    stop = true;
                    break;
                case 7:
                    buscaCaracterOptimizado(arrChar);
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
        System.out.println("3. Imprimir el arreglo al revés.\r\n4. Encontrar caracter.");
        System.out.println("5. Encontrar cantidad de veces que aparece un caracter.\r\n6. Terminar.");
        System.out.println("7. Para la opción 5 y 4 a la vez.");
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

    public static void buscaCaracter(char[] arreglo) {
        // Busca un caracter determinado en un arreglo de caracteres.
        // decl
        Scanner sc = new Scanner(System.in);
        char car;
        boolean coincidencia = false;
        ///////

        System.out.println("Ingrese el caracter a buscar: ");
        car = sc.next().charAt(0);
        for (int i = 0; i < arreglo.length; i++) {
            if (car == arreglo[i]) {
                coincidencia = true;
            }
        }

        // Salida
        if (coincidencia) {
            System.out.println("Caracter " + car + " encontrado.");
        } else {
            System.out.println("No se encontró el caracter: " + car);
        }
    }

    public static void cuentaCaracter(char[] arreglo) {
        // Método que cuenta las veces aparece un caracter en un arreglo de caracteres.

        // decl
        Scanner sc = new Scanner(System.in);
        char car;
        int contador = 0;
        /////////

        System.out.println("Ingrese el caracter a buscar. ");
        car = sc.next().charAt(0);

        for (int i = 0; i < arreglo.length; i++) {
            if (car == arreglo[i]) {
                // Coincidencia!
                contador++;
            }
        }
        // Salida
        System.out.println("El caracter " + car + " fue encontrado " + contador + " veces.");

    }

    public static void buscaCaracterOptimizado(char[] arreglo) {
        // decl
        Scanner sc = new Scanner(System.in);
        char car;
        int contador = 0;
        /////////

        System.out.println("Ingrese el caracter a buscar. ");
        car = sc.next().charAt(0);

        for (int i = 0; i < arreglo.length; i++) {
            if (car == arreglo[i]) {
                // Coincidencia!
                contador++;
            }
        }
        // Salida
        if (contador != 0) {
            System.out.println("Caracter encontrado! Cantidad: " + contador);
        } else {
            System.out.println("El caracter no está en la cadena.");
        }
    }
}