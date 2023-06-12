package TP5.puntoDos;

public class terreno {
    /*
     * Clase terreno
     */

    // Datos
    private int codigo;
    private double base;
    private double altura;
    private int manzana;
    private propietario prop;
    // Fin datos

    // Constructores

    // Llave principal
    public terreno(int cod) {
        this.codigo = cod;
        this.base = 0;
        this.altura = 0;
    }

    // Completo
    public terreno(int cod, double ba, double al, int man, propietario pr) {
        this.codigo = cod;
        this.base = ba;
        this.altura = al;
        this.manzana = man;
        this.prop = pr;
    }
    // Fin constructores

    // Observadores

    // Getters
    public int getCodigo() {
        return this.codigo;
    }

    public double getBase() {
        return this.base;
    }

    public double getAltura() {
        return this.altura;
    }

    public int getManzana() {
        return this.manzana;
    }

    public propietario getPropietario() {
        return this.prop;
    }
    ////////////

    public String toString() {
        return "Código: " + this.codigo +
                "\n\rBase: " + this.base +
                "\n\rAltura: " + this.altura +
                "\n\rManzana: " + this.manzana;
    }

    public boolean equals(terreno n) {
        return this.codigo == n.getCodigo();
    }

    // Modificadores
    public void setPropietario(propietario pr) {
        this.prop = pr;
    }

    public void setManzana(int man) {
        this.manzana = man;
    }

    public void setCodigo(int cod) {
        this.codigo = cod;
    }

    public void setBase(double ba) {
        this.base = ba;
    }

    public void setAltura(double al) {
        this.altura = al;
    }

    // Propias del tipo
    public double perimetro() {
        return (2 * this.base) + (2 * this.altura);
    }

    public double superficie() {
        return base * altura;
    }

    public double valor(double precio) {
        return superficie() * precio;
    }

}
