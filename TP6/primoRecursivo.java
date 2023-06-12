package TP6;

public class primoRecursivo {
    public static boolean primoRec(int num, int div) {
        boolean verif = false;

        if ((num == 1 || num == 2 || num == 3)) {
            verif = true;
        } else if (div > 1) { // CB
            if (num % div == 0) {
                verif = false;
            } else {
                // PR
                verif = primoRec(num, div - 1);
            }
        } else {
            verif = true;
        }

        return verif;
    }

    public static void main(String[] args) {

        int unNum = 37;
        System.out.println(primoRec(unNum, unNum - 1));

    }
}
