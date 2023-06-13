import java.util.*;
import java.lang.*;

public class puntoDoce {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int orden = 0;
        int fila = 0;
        int pos = 0;
        int[][] matriz;
        System.out.println("Ingrese el orden de la matriz.");
        orden = sc.nextInt();
        matriz = new int[orden][orden];
        cargMat(matriz);
        System.out.println("Su matriz es: ");
        muestraMatriz(matriz);
        System.out.println("--------------");
        for (int i = 0; i < orden; i++) {
            pos = buscaDiagonal(matriz, fila);
            System.out.println(pos);
            reorganiza(matriz, pos, fila);
            reempCero(matriz, fila);
            fila++;
            muestraMatriz(matriz);
            System.out.println("--------------");
            
        }

    }

    public static void muestraMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                System.out.print("|"+matriz[i][j]);
            }
            System.out.println();
        }
    }

    public static void cargMat(int[][] array) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.println("Ingrese el elemento " + i + "," + j + " de la matriz.");
                array[i][j] = sc.nextInt();
            }
        }
    }

    public static int buscaDiagonal(int[][] array, int fila) {
        int check = 0;
        int pos = 0;
        for (int i = 0; i < array[fila].length; i++) {
            if (array[i][fila] > check) {
                check = array[0][i];
                pos = i;
            }
        }
        return pos;
    }

    public static void reorganiza(int[][] array, int pos, int fila) {
        int[] reemplaza;
        reemplaza = array[fila];
        array[pos] = array[fila];
        array[fila] = reemplaza;
    }

    public static void reempCero(int[][] array, int fila) {
        for (int i = fila + 1; i < array[fila].length; i++) {
            array[fila][i] = 0;
        }
    }
}
