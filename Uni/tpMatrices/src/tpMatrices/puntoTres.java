package tpMatrices;

import java.util.*;

public class puntoTres {
    public static void main(String[] args) {
        /*
         * Carga oraciones en una matriz.
         */

        // Decl
        String[][] unaMatriz;
        Scanner sc = new Scanner(System.in);
        int palabras = 0, contador = 0;
        boolean detenerse = false;
        /////////////////

        System.out.println("Ingrese la cantidad de palabras por oracion: ");
        palabras = sc.nextInt();

        // Crea matriz
        unaMatriz = new String[99][palabras];

        // Itera verificando y cargando.
        do {
            switch (menu()) {
                case 1:
                    cargaString(unaMatriz, contador, palabras);
                    contador++;
                    break;
                case 2:
                    imprimeMatriz(unaMatriz);
                    break;
                case 3:
                    detenerse = true;
                    break;
                default:
                    System.out.println("Ingrese inválido. Intente de nuevo.");
                    break;
            }
        } while (!detenerse);

    }

    public static void cargaString(String[][] matriz, int fila, int cantPalabras) {
        // Lee una cadena ingresada, verifica y carga en una fila x.

        // Decl
        Scanner sc = new Scanner(System.in);
        boolean detenerse = false;
        String unaCadena;

        do {
            // Lee una oración.
            System.out.println("Ingrese la oración a cargar: ");
            unaCadena = sc.nextLine();
            unaCadena = unaCadena.trim().replaceAll(" +", " ");
            // Verifica
            if (verificaCadena(unaCadena, cantPalabras)) {
                // Carga
                matriz[fila] = unaCadena.split(" ");
                detenerse = true;
            } else {
                // Caso excepcional.
                System.out.println("Ingreso inválido.");
            }
        } while (!detenerse);

    }

    public static boolean verificaCadena(String cadena, int n) {
        // verifica que una cadena tenga n palabras.

        // Decl
        boolean check = false;
        int aux = 0;
        cadena = cadena.replace("+ ", " ") + " ";

        // Verifica que no contenga algo que no sea letras.
        for (int i = 0; i < cadena.length(); i++) {
            if (!((cadena.charAt(i) == ' ') || (cadena.charAt(i) >= 'a' && cadena.charAt(i) <= 'z')
                    || (cadena.charAt(i) >= 'A' && cadena.charAt(i) <= 'Z'))) {
                check = false;
            } else {
                check = true;
            }
        }

        if (check) {
            // Verifica que tenga n palabras.
            for (int i = 0; i < cadena.length(); i++) {
                if (cadena.charAt(i) == ' ') {
                    aux++;
                }
            }
            if (aux == n) {
                check = true;
            } else {
                check = false;
            }
        }

        return check;
    }

    public static short menu() {
        // Menú

        // Decl
        short opcion = 0;
        Scanner sc = new Scanner(System.in);

        // Out
        System.out.println("Ingrese un número para elegir:");
        System.out.println("1. Cargar una oracion\n\r2. Imprimir matriz\n\r3. Terminar.");

        // Retorno
        opcion = sc.nextShort();
        return opcion;
    }

    public static void imprimeMatriz(String[][] matriz) {
        // Imprime una matriz.

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if (matriz[i][j] != null) {
                    System.out.print("|" + matriz[i][j]);
                } else {
                    i = matriz.length;
                    j = matriz[0].length;
                }
            }
            System.out.println("|");
        }

    }
}
