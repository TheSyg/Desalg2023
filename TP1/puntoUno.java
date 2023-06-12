package TP1;
import java.util.Scanner;

public class puntoUno {
    public static void main(String[] args) {
        // Algoritmo que lee un entero y muestra sus primeros 10 múltiplos
        Scanner sc = new Scanner(System.in);
        int multiplo;
        System.out.println("Ingrese un valor entero: ");
        multiplo = sc.nextInt();
        System.out.println("Los múltipos de " +multiplo+" son: ");
        for (int i = 0; i < 10; i++) {

            System.out.println((i+1)*multiplo);
        }
    }
}