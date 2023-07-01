package TPFinal;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class pruebaTiempo {

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

    public static void cambiazo(Alumno[] arr, int pos1, int pos2) {
        Alumno temp = arr[pos1];
        arr[pos1] = arr[pos2];
        arr[pos2] = temp;
    }

    public static void imprime_egresados(Alumno[] egr) {
        System.out.println("-----\n\rEgresados\n\r-----");
        for (int i = 0; i < egr.length; i++) {
            System.out.println(egr[i].toString());
        }
    }

    public static void arreglo_egresados(Alumno[] egr, List<Alumno> listaEgr) {

        for (int i = 0; i < egr.length; i++) {
            egr[i] = listaEgr.get(i);
        }

    }

    public static void pasar(Alumno[][] esc, List<Alumno> egr) {
        for (int i = esc.length - 1; i >= 1; i--) {
            int j = 0; // Reset.
            while (esc[i][j] != null && j < esc[0].length) {

                // Check nota.
                if (esc[i][j].getPromedioGral() >= 6.0) {
                    // Check sólo si está en el último grado.
                    if (i == esc.length - 1) {
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
            elimina_null(esc[i]); // Limpia espacios nulos entre alumnos.
        }
    }

    public static void unir(Alumno[] egr, int izq, int centro, int der) {

        // Indice que se usan para organizar los subarreglos.
        int i = 0, j = 0;

        // Longitudes de los arreglos a unirse.
        int long1 = centro - izq + 1;
        int long2 = der - centro;

        // Arreglos a unirse
        Alumno[] arr_izq = new Alumno[long1];
        Alumno[] arr_der = new Alumno[long2];

        // Carga a los arreglos.
        for (int k = 0; k < arr_izq.length; k++) {
            // izq es el inicio del superarreglo egr y el inicio del subarreglo izquierdo.
            arr_izq[k] = egr[izq + k];
        }

        for (int k = 0; k < arr_der.length; k++) {
            // centro es el centro del superarreglo egr y el inicio del subarreglo derecho.
            arr_der[k] = egr[centro + k + 1];
        }

        int k = izq; // Indice inicial del nuevo arreglo.

        // Inicio organización.
        while (i < long1 && j < long2) {
            // Compara ambas notas, elige la más alta como elemento del subarreglo.
            if (arr_izq[i].getPromedioGral() <= arr_der[j].getPromedioGral()) {
                egr[k] = arr_der[j];
                j++;
            } else {
                egr[k] = arr_izq[i];
                i++;
            }
            k++;
        }

        // Elementos restantes
        while (i < long1) {
            egr[k] = arr_izq[i];
            i++;
            k++;
        }
        while (j < long2) {
            egr[k] = arr_der[j];
            j++;
            k++;
        }

    }

    public static void ord_promedio_mergesort(Alumno[] egr, int izq, int der) {

        // Caso Base
        if (izq < der) {

            // Busca centro.
            int centro = (izq + der) / 2;

            // PR
            ord_promedio_mergesort(egr, izq, centro);
            ord_promedio_mergesort(egr, centro + 1, der);

            // Reune los subarreglos (merge)

            unir(egr, izq, centro, der);

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

        Alumno aux = new Alumno(ap, nom, leg, gr, pr);

        return aux;
    }

    public static void lee_lista(String unaRaiz, Alumno[][] esc) {

        try (BufferedReader br = new BufferedReader(new FileReader(unaRaiz))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] atributos_temp = linea.split(";");
                Alumno alumno_temporal;

                // Chequea que efectivamente hayan cinco atributos.
                if (atributos_temp.length == 5) {
                    // El orden tiene que ser el mismo del archivo.
                    // Esto es: apellido, nombre, legajo, grado y promedio.
                    int checkGrado = Integer.valueOf(atributos_temp[3]);

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
            br.close();
        } catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage());
        } catch (IOException ex) {
            System.err.println("Error leyendo o escribiendo en algun archivo.");
        }
    }

    public static void carga_lista(Alumno[][] esc) {
        // Carga por lista
        String raiz = null;
        boolean stop = false;
        Scanner sc = new Scanner(System.in);
        char opcion = 'y';

        while (!stop) {
            if (Character.toLowerCase(opcion) == 'y') {
                raiz = "TPFinal\\TPFinal\\ListaAlumnos.txt";
                stop = true;
            } else if (Character.toLowerCase(opcion) == 'n') {
                System.out.println("Ingrese una raiz nueva>");
                raiz = sc.next();
                stop = true;
            } else {
                System.out.println("Error de ingreso.");
            }
        }

        lee_lista(raiz, esc);

    }

    public static void ord_burbuja(Alumno[] arr) {

        int i, j;
        for (i = 0; i < arr.length - 1; i++) {
            for (j = 0; j < arr.length - i - 1; j++) {
                if (arr[j + 1].getPromedioGral() >= arr[j].getPromedioGral()) {
                    cambiazo(arr, j, j + 1);
                }
            }
        }

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Alumno[][] escuela = new Alumno[7][30];
        List<Alumno> egresadosLista = new ArrayList<>();
        long inicio = 0, fin = 0;
        carga_lista(escuela);
        for (int i = 0; i < 7; i++) { // Cambiar para hacer el arreglo aún más largo.
            pasar(escuela, egresadosLista);
        }

        short elec = 1; // Cambiar esta variable a 1 para probar por método mergesort, cambiar a otro
                        // número para burbuja.
        Alumno[] prom_egresados = new Alumno[egresadosLista.size()];
        arreglo_egresados(prom_egresados, egresadosLista);
        if (elec == 1) {
            inicio = System.nanoTime();
            ord_promedio_mergesort(prom_egresados, 0, prom_egresados.length - 1);
            imprime_egresados(prom_egresados);
            fin = System.nanoTime();
            System.out.println("El código demoró: " + (fin - inicio) + " nanosegundos.");
        } else {
            inicio = System.nanoTime();
            ord_burbuja(prom_egresados);
            imprime_egresados(prom_egresados);
            fin = System.nanoTime();
            System.out.println("El código demoró: " + (fin - inicio) + " nanosegundos.");
        }

    }
}
