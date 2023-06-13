
import java.util.Scanner;
import java.lang.*;

public class puntoOnce {

    // main
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr1, arr2;
        boolean seguir;
        int longi = 0;
        System.out.println("El algoritmo compara dos arreglos para verificar que son iguales.");
        System.out.println("Ingrese la longitud del primer arreglo> ");
        longi = sc.nextInt();
        arr1 = new int[longi];
        cargArr(arr1);
        System.out.println("Ingrese la longitud del segundo arreglo> ");
        longi = sc.nextInt();
        arr2 = new int[longi];
        cargArr(arr2);
        seguir = comparaLength(arr1, arr2);
        if (seguir) {
            seguir = comparaContenido(arr1, arr2);
            if (seguir) {
                System.out.println("Los arreglos son iguales.");
            } else {
                System.out.println("Los arreglos tienen distintas variables, no son iguales.");
            }
        } else {
            System.out.println("Los arreglos tienen distinta longitud, no son iguales.");
        }
    }

    // Método para comparar longitud de dos arreglos.
    public static boolean comparaLength(int[] array1, int[] array2) {
        boolean comp = false; // comparador
        if (array1.length == array2.length) {
            comp = true;
        }
        return comp;
    }

    // Método que compara las variables de dos arreglos con misma longitud.
    public static boolean comparaContenido(int[] array1, int[] array2) {
        boolean comp = false; // Comparador
        for (int i = 0; i < array2.length; i++) {
            if (array1[i] == array2[i]) {
                comp = true;
            } else {
                comp = false;
                i = array1.length; // Corte for
            }
        }
        return comp;
    }

    // Metodo para cargar el arreglo
    public static void cargArr(int[] arreglo) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese los numeros a guardar en el arreglo.");
        for (int i = 0; i < arreglo.length; i++) {
            arreglo[i] = sc.nextInt();
        }
    }
}
