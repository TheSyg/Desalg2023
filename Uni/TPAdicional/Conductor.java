package TPAdicional;

public class Conductor {
    // Atributos
    private int dni;
    private String nombre;
    private double recorrido;
    private double gastoComb;

    // Constructores
    public Conductor(int dni, String nombre, double recorrido) {
        this.dni = dni;
        this.nombre = nombre;
        this.recorrido = recorrido;
        this.gastoComb = 0;
    }

    // Obs
    public int getDni() {
        return this.dni;
    }

    public String getNombre() {
        return this.nombre;
    }

    public double getKmRec() {
        return this.recorrido;
    }

    public String toString() {
        return "\n\rNombre: " + this.nombre +
                "\n\rDNI: " + this.dni +
                "\n\rKm Recorridos: " + this.recorrido;
    }

    // No hay modificadoras.

    // Propias
    public void regGastoCombustible(int fab, boolean caja) {
        if (caja) {
            // Caja manual
            if (caja) {
                // < 2015
                this.gastoComb = 13 * (this.getKmRec() / 100);
            } else {
                // > 2015
                this.gastoComb = 10 * (this.getKmRec() / 100);
            }
        } else {
            // Caja automática
            this.gastoComb = 8 * (this.getKmRec() / 100);
        }
    }

}
