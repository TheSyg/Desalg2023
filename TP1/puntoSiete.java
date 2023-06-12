package TP1;

import java.util.*;

public class puntoSiete {
    public static void main(String[] args) {
        /*
         * Algoritmo que lee N cantidad de palabras
         * y muestra capicúas, palabras con más de dos vocales
         * la palabra más larga.
         */

        // Decl
        int aux = 0;
        int cantPal = 0;
        int mas2Vocales = 0;
        int largo = 0;
        int indFinal = 0;
        int capicuas = 0;
        Scanner sc = new Scanner(System.in);
        boolean detenerse = false;
        String palab;
        String palabras = "";
        // Fin decl

        System.out.println("Ingrese la cantidad de palabras: ");
        cantPal = sc.nextInt();

        // Carga palabras
        System.out.println("Ingrese las palabras: ");
        for (int i = 0; i < cantPal; i++) {
            do {
                palab = sc.nextLine();
                detenerse = veriFrase(palab);
            } while (!detenerse);
            detenerse = false;
            palabras = palabras + palab.trim() + ' ';
        }
        System.out.println("Palabras cargadas: " + palabras);

        palabras = preparaFrase(palabras);

        // Verifica los enunciados.
        for (int i = 0; i < palabras.length(); i++) {
            if (!(palabras.charAt(i) == ' ')) {
                aux++;
            } else {
                // Capicuas.
                if (palabraCapicua(palabras.substring((i - aux), i))) {
                    capicuas++;
                }
                // 2 vocales o más.
                if (dosVocales(palabras.substring((i - aux), i))) {
                    mas2Vocales++;
                }
                // Palabra más larga
                if (aux > largo) {
                    largo = aux;
                    indFinal = i;
                }
                aux = 0;
            }
        }
        System.out.println("Hay " + capicuas + " palabras capicuas en las palabras cargadas.");
        System.out.println("Hay " + mas2Vocales + " palabras con más de dos vocales.");
        System.out.println("La palabra más larga es: " + palabras.substring(indFinal - largo, indFinal));
    }

    public static boolean palabraCapicua(String palab) {
        // Método que verifica si una cadena es capicúa.
        palab = palab.trim();
        boolean check = false;
        for (int i = 0; i < palab.length(); i++) {
            if (palab.charAt(i) == palab.charAt(palab.length() - 1 - i)) {
                check = true;
            } else {
                check = false;
            }
        }
        if (check) {
            System.out.println("La palabra " + palab + " es capicúa.");
        }
        return check;
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
            }
        }

        // Lanza error.
        if (!soloLetras) {
            System.out.println("Ingreso inválido. Intente de nuevo.");
        }
        return soloLetras;
    }

    public static boolean dosVocales(String palab) {
        // Método que verifica si la palabra tiene dos o más vocales.
        boolean check = false;
        palab = palab.toLowerCase();
        char ch;
        int contador = 0;
        for (int i = 0; i < palab.length(); i++) {
            ch = palab.charAt(i);
            if ((ch == 'a') || (ch == 'e') || (ch == 'i') || (ch == 'o') || (ch == 'u')) {
                contador++;
            }
        }
        if (contador > 2) {
            check = true;
        }
        return check;
    }
}
