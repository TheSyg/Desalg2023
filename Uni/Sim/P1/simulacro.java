package P1;

import javax.swing.plaf.synth.Region;

public class simulacro {
    public static void main(String[] args) {

        // Temperaturas registradas.
        int[][] registro = { { 41, 42, 47, 25, 13, 8, 2, -1, 3, 16, 29, 40 },
                { 40, 41, 44, 21, 10, 1, -3, -7, 11, 18, 34, 38 },
                { 48, 46, 41, 36, 21, 9, 6, -2, 16, 15, 27, 42 } };

        // Decl
        double[] promedioAnual = new double[3];
        int mesMayorProm, mayorPromAnual; // Mes y año respectivamente
        boolean tempExt = false;

        // Imprime el registro
        imprMatriz(registro);

        // Punto 1, 1
        promedioMatriz(registro, promedioAnual);
        imprArr(promedioAnual);

        // Punto 1, 2
        mesMayorProm = mesMayorTemProm(registro);
        System.out.println("El mes con mayor promedio de temperatura fue: " + mesMayorProm);

        // Punto 1, 3
        mayorPromAnual = PromAnualMayor(registro);
        System.out.println("El año con mayor temp anual fue: " + mayorPromAnual);

        // Punto 1, 4
        tempExt = tempExtrema(registro);
        if (tempExt) {
            System.out.println("Si hubo temperaturas extremas.");
        } else {
            System.out.println("No hubo temperaturas extremas.");
        }

    }

    public static boolean tempExtrema(int[][] mat) {
        // Decl
        boolean resultado = false;
        int i = 0, j = 0;

        do {
            do {
                if (mat[i][j] < -10 && mat[i][j] > 44) {
                    resultado = true;
                }
            } while (j < 12 || !resultado);
        } while (!resultado || i < 3);
        return resultado;
    }

    public static int PromAnualMayor(int[][] mat) {
        // Retorna la fila con mayor promedio entre sus elementos
        // en una matriz de enteros.

        // Decl
        int mayorProm;
        double aux = 0, prom = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                aux += mat[i][j];
            }
            if (aux / 12 > prom) {
                mayorProm = i;
                prom = aux / 12;
            }
        }

        return mayorProm + 1;
    }

    public static int mesMayorTemProm(int[][] mat) {
        // Decl
        double aux = 0, prom = 0;
        int mes;

        for (int col = 0; col < mat[0].length; col++) {
            aux = 0; // Limpia auxiliar
            for (int fil = 0; fil < mat.length; fil++) {
                aux += mat[fil][col];
            }
            if (aux / 12 > prom) {
                mes = col;
                prom = aux / 12;
            }
        }

        return mes + 1;
    }

    public static void imprArr(double[] arr) {
        for (int j = 0; j < arr.length; j++) {
            System.out.println("|" + arr[j]);
        }
        System.out.println("|");
    }

    public static void imprMatriz(int[][] mat) {
        // Método que imprime una matriz.

        for (int i = 0; i < mat.length; i++) {
            imprArr(mat[i]);
        }
    }

    public static void promedioMatriz(int[][] mat, double[] arr) {
        // Método que calcula el promedio de los valores de las filas de una matriz
        // Y lo carga en un arreglo

        // Decl
        double aux = 0;

        for (int i = 0; i < mat.length; i++) {
            aux = 0;// limpia el auxiliar
            for (int j = 0; j < mat[0].length; j++) {
                aux += mat[i][j];
            }
            arr[i] = aux / 12;
        }
    }
}