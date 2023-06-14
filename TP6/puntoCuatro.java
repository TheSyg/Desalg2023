package TP6;

public class puntoCuatro {

    public static int primerDig(int num) {
        int primDig = 0;
        while (num > 0) {
            primDig = num % 10;
            num = num / 10;
        }

        return primDig;
    }

    public static boolean numerosIguales(int num) {
        boolean check = false;
        if (num > 10) {
            System.out.println(num);
            if (primerDig(num) == num % 10) {
                // PR si el primer y último dígito son iguales.
                check = numerosIguales(num / 10);
            } else {
                // No son iguales. Retorna falso.
                check = false;
            }

        } else {
            // Si no entró es porque todos fueron iguales.
            check = true;
        }
        return check;
    }

    public static void main(String[] args) {
        System.out.println(numerosIguales(33333333));
    }
}