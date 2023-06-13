import javax.print.DocPrintJob;

public class Producto {

    // Atributos
    private double precio;
    private double stock;
    private int codigo;
    private String descripcion;

    // Constructores

    // 1
    public Producto(double pr, int cod, String des, int sto) {
        this.precio = pr;
        this.codigo = cod;
        this.descripcion = des;
        this.stock = sto;
    }

    // 2 (vacio)
    public Producto() {
        this.precio = 0;
        this.codigo = 0;
        this.descripcion = 0;
        this.sto = 0;
    }

    // Observadores
    public double getPrecio() {
        return this.precio;
    }

    public int getCodigo() {
        return this.codigo;
    }

    public String getDesc() {
        return this.descripcion;
    }

    public double getStock() {
        return this.stock;
    }

    public boolean equals(Producto elProd) {
        return this.codigo == elProd.getCodigo();
    }

    public String toString() {
        return "Codigo: " + this.codigo +
                "\nDescripcion: " + this.descripcion +
                "\nPrecio: " + this.precio +
                "\nStock: " + this.stock;
    }

    // Modifs
    public void setStock(double n) {
        this.stock = n;
    }

    public void setPrecio(double n) {
        this.precio = n;
    }

    public void setCodigo(int n) {
        this.codigo = n;
    }

    public void setDescripcion(String n) {
        this.descripcion = n;
    }

    // Propias

    public double compra(double n) {
        this.stock -= n;
        return this.precio * n;
    }
}
