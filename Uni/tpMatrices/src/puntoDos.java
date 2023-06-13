import java.util.Scanner;

public class puntoDos {

    public static void main(String[] args) {
        // Algoritmo que carga una matriz de caracteres y muestra su diagonal principal.

        Scanner sc = new Scanner(System.in);

        // Carga dimensiones.
        System.out.println("Ingrese la dimension de la matriz (nxn): ");
        int dimension = sc.nextInt();

        // Crea matriz.
        char[][] matriz = new char[dimension][dimension];

        // Carga
        cargaMatriz(matriz);

        // Salida
        System.out.print("La diagonal principal es ");
        imprimeDiagonal(matriz);
    }

    public static void cargaMatriz(char[][] matriz) {
        // Método que carga una matriz.
        Scanner sc = new Scanner(System.in);

        for (int fil = 0; fil < matriz.length; fil++) {
            for (int col = 0; col < matriz[0].length; col++) {
                System.out.println("Ingrese el elemento (" + (fil + 1) + "," + (col + 1) + ") de la matriz.");
                matriz[fil][col] = sc.next().charAt(0);
            }
        }
    }

    public static void imprimeDiagonal(char[][] matriz) {
        // Imprime la diagonal principal de una matriz.

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if (i == j) {
                    System.out.print("|" + matriz[i][j]);
                }
            }
        }
        System.out.println("|");

    }
}
