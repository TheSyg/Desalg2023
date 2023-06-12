package TP6;

public class puntoDoce {
    public static void main(String[] args) {

        char[] unArreglo = { '3', '4', '$', 'a', 'T', '5', '^' };
        char unChar = '3';
        boolean logico = false;
        logico = buscaChar(unArreglo, unChar, 0);
        System.out.println(logico);

    }

    public static boolean buscaChar(char[] arr, char car, int contador) {
        boolean verif = false;

        if (contador < arr.length) {
            // Caso base
            System.out.println(contador);
            if (car == arr[contador]) {
                // Si encontró
                verif = true;
            } else {
                // Si no encontró
                verif = buscaChar(arr, car, contador + 1);
            }
        } else {
            // Si se salió
            verif = false;
        }
        return verif;
    }

}
