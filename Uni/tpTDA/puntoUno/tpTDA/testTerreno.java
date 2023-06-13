import java.util.Scanner;
import clases.terreno;



public class testTerreno {
    public static void main(String[] args) {

        // Decl
        terreno terreno1, terreno2, terreno3;

        // Crea
        terreno1 = creaTerrenos();
        terreno2 = creaTerrCompleto();
        terreno3 = terreno1;

        // Prueba equals
        System.out.println("Compara t1 con t2: "+terreno1.equals(terreno2));
        System.out.println("Compara t1 y t2: "+ terreno1.equals(terreno1));
        System.out.println("Compara t3(t3=t1) con t1:"+terreno3.equals(terreno1));
        

        // Prueba observadores
        System.out.println("t1");
        testGetters(terreno1);
        System.out.println("t2:");
        testGetters(terreno2);
        System.out.println("t3(t3=t1):");
        testGetters(terreno3);
    }

    public static double verifDimension() {
        boolean detenerse = false;
        double num = 0;
        Scanner sc = new Scanner(System.in);
        do {
            num = sc.nextDouble();
            if (num > 0) {
                detenerse = true;
            } else {
                System.out.println("Ingreso inválido.");
            }
        } while (!detenerse);
        return num;
    }

    public static int verifValores() {
        boolean detenerse = false;
        int num = 0;
        Scanner sc = new Scanner(System.in);
        do {
            num = sc.nextInt();
            if (num > 0) {
                detenerse = true;
            } else {
                System.out.println("Ingreso inválido.");
            }
        } while (!detenerse);
        return num;
    }

    public static void testGetters(terreno unTerreno) {
        System.out.println("Altura: " + unTerreno.getAltura());

        System.out.println("Codigo: " + unTerreno.getCodigo());

        System.out.println("Base: " + unTerreno.getBase());

        System.out.println("Manzana: " + unTerreno.getManzana());

    }

    public static terreno creaTerrenos() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el código del terreno: ");
        terreno unTerreno = new terreno(verifValores());
        System.out.println("Ingrese la base del terreno: ");
        unTerreno.setBase(verifDimension());
        System.out.println("Ingrese la altura del terreno: ");
        unTerreno.setAltura(verifDimension());
        System.out.println("Ingrese la manzana donde está el terreno: ");
        unTerreno.setManzana(verifValores());
        System.out.println(unTerreno.toString());

        return unTerreno;
    }

    public static terreno creaTerrCompleto() {
        Scanner sc = new Scanner(System.in);
        double ba = 0, al = 0;
        int man = 0, cod = 0;
        System.out.println("Ingrese el código del terreno: ");
        cod = verifValores();
        System.out.println("Ingrese la base del terreno: ");
        ba = verifDimension();
        System.out.println("Ingrese la altura del terreno: ");
        al = verifDimension();
        System.out.println("Ingrese la manzana donde está el terreno: ");
        man = verifValores();
        terreno unTerreno = new terreno(cod, ba, al, man);
        System.out.println(unTerreno.toString());

        return unTerreno;
    }
}
