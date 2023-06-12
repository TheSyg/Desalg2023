package TP4.puntoSeis;

public class Receta {

    // Atributos
    private String nombre;
    private int cantIngredientes;
    private int cantMax;
    private Ingrediente[] ingredientes;

    // Constructor
    public Receta(String nom, int numIng) {
        this.nombre = nom;
        this.cantMax = numIng;
        this.cantIngredientes = 0;
        this.ingredientes = new Ingrediente[numIng];
    }

    // Observadores
    public Ingrediente[] getIngredientes() {
        return this.ingredientes;
    }

    public String getNombre() {
        return this.nombre;
    }

    // Propias del tipo

    public static boolean verifNombre(String nom) {
        boolean verif = true;

        for (int i = 0; i < nom.length(); i++) {
            if (!((nom.charAt(i) == ' ') || ((nom.charAt(i) >= 'a') && (nom.charAt(i) <= 'z'))
                    || ((nom.charAt(i) >= 'A') && (nom.charAt(i) <= 'Z')))) {
                verif = false;
            }else{
                verif = true;
            }
        }

        return verif;
    }

    public static boolean verifCantidad(double cant) {
        boolean verif = true;

        if (cant <= 0) {
            verif = false;
        }

        return verif;
    }

    public static boolean verifDosLogicos(boolean b1, boolean b2) {
        boolean verif = false;
        if (b1 && b2) {
            verif = true;
        }
        return verif;
    }

    public boolean cargaIngrediente(String nom, double cant) {
        boolean verifica = false;
        verifica = verifDosLogicos(verifNombre(nom), verifCantidad(cant));
        if (verifica) {
            if (this.cantIngredientes < this.cantMax) {
                this.ingredientes[cantIngredientes] = new Ingrediente(nom, cant);
                cantIngredientes++;
            } else {
                // Si se llegó al límite.
                System.out.println("Se llegó al límite de ingredientes.");
            }
        }

        return verifica;
    }

}
