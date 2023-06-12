package TP7;

public class puntoTres {

    public static void cambiazo(int[] arr, int p1, int p2) {
        int aux = arr[p1];
        arr[p1] = arr[p2];
        arr[p2] = aux;
    }

    public static int buscaPosMenor(int[] arr, int ini) {
        int posMenor = ini;
        int menor = arr[ini];

        for (int i = ini; i < arr.length; i++) {
            if (menor > arr[i]) {
                posMenor = i;
                menor = arr[i];
            }
        }

        return posMenor;
    }

    public static void ordSeleccion(int[] arr) {
        int posMenor = 0;
        for (int i = 0; i < arr.length; i++) {
            posMenor = buscaPosMenor(arr, i);
            cambiazo(arr, i, posMenor);
        }
    }

    public static void main(String[] args) {
        int[] unArr = { 7, 6, 11, 17, 3, 15, 5, 19, 30, 14 };
        ordSeleccion(unArr);
        for (int i = 0; i < unArr.length; i++) {
            System.out.print("|" + unArr[i]);
        }
        System.out.println("|");
    }
}