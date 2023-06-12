package TP3;

import java.util.Scanner;
import java.util.Random;

public class puntoSeis {
    public static void main(String[] args) {
        // Algoritmo que permite visuliazar la deuda de los 10 socios de un club.

        // Decl
        double[][] socios = new double[12][10];
        boolean detenerse = false;
        //////////////
        // Carga socios
        cargaMatriz(socios);
        // cargaMatrizRandom(socios);
        // imprimeMatriz(socios);

        do {
            switch (menu()) {
                case 1:
                    tresOMas(socios);
                    break;
                case 2:
                    noDeudas(socios);
                    break;
                case 3:
                    socioMayorDeuda(socios);
                    break;
                case 4:
                    mesMayorDeuda(socios);
                    break;
                case 5:
                    detenerse = true;
                    break;
                case 11:
                    imprimeMatriz(socios);
                    break;
                default:
                    System.out.println("Inválido. Intente de nuevo.");
                    break;
            }
        } while (!detenerse);

    }

    public static short menu() {
        // Muestra el menú

        // Decl
        short opcion = 0;
        Scanner sc = new Scanner(System.in);
        //////

        // Salida
        System.out.println("Ingrese un número para elegir: ");
        System.out.println("1.Listar por pantalla los socios que deben 3 o más meses.");
        System.out.println("2. Listar por pantalla los socios que no deben ningún mes.");
        System.out.println("3. Buscar el socio que acumula mayor deuda.");
        System.out.println("4. Mostrar en cual mes se registra la mayor deuda por parte de los socios.");
        System.out.println("5. Terminar");

        // Retorno
        opcion = sc.nextShort();
        return opcion;
    }

    public static void cargaMatriz(double[][] matriz) {
        // Carga una matriz desde sus columnas.
        Scanner sc = new Scanner(System.in);

        for (int j = 0; j < matriz[0].length; j++) {
            for (int i = 0; i < matriz.length; i++) {
                System.out.println("Ingrese el mes " + (i + 1) + " del socio " + (j + 1));
                matriz[i][j] = sc.nextDouble();
            }
        }
    }

    public static void cargaMatrizRandom(double[][] matriz) {
        // Carga una matriz desde sus columnas.
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        for (int j = 0; j < matriz[0].length; j++) {
            for (int i = 0; i < matriz.length; i++) {
                matriz[i][j] = rand.nextInt(100) + 0;
            }
        }
    }

    public static void imprimeMatriz(double[][] matriz) {
        // Método que imprime una matriz.

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print("|" + matriz[i][j]);
            }
            System.out.println("|");
        }
    }

    public static void tresOMas(double[][] matrix) {
        // Método que imprime qué columnas tienen 3 o más elementos mayor a cero.
        // Decl
        int aux = 0;
        for (int j = 0; j < matrix[0].length; j++) {
            aux = 0;
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[i][j] > 0) {
                    // Suma mes
                    aux++;
                }
            }
            if (aux >= 3) {
                // Encontró deudor
                System.out.println("El socio " + (j + 1) + " adeuda 3 o más meses.");
            }
        }
    }

    public static void noDeudas(double[][] matriz) {
        // Método que devuelve que columnas tiene todos sus elementos en cero.
        // Decl
        boolean deuda = false;
        ////////

        for (int j = 0; j < matriz[0].length; j++) {
            deuda = false;
            for (int i = 0; i < matriz.length; i++) {
                if (matriz[i][j] > 0) {
                    deuda = true;
                }
            }
            if (deuda == false) {
                System.out.println("El socio " + (j + 1) + " no tiene deudas para el club.");
            }
        }
    }

    public static void socioMayorDeuda(double[][] matriz) {
        // Devuelve cuál de las columnas de una matriz suma más entre sus elementos.
        // Decl
        double suma = 0, aux = 0;
        int deudor = 0;
        ////////////

        for (int j = 0; j < matriz[0].length; j++) {
            aux = 0;
            for (int i = 0; i < matriz.length; i++) {
                aux += matriz[i][j];
            }
            if (aux > suma) {
                suma = aux;
                deudor = j + 1;
            }
        }
        System.out.println("El socio que más debe es " + deudor + " con una deuda de " + suma);
    }

    public static void mesMayorDeuda(double[][] matriz) {
        // Devuelve la fila con la mayor suma entre sus elementos.
        // Decl
        double suma = 0, aux = 0;
        int mes = 0, i = 0, j = 0;
        ///////////

        for (i = 0; i < matriz.length; i++) {
            aux = 0;
            for (j = 0; j < matriz[0].length; j++) {
                aux += matriz[i][j];
            }
            if (aux > suma) {
                suma = aux;
                mes = i + 1;
            }
        }
        System.out.println("El mes con más deudas es el número " + mes);
    }
}
