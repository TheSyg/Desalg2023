package TPFinal;

import java.io.*;
import java.util.*;

public class escuela {

    public static void agrega_alumno(Alumno[] esc, Alumno al) {
        // Método que agrega al alumno en el arreglo de grado correspondiente
        int i = 0;
        boolean detenerse = false;

        while (!detenerse) {
            if (esc[i] == null) {
                esc[i] = al;
                detenerse = true;
            }
            i++;
        }

    }

    public static Alumno crea_alumno(String[] atributos) {
        // El orden tiene que ser el mismo del archivo.
        // Esto es: apellido, nombre, legajo, grado y promedio.
        String ap = atributos[0];
        String nom = atributos[1];
        int leg = Integer.parseInt(atributos[2]);
        int gr = Integer.parseInt(atributos[3]);
        double pr = Double.parseDouble(atributos[4]);

        return new Alumno(ap, nom, leg, gr, pr);
    }

    public static void lee_lista(String unaRaiz, Alumno[][] esc) {
        String linea = null;

        try (BufferedReader br = new BufferedReader(new FileReader(unaRaiz))) {
            while (br.readLine() != null) {
                linea = br.readLine();
                String[] atributos_temp = linea.split(";");
                Alumno alumno_temporal;

                // Chequea que efectivamente hayan cinco atributos.
                if (atributos_temp.length == 5) {
                    // El orden tiene que ser el mismo del archivo.
                    // Esto es: apellido, nombre, legajo, grado y promedio.
                    int checkGrado = Integer.parseInt(atributos_temp[3]);

                    // Check que el grado esté en el rango.
                    // Check que el legajo tenga 4 caracteres (o sea, tenga 4 digitos)
                    if (checkGrado >= 1 && checkGrado <= 7 && atributos_temp[2].length() == 4) {
                        alumno_temporal = crea_alumno(atributos_temp);
                        agrega_alumno(esc[alumno_temporal.getGrado() - 1], alumno_temporal);
                    } else {
                        System.out.println("Atributos inválidos.");
                    }
                    /////////////////////

                } else {
                    System.out.println("Número de atributos inválidos.");
                }
            }
        } catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage());
        } catch (IOException ex) {
            System.err.println("Error leyendo o escribiendo en algun archivo.");
        }
    }

    public static short menu() {
        // Menú principal

        short opcion = 0;
        Scanner sc = new Scanner(System.in);

        System.out.println("Menu de escuela\n\r----------");
        System.out.println("1. Pasar de Grado.");
        System.out.println("2. Calcular promedio del grado.");
        System.out.println("3. Listar alumnos de un grado por apellido y nombre de forma ascendente.");
        System.out.println("4. Mostrar promedio alumnos egresados por promedio de forma descendente.");
        System.out.println("5. Mostrar vacantes.\n\r6. Ubicar alumno.\n\r----------");
        System.out.println("Ingrese cualquier otro numero para salir.");

        opcion = sc.nextShort();

        return opcion;
    }

    public static void carga_lista(Alumno[][] esc) {
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

        lee_lista(raiz, esc);

    }

    public static void main(String[] args) {

        Alumno[][] escuela = new Alumno[30][7];

        carga_lista(escuela);

        switch (menu()) {
            case 1:
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
            default:
                break;
        }

    }
}
