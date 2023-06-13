package tpTDA2;

public class propietario {

    // Atributos
    private String nombre, apellido, mail;
    private int dni, cuit, telefono;
    private char gen;

    // Constructor con DNI, nombre y apellido.
    public Propietario(int dni, String nom, String ap, char gen){
        this.dni = dni;
        nombre = nom;
        apellido = ap;
        telefono = 0;
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

    public int getCuit() {
        return this.cuit;
    }

    public int getTelefono() {
        return this.telefono;
    }

    public char getGenero() {
        return this.gen;
    }

    public boolean equals(Propietario p1) {
        return this.cuit == p1.getCuit();
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
    public void setTelefono(int tel) {
        this.telefono = tel;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    // Propias del tipo

    private int sacaCuit(int dni, char gen) {
        int verif = 0, armado = 0, mult = 2, suma = 0, tipo = 20;
        double sinRedondeo = 0;

        // Determina tipo inicial
        gen = Character.toLowerCase(gen);
        if (gen == 'f') {
            tipo = 27;
        }
        
        // Armo el cuit sin el verificador
        armado = (tipo * Math.pow(10, 9)) + dni;

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

        // Obtengo verificador.
        switch (Math.round(sinRedondeo)) {
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
                verif = 11 - Math.round(sinRedondeo);
                break;
        }

        // Armo cuit
        armado = (tipo * Math.pow(10, 11)) + dni + verif;
        return armado;
    }

}
