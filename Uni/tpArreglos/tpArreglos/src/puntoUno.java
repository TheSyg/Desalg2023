import java.util.*;

public class puntoUno {
    public static void main(String[] args) {
        /*
         * Algoritmo que carga un arreglo de caracteres
         * con longitud n, y luego permite al usuario
         * imprimirlo derecho o al revés.
         */

        // decl
        char[] arrChar;
        Scanner sc = new Scanner(System.in);
        int largo = 0;
        short opcion;
        boolean stop = false;
        // fin decl

        // Longitud
        System.out.println("Ingrese la longitud del arreglo.");
        largo = sc.nextInt();
        arrChar = new char[largo];
        /////////

        // Menú
        do {
            opcion = menu(arrChar);
            switch (opcion) {
                case 1:
                    cargArr(arrChar);
                    break;
                case 2:
                    mostrArr(arrChar);
                    break;
                case 3:
                    arrInvertido(arrChar);
                    break;
                case 4:
                    stop = true;
                    break;
                default:
                    System.out.println("Opción inválida.");
                    break;
            }
        } while (!stop);
        ///////////
    }

    public static short menu(char[] arreglo) {
        // Menú

        // decl
        short opcion = 0;
        Scanner sc = new Scanner(System.in);
        // fin decl

        // Salida
        System.out.println("Elija una opción: ");
        System.out.println("1. Cargar el arreglo.");
        System.out.println("2. Imprimir el arreglo derecho.");
        System.out.println("3. Imprimir el arreglo al revés.");
        System.out.println("4. Terminar.");
        //////
        opcion = sc.nextShort();

        return opcion;
    }

    public static void cargArr(char[] arreglo) {
        // Carga un arreglo unidimensional.
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < arreglo.length; i++) {
            System.out.println("Ingrese el elemento " + (i + 1) + " del arreglo.");
            arreglo[i] = sc.next().charAt(0);
        }

    }

    public static void mostrArr(char[] arreglo) {
        // Imprime un arreglo unidimensional.
        for (int i = 0; i < arreglo.length; i++) {
            System.out.print("|" + arreglo[i]);
        }
        System.out.println("|");

    }

    public static void arrInvertido(char[] arreglo) {
        // Imprime un arreglo unidimensional, pero al revés.
        for (int i = 0; i < arreglo.length; i++) {
            System.out.print("|" + arreglo[arreglo.length - 1 - i]);
        }
        System.out.println("|");

    }
}
