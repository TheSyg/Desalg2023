package TPAdicional;

import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        // Main
        Auto[] concesionaria = new Auto[5];
        String color, marca, mod;
        boolean caja;
        int fabric, dni;
        double capacidad, recorrido;
        String nombre;

        for (int i = 0; i < concesionaria.length; i++) {
            System.out.println("Ingrese la marca del auto n" + (i + 1) + ": ");
            System.out.println("Ingrese P para peugeot, T para toyota o F para ford.");
            marca = veriCargaMarca();
            System.out.println("Ingrese el modelo: ");
            System.out.println(modelos(marca));
            mod

        }

    }

    public static String modelos(String str) {
        String anunciador;
        switch (str) {
            case "Peugeot":
                anunciador = "1. Peugeot 308.\n\r2. Peugeot 408.\n\r3. Peugeot 306.";
                break;
            case "Ford":
                anunciador = "1. Ford Ranger.\n\r2. Ford KA.\n\r3. Ford Fiesta.";
                break;
            case "Toyota":
                anunciador = "1. Toyota Corolla.\n\r2. Toyota Hilux.\n\r3. Toyota Etios.";
                break;
            default:
                break;
        }
    }

    public static String veriCargaMarca() {
        // Recibe un caracter, verifica que el caracter corresponda
        // retorna un string con la marca.

        // Decl
        Scanner sc = new Scanner(System.in);
        String marca = " ";
        char inicial = ' ';
        boolean stop = false;

        do {
            inicial = sc.next().charAt(0);
            inicial = Character.toLowerCase(inicial);
            switch (inicial) {
                case 'p':
                    stop = true;
                    marca = "Peugeot";
                    break;
                case 't':
                    stop = true;
                    marca = "Toyota";
                    break;
                case 'f':
                    stop = true;
                    marca = "Ford";
                default:
                    System.out.println("Ingreso inválido. Reintente.");
                    break;
            }
        } while (!stop);

        return marca;
    }
}
