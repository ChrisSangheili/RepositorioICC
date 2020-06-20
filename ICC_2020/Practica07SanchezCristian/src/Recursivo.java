
import java.util.Scanner;

/**
 * Clase que implementa metodos recursivos para la practica 7.
 *
 * @author Sanchez Segura Cristian Alonso NoCuenta: 314217547
 * @version 1.0 junio 2020.
 */
public class Recursivo implements InterfazRecursion {

    /**
     * Verifica si una cadena es palindromo.
     *
     * @param cadena verificar condicion.
     * @return true si la cadena es palindromo, false en otro caso.
     */
    public boolean esPalindromo(String cadena) {
        boolean resultado;
        String copia = quitaEspacios(cadena.toLowerCase(), 0);
        if (cadena.length() == 2) {
            resultado = cadena.charAt(0) == cadena.charAt(1);
        } else {
            resultado = esPalindromoAux(copia, 0, copia.length() - 1);
        }
        return resultado;
    }

    /**
     * Verifica si una cadena es palindromo utilizando recursión de cola.
     *
     * @param cadena verificar condicion.
     * @param contador Contador para el indice del caracter.
     * @param longitud La longitud de la cadena.
     * @return true si la cadena es palindromo, false en otro caso.
     */
    private boolean esPalindromoAux(String cadena, int contador, int longitud) {
        if (cadena.length() > 1) {
            if (contador == longitud) {
                return true;
            } else {
                if (cadena.charAt(contador) == cadena.charAt(longitud)) {

                    return esPalindromoAux(cadena, contador + 1, longitud - 1);
                } else {
                    return false;
                }
            }
        } else {
            return false;
        }

    }

    /**
     * Quita los espacios de una cadena
     *
     * @param cadena La cadena que queremos sin espacios
     * @param contador Contador para el indice del caracter
     * @return La cadena sin espacios.
     */
    public String quitaEspacios(String cadena, int contador) {
        String cadenaSinEspacios = "";
        if (contador < cadena.length()) {
            if (cadena.charAt(contador) != ' ') {
                cadenaSinEspacios += cadena.charAt(contador) + quitaEspacios(cadena, contador + 1);
            } else {
                cadenaSinEspacios += quitaEspacios(cadena, contador + 1);
            }
        } else {
            return cadenaSinEspacios;
        }
        return cadenaSinEspacios;
    }

    /**
     * Reemplaza todas las apariciones de un caracter en una cadena.
     *
     * @param cadena la cadena a reemplazar los caracteres.
     * @param reemplazado el caracter a reemplazar.
     * @param reemplazador el caracter que va a reemplazar.
     * @return una cadena con todas las apariciones del primer caracter
     * reemplazado por el segundo.
     */
    public String reemplazaCaracter(String cadena, char reemplazado, char reemplazador) {
        return reemplazaCharAux(cadena, reemplazado, reemplazador, 0);
    }

    /**
     * Reemplaza todas las apariciones de un caracter en una cadena utilizando
     * recursión de cola.
     *
     * @param cadena la cadena a reemplazar los caracteres.
     * @param reemplazado el caracter a reemplazar.
     * @param reemplazador el caracter que va a reemplazar.
     * @param contador el indice para recorrer la cadena.
     * @return una cadena con todas las apariciones del primer caracter
     * reemplazado por el segundo.
     */
    private String reemplazaCharAux(String cadena, char reemplazado, char reemplazador, int contador) {
        String reempCadena = "";
        if (contador < cadena.length()) {
            if (cadena.charAt(contador) == reemplazado) {
                reempCadena += reemplazador + reemplazaCharAux(cadena, reemplazado, reemplazador, contador + 1);
            } else {
                reempCadena += cadena.charAt(contador) + reemplazaCharAux(cadena, reemplazado, reemplazador, contador + 1);
            }
        }
        return reempCadena;
    }

