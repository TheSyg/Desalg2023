package TP7;

public class puntoCuatro {

    public static void ordBurbuja(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j+1]) {
                    cambiazo(arr, j+1, j);
                }
            }
        }
    }

    public static void cambiazo(int[] arr, int p1, int p2) {
        int aux = arr[p1];
        arr[p1] = arr[p2];
        arr[p2] = aux;
    }

    public static void main(String[] args) {
        int[] unArr = { 89, 45, 68, 90, 29, 34, 17 };
        ordBurbuja(unArr);
        for (int i = 0; i < unArr.length; i++) {
            System.out.print("|" + unArr[i]);
        }
        System.out.println("|");
    }
}
