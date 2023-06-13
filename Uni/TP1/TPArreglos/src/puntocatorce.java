import java.util.*;
import java.lang.*;

public class puntocatorce {
    // main
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arr1, arrPar, arrImpar;
        System.out.println("Ingrese la longitud del arreglo: ");
        arr1 = new String[sc.nextInt()];
        cargArr(arr1);
        mostrArr(arr1);
        arrPar = new String[cuentaPares(arr1)];
        arrImpar = new String[arr1.length - arrPar.length];
        cargaPares(arr1, arrPar);
        System.out.println("Los elementos pares son:");
        mostrArr(arrPar);
        cargaImpar(arr1, arrImpar);
        System.out.println("Los elementos impares son: ");
        mostrArr(arrImpar);

    }

    // Método que carga los valores impares de un arreglo a otro.
    public static void cargaImpar(String[] array, String[] arrImpar) {
        int cuentaImpar = 0;
        for (int i = 0; i < array.length; i++) {
            if (i % 2 != 0) {
                arrImpar[cuentaImpar] = array[i];
                cuentaImpar++;
            }
        }
    }

    // Método que carga los valores pares de un arreglo en otro.
    public static void cargaPares(String[] array, String[] arrPar) {
        int cuentaPar = 0;
        for (int i = 0; i < array.length; i++) {
            if (i % 2 == 0) {
                arrPar[cuentaPar] = array[i];
                cuentaPar++;
            }
        }
    }

    // Método que cuenta los valores pares de un arreglo.
    public static int cuentaPares(String[] array) {
        int pares = 0;
        for (int i = 0; i < array.length; i++) {
            if (i % 2 == 0) {
                pares++;
            }
        }
        System.out.println(pares);
        return pares;
    }

    // Método que muestra un arreglo.
    public static void mostrArr(String[] array) {
        System.out.println("Su arreglo es");
        System.out.print("|");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "|");
        }
        System.out.println();
    }

    // Método carga de arreglos.
    public static void cargArr(String[] array) {
        String valor;
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < array.length; i++) {
            System.out.println("Ingrese el valor del elemento " + (i + 1) + " del arreglo.");
            valor = sc.next();
            array[i] = valor;
        }
    }
}
