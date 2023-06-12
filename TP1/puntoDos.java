package TP1;

import java.util.Scanner;

public class puntoDos {
    public static void main(String[] args) {
        // Algoritmo que lee un valor de tres cifras y lo invierte.
        int nuevoNum, numero;
        nuevoNum = 0;
        numero = verificador();
        do {
            nuevoNum = (nuevoNum * 10) + (numero % 10);
            numero = numero / 10;
        } while (numero > 0);

        if (nuevoNum < 10) {
            // En caso que el número ingresado sea 100, 200, 300,..., 900.
            System.out.println("El número invertido es " + 0 + 0 + nuevoNum);
        } else {
            System.out.println("El número invertido es " + nuevoNum);
        }
    }

    public static int verificador() {
        // Método que verifica que un número entero sea de 3 cifras
        boolean detenerse = false;
        Scanner sc = new Scanner(System.in);
        int num = 0;
        do {
            System.out.println("Ingrese un entero de tres cifras> ");
            num = sc.nextInt();
            if ((num > 99) && (num < 1000)) {
                detenerse = true;
            } else {
                System.out.println("Ingreso inválido. Intente de nuevo.");
            }
        } while (!detenerse);
        return num;
    }
}
