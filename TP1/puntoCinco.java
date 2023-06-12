package TP1;

import java.util.*;

public class puntoCinco {
    public static void main(String[] args) {

        /*
         * Algoritmo que lee una frase y un caracter
         * Y verifica que el caracter esté en la frase
         */

        // Decl
        Scanner sc = new Scanner(System.in);
        boolean detenerse = false;
        boolean esCar = false;
        char unCar;
        String unaFrase;
        // Fin decl
        System.out.println("Ingrese una frase: ");

        // Verificación frase.
        do {
            unaFrase = sc.nextLine();
            detenerse = veriFrase(unaFrase);
        } while (!detenerse);

        detenerse = false;
        System.out.println("Ingrese una letra: ");

        // Verif caracter
        do {
            unCar = sc.next().charAt(0);
            detenerse = verifCar(unCar);
        } while (!detenerse);

        // Busco caracter
        esCar = buscaCarac(unaFrase, unCar);

        // Salida
        if (esCar) {
            System.out.println("El carácter se encuentra en la frase.");
        } else {
            System.out.println("El carácter no se encuentra en la frase.");
        }
        
        // Con método string
        if (unaFrase.indexOf(unCar) == -1) {
            System.out.println("El carácter no se encuentra en la frase.");
        } else {
            System.out.println("El carácter se encuentra en la frase.");
        }
    }

    public static boolean verifCar(char car) {
        // Método que verifica que un caracter sea una letra.

        // Decl
        boolean esCar = false;
        // Fin decl
        if ((car >= 'a' && car <= 'z') || (car >= 'A' && car <= 'Z')) {
            esCar = true;
        }

        return esCar;
    }

    public static boolean veriFrase(String frase) {
        // Verifica que la frase esté compuesta sólo por letras y espacios en blanco

        // Declaración
        boolean soloLetras = true;
        char ch;
        // Fin Declaración

        if ((frase == "") || (frase == null)) {
            // Verifica que no esté vacío.
            soloLetras = false;
            System.out.println("La cadena está vacía. Intente de nuevo.");
        } else {
            // Verifica que sólo contenga espacios y letras.
            for (int j = 0; j < frase.length(); j++) {
                ch = frase.charAt(j);
                if (!(ch >= 'a' && ch <= 'z') && !(ch >= 'A' && ch <= 'Z') && !(ch == ' ')) {
                    soloLetras = false;
                }
                /*
                 * if (!(ch >= 'A' && ch <= 'Z')) {
                 * soloLetras = false;
                 * }
                 * if (!(ch == ' ')) {
                 * soloLetras = false;
                 * }
                 */
            }
        }

        // Lanza error.
        if (!soloLetras) {
            System.out.println("Ingreso inválido. Intente de nuevo.");
        }
        return soloLetras;
    }

    public static boolean buscaCarac(String frase, char ch) {
        // Método que itera en una frase y busca si el caracter ch se encuentra ahí.

        // decl
        boolean esCar = false;

        for (int i = 0; i < frase.length(); i++) {
            if (ch == frase.charAt(i)) {
                esCar = true;
            }
        }

        return esCar;
    }
}
