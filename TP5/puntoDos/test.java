package TP5.puntoDos;

import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        // Algoritmo que representa una manzana de terrenos.

        // Decl
        terreno[] terrenos = new terreno[3];
        propietario[] props = new propietario[3];
        double base, altura;
        int codigo, manzana, dni, contador = 0;
        String nom, ap, mail, fono;
        int selec = 0;
        char gen;
        boolean stop = false, stop1 = false;
        Scanner sc = new Scanner(System.in);

        // Carga

        for (int i = 0; i < terrenos.length; i++) {
            // Limpia variables
            stop1 = false;
            base = 0;
            altura = 0;
            codigo = 0;
            manzana = 0;
            //
            System.out.println("Ingrese la base del terreno " + (i + 1) + ": ");
            base = veriDouble(); // Base
            System.out.println("Ingrese la altura del terreno " + (i + 1) + ": ");
            altura = veriDouble(); // Altura
            System.out.println("Ingrese el código del terreno " + (i + 1) + ": ");
            System.out.println("Recuerde que debe ser un código de 3 cifras.");
            codigo = veriCodigo(); // Codigo
            System.out.println("Ingrese el número de la manzana del terreno " + (i + 1) + ": ");
            System.out.println("Recuerde que debe ser un número no mayor a 100.");
            manzana = veriManzana(); // Manzana
            if (props[0] == null) {
                System.out.println("No hay propietarios cargados.");
                System.out.println("Ingrese DNI del propietario: ");
                dni = veriDNI();
                System.out.println("Ingrese nombre del propietario: ");
                nom = veriNombre();
                System.out.println("Ingrese el apellido: ");
                ap = veriNombre();
                System.out.println("Ingrese el género (M/F): ");
                gen = veriGen();
                props[contador] = new propietario(dni, nom, ap, gen);
                // Mail
                mail = validaMail();
                props[contador].setMail(mail);
                // Fono
                fono = veriFono();
                props[contador].setTelefono(fono);
                // Out
                System.out.println("Cargó: ");
                System.out.println(props[contador].toString());
                terrenos[i] = new terreno(codigo, base, altura, manzana, props[contador]);
                contador++; // Contador de arreglo de props.
            } else {
                do {
                    switch (menu()) {
                        case 1:
                            if (contador < props.length) {
                                nuevoProp(props, contador);
                                contador++;
                            } else {
                                System.out.println("Se llegó al límite de propietarios.");
                            }
                            break;
                        case 2:
                            System.out.println("Elija un número.");
                            selec = elecProp(props);
                            terrenos[i] = new terreno(codigo, base, altura, manzana, props[selec]);
                            stop1 = true;
                            break;
                        default:
                            System.out.println("Ingreso inválido. Intente de nuevo.");
                            break;
                    }
                } while (!stop1);
            }

        }

        do {
            switch (menuCargado()) {
                case 1:
                    listaProps(props);
                    break;
                case 2:
                    listaTerr(terrenos);
                    break;
                case 3:
                    porProps(terrenos, props);
                    break;
                case 4:
                    stop = true;
                    break;
                default:
                    System.out.println("Elección inválida.");
                    break;
            }
        } while (!stop);

    }

    public static void porProps(terreno[] arr, propietario[] arr1) {
        // Decl
        int cargador = 0, i = 0;
        boolean stop = false;
        terreno[] imprimir = new terreno[arr.length];

        // Carga los distintos propietarios.
        do {
            // Limpia variables
            for (int j = 0; j < imprimir.length; j++) {
                imprimir[j] = null;
            }
            cargador = 0;
            //////////////////

            if (arr1[i] == null || i >= arr1.length) {
                stop = true;
            } else {
                // Carga arreglo a imprimir
                for (int j = 0; j < arr.length; j++) {
                    if (arr[j].getPropietario() == arr1[i]) {
                        imprimir[cargador] = arr[j];
                        cargador++;
                    }
                }
                // Salida de arreglo a imprimir
                System.out.println("Terrenos del propietario: " + arr1[i].toString());
                for (int k = 0; k < imprimir.length; k++) {
                    if (imprimir[k] != null) {
                        System.out.println(imprimir[k].toString());
                    }
                }
            }
            i++;
        } while (!stop);
    }

    public static void listaProps(propietario[] arr) {
        // Decl
        int i = 0;
        boolean stop = false;

        do {
            if (arr[i] == null || i >= arr.length) {
                stop = true;
            } else {
                System.out.println((i + 1) + ". " + arr[i].toString());
            }
            i++;
        } while (!stop);
    }

    public static void listaTerr(terreno[] arr) {
        // Decl
        int i = 0;
        boolean stop = false;

        do {
            if (i >= arr.length || arr[i] == null) {
                stop = true;
            } else {
                System.out.println((i + 1) + ". " + arr[i].toString());
            }
            i++;
        } while (!stop);
    }

    public static short menuCargado() {
        // Decl
        short elec = 0;
        Scanner sc = new Scanner(System.in);
        /////////////

        System.out.println("Elija un número:\n\r1. Listar propietarios.");
        System.out.println("2. Listar Terrenos.\n\r3. Listar Terrenos por propietario.");
        System.out.println("4. Para terminar.");

        elec = sc.nextShort();
        return elec;
    }

    public static int elecProp(propietario[] arr) {
        // Decl
        int sel = 0, i = 0;
        boolean stop = false;
        Scanner sc = new Scanner(System.in);

        do {
            if (arr[i] == null || i >= arr.length) {
                stop = true;
            } else {
                System.out.println((i + 1) + ". " + arr[i].toString());
            }
            i++;
        } while (!stop);
        sel = sc.nextInt();
        return sel;
    }

    public static void nuevoProp(propietario[] props, int cuenta) {
        // Decl
        int dni = 0;
        char gen;
        String ap, nom, mail, fono;
        Scanner sc = new Scanner(System.in);
        ////////

        // DNI
        System.out.println("Ingrese DNI del propietario: ");
        dni = veriDNI();
        // Nombre y apellido.
        System.out.println("Ingrese nombre del propietario: ");
        nom = veriNombre();
        System.out.println("Ingrese el apellido: ");
        ap = veriNombre();
        // Género
        System.out.println("Ingrese el género (M/F): ");
        gen = veriGen();
        props[cuenta] = new propietario(dni, nom, ap, gen);
        System.out.println("Ingrese el mail: ");
        mail = validaMail();
        props[cuenta].setMail(mail);
        fono = veriFono();
        props[cuenta].setTelefono(fono);
        System.out.println("Cargó: ");
        System.out.println(props[cuenta].toString());
    }

    public static short menu() {
        // Decl
        short el = 0;
        Scanner sc = new Scanner(System.in);

        // Menu
        System.out.println("Ingrese una opción: ");
        System.out.println("1. Cargar un dueño nuevo.\n\r2. Elegir un dueño previo.");
        //
        el = sc.nextShort();

        return el;
    }

    public static String veriFono() {
        // Decl
        String tlf;
        int i = 0;
        char cr;
        boolean stop = false, cifras = true;
        Scanner sc = new Scanner(System.in);
        //////////////

        System.out.println("Ingrese el número telefónico: ");
        do {
            tlf = sc.nextLine();
            // Check que tenga 10 cifras.
            if (tlf.length() == 10) {
                do {
                    cr = tlf.charAt(i);
                    if (!((cr >= '0') && (cr <= '9'))) {
                        i = tlf.length() + 1;
                        cifras = false;
                    }
                    i++;
                } while (i < tlf.length());
                if (cifras) {
                    if (tlf.charAt(0) != '0') {
                        stop = true;
                    } else {
                        System.out.println("El primer dígito no puede ser cero.");
                        System.out.println("Reintente.");
                    }
                } else {
                    System.out.println("El número sólo puede contener cifras numéricas.");
                }
            } else {
                System.out.println("Ingreso inválido. Debe tener 10 digitos.");
                System.out.println("Intente de nuevo.");
            }

        } while (!stop);

        return tlf;
    }

    public static String validaMail() {
        // Decl
        String email;
        Scanner sc = new Scanner(System.in);
        boolean stop = false;
        //////////
        System.out.println("Ingrese la dirección de mail: ");
        do {
            email = sc.nextLine();
            // Check si está vacío.
            if (email == null || email.isEmpty()) {
                System.out.println("");
            } else {

                // Check que sólo haya un @.
                int atIndex = email.indexOf('@');
                if (atIndex == -1 || atIndex != email.lastIndexOf('@')) {
                    System.out.println("Ingreso en blanco. Intente de nuevo.");
                } else {
                    // Check que el @ no al inicio ni final.
                    if (atIndex == 0 || atIndex == email.length() - 1) {
                        System.out.println("@ en posición inválida. Intente de nuevo.");
                    } else {

                        // Check que haya algo antes del @.
                        if (atIndex == 1 && email.charAt(0) == '.' ||
                                atIndex == email.length() - 2 && email.charAt(email.length() - 1) == '.') {
                            System.out.println("Ingreso inválido.");
                            System.out.println("Intente de nuevo.");
                        } else {

                            // Check que haya un punto en algún lugar.
                            int dotIndex = email.indexOf('.', atIndex);
                            if (dotIndex == -1 || dotIndex == atIndex + 1 || dotIndex == email.length() - 1) {
                                System.out.println("Ingreso inválido, no hay dominio.");
                                System.out.println("Intente de nuevo.");
                            } else {
                                stop = true;
                            }
                        }
                    }
                }
            }
        } while (!stop);

        return email;
    }

    public static char veriGen() {
        // Decl
        char gen;
        Scanner sc = new Scanner(System.in);
        boolean stop = false;

        do {
            gen = sc.next().charAt(0);
            if (gen == 'M' || gen == 'm' || gen == 'f' || gen == 'F') {
                stop = true;
            } else {
                System.out.println("Ingreso inválido.");
            }
        } while (!stop);

        return gen;
    }

    public static String veriNombre() {
        // Decl
        String str;
        int i = 0;
        char unChar;
        Scanner sc = new Scanner(System.in);
        boolean stop = false, detenerse = false;
        do {
            str = sc.nextLine();
            i = 0;
            do {
                unChar = str.charAt(i);
                if (!(((unChar >= 'a') && (unChar <= 'z')) || ((unChar >= 'A') && (unChar <= 'Z')))) {
                    System.out.println("Nombre inválido. Sólo puede contener letras.");
                    detenerse = true;
                } else {
                    i++;
                }
                if (i >= str.length()) {
                    stop = true;
                    detenerse = true;
                }
            } while (!detenerse);
        } while (!stop);
        return str;
    }

    public static int veriDNI() {
        // Decl
        Scanner sc = new Scanner(System.in);
        int dni;
        boolean stop = false;
        do {
            dni = sc.nextInt();
            if ((dni > 999999) && (dni < 100000000)) {
                stop = true;
            } else {
                System.out.println("Ingreso inválido. El dni debe tener 7 u 8 cifras.");
            }
        } while (!stop);
        return dni;

    }

    public static int veriManzana() {
        // Decl
        int verif = 0;
        boolean stop = false;
        Scanner sc = new Scanner(System.in);

        // Verifica
        do {
            verif = sc.nextInt();
            if ((verif > 0) && (verif < 100)) {
                stop = true;
            } else {
                System.out.println("Ingreso inválido. Intente de nuevo.");
            }
        } while (!stop);

        return verif;
    }

    public static int veriCodigo() {
        // Decl
        int verif = 0;
        boolean stop = false;
        Scanner sc = new Scanner(System.in);

        // Verifica
        do {
            verif = sc.nextInt();
            if (((verif > 99) && (verif < 1000))) {
                stop = true;
            } else {
                System.out.println("Ingreso inválido. Intente de nuevo.");
            }
        } while (!stop);

        return verif;
    }

    public static double veriDouble() {
        // Decl
        double verif = 0;
        boolean stop = false;
        Scanner sc = new Scanner(System.in);

        // Verifica
        do {
            verif = sc.nextDouble();
            if (((verif > 0) && (verif < 100))) {
                stop = true;
            } else {
                System.out.println("Ingreso inválido. Intente de nuevo.");
            }
        } while (!stop);

        return verif;
    }
}