    /**
     * Cuenta todas las apariciones de un caracter en una cadena.
     *
     * @param cadena la cadena donde buscar las apariciones.
     * @param c el caracter a contabilizar en la cadena.
     * @return la cantidad de veces que aparece el caracter 'c' en la cadena.
     */
    public int cuentaCaracter(String cadena, char c) {

        return cuentaCharAux(cadena, c, cadena.length());
    }

    /**
     * Cuenta todas las apariciones de un caracter en una cadena. Utilizando
     * recursión de cola.
     *
     * @param cadena la cadena donde buscar las apariciones.
     * @param c el caracter a contabilizar en la cadena.
     * @param lonCadena Longitud de la cadena original
     * @return la cantidad de veces que aparece el caracter 'c' en la cadena.
     */
    private int cuentaCharAux(String cadena, char c, int lonCadena) {
        if (lonCadena > 0) {

            if (cadena.charAt(lonCadena - 1) == c) {
                return 1 + cuentaCharAux(cadena, c, lonCadena - 1);

            } else {

                return cuentaCharAux(cadena, c, lonCadena - 1);
            }
        }
        return 0;
    }

    /**
     * Calcula un elemento de la serie de fibonacci.
     *
     * @param n el numero de la serie de fibonacci a calcular.
     * @return el resultado de calcular fibonacci de n.
     */
    public int fibonacci(int n) {

        if (n == 1) {
            return 1;
        } else if (n == 0) {
            return 0;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    public static void main(String[] args) {

        Recursivo recursivo = new Recursivo();
        Scanner sn = new Scanner(System.in);
        sn.useDelimiter("\n");
        boolean salir = false;
        int fibo;
        char auxiliar;
        char caracter;
        String cadena;
        String strChar;
        int opcion; //Guardaremos la opcion del usuario
        while (!salir) {

            System.out.println("1. esPalindromo\n" + "2. reemplazaCaracter\n"
                    + "3. cuentaCaracter\n" + "4. fibonacci\n" + "0. Salir");

            try {

                System.out.println("Selecciona una de las opciones");
                opcion = sn.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.println("Verifica si una cadena es un palindromo."
                                + "\nEscribe una cadena.");
                        cadena = (String) sn.next();
                        System.out.println("¿Tu cadena " + cadena + " es un palindromo?\n" + recursivo.esPalindromo(cadena));
                        break;
                    case 2:
                        System.out.println("Reemplaza todos los caracteres que "
                                + "selecciones.");
                        System.out.println("Ingresa una cadena.");
                        cadena = sn.next();
                        System.out.println("¿Que caracter de tu cadena quieres cambiar?");
                        strChar = sn.next();
                        auxiliar = strChar.charAt(0);
                        System.out.println("Escribe el caracter que va a reemplazar al anterior.");
                        strChar = sn.next();
                        caracter = strChar.charAt(0);
                        System.out.println("Tu cadena cambiada es: "
                                + recursivo.reemplazaCaracter(cadena, auxiliar, caracter));
                        break;
                    case 3:
                        System.out.println("Metodo que cuenta las apariciones del caracter pasado en una cadena.");
                        System.out.println("Ingresa tu cadena.");
                        cadena = sn.next();
                        System.out.println("Ingresa el caracter que quieres contar");
                        strChar = sn.next();
                        auxiliar = strChar.charAt(0);
                        System.out.println("Este es el numero de veces que se repite tu caracter: "
                                + recursivo.cuentaCaracter(cadena, auxiliar));
                        break;
                    case 4:
                        System.out.println("Ingresa un valor para obtener su representación en fibonacci");
                        fibo = sn.nextInt();
                        System.out.println(recursivo.fibonacci(fibo));
                        break;
                    case 0:
                        salir = true;
                        System.out.println("Hasta la proxima. :)");
                        break;
                    default:
                        System.out.println("Solo números entre 0 y 4");
                }
            } catch (Exception e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }
        }
    }
}
