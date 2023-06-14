package TP6;

public class puntoNueve {

    public static int division(int dividendo, int divisor) {
        int resultado = 0;
        System.out.println(dividendo);
        if (dividendo >= divisor) {
            resultado = 1 + division(dividendo - divisor, divisor);
        }

        return resultado;
    }

    public static void main(String[] args) {
        int cociente = division(23, 7);
        System.out.println(cociente);
    }
}
