package TP6;

public class puntoDieciocho {
    public static String explotar(int n, int b) {
        String n1 = "";
        String n2 = "";

        if (n <= b) {
            n1 = n1 + "|" + n;
        } else {
            n1 = explotar(n / b, b);
            n2 = explotar((n - (n / b)), b);
        }

        return n1 + n2;
    }

    public static void main(String[] args) {
        System.out.println(explotar(21, 3) + "|");
    }
}
