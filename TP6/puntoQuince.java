package TP6;

public class puntoQuince {
    public static void main(String[] args) {
        int contador = cuentaVocales("ola k ase");
        System.out.println(contador);
    }

    public static int cuentaVocales(String s) {
        int retorno = 0;
        if (s.length() >= 1) {
            switch (s.charAt(0)) {
                case 'a':
                    retorno++;
                    retorno += cuentaVocales(s.substring(1));
                    break;
                case 'e':
                    retorno++;
                    retorno += cuentaVocales(s.substring(1));
                    break;
                case 'i':
                    retorno++;
                    retorno += cuentaVocales(s.substring(1));
                    break;
                case 'o':
                    retorno++;
                    retorno += cuentaVocales(s.substring(1));
                    break;
                case 'u':
                    retorno++;
                    retorno += cuentaVocales(s.substring(1));
                    break;
                default:
                    retorno += cuentaVocales(s.substring(1));
                    break;
            }
        }

        return retorno;
    }
}
