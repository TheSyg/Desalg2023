import java.util.*;
import java.lang.*;

public class puntdiez {
    // main
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr1, arr2;
        int longi;
        System.out.println("Ingrese la longitud del arreglo> ");
        longi = sc.nextInt();
        arr1 = new int[longi];
        arr2 = new int[longi];
        cargArr(arr1);
        mostrArr(arr1);
        cargaInverso(arr1, arr2);
        System.out.println("Tras invertirlo, el nuevo arreglo es ");
        mostrArr(arr2);
    }

    // Mëtodo carga de arreglos.
    public static void cargArr(int[] array) {
        int valor;
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < array.length; i++) {
            System.out.println("Ingrese el valor del elemento " + (i + 1) + " del arreglo.");
            valor = sc.nextInt();
            array[i] = valor;
        }
    }

    // Método que muestra un arreglo.
    public static void mostrArr(int[] array) {
        System.out.println("Su arreglo es");
        System.out.print("|");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "|");
        }
        System.out.println();
    }

    // Método que carga al revés los valores de un arreglo en otro.
    public static void cargaInverso(int[] array1, int[] array2) {
        for (int i = 0; i < array2.length; i++) {
            array2[array2.length - 1 - i] = array1[i];
        }
    }
}