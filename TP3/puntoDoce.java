package TP3;

import java.util.*;

public class puntoDoce {
    public static void main(String[] args) {
        /*
         * Algoritmo que escalona una matriz,
         * colocando los valores más altos en la diagonal
         */

        // Decl
        int[][] unaMatriz;
        int longitud = 0;
        Scanner sc = new Scanner(System.in);
        ///////////////////

        // Crea matriz
        System.out.println("Ingrese la longitud de la matriz: ");
        longitud = sc.nextInt();
        unaMatriz = new int[longitud][longitud];
        cargaMatriz(unaMatriz);
        System.out.println("Matriz original:");
        imprimeMatriz(unaMatriz);

        // Escalador
        for (int i = 0; i < unaMatriz.length; i++) {
            filaMasGrande(i, unaMatriz);
            haceCeros(unaMatriz, i);
        }

        System.out.println("Matriz transformada: ");
        imprimeMatriz(unaMatriz);

    }

    public static void imprimeMatriz(int[][] matriz) {
        // Método que imprime una matriz.

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                System.out.print("|" + matriz[i][j]);
            }
            System.out.println("|");
        }
    }

    public static void cargaMatriz(int[][] matriz) {
        // Método que carga una matriz de enteros.

        // Decl
        Scanner sc = new Scanner(System.in);
        //////

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.println("Ingrese el elemento (" + (i + 1) + "," + (j + 1) + ") de la matriz.");
                matriz[i][j] = sc.nextInt();
            }
        }
    }

    public static int[][] intercambiarFilas(int[][] matriz, int fila1, int fila2) {
        // Método para intercambiar dos filas de una matriz
        int[] temp = matriz[fila1];
        matriz[fila1] = matriz[fila2];
        matriz[fila2] = temp;
        return matriz;
    }

    public static int[][] filaMasGrande(int columna, int[][] matriz) {
        // Método que busca en una columna determinada el valor más alto entre las filas
        // y la coloca arriba.

        // Decl
        int auxNum = 0, auxFil = 0;
        ////////////////////////

        // Busca el elemento más grande de X columna.
        for (int i = 0; i < matriz.length; i++) {
            if (matriz[i][columna] > auxNum) {
                auxNum = matriz[i][columna];
                auxFil = i;
            }
        }

        matriz = intercambiarFilas(matriz, columna, auxFil);

        return matriz;
    }

    public static void haceCeros(int[][] matriz, int fila) {
        // Método que convierte en cero los objetos después del elemento X en una fila.

        int[] ayudante = new int[matriz.length];
        ayudante = matriz[fila];
        for (int i = fila + 1; i < ayudante.length; i++) {
            ayudante[i] = 0;
        }
        matriz[fila] = ayudante;
    }
}
