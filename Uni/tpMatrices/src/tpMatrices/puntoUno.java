package tpMatrices;

import java.util.Scanner;

public class puntoUno {
    public static void main(String[] args) {
        // Algoritmo que carga e imprime una matriz de forma organizada.

        // Decl
        boolean detenerse = false;
        int[][] matriz;
        int fil = 0, col = 0;
        Scanner sc = new Scanner(System.in);
        //////////

        // Creación
        System.out.println("Ingrese la cantidad de filas en la matriz: ");
        fil = sc.nextInt();
        System.out.println("Ingrese la cantidad de columnas en una matriz: ");
        col = sc.nextInt();
        matriz = new int[fil][col];
        ////////////

        do {
            switch (menu()) {
                case 1:
                    cargaMatriz(matriz);
                    break;
                case 2:
                    imprimeMatriz(matriz);
                    break;
                case 3:
                    detenerse = true;
                    break;
                default:
                    System.out.println("Intente de nuevo.");
                    break;
            }

        } while (!detenerse);
    }

    public static void cargaMatriz(int[][] matriz) {
        // Método que carga una matriz.
        Scanner sc = new Scanner(System.in);

        for (int fil = 0; fil < matriz.length; fil++) {
            for (int col = 0; col < matriz[0].length; col++) {
                System.out.println("Ingrese el elemento (" + (fil + 1) + "," + (col + 1) + ") de la matriz.");
                matriz[fil][col] = sc.nextInt();
            }
        }
    }

    public static void imprimeMatriz(int[][] matriz) {
        // Imprime una matriz.
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print("|" + matriz[i][j]);
            }
            System.out.println("|");
        }

    }

    public static short menu() {
        // Menú

        // Decl
        short opcion = 0;
        Scanner sc = new Scanner(System.in);

        // Out
        System.out.println("Ingrese un número para elegir:");
        System.out.println("1. Cargar una matriz\n\r2. Imprimir matriz\n\r3. Terminar.");

        // Retorno
        opcion = sc.nextShort();
        return opcion;
    }
}
