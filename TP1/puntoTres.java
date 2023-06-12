package TP1;

import java.util.Scanner;

public class puntoTres {
    public static void main(String[] args) {

        /*
         * El algoritmo lee enteros positivos hasta que
         * se ingrese uno negativo. Luego muestra
         * el entero más grande ingresado.
         */

        // Declaración
        int pares, masAlto, numero;
        Scanner sc = new Scanner(System.in);
        // Fin declaración
        // Inicialización
        pares = 0;
        masAlto = 0;
        numero = 0;
        // Fin inicialización

        do {
            System.out.println("Ingrese un entero: ");
            numero = sc.nextInt();
            if ((numero % 2) == 0) {
                pares++;
            }
            if (numero > masAlto) {
                masAlto = numero;
            }
        } while (numero >= 0);

        // Salida
        System.out.println("El número más alto ingresado fue: " + masAlto);
        System.out.println("La cantidad de números pares fue: " + pares);

    }
}
