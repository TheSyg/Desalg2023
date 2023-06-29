package TPFinal;

import java.io.*;
import java.util.*;

public class escuela {

    public static void cambiazo(Alumno[] arr, int pos1, int pos2) {
        Alumno temp = arr[pos1];
        arr[pos1] = arr[pos2];
        arr[pos2] = temp;
    }

    public static void organiza_alfab_gr(Alumno[] arr) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i].getComparadorNombre().compareTo(arr[j].getComparadorNombre()) < 0) {
                    cambiazo(arr, i, j);
                }
            }
        }

    }

    public static void organiza_alfab(Alumno[][] esc) {
        for (int i = 0; i < esc.length; i++) {
            organiza_alfab_gr(esc[i]);
        }
    }

    public static void imprime_promedios(double[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Grado " + (i + 1) + ": " + arr[i]);
        }
    }

    public static double obtiene_promedio_grado(Alumno[] gr, int contador) {
        double total = 0;
        if (contador < gr.length && gr[contador] != null) {
            total += gr[contador].getPromedioGral() + obtiene_promedio_grado(gr, contador + 1);
        }

        return total / (contador - 1);
    }

    public static void calcula_promedios_rec(Alumno[][] esc, double[] arr, int fil) {

        if (fil < esc.length) {
            arr[fil] = obtiene_promedio_grado(esc[fil], 0);
            calcula_promedios_rec(esc, arr, fil + 1);
        }

    }

    public static void elimina_null(Alumno[] arr) {
        int j = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null) {
                // Encontró no nulo.
                arr[j] = arr[i]; // Guarda en la posición más cercana al inicio posible.
                j++;
            }
        }

        while (j < arr.length) {
            // Cualquier elemento después de j se hace nulo.

            arr[j] = null;
            j++;
        }
    }

    public static void imprime_alumnos(Alumno[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            int j = 0;
            System.out.println("Alumnos del grado " + (i + 1) + ": ");
            while (arr[i][j] != null && j < arr[0].length) {
                System.out.println(arr[i][j].toString());
            }
        }
    }

    public static void agrega_alumno(Alumno[] esc, Alumno al) {
        // Método que agrega al alumno en el arreglo de grado correspondiente
        int i = 0;
        boolean detenerse = false;

        while (!detenerse && i < esc.length) {
            if (esc[i] == null) {
                esc[i] = al;
                detenerse = true;
                System.out.println("Alumno cargado.");
            }
            i++;
            if (i > esc.length) {
                System.out.println("Error, no hay vacantes en el grado.");
            }
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

    public static void pasar(Alumno[][] esc, List<Alumno> egr) {
        for (int i = esc.length; i >= 1; i--) {
            int j = 0; // Reset.
            while (esc[i][j] != null && j < esc[0].length) {

                // Check nota.
                if (esc[i][j].getPromedioGral() >= 6.0) {
                    // Check sólo si está en el último grado.
                    if (i == esc.length) {
                        // Se agrega a la lista de egresados.
                        egr.add(esc[i][j]);
                        esc[i][j] = null;
                    } else {
                        // No está en el último grado.
                        esc[i][j].setGrado(i + 1);
                        agrega_alumno(esc[i + 1], esc[i][j]);
                        esc[i][j] = null;
                    }
                }
                j++;
            }
            elimina_null(esc[i]);
        }
    }

    public static void main(String[] args) {

        Alumno[][] escuela = new Alumno[7][30];
        double[] promedios = new double[7];
        List<Alumno> egresadosLista = new ArrayList<>();

        carga_lista(escuela);

        switch (menu()) {
            case 1:
                pasar(escuela, egresadosLista);
                break;
            case 2:
                calcula_promedios_rec(escuela, promedios, 0);
                imprime_promedios(promedios);
                break;
            case 3:
                organiza_alfab(escuela);
                imprime_alumnos(escuela);
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
