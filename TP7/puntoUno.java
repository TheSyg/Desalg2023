package TP7;

public class puntoUno {

    public static boolean busquedaLineal(int[] arr, int pos, int inc) {
        /*
         * Prueba de busqueda lineal
         * Punto 1, TP7
         */

        boolean busq = false;
        System.out.println(pos);
        if (pos < arr.length) { // CB
            if (inc != arr[pos]) {
                // No encontró
                busq = busquedaLineal(arr, pos + 1, inc); // PR
            } else {
                // Encontró
                busq = true;
            }
        }

        return busq;
    }

    public static boolean busqLinInv(int[] arr, int pos, int inc) {
        /*
         * Variante de busqueda lineal
         * Punto 1, TP7
         */

        boolean busq = false;
        System.out.println(pos);
        if (pos >= 0) {
            // CB
            if (arr[pos] != inc) {
                // No encontró
                busq = busqLinInv(arr, pos - 1, inc); // PR
            } else {
                // Encontró
                busq = true;
            }
        }

        return busq;
    }

    public static void main(String[] args) {
        int[] unArr = { 1, 2, 3, 4, 0, 7, 22, 6 };
        boolean enc = busquedaLineal(unArr, 0, 8); // Lineal convencional
        System.out.println(enc);
        enc = busqLinInv(unArr, unArr.length - 1, 3); // Lineal invertido
        System.out.println(enc);
    }
}
