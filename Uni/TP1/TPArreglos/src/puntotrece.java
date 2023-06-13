import java.util.*;
import java.lang.*;

public class puntotrece {
    // main
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] arr1, arrVocales;
        int longi;
        System.out.println("Ingrese la longitud del arreglo a extraerle las vocales: ");
        longi = sc.nextInt();
        arr1 = new char[longi];
        cargArr(arr1);
        mostrArr(arr1);
        arrVocales = new char[cuentaVocales(arr1)];
        cargaVocales(arr1, arrVocales);
        System.out.println("Las vocales de su arreglo son: ");
        mostrArr(arrVocales);
    }

    // Método que carga las vocales de un arreglo de caracteres en otro.
    public static void cargaVocales(char[] array1, char[] array2) {
        int contador = 0; // Contador de iteraciones para el arreglo de vocales.
        for (int j = 0; j < array1.length; j++) {
            switch (Character.toLowerCase(array1[j])) {
                case 'a':
                    array2[contador] = array1[j];
                    contador++;
                    break;
                case 'e':
                    array2[contador] = array1[j];
                    contador++;
                    break;
                case 'i':
                    array2[contador] = array1[j];
                    contador++;
                    break;
                case 'o':
                    array2[contador] = array1[j];
                    contador++;
                    break;
                case 'u':
                    array2[contador] = array1[j];
                    contador++;
                    break;
                default:
                    break;
            }

        }
    }

    // Método que cuenta las vocales en un arreglo de caracteres
    public static int cuentaVocales(char[] array) {
        int cantVocales = 0;
        for (int i = 0; i < array.length; i++) {
            switch (Character.toLowerCase(array[i])) {
                case 'a':
                    cantVocales++;
                    break;
                case 'e':
                    cantVocales++;
                    break;
                case 'i':
                    cantVocales++;
                    break;
                case 'o':
                    cantVocales++;
                    break;
                case 'u':
                    cantVocales++;
                    break;
                default:
                    break;
            }
        }
        return cantVocales;
    }

    // Método que muestra un arreglo.
    public static void mostrArr(char[] array) {
        System.out.println("Su arreglo es");
        System.out.print("|");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "|");
        }
        System.out.println();
    }

    // Método carga de arreglos.
    public static void cargArr(char[] array) {
        char valor;
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < array.length; i++) {
            System.out.println("Ingrese el valor del elemento " + (i + 1) + " del arreglo.");
            valor = sc.next().charAt(0);
            array[i] = valor;
        }
    }
}
