package TPArreglo.src;

import java.util.Scanner;
//Autor: Nicola Lamontanara

public class puntocinco {
    public static void main(String[] args) {
        // Main
        /*
         * Algoritmo que saca el promedio de los elementos de un arreglo entero.
         */
        Scanner sc = new Scanner(System.in);
        int[] arr;
        System.out.print("Longitud del arreglo> ");
        arr = new int[sc.nextInt()];
        System.out.println();
        cargArr(arr);
        System.out.println("El arreglo ingresado es: ");
        mostrArr(arr);
        double promedio = promediArr(arr);
        System.out.println("El promedio del arreglo es: " + promedio);
    }

    public static void mostrArr(int[] array) {
        // Método que muestra los el arreglo en pantalla.
        for (int i = 0; i < array.length; i++) {

            System.out.print("|" + array[i]);
        }
        System.out.println("|");
    }

    public static void cargArr(int[] array) {
        // Método que carga datos de un arreglo.
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < array.length; i++) {
            System.out.println("Ingrese el elemento " + i + " del arreglo.");
            array[i] = sc.nextInt(); // Carga

        }
    }

    public static double promediArr(int[] array) {
        // El método promedia los elementos de un arreglo de enteros.
        double prom = 0; // Entero a usar para calcular el promedio.
        for (int i = 0; i < array.length; i++) {
            prom += array[i];
        }
        prom = prom / array.length;
        return prom;

    }
}
