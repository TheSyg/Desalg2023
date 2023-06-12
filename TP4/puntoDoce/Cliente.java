package TP4.puntoDoce;

public class Cliente {
    // Atributos
    private String nombre;
    private Direccion direccion;
    private int telefono;

    // Constructor
    public Cliente() {
        this.nombre = " ";
        this.telefono = 0;
    }

    // Mod
    public void setNombre(String nom) {
        this.nombre = nom;
    }

    public void setDireccion(int alt, String nom) {
        this.direccion = new Direccion(alt, nom);
    }

    public void setTelefono(int num) {
        this.telefono = num;
    }

    public String getNombre() {
        return this.nombre;
    }

    public Direccion getDireccion() {
        return this.direccion;
    }

    public int getTelefono() {
        return this.telefono;
    }

    public String toString() {
        return "\n\rNombre: " + this.nombre +
                "\n\rDireccion: " + this.direccion.toString() +
                "\n\rTelefono: " + this.telefono;
    }

}
