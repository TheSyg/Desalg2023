package TP4.puntoDiez;

import java.util.Scanner;

public class testProducto {
    public static void main(String[] args) {
        // Decl
        int codigo = 0, cantInv = 0;
        String desc = " ";
        boolean detenerse = false;
        Producto[] inventario;
        Scanner sc = new Scanner(System.in);
        ///////

        // Creación del inventario
        System.out.println("Ingrese la cantidad de productos en el inventario: ");
        cantInv = sc.nextInt();
        inventario = new Producto[cantInv];

        // Carga
        for (int i = 0; i < cantInv; i++) {
            // Limpia los valores
            desc = " ";
            codigo = 0;

            // Obtiene datos para crear la clase.
            System.out.println("Ingrese el código del producto " + (i + 1) + ": ");
            codigo = sc.nextInt();
            System.out.println("Ingrese la descripción del producto: ");
            desc = sc.next();

            // Carga datos en la clase.
            inventario[i] = new Producto(codigo);
            inventario[i].setDescripcion(desc);
        }

        // Menú
        do {
            switch (menu()) {
                case 1:
                    agregaPrecio(inventario);
                    break;
                case 2:
                    agregaStock(inventario);
                    break;
                case 3:
                    restaStock(inventario);
                    break;
                case 4:
                    calcPrecio(inventario);
                    break;
                case 5:
                    listaInv(inventario);
                    break;
                case 6:
                    detenerse = true;
                    break;
                default:
                    System.out.println("Ingreso inválido. Intente de nuevo.");
                    break;
            }
        } while (!detenerse);

    }

    public static void listaInv(Producto[] arreglo) {
        for (int i = 0; i < arreglo.length; i++) {
            System.out.print((i + 1) + ". \n\r" + arreglo[i].toString());
        }
    }

    public static void calcPrecio(Producto[] arreglo) {
        // Decl
        boolean detenerse = false;
        short sel = 0;
        int i;
        double cant = 0;
        Scanner sc = new Scanner(System.in);
        /////////

        System.out.println("De cuál producto quiere ingresar el stock?");
        for (i = 0; i < arreglo.length; i++) {
            System.out.print((i + 1) + ". \n\r" + arreglo[i].toString());
        }
        do {
            sel = sc.nextShort();
            if (sel > 0 && sel < arreglo.length + 1) {
                detenerse = true;
                System.out.println("Ingrese la cantidad a calcular el precio: ");
                cant = sc.nextDouble();
                System.out.println("El precio es: " + arreglo[sel - 1].calcularPrecio(cant));
            } else {
                System.out.println("Ingreso inválido.");
            }
        } while (!detenerse);
    }

    public static void restaStock(Producto[] arreglo) {
        // Decl
        boolean detenerse = false;
        short sel = 0;
        int i;
        double cant = 0;
        Scanner sc = new Scanner(System.in);
        /////////

        System.out.println("De cuál producto quiere restar del stock?");
        for (i = 0; i < arreglo.length; i++) {
            System.out.print((i + 1) + ". \n\r" + arreglo[i].toString());
        }
        do {
            sel = sc.nextShort();
            if (sel > 0 && sel < arreglo.length + 1) {
                detenerse = true;
                System.out.println("Ingrese la cantidad a restar del stock: ");
                cant = sc.nextDouble();
                arreglo[sel - 1].restarStock(cant);
            } else {
                System.out.println("Ingreso inválido.");
            }
        } while (!detenerse);
    }

    public static void agregaStock(Producto[] arreglo) {
        // Decl
        boolean detenerse = false;
        short sel = 0;
        int i;
        double stock = 0;
        Scanner sc = new Scanner(System.in);
        /////////

        System.out.println("De cuál producto quiere ingresar el stock?");
        for (i = 0; i < arreglo.length; i++) {
            System.out.print((i + 1) + ". \n\r" + arreglo[i].toString());
        }
        do {
            sel = sc.nextShort();
            if (sel > 0 && sel < arreglo.length + 1) {
                detenerse = true;
                System.out.println("Ingrese el nuevo stock: ");
                stock = sc.nextDouble();
                arreglo[sel - 1].setStock(stock);
            } else {
                System.out.println("Ingreso inválido.");
            }
        } while (!detenerse);
    }

    public static void agregaPrecio(Producto[] arreglo) {
        // Decl
        boolean detenerse = false;
        short sel = 0;
        int i;
        double precio = 0;
        Scanner sc = new Scanner(System.in);
        /////////

        System.out.println("De cuál producto quiere ingresar el precio?");
        for (i = 0; i < arreglo.length; i++) {
            System.out.print((i + 1) + ". \n\r" + arreglo[i].toString());
        }
        do {
            sel = sc.nextShort();
            if (sel > 0 && sel < arreglo.length + 1) {
                detenerse = true;
                System.out.println("Ingrese el nuevo precio: ");
                precio = sc.nextDouble();
                arreglo[sel - 1].setPrecio(precio);
            } else {
                System.out.println("Ingreso inválido.");
            }
        } while (!detenerse);
    }

    public static short menu() {
        // Decl
        Scanner sc = new Scanner(System.in);
        short eleccion = 0;
        //////////////

        System.out.println("Elija un número: ");
        System.out.println("1. Agregar precio.\n\r2. Agregar stock.\n\r3. Restar Stock.");
        System.out.println("4. Calcular precio.\n\r5. Listar.");
        System.out.println("6. Terminar.");
        eleccion = sc.nextShort();

        return eleccion;
    }
}
