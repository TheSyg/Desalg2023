package TP3;

import java.util.Scanner;

public class puntoSiete {
    public static void main(String[] args) {
        /*
         * Algoritmo que recorre e imprime una matrix cuadrada
         * de diferentes formas.
         */

        // Decl
        boolean detenerse = false;
        int[][] unaMatriz;
        int dimension = 0;
        Scanner sc = new Scanner(System.in);
        ////////////////

        // Carga matriz.
        System.out.println("Ingrese la dimensión de la matriz.");
        dimension = sc.nextInt();
        unaMatriz = new int[dimension][dimension];
        //////////

        do {
            // Llama menú.
            switch (menu()) {
                case 1:
                    cargaMatriz(unaMatriz);
                    break;
                case 2:
                    imprimeMatriz(unaMatriz);
                    break;
                case 3:
                    imprimeDerechaIzq(unaMatriz);
                    break;
                case 4:
                    arribAbajo(unaMatriz);
                    break;
                case 5:
                    enEspiral(unaMatriz);
                    break;
                case 6:
                    enZigzag(unaMatriz);
                    break;
                case 7:
                    detenerse = true;
                    break;
                default:
                    System.out.println("Elección inválida. Intente de nuevo.");
                    break;
            }
        } while (!detenerse);
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

    public static short menu() {
        // Muestra el menú, retorna opción elegida.
        // decl
        short opcion = 0;
        Scanner sc = new Scanner(System.in);
        ///////////
        // Salida
        System.out.println("1. Cargar la matriz.\r\n2. Imprimir la matriz con normalidad.");
        System.out.println("3. Imprimir la matriz por filas de atrás hacia adelante.");
        System.out.println("4. Imprimir la matriz por columnas de arriba hacia abajo.");
        System.out.println("5. Imprimir la matriz en espiral.");
        System.out.println("6. Imprimir la matriz en zig-zag.");
        System.out.println("7. Terminar.");
        //////////
        opcion = sc.nextShort();
        return opcion;
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

    public static void imprimeDerechaIzq(int[][] matriz) {
        // Método que imprime la matriz por filas de atrás hacia adelante.
        for (int i = 0; i < matriz.length; i++) {
            for (int j = matriz[i].length - 1; j >= 0; j--) {
                System.out.print("|" + matriz[i][j]);
            }

        }
        System.out.println("|");
    }

    public static void arribAbajo(int[][] matriz) {
        // Imprime la matriz por columnas de arriba hacia abajo.

        for (int i = 0; i < matriz.length; i++) {
            for (int j = matriz[i].length - 1; j >= 0; j--) {
                System.out.print("|" + matriz[j][i]);
            }
        }
        System.out.println("|");
    }

    public static void enEspiral(int[][] matriz) {
        // Imprime la matriz en espiral.

        // Declaro límites del espiral.
        int inicioFilas = 0;
        int finalFilas = matriz.length - 1;
        int inicioColumnas = 0;
        int finalColumnas = matriz[0].length - 1;
        ////////////////////

        while (inicioFilas <= finalFilas && inicioColumnas <= finalColumnas) {
            // Itera en sentido horario.

            // Itera de izquierda a derecha.
            for (int i = inicioColumnas; i <= finalColumnas; i++) {
                System.out.print("|" + matriz[inicioFilas][i]);
            }
            inicioFilas++;

            // Itera de arriba a abajo.
            for (int i = inicioFilas; i <= finalFilas; i++) {
                System.out.print("|" + matriz[i][finalColumnas]);
            }
            finalColumnas--;

            // Itera de derecha a izquierda.
            if (inicioFilas <= finalFilas) {
                for (int i = finalColumnas; i >= inicioColumnas; i--) {
                    System.out.print("|" + matriz[finalFilas][i]);
                }
                finalFilas--;
            }

            // Itera de abajo a arriba.
            if (inicioColumnas <= finalColumnas) {
                for (int i = finalFilas; i >= inicioFilas; i--) {
                    System.out.print("|" + matriz[i][inicioColumnas]);
                }
                inicioColumnas++;
            }
        }
        System.out.println("|");
    }

    public static void enZigzag(int[][] matriz) {
        // Imprime la matriz en Zig Zag.

        // Decl
        int filas = matriz.length;
        int columnas = matriz[0].length;
        boolean sentidoIterador = true;
        ////////

        for (int i = 0; i < filas; i++) {
            if (sentidoIterador) {
                // Izquierda a derecha.
                for (int j = 0; j < columnas; j++) {
                    System.out.print("|" + matriz[i][j]);
                }
                sentidoIterador = false;
            } else {
                // Derecha a izquierda.
                for (int j = columnas - 1; j >= 0; j--) {
                    System.out.print("|" + matriz[i][j]);
                }
                sentidoIterador = true;
            }
        }
        System.out.println("|");
    }

}
