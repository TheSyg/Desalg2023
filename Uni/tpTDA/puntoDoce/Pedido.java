package tpTDA;

public class Pedido {
    // Atributo
    private int codigo, contador;
    private String descripcion;
    private Producto[] productos = new Producto[10];
    private Cliente cliente;

    // Constructor
    public Pedido(int cod) {
        cantMax = 0;
        contador = 0;
        codigo = cod;
        cliente = new Cliente();
        descripcion = " ";
    }

    // Mod
    public void setDescripcion(String desc) {
        descripcion = desc;
    }

    public void cargaProductos(int cod) {
        if (contador < productos.length) {
            productos[contador] = new Producto(cod);
            contador++;
        } else {
            System.out.println("Numero de productos excedido.");
        }
    }

    public void setDireccion(String nom, int altura) {
        this.cliente.setDireccion(alt, nom);
    }

    public void setNombreCliente(String nom) {
        this.cliente.setNombre(nom);
    }

    public void setTelefono(int num) {
        this.cliente.setTelefono(num);
    }

    public Producto getProducto() {
        return this.productos;
    }

    public int getCodigo() {
        return this.codigo;

    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public int getTelefono() {
        return this.cliente.getTelefono();
    }

    public String getNombreCliente() {
        return this.cliente.getNombre();
    }

    public Direccion getDireccion() {
        return this.cliente.getDireccion();
    }

    public String listaProductos() {
        for (int i = 0; i < productos.length; i++) {
            this.productos[i].toString();
        }
    }

    public String toString() {
        return "Codigo: " + this.codigo +
                "\n\rDescripcion: " + this.descripcion +
                "\n\rDatos del cliente: " + this.cliente.toString() +
                "\n\rPedido: " + listaProductos();

    }

    public double calcularCosto(){
        double total=0;
        for (int i = 0; i < productos.length; i++){
            total += productos[i].getPrecio();
        }
        return total;
    }

}
