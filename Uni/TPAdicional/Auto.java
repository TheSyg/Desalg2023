package TPAdicional;

public class Auto {
    // Atributos
    private String color;
    private String marca;
    private String modelo;
    private int fabricacion;
    private boolean caja;
    private double tanque;
    private double canTanque;
    private double kmRec;
    private Conductor[] conductores;
    private int contador;

    // Constructores
    public Auto(String color, String marca, String mod, int fab, boolean caja, double tanque) {
        this.color = color;
        this.marca = marca;
        this.modelo = mod;
        this.fabricacion = fab;
        this.caja = caja;
        this.tanque = tanque;
        this.canTanque = tanque; // Arranca con tanque lleno.
        this.kmRec = 0; // Se supone es un auto nuevo.
        conductores = new conductor[10]; // Cada auto no puede tener más de 10 conductores.
        this.contador = 0;
    }

    // Obs
    public String getCaja() {
        String tipoCaja = "Automática.";
        if (this.caja) {
            tipoCaja = "Manual.";
        }

        return tipoCaja;
    }

    public String toString() {
        return "\n\rMarca: " + this.marca +
                "\n\rModelo: " + this.modelo +
                "\n\rFecha de fabrica: " + this.fabricacion +
                "\n\rColor: " + this.color +
                "\n\rCaja: " + this.getCaja() +
                "\n\rCapacidad: " + this.tanque;
    }

    // Propias
    public void sumaKm(double rec) {
        this.kmRec += rec;
    }
    public void restaTanque(double rest) {
        this.canTanque -= rest;
    }
    public void llenaTanque() {
        this.canTanque = tanque;
    }
    public boolean cargaConductor(conductor unConductor){
        boolean check = false;
        if ((i < this.conductores.length)) {
            conductores[i] = unConductor;
            i++;
            check = true;
        }

        return check;
    }

}
