package TP7;

public class puntoSeis {

    public static void ordInsercion(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int aux = arr[i];
            int j = i - 1;
            while ((j >= 0) && (arr[j] > aux)) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = aux;
        }
    }

    public static void main(String[] args) {
        int[] unArr = { 89, 45, 68, 90, 29, 34, 17 };
        ordInsercion(unArr);
        for (int i = 0; i < unArr.length; i++) {
            System.out.print("|" + unArr[i]);
        }
        System.out.println("|");
    }
}