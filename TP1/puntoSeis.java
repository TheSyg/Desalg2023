package TP1;

import java.util.*;

public class puntoSeis {
    public static void main(String[] args) {
        // Algoritmo que lee una palabra y una frase y busca cuántas veces se repite la
        // palabra en la frase.

        // decl
        String palabra, frase;
        int longi = 0;
        int cantidad=0;
        Scanner sc = new Scanner(System.in);
        boolean detenerse = false;
        boolean coincidencia = false;

        System.out.println("Ingrese una frase. ");
        do {
            frase = sc.nextLine();
            detenerse = veriFrase(frase);
        } while (!detenerse);
        detenerse = false;

        System.out.println("Ingrese una palabra. ");

        do {
            palabra = sc.nextLine();
            detenerse = veriFrase(palabra);
        } while (!detenerse);

        frase = preparaFrase(frase);
        
        for (int i = 0; i < frase.length(); i++) {
            if (!(frase.charAt(i) == ' ')) {
                longi++;
            } else {

                if (palabra.equals(frase.substring((i - longi), i))) {
                    coincidencia = true;
                    cantidad++;
                }
                longi = 0;
            }
        }

        if (coincidencia) {
            System.out.println("La palabra se encuentra en la cadena, y aparece "+cantidad+" veces.");
        } else {
            System.out.println("La palabra no está en la cadena.");
        }

        // Con el método apropiado:

        coincidencia = false;
        cantidad=0;
        if (frase.indexOf(palabra) != -1) {
            coincidencia = true;
            cantidad++;
        }
        if (coincidencia) {
            System.out.println("La palabra se encuentra en la cadena, y aparece "+cantidad+" veces.");
        } else {
            System.out.println("La palabra no está en la cadena.");
        }

    }

    public static String preparaFrase(String frase) {
        // Método que hace legible la cadena para el algoritmo.

        // Reemplaza instancias donde hay más de un espacio por un espacio.
        frase = frase.trim().replaceAll(" +", " ");

        // Elimina espacios al final e inicio. Y agrega uno al comienzo.
        frase = frase.trim();
        frase = frase + ' ';
        return frase;
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
}
