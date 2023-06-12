package TP6;

import java.util.Scanner;

public class puntoOcho {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String unString = " ";

        System.out.println("Ingrese un string para verificar si es capicua.");
        unString = sc.nextLine();

        boolean si = palindromo(unString.toLowerCase());
        System.out.println(si);

        // sexito
    }

    public static boolean palindromo(String elString) {
        boolean valido = false;

        if (elString.length() > 1) {
            if (elString.charAt(0) == elString.charAt(elString.length() - 1)) {
                valido = true;
            } else {
                valido = false;
            }
        }
        if (valido) {
            palindromo(elString.substring(1,elString.length()-1));
        }

        return valido;
    }
}
