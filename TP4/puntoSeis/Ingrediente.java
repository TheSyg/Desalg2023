package TP4.puntoSeis;

public class Ingrediente {

    // Atributos
    private String nombre;
    private double cantidad;

    // Constructor

    public Ingrediente()  {
        this.nombre = " ";
        this.cantidad = 0.0;
    }

    public Ingrediente(String nom, double cant) {
        this.nombre = nom;
        this.cantidad = cant;
    }

    // Observadores
    public String toString() {
        return "Nombre: " + this.nombre +
                "\n\rCantidad: " + this.cantidad;
    }

    // Modificadores
    public void setNombre(String nom){
        this.nombre = nom;
    }

    public void setCantidad(double cant) {
        this.cantidad = cant;
    }
}
