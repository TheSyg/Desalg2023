package TP4.puntoDoce;

public class Direccion {
    // Atributos
    private int altura;
    private String nombre;

    // Constructor
    public Direccion(int alt, String nom) {
        this.altura = alt;
        this.nombre = nom;
    }

    // Obs
    public String toString() {
        return this.nombre + " " + this.altura;
    }
}
