package TP4.puntoDiez;

class Producto {

    // Atributos
    private String descripcion = " ";
    private double stock = 0;
    private int codigo;
    private double precio = 0;

    // Constructor

    // Sólo con llave principal.
    public Producto(int codigo) {
        this.codigo = codigo;
    }

    // Completo
    public Producto(int codigo, double precio, double stock, String descr) {
        this.descripcion = descr;
        this.stock = stock;
        this.precio = precio;
        this.codigo = codigo;
    }

    // Observadores

    public String getDescripcion() {
        return this.descripcion;
    }

    public double getStock() {
        return this.stock;
    }

    public double getPrecio() {
        return this.precio;
    }

    public int getCodigo() {
        return this.codigo;
    }

    public String toString() {
        return "Código: " + this.codigo +
                "\n\rDescripción: " + this.descripcion +
                "\n\rStock: " + this.stock +
                "\n\rPrecio: " + this.precio + "\n\r";
    }

    // Modificadores

    public void setCodigo(int cod) {
        this.codigo = cod;
    }

    public void setDescripcion(String desc) {
        this.descripcion = desc;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setStock(double stock) {
        this.stock = stock;
    }

    // Propias del tipo

    public double calcularPrecio(double cantidad) {
        return cantidad * this.precio;
    }

    public void restarStock(double resta) {
        this.stock -= resta;
    }
}
