package TP6;

import java.util.Scanner;

public class puntoSiete {

    public static void cargaMatrizRec(int[][] mat, int fil, int col) {
        Scanner sc = new Scanner(System.in);

        if (fil < mat.length) {
            if (col < mat[fil].length) {
                System.out.println("Ingrese el elemento (" + (fil + 1) + "," + (col + 1) + ") de la matriz.");
                mat[fil][col] = sc.nextInt();
                cargaMatrizRec(mat, fil, col + 1);
            } else {
                cargaMatrizRec(mat, fil + 1, 0);
            }
        }
    }

    public static void imprimeMatrizRec(int[][] mat, int fil, int col) {
        if (fil < mat.length) {
            if (col < mat[fil].length) {
                System.out.print("|" + mat[fil][col]);
                imprimeMatrizRec(mat, fil, col + 1);
            } else {
                System.out.println("|");
                imprimeMatrizRec(mat, fil + 1, 0);
            }
        }
    }

    public static void ImprSumaFilasRec(int[][] mat, int fil, int col, int aux) {
        if (fil < mat.length) {
            if (col < mat[fil].length) {
                aux += mat[fil][col];
                ImprSumaFilasRec(mat, fil, col + 1, aux);
            } else {
                System.out.println("La suma de la fila " + (fil + 1) + " es: " + aux);
                ImprSumaFilasRec(mat, fil + 1, 0, 0);
            }
        }
    }

    public static int sumaArregloRec(int[] arr, int contador) {
        int aux = 0;

        if (contador < arr.length) {
            aux = arr[contador] + sumaArregloRec(arr, contador + 1);
        }

        return aux;
    }

    public static void main(String[] args) {
        int[][] unaMatriz = new int[4][3];
        cargaMatrizRec(unaMatriz, 0, 0);
        System.out.println("Cargó: ");
        imprimeMatrizRec(unaMatriz, 0, 0);

        // Opcion 1
        ImprSumaFilasRec(unaMatriz, 0, 0, 0);

        // Opcion 2
        for (int i = 0; i < unaMatriz.length; i++) {
            System.out.println("La suma de la fila " + (i + 1) + " es:" + sumaArregloRec(unaMatriz[i], 0));
        }
    }
}
