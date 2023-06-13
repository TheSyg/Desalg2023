import java.lang.*;
import java.util.*;

public class puntodoce {
    // main
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int longi;
        char[] arr1, arr2;
        System.out.println("Escriba la longitud del arreglo: ");
        longi = sc.nextInt();
        arr1 = new char[longi];
        arr2 = new char[longi];
        cargArr(arr1);
        mostrArr(arr1);
        copiArr(arr1, arr2);
        System.out.println("Después de copiarse, el arreglo 2 es: ");
        mostrArr(arr2);
    }

    // Mëtodo carga de arreglos.
    public static void cargArr(char[] array) {
        char valor;
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < array.length; i++) {
            System.out.println("Ingrese el valor del elemento " + (i + 1) + " del arreglo.");
            valor = sc.next().charAt(0);
            array[i] = valor;
        }
    }

    // Método que copia dos arreglos.
    public static void copiArr(char[] array1, char[] array2) {
        for (int i = 0; i < array2.length; i++) {
            array2[i] = array1[i];
        }
    }

    // Método que muestra un arreglo.
    public static void mostrArr(char[] arr1) {
        System.out.println("Su arreglo es");
        System.out.print("|");
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i] + "|");
        }
        System.out.println();
    }
}
