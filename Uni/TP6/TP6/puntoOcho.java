package TP6;

import java.util.Scanner;

public class puntoOcho {

    public static boolean palindromoRec(String cadena) {
        boolean verif = false;

        if (cadena.length() > 1) {
            if (cadena.charAt(0) == cadena.charAt(cadena.length() - 1)) {
                verif = palindromoRec(cadena.substring(1, cadena.length() - 1));
            } else {
                verif = false;
            }
        } else {
            verif = true;
        }

        return verif;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String unString = " ";

        System.out.println("Ingrese un string para verificar si es capicua.");
        unString = sc.nextLine().trim();

        boolean si = palindromoRec(unString.toLowerCase());
        System.out.println(si);

    }

}
