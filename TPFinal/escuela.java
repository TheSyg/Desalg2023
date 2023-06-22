package TPFinal;

import java.io.*;
import java.util.*;

public class escuela {

    public static void leerLista(String unaRaiz) {
        String linea = null;

        try {

        } catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage() + "\nSignifica que el archivo del "
                    + "que queriamos leer no existe.");
        } catch (IOException ex) {
            System.err.println("Error leyendo o escribiendo en algun archivo.");
        }
    }

    public static short menu() {
        // Menú principal

        short opcion = 0;
        boolean stop = false;
        Scanner sc = new Scanner(System.in);

        System.out.println("Menu de escuela\n\r----------");
        System.out.println("1. Carga Alumno.\n\r2. Pasar de Grado.");
        System.out.println("3. Calcular promedio del grado.");
        System.out.println("4. Listar alumnos de un grado por apellido y nombre de forma ascendente.");
        System.out.println("5. Mostrar promedio alumnos egresados por promedio de forma descendente.");
        System.out.println("6. Mostrar vacantes.\n\r7. Ubicar alumno.\n\r----------");
        System.out.println("Ingrese cualquier otro numero para salir.");

        opcion = sc.nextShort();

        return opcion;
    }

    public static short cargarIngresante() {
        // Menu para carga de estudiantes.

        short opcion = 0;
        boolean stop = false;
        Scanner sc = new Scanner(System.in);

        System.out.println("1. Cargar estudiante individual.");
        System.out.println("2. Cargar desde archivo.");

        opcion = sc.nextShort();

        return opcion;
    }

    public static void cargaPorLista() {
        // Carga por lista
        String raiz = null;
        boolean stop = false;
        Scanner sc = new Scanner(System.in);
        char opcion = ' ';

        System.out.println("Desea usar el archivo de prueba? y/n");
        while (!stop) {
            opcion = sc.next().charAt(0);
            if (Character.toLowerCase(opcion) == 'y') {
                raiz = "D:/Desalg2023/TPFinal/ListaAlumnos.txt";
                stop = true;
            } else if (Character.toLowerCase(opcion) == 'n') {
                System.out.println("Ingrese una raiz nueva>");
                raiz = sc.nextLine();
                stop = true;
            } else {
                System.out.println("Error de ingreso.");
            }
        }

        leerLista(raiz);

    }

    public static void main(String[] args) {

        Alumno[][] escuela = new Alumno[30][7];

        switch (menu()) {
            case 1:
                boolean detenerse = false;
                while (!detenerse) {
                    if (cargarIngresante() == 1) {

                    } else if (cargarIngresante() == 2) {
                        cargaPorLista();
                    } else {
                        System.out.println("Opción errónea.");
                    }
                }
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            default:
                break;
        }

    }
}
