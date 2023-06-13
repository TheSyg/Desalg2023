
import java.util.*;
import java.lang.*;

public class puntoOcho {

    // main
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] palMasLarga;
        int dim, pos = 0;
        System.out.println("Ingrese la dimensión del arreglo> ");
        dim = sc.nextInt();
        palMasLarga = new String[dim];
        cargArr(palMasLarga);
        buscarMasLarga(palMasLarga);
        System.out.println("La palabra más larga es la de la posición " + (pos + 1) + ", que es " + palMasLarga[pos]);
    }

    // Método de carga de arreglo.
    public static void cargArr(String[] arreglo) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese las palabras a guardar en el arreglo.");
        for (int i = 0; i < arreglo.length; i++) {
            arreglo[i] = sc.next();
        }
    }
    // Método que busca el string con mayor longitud en un arreglo.

    public static int buscarMasLarga(String[] arreglo) {
        int longi = 0;
        int pos = 0;
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i].length() > longi) {
                longi = arreglo[i].length();
                pos = i;
            }
        }
        return pos;
    }
}
