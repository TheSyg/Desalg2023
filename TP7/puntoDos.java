package TP7;

public class puntoDos {

    public static boolean busqBinaria(int[] arr, int ini, int fin, int obj) {
        boolean busq = false;
        int med = (ini + fin) / 2; // Centro
        if (ini <= fin && fin >= 1) {
            // Chequea que se mantenga dentro del arreglo.
            if (arr[med] == obj) {
                // Encontró
                busq = true;
            } else {
                // No encontró y aún queda por iterar.
                if (arr[med] > obj) {
                    // Si es más pequeño, entonces está en el subarreglo izquierdo.
                    busq = busqBinaria(arr, ini, med - 1, obj);
                } else {
                    // Si es mayor, entonces está en el subarreglo derecho.
                    busq = busqBinaria(arr, med + 1, fin, obj);
                }
            }
        }

        return busq;
    }

    public static void main(String[] args) {
        int[] unArr = { 2, 4, 6, 8, 10, 12, 14, 16, 18, 20 };
        boolean a = busqBinaria(unArr, 0, unArr.length - 1, 8);
        System.out.println(a);
    }
}
