package TP2;

import java.util.*;

public class puntoCinco {
    public static void main(String[] args) {
        /*
         * Algoritmo que almacena los primeros 10 múltiplos de un número en un arreglo.
         */

        // decl
        Scanner sc = new Scanner(System.in);
        int[] arrMultiplos = new int[10];
        int multiplo = 0;
        ///////

        cargaMultiplos(multiplo, arrMultiplos);
        mostrArr(arrMultiplos);
    }

    public static void cargaMultiplos(int multiplo, int[] arreglo) {
        // Método que carga los 10 primeros multiplos de un numero N en un arreglo.
        for (int i = 0; i < arreglo.length; i++) {
            arreglo[i] = multiplo * (i + 1);
        }
    }

    public static void mostrArr(int[] arreglo) {
        // Método que muestra un arreglo.
        for (int i = 0; i < arreglo.length; i++) {
            System.out.print("|" + arreglo[i]);
        }
        System.out.println("|");
    }
}
