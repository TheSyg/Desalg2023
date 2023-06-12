package TP4.puntoDoce;

import java.util.Scanner;

public class testPedido {
    public static void main(String[] args) {
        // Decl
        Scanner sc = new Scanner(System.in);
        Pedido unPedido;
        short llave = 0;
        boolean detenerse = false;
        int tlfn = 0, altura = 0, codPed = 0, codProd = 0, cuenta = 0;
        String nom, dir, desc;

        // Creación
        System.out.println("Ingrese el código del pedido: ");
        codPed = sc.nextInt();
        unPedido = new Pedido(codPed);
        System.out.println("Desc. del pedido> ");
        desc = sc.next();
        unPedido.setDescripcion(desc);

        // Carga datos cliente
        System.out.println("Ingrese el nombre del cliente: ");
        nom = sc.next();
        unPedido.setNombreCliente(nom); // Nombre
        System.out.println("Ingrese el telefono del cliente: ");
        tlfn = sc.nextInt();
        unPedido.setTelefono(tlfn); // Telefono
        System.out.println("Ingrese la calle del domicilio del cliente: ");
        dir = sc.next();
        System.out.println("Altura de la calle: ");
        altura = sc.nextInt();
        unPedido.setDireccion(dir, altura); // Direccion

        // Test datos
        System.out.println(unPedido.toString());

        // Carga pedido

        do {
            System.out.println("Ingrese el código del pedido: ");
            llave = menu();
            switch (llave) {
                case 1:
                    // Milanesa de pollo
                    codProd = llave;
                    unPedido.cargaProductos(codProd);
                    cuenta++;
                    if (cuenta >= 10) {
                        detenerse = true;
                    }
                    break;
                case 2:
                    // Milanesa de carne
                    codProd = llave;
                    unPedido.cargaProductos(codProd);
                    cuenta++;
                    if (cuenta >= 10) {
                        detenerse = true;
                    }
                    break;
                case 3:
                    // Arroz
                    codProd = llave;
                    unPedido.cargaProductos(codProd);
                    cuenta++;
                    if (cuenta >= 10) {
                        detenerse = true;
                    }
                    break;
                case 4:
                    // Ensalada rusa
                    codProd = llave;
                    unPedido.cargaProductos(codProd);
                    cuenta++;
                    if (cuenta >= 10) {
                        detenerse = true;
                    }
                    break;
                case 5:
                    // Carne al horno
                    codProd = llave;
                    unPedido.cargaProductos(codProd);
                    cuenta++;
                    if (cuenta >= 10) {
                        detenerse = true;
                    }
                    break;
                case 6:
                    // Pollo al horno
                    codProd = llave;
                    unPedido.cargaProductos(codProd);
                    cuenta++;
                    if (cuenta >= 10) {
                        detenerse = true;
                    }
                    break;
                case 7:
                    // Pescado frito
                    codProd = llave;
                    unPedido.cargaProductos(codProd);
                    cuenta++;
                    if (cuenta >= 10) {
                        detenerse = true;
                    }
                    break;
                case 8:
                    // Filón de pan
                    codProd = llave;
                    unPedido.cargaProductos(codProd);
                    cuenta++;
                    if (cuenta >= 10) {
                        detenerse = true;
                    }
                    break;
                case 9:
                    // Ensalada Cesar
                    codProd = llave;
                    unPedido.cargaProductos(codProd);
                    cuenta++;
                    if (cuenta >= 10) {
                        detenerse = true;
                    }
                    break;
                case 10:
                    // Empanada de carne
                    codProd = llave;
                    unPedido.cargaProductos(codProd);
                    cuenta++;
                    if (cuenta >= 10) {
                        detenerse = true;
                    }
                    break;
                case 0:
                    detenerse = true;
                    break;
                default:
                    System.out.println("Ingreso inválido.");
                    break;
            }
        } while (!detenerse);

        // Test
        unPedido.listaProductos();
    }

    public static short menu() {
        // Decl
        short elec = 0;
        Scanner sc = new Scanner(System.in);

        // Muestra menú
        System.out.println("1. Mila de Pollo.\n\r2. Mila de Carne.\n\r3. Arroz.");
        System.out.println("4. Ensalada Rusa.\n\r5. Carne al horno.\n\r6. Pollo al horno.");
        System.out.println("7. Pescado frito.\n\r8. Filón de pan.\n\r9. Ensalada Cesar.");
        System.out.println("10. Empanada de carne. \n\rIngrese 0 para terminar.");

        elec = sc.nextShort();
        return elec;
    }
}
