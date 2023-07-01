package TPFinal;

import java.io.*;
import java.util.*;

public class escuela {

    public static void ordInsercion(Alumno[] arr) {
        for (int i = 1; i < arr.length; i++) {
            Alumno aux = arr[i];
            int j = i - 1;

            while (j >= 0 && (arr[i].getComparadorNombre().compareTo(arr[j].getComparadorNombre()) > 0)) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = aux;
        }
    }

    public static void ordSelec(Alumno[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {

            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[min].getComparadorNombre().compareTo(arr[j].getComparadorNombre()) > 0) {
                    min = j;
                }
            }

            Alumno temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
    }

    public static void unir(Alumno[] egr, int izq, int centro, int der) {

        // Método que une (conquista).

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

        // Método que divide antes de conquistar.

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

    public static void arreglo_egresados(Alumno[] egr, List<Alumno> listaEgr) {

        for (int i = 0; i < egr.length; i++) {
            egr[i] = listaEgr.get(i);
        }

    }

    public static void cambiazo(Alumno[] arr, int pos1, int pos2) {
        Alumno temp = arr[pos1];
        arr[pos1] = arr[pos2];
        arr[pos2] = temp;
    }

    public static void organiza_alfab_gr(Alumno[] arr) {
        int i = 0;
        int j = 0;

        while (i < arr.length && arr[i] != null) {
            j = i + 1;
            while (j < arr.length && arr[j] != null) {
                if (arr[i].getComparadorNombre().compareTo(arr[j].getComparadorNombre()) > 0) {
                    cambiazo(arr, i, j);
                }
                j++;
            }
            i++;
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

    public static int cuenta_alumnos_grado(Alumno[] gr, int contador) {
        int total = 0;

        if (gr[contador] != null && contador < gr.length) {
            total = 1 + cuenta_alumnos_grado(gr, contador + 1);
        }

        return total;
    }

    public static double obtiene_promedio_grado(Alumno[] gr, int contador) {
        double total = 0;

        if (contador < gr.length && gr[contador] != null) {
            total += gr[contador].getPromedioGral() + obtiene_promedio_grado(gr, contador + 1);
        }

        return total;
    }

    public static void calcula_promedios_rec(Alumno[][] esc, double[] arr, int fil) {

        if (fil < esc.length) {
            arr[fil] = obtiene_promedio_grado(esc[fil], 0) / cuenta_alumnos_grado(esc[fil], 0);
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
            System.out.println("-----");
            System.out.println("Alumnos del grado " + (i + 1) + ": ");
            System.out.println("-----");
            while (arr[i][j] != null && j < arr[0].length) {
                System.out.println(arr[i][j].toString() + "\n\r------");
                j++;

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

    public static short menu() {
        // Menú principal

        short opcion = 0;
        Scanner sc = new Scanner(System.in);

        System.out.println("-----\n\rMenu de escuela\n\r-----");
        System.out.println("1. Pasar de Grado.");
        System.out.println("2. Calcular promedio del grado.");
        System.out.println("3. Listar alumnos de un grado por apellido y nombre de forma ascendente.");
        System.out.println("4. Mostrar promedio alumnos egresados por promedio de forma descendente.");
        System.out.println("5. Mostrar vacantes.\n\r6. Ubicar alumno.\n\r7. Imprimir Alumnos.");
        System.out.println("8. Pasar alumnos según lista.\n\r-----");
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

    public static void imprime_egresados(Alumno[] egr) {
        System.out.println("-----\n\rEgresados\n\r-----");
        for (int i = 0; i < egr.length; i++) {
            System.out.println(egr[i].toString());
        }
    }

    public static int cuenta_vacantes(Alumno[][] esc, int fil, int col) {
        int total = 0;

        if (fil < esc.length) {
            if (col < esc[0].length) {
                if (esc[fil][col] == null) {
                    // Vacante
                    total = 1 + cuenta_vacantes(esc, fil, col + 1);
                } else {
                    total = cuenta_vacantes(esc, fil, col + 1);
                }
            } else {
                // Reset de columna, comienza nueva fila.
                total = cuenta_vacantes(esc, fil + 1, 0);
            }
        }

        return total;
    }

    public static int cuenta_elementos_nonulos(Alumno[] arr) {
        int total = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null) {
                total++;
            }
        }

        return total;
    }

    public static void busca_alumno(Alumno[][] esc) {
        int legajo = 0, grado = 0, pos = 0;
        Scanner sc = new Scanner(System.in);
        boolean stop = false;
        System.out.println("Ingrese el grado del alumno> ");
        while (!stop) {
            grado = sc.nextInt();
            if (grado >= 1 && grado <= 7) {
                stop = true;
            } else {
                System.out.println("Grado inválido.");
            }
        }
        System.out.println("Ingrese el legajo del estudiante> ");
        stop = false;
        while (!stop) {
            legajo = sc.nextInt();
            if (legajo >= 1000 && legajo <= 9999) {
                stop = true;
            } else {
                System.out.println("Legajo inválido.");
            }
        }

        Alumno[] arrBusq = new Alumno[cuenta_elementos_nonulos(esc[grado - 1])];

        carga_arreglo_busq(arrBusq, esc[grado - 1]);

        pos = busqBinaria(arrBusq, 0, arrBusq.length - 1, legajo);

        if (pos == -1) {
            System.out.println("No se encontró al alumno.");
        } else {
            System.out.println("Alumno encontrado en la posición: " + (pos + 1));
        }

    }

    public static void carga_arreglo_busq(Alumno[] arr1, Alumno[] arr2) {
        int i = 0;
        while (arr2[i] != null && i < arr1.length) {
            arr1[i] = arr2[i];
            i++;
        }
    }

    public static int busqBinaria(Alumno[] arr, int ini, int fin, int obj) {
        int busq = 0;
        int med = (ini + fin) / 2; // Centro
        if (ini <= fin && fin >= 1) {
            // Chequea que se mantenga dentro del arreglo.
            if (arr[med].getLegajo() == obj) {
                // Encontró
                busq = med;
            } else {
                // No encontró y aún queda por iterar.
                if (arr[med].getLegajo() > obj) {
                    // Si es más pequeño, entonces está en el subarreglo izquierdo.
                    busq = busqBinaria(arr, ini, med - 1, obj);
                } else {
                    // Si es mayor, entonces está en el subarreglo derecho.
                    busq = busqBinaria(arr, med + 1, fin, obj);
                }
            }
        } else {
            busq = -1;
        }

        return busq;
    }

    public static void carga_repitentes(List<String> rep) {
        try (BufferedReader br = new BufferedReader(
                new FileReader("TPFinal\\TPFinal\\ListaDesaprobados.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                rep.add(linea);
            }
            br.close();
        } catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage());
        } catch (IOException ex) {
            System.err.println("Error leyendo o escribiendo en algun archivo.");
        }
    }

    public static void carga_arr_repitente(int[] arr, List<String> lista) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.valueOf(lista.get(i));
        }
    }

    public static boolean busca_en_lista(Alumno al, int[] rep) {
        // Devuelve true si el legajo de un alumno está en la lista de desaprobados.
        boolean check = false;
        int i = 0;
        while (i < rep.length) {
            if (al.getLegajo() == rep[i]) {
                check = true;
            }
            i++;
        }

        return check;
    }

    public static void pasar_lista(Alumno[][] esc, int[] rep, List<Alumno> egr) {
        int j = 0;
        for (int i = esc.length - 1; i >= 1; i--) {
            j = 0; // reset cada que comienza a iterar un grado nuevo.
            while (esc[i][j] != null && j < esc[0].length) {

                // Check si está en la lista
                if (!busca_en_lista(esc[i][j], rep)) {

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
            elimina_null(esc[i]);
        }

    }

    public static void main(String[] args) {

        Alumno[][] escuela = new Alumno[7][30];
        double[] promedios = new double[7];
        List<Alumno> egresadosLista = new ArrayList<>();
        List<String> repitentes = new ArrayList<>();
        int vacantes = 0;
        boolean stop = false;
        carga_lista(escuela);

        while (!stop) {
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
                    Alumno[] prom_egresados = new Alumno[egresadosLista.size()];
                    arreglo_egresados(prom_egresados, egresadosLista);
                    ord_promedio_mergesort(prom_egresados, 0, prom_egresados.length - 1);
                    imprime_egresados(prom_egresados);
                    break;
                case 5:
                    vacantes = cuenta_vacantes(escuela, 0, 0);
                    System.out.println("Hay " + vacantes + " vacantes disponibles.");
                    break;
                case 6:
                    busca_alumno(escuela);
                    break;
                case 7:
                    imprime_alumnos(escuela);
                    break;
                case 8:
                    carga_repitentes(repitentes); // Carga alumnos que no pasaron desde archivo.
                    int[] repite = new int[repitentes.size()]; // Crea arreglo de alumnos que no pasaron.
                    carga_arr_repitente(repite, repitentes);
                    pasar_lista(escuela, repite, egresadosLista);
                    break;
                default:
                    stop = true;
                    break;
            }
        }

    }
}
