package TP1;

import java.util.Scanner;

public class puntoCuatro {
    public static void main(String[] args) {
        // Algoritmo que lee una frase y elige la palabra más larga.

        // Declaración
        boolean detenerse = false;
        Scanner sc = new Scanner(System.in);
        String frase;
        int largo = 0;
        int aux = 0;
        int indFinal = 0;
        int indInicial = 0;
        // Fin declaración

        System.out.println("Ingrese una frase.");

        // Verificación.
        do {
            frase = sc.nextLine();
            detenerse = veriFrase(frase);
        } while (!detenerse);

        // Acomoda la cadena para ser legible por el algoritmo.
        frase = preparaFrase(frase);

        // Encuentra el índice final de la palabra más larga.
        for (int i = 0; i < frase.length(); i++) {
            if (!(frase.charAt(i) == ' ')) {
                aux++;
            } else {
                if (aux > largo) {
                    largo = aux;
                    indFinal = i;
                }
                aux = 0;
            }
        }

        // Encuentra el índice inicial de la palabra más larga.
        indInicial = indFinal - largo;

        // Out
        System.out.println(frase.substring(indInicial, indFinal));

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
