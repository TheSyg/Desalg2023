package tpTDA;

public class Producto {
    // Atributos
    private int codigo;
    private String descripcion;
    private double precio;

    // Constructor
    public Producto(int cod) {
        this.codigo = cod;
        this.descripcion = " ";
        this.precio = 0;
        precioDesc(cod);
    }

    // Propias del tipo
    private void precioDesc(int cod) {
        switch (cod) {
            case 1:
                // Milanesa de pollo
                this.descripcion = "Milanesa de Pollo.";
                this.precio = 330.31;
                break;
            case 2:
                // Milanesa de carne
                this.descripcion = "Mila de Carne.";
                this.precio = 370.33;
                break;
            case 3:
                // Arroz
                this.descripcion = "Arroz";
                this.precio = 100;
                break;
            case 4:
                // Ensalada rusa
                this.descripcion = "Ensalada rusa";
                this.precio = 140.17;
                break;
            case 5:
                // Carne al horno
                this.descripcion = "Carne al horno.";
                this.precio = 447.87;
                break;
            case 6:
                // Pollo al horno
                this.descripcion = "Pollo al horno.";
                this.precio = 400;
                break;
            case 7:
                // Pescado frito
                this.descripcion = "Pescado frito.";
                this.precio = 420.55;
                break;
            case 8:
                // Filón de pan
                this.descripcion = "Filon de pan.";
                this.precio = 50;
                break;
            case 9:
                // Ensalada Cesar
                this.descripcion = "Ensalada Cesar.";
                this.precio = 200;
                break;
            case 10:
                // Empanada de carne
                this.descripcion = "Empanada de carne.";
                this.precio = 133.71;
                break;
            default:
                System.out.println("Te equivocaste.");
                break;
        }
    }

    // Obs
    public double getPrecio() {
        return this.precio;
    }

    public String toString() {
        return "Descripcion: " + this.descripcion +
                "\n\rPrecio: " + this.precio +
                "\n\rCodigo: " + this.codigo;
    }

}
