package TP5.puntoDos;

public class propietario {

    // Atributos
    private String nombre, apellido, mail, telefono;
    private int dni;
    private long cuit;
    private char gen;

    // Constructor con DNI, nombre y apellido.
    propietario(int dni, String nom, String ap, char gen) {
        this.dni = dni;
        nombre = nom;
        apellido = ap;
        telefono = " ";
        mail = " ";
        this.gen = gen;
        cuit = sacaCuit(dni, gen);
    }

    // Observadores

    public String getNombre() {
        return this.nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public String getMail() {
        return this.mail;
    }

    public int getDni() {
        return this.dni;
    }

    public long getCuit() {
        return this.cuit;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public char getGenero() {
        return this.gen;
    }

    public boolean equals(propietario p1) {
        return this.dni == p1.getDni();
    }

    public String toString() {
        return "Nombre: " + this.nombre +
                "\n\rApellido: " + this.apellido +
                "\n\rDNI: " + this.dni +
                "\n\rCUIT: " + this.cuit +
                "\n\rGenero: " + this.gen +
                "\n\rTelefono: " + this.telefono +
                "\n\rMail: " + this.mail;
    }

    // Modificadores
    public void setTelefono(String tel) {
        this.telefono = tel;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    // Propias del tipo
    private long sacaCuit(int dni, char gen) {
        long verif = 0, armado = 0, mult = 2, suma = 0, tipo = 20;
        int red = 0;
        double sinRedondeo = 0;

        // Determina tipo inicial
        gen = Character.toLowerCase(gen);
        if (gen == 'f') {
            tipo = 27;
        }

        // Armo el cuit sin el verificador
        armado = (tipo * 1000000000) + dni;

        // Consigo la suma de los digitos.
        while (armado > 0) {
            suma += (armado % 10) * mult;
            armado = armado / 10;
            mult++;
            if (mult > 7) {
                mult = 2;
            }
        }
        // Limpio el cuit
        armado = 0;

        // Mod 11
        sinRedondeo = suma % 11;
        red = (int) Math.round(sinRedondeo);
        // Obtengo verificador.
        switch (red) {
            case 1:
                if (gen == 'f') {
                    tipo = 23;
                    verif = 4;
                } else {
                    tipo = 23;
                    verif = 9;
                }
                break;
            case 0:
                verif = 0;
                break;
            default:
                verif = (11 - red);
                break;
        }

        // Armo cuit
        armado = (tipo * 1000000000) + (dni*10) + verif;
        return armado;
    }

}
