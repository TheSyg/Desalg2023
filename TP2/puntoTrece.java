package TP2;

import java.util.*;

public class puntoTrece {
    public static void main(String[] args) {
        /*
         * Algoritmo que lee un arreglo de caracteres
         * Y crea otro pero sólo con las vocales del primero.
         */
        // Decl
        char[] arrCaracteres, arrVocales;
        int largo;
        Scanner sc = new Scanner(System.in);
        //////////////
        // Carga arreglo inicial
        System.out.println("Ingrese el largo del arreglo inicial: ");
        largo = sc.nextInt();
        arrCaracteres = new char[largo];
        cargArr(arrCaracteres);
        System.out.println("El arreglo cargado es: ");
        mostrArr(arrCaracteres);
        /////////////
        // Inicializa el arreglo de vocales.
        arrVocales = new char[contadorVocales(arrCaracteres)];
        /////////////
        // Out
        filtraVocales(arrCaracteres, arrVocales);
        System.out.println("El arreglo resultante es: ");
        mostrArr(arrVocales);
        ////////
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

    public static void filtraVocales(char[] arrInicial, char[] arrVocales) {
        // Método que toma las vocales de un arreglo y las carga en otro.
        // Decl
        int contador = 0;
        /////////////////

        // Carga vocales.
        for (int i = 0; i < arrInicial.length; i++) {
            if ((arrInicial[i] == 'a') || (arrInicial[i] == 'e') || (arrInicial[i] == 'i') || (arrInicial[i] == 'o')
                    || (arrInicial[i] == 'u')) {
                arrVocales[contador] = arrInicial[i];
                contador++;
            }
        }
        //////////////
    }

    public static int contadorVocales(char[] arrInicial) {
        // Método que cuenta las vocales en un arreglo.

        // Decl
        int contador = 0;
        //////////

        // Obtiene el largo del arreglo de vocales.
        for (int i = 0; i < arrInicial.length; i++) {
            if ((arrInicial[i] == 'a') || (arrInicial[i] == 'e') || (arrInicial[i] == 'i') || (arrInicial[i] == 'o')
                    || (arrInicial[i] == 'u')) {
                // Coincidencia!
                contador++;
            }
        }
        ////////////
        return contador;
    }
}
