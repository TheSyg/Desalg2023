package TP6;

public class puntoCinco {

    public static int cuentaMulTresArr(int[] arr, int contador) {
        int aux = 0;

        if (contador < arr.length && arr[contador] != 0) {

            if (arr[contador] % 3 == 0) {
                aux += 1 + cuentaMulTresArr(arr, contador + 1);
            } else {
                aux += cuentaMulTresArr(arr, contador + 1);
            }
        }

        return aux;
    }

    public static int cuentaMulTresInt(int num) {
        int aux = 0;

        if (num / 10 > 0 && num % 10 != 0) {
            if ((num % 10) % 3 == 0) {
                aux += 1 + cuentaMulTresInt(num / 10);
            } else {
                aux += cuentaMulTresInt(num / 10);
            }
        }

        return aux;
    }

    public static void main(String[] args) {
        int[] prueba = { 3, 6, 0, 1, 33, 7 };
        int otraPrueba = 765432;
        System.out.println(cuentaMulTresArr(prueba, 0));
        System.out.println(cuentaMulTresInt(otraPrueba));

    }
}
