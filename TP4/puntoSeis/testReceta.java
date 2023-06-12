package TP4.puntoSeis;

import java.util.Scanner;

public class testReceta {
    public static void main(String[] args) {
        // Decl
        Scanner sc = new Scanner(System.in);
        int i = 0;
        boolean verifCarga = false;
        Receta unaReceta;
        String nombreRec, nombreIng;
        int cant = 0, ingCant = 0;
        ////

        System.out.println("Ingrese el nombre de la receta: ");
        nombreRec = sc.nextLine();
        System.out.println("Ingrese el número de ingredientes:");
        cant = sc.nextInt();

        // Creación
        unaReceta = new Receta(nombreRec, cant);

        do {
            // Limpia los valores
            ingCant = 0;
            nombreIng = " ";

            // Nombre
            System.out.println("Ingrese el nombre del ingrediente " + (i + 1) + ": ");
            nombreIng = sc.next();

            // Ingrediente
            System.out.println("Ingrese la cantidad del ingrediente " + (i + 1) + ": ");
            ingCant = sc.nextInt();

            // Agrega ingrediente en la receta
            verifCarga = unaReceta.cargaIngrediente(nombreIng, ingCant);
            if (verifCarga) {
                // Nombre correcto y valor no negativo.
                System.out.println("Cargó " + unaReceta.getIngredientes()[i].toString());
                i++;
            } else {
                // Caso excepcional
                System.out.println("Ingrediente inválido. Intente de nuevo.");
            }

        } while (i < cant);

        System.out.println("Para preparar " + unaReceta.getNombre() + " se necesita: ");
        for (int j = 0; j < cant; j++) {
            System.out.println(unaReceta.getIngredientes()[j].toString());
        }

    }
}
