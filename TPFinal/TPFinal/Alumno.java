package TPFinal;

public class Alumno {
    // Atributos
    private String apellido, nombre;
    private int legajo, grado;
    private double promGral;

    // Constructores
    public Alumno(String ap, String nom, int leg, int grad, double pr) {
        this.apellido = ap;
        this.nombre = nom;
        this.legajo = leg;
        this.grado = grad;
        this.promGral = pr;
    }

    // Observadores
    public String getApellido() {
        return this.apellido;
    }

    public String getNombre() {
        return this.nombre;
    }

    public int getLegajo() {
        return this.legajo;
    }

    public int getGrado() {
        return this.grado;
    }

    public double getPromedioGral() {
        return this.promGral;
    }

    public String getComparadorNombre() {
        String comp = this.apellido + this.nombre;
        return comp;
    }

    // Modif
    public void setApellido(String ap) {
        this.apellido = ap;
    }

    public void setNombre(String nom) {
        this.nombre = nom;
    }

    public void setLegajo(int leg) {
        this.legajo = leg;
    }

    public void setGrado(int grad) {
        this.grado = grad;
    }

    public void setPromedioGral(double pr) {
        this.promGral = pr;
    }

}
