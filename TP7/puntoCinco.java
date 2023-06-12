package TP7;

public class puntoCinco {

    public static void ordBurbujaMejorado(int[] arr) {
        boolean ordenado = false;
        int i = 0;
        while ((!ordenado) && (i < arr.length)) {
            ordenado = true;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    ordenado = false;
                    cambiazo(arr, j + 1, j);
                }
            }
            i++;
        }
    }

    public static void cambiazo(int[] arr, int p1, int p2) {
        int aux = arr[p1];
        arr[p1] = arr[p2];
        arr[p2] = aux;
    }

    public static void main(String[] args) {
        int[] unArr = { 89, 45, 68, 90, 29, 34, 17 };
        ordBurbujaMejorado(unArr);
        for (int i = 0; i < unArr.length; i++) {
            System.out.print("|" + unArr[i]);
        }
        System.out.println("|");
    }
}
