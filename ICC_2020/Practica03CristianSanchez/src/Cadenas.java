
/**
 * Clase que implementa los metodos
 * de la interfaz AnalizadorDeCadenas
 *
 * @author Cristian Alonso Sanchez Segura. NoCuenta 314217547
 * @version 1.0 Marzo de 2020.
 */
import java.util.InputMismatchException;
import java.util.Scanner;

public class Cadenas implements AnalizadorDeCadenas {

    /**
     * Busca la primera aparicion de un caracter especifico en una cadena.
     *
     * @param cadena la cadena a recorrer.
     * @param c el caracter a buscar en la cadena.
     * @return el indice de la primera aparicion del cararcter 'c' en la cadena.
     * Si el caracter no esta, se regresa -1.
     */
    public int encuentraPosicion(String cadena, char c) {
        for (int i = 0; i < cadena.length(); i++) {
            if (cadena.charAt(i) == c) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Verifica si una cadena es un numero.
     *
     * @param cadena la cadena a verificar si es numero.
     * @return true si la cadena es un numero, false el otro caso.
     */
    public boolean esNumero(String cadena) {
        String copia = cadena.toLowerCase();
        if (contieneChar(copia, 'a') || contieneChar(copia, 'b')
                || contieneChar(copia, 'c') || contieneChar(copia, 'd')
                || contieneChar(copia, 'e') || contieneChar(copia, 'f')
                || contieneChar(copia, 'g') || contieneChar(copia, 'h')
                || contieneChar(copia, 'i') || contieneChar(copia, 'j')
                || contieneChar(copia, 'k') || contieneChar(copia, 'l')
                || contieneChar(copia, 'm') || contieneChar(copia, 'n')
                || contieneChar(copia, 'o') || contieneChar(copia, 'p')
                || contieneChar(copia, 'q') || contieneChar(copia, 'r')
                || contieneChar(copia, 's') || contieneChar(copia, 't')
                || contieneChar(copia, 'u') || contieneChar(copia, 'v')
                || contieneChar(copia, 'w') || contieneChar(copia, 'x')
                || contieneChar(copia, 'y') || contieneChar(copia, 'z')) {
            return false;
        }
        if (cuentaCaracter(copia, '.') > 1) {
            return false;
        }
        if (contieneChar(copia, '0') || contieneChar(copia, '1')
                || contieneChar(copia, '2') || contieneChar(copia, '3')
                || contieneChar(copia, '4') || contieneChar(copia, '5')
                || contieneChar(copia, '6') || contieneChar(copia, '7')
                || contieneChar(copia, '8') || contieneChar(copia, '9')) {
            return true;
        }

        return false;
    }

    /**
     * Metodo auxiliar que verifica si una cadena contiene un caracter.
     *
     * @param cadena la cadena a recorrer.
     * @param c el caracter a buscar.
     * @return true si la cadena contiene el caracter, false en otro caso.
     */
    public boolean contieneChar(String cadena, char c) {
        for (int i = 0; i < cadena.length(); i++) {
            if (cadena.charAt(i) == c) {
                return true;
            }
        }
        return false;
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
    public String reemplazaCaracter(String cadena, char reemplazado,
            char reemplazador) {
        String nuevo = "";
        for (int i = 0; i < cadena.length(); i++) {
            if (cadena.charAt(i) == reemplazado) {
                nuevo += reemplazador;
            } else {
                nuevo += cadena.charAt(i);
            }
        }
        return nuevo;
    }

    /**
     * Cuenta todas las apariciones de un caracter en una cadena.
     *
     * @param cadena la cadena donde buscar las apariciones.
     * @param c el caracter a contabilizar en la cadena.
     * @return la cantidad de veces que aparece el caracter 'c' en la cadena.
     */
    public int cuentaCaracter(String cadena, char c) {
        int contador = 0;
        for (int i = 0; i < cadena.length(); i++) {
            if (cadena.charAt(i) == c) {
                contador = contador + 1;
            }
        }
        return contador;
    }

    /**
     * Verifica si una cadena es palindromo.
     *
     * @param cadena verificar condicion.
     * @return true si la cadena es palindromo, false en otro caso.
     */
    public boolean esPalindromo(String cadena) {
        String nuevo = reemplazaCaracter(cadena.toLowerCase(), ' ', '\u0000');
        String atras = "";
        for (int i = nuevo.length() - 1; i >= 0; i--) {
            atras += nuevo.charAt(i);
        }
        if (sonIguales(nuevo, atras)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Verifica si una cadena contiene a otra.
     *
     * @param cadena la cadena donde buscar la segunda cadena.
     * @param buscada la subcadena a buscar en la cadena.
     * @param true si cadena contiene la subcadena buscada.
     */
    public boolean contiene(String cadena, String buscada) {
        int contador = 0;
        boolean resultado = false;
        String copia = "";
        for (int i = 0; i < cadena.length(); i++) {
            if (cadena.charAt(i) == buscada.charAt(contador)) {
                for (int j = contador; j < buscada.length() & i < cadena.length(); j++) {
                    if (cadena.charAt(i) == buscada.charAt(j)) {
                        copia += cadena.charAt(i);
                        i++;
                    } else {
                        copia = "";
                    }
                }
            }
        }
        return sonIguales(copia, buscada);
    }

    /**
     * Verifica si dos cadenas son iguales lexicograficamente.
     *
     * @param cadena1 la primera cadena a comparar.
     * @param cadena2 la segunda cadena a comparar.
     * @return true si ambas cadenas son iguales, false el otro caso.
     */
    public boolean sonIguales(String cadena1, String cadena2) {
        String cadena1Copia = cadena1.toLowerCase();
        String cadena2Copia = cadena2.toLowerCase();
        boolean resultado = false;
        if (cadena1Copia.length() != cadena2Copia.length()) {
            return false;
        } else {
            for (int i = 0; i < cadena1Copia.length(); i++) {
                if (cadena1Copia.charAt(i) == cadena2Copia.charAt(i)) {
                    resultado = true;
                } else {
                    return false;
                }
            }
        }
        return resultado;
    }

    /**
     * Da una subcadena de una cadena específica.
     *
     * @param cadena la cadena de la cual obtener la subcadena.
     * @param inicio el indice de inicio de la subcadena.
     * @param fin el indice del final de la subcadena.
     * @return la subcadena desde el indice inicio al indice final. En caso de
     * pasar indices no validos regresar la cadena tal cual.
     */
    public String daSubcadena(String cadena, int inicio, int fin) {
        String subCadena = "";
        if ((inicio < 0 || fin < 0) || (inicio > cadena.length() || fin > cadena.length())
                || inicio > fin) {
            return cadena;
        } else {
            for (int i = 0; i < cadena.length(); i++) {
                if (i == inicio) {
                    for (int j = i; j < fin; j++) {
                        subCadena += cadena.charAt(j);
                    }
                }
            }
        }
        return subCadena;
    }

    public static void main(String[] args) {

        Scanner sn = new Scanner(System.in);
        Cadenas cadena = new Cadenas();
        boolean salir = false;
        int opcion;
        String cadenaStr;
        String strChar;
        char auxiliar;
        char caracter;
        int inicio;
        int fin;

        while (!salir) {

            System.out.println("\nOperadores de Cadenas.");
            System.out.println("Podras manipular cadenas con este programa.");
            System.out.println("\n1. encuentraPosicion\n" + "2. esNumero\n"
                    + "3. reemplazaCaracter\n" + "4. cuentaCaracter\n"
                    + "5. esPalindromo\n" + "6. contiene\n"
                    + "7. sonIguales\n" + "8. daSubcadena\n"
                    + "9. Pruebas Unitarias\n" + "0. Salir");

            try {

                System.out.println("Escribe el numero de una de las opciones");
                opcion = sn.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.println("Metodo que encuentra la posición "
                                + "de la primera aparicion de un caracter.\n"
                                + "Devuelve -1 si no encuntra el caracter.");
                        System.out.println("Escribe la cadena que tu quieras.");
                        cadenaStr = sn.next();
                        System.out.println("Escribe el caracter que quieras buscar.");
                        strChar = sn.next();
                        caracter = strChar.charAt(0);
                        System.out.println("Esta es la posición del caracter en tu cadena: "
                                + cadena.encuentraPosicion(cadenaStr, caracter));
                        break;

                    case 2:
                        System.out.println("Metodo que lee una cadena y te dice si"
                                + " representa un numero.");
                        System.out.println("Escribe tu cadena");
                        cadenaStr = sn.next();
                        System.out.println("¿Tu cadena representa un numero?\n"
                                + cadena.esNumero(cadenaStr));
                        break;

                    case 3:
                        System.out.println("Este metodo reemplaza todos los caracteres que "
                                + "selecciones.");
                        System.out.println("Ingresa una cadena.");
                        cadenaStr = sn.next();
                        System.out.println("¿Que caracter de tu cadena quieres cambiar?");
                        strChar = sn.next();
                        auxiliar = strChar.charAt(0);
                        System.out.println("Escribe el caracter que va a reemplazar al anterior.");
                        strChar = sn.next();
                        caracter = strChar.charAt(0);
                        System.out.println("Tu cadena cambiada es: "
                                + cadena.reemplazaCaracter(cadenaStr, auxiliar, caracter));
                        break;

                    case 4:
                        System.out.println("Metodo que cuenta las apariciones del caracter pasado.");
                        System.out.println("Ingresa tu cadena.");
                        cadenaStr = sn.next();
                        System.out.println("Ingresa el caracter que quieres contar");
                        strChar = sn.next();
                        auxiliar = strChar.charAt(0);
                        System.out.println("Este es el numero de veces que se repite tu caracter: "
                                + cadena.cuentaCaracter(cadenaStr, auxiliar));
                        break;

                    case 5:
                        System.out.println("Metodo que nos dice si tu cadena es un palidromo");
                        System.out.println("Ingresa tu cadena.");
                        cadenaStr = sn.next();
                        System.out.println("¿Tu cadena es un palindromo?\n" + cadena.esPalindromo(cadenaStr));
                        break;

                    case 6:
                        System.out.println("Metodo que nos dice si tu cadena tiene la subcadena pasada");
                        System.out.println("Ingresa tu cadena.");
                        cadenaStr = sn.next();
                        System.out.println("Ingresa la subcadena que quieras buscar.");
                        strChar = sn.next();
                        System.out.println("¿Tu subcadena esta contenida en la cadena origial?\n"
                                + cadena.contiene(cadenaStr, strChar));
                        break;

                    case 7:
                        System.out.println("Metodo que devuelve si dos cadenas son iguales.");
                        System.out.println("Ingresa la primer cadena");
                        cadenaStr = sn.next();
                        System.out.println("Ingresa una segunda cadena");
                        strChar = sn.next();
                        System.out.println("¿Tus cadenas son iguales?\n"
                                + cadena.sonIguales(cadenaStr, strChar));
                        break;

                    case 8:
                        System.out.println("Este metodo nos devuelve una subcadena, de la cadena original.");
                        System.out.println("Si ingresas un indice incorrecto, se devolvera la cadena original.");
                        System.out.println("Ingresa la cadena original");
                        cadenaStr = sn.next();
                        System.out.println("Ingresa el indice donde quieras que inicie tu subcadena.");
                        inicio = sn.nextInt();
                        System.out.println("Ingresa el indice donde quieras que termine tu subcadena");
                        fin = sn.nextInt();
                        System.out.println("Tu subcadena genera es:\n"
                                + cadena.daSubcadena(cadenaStr, inicio, fin));

                        break;
                    case 9:
                        System.out.println("Estas son las pruebas unitarias:\n");
                        int resultado = 0;
                        //encuentraPosicion
                        System.out.println("-----------------------------------");
                        System.out.println("Pruebas del metodo 'encuentraPosicion'");
                        resultado = cadena.encuentraPosicion("Esta es una palabra de prueba", 'e');
                        System.out.println("La posicion del caracter es: " + resultado);
                        resultado = cadena.encuentraPosicion("Esta es una palabra de prueba", 'E');
                        System.out.println("La posicion del caracter es: " + resultado);
                        resultado = cadena.encuentraPosicion("Esta es una palabra de prueba", 'z');
                        System.out.println("La posicion del caracter es: " + resultado);
                        resultado = cadena.encuentraPosicion("Esta es una palabra de prueba", 'u');
                        System.out.println("La posicion del caracter es: " + resultado);

                        //esNumero
                        System.out.println("-----------------------------------");
                        System.out.println("Pruebas del metodo 'esNumero'");
                        System.out.println("¿La cadena es un numero?\n" + cadena.esNumero("Texto"));
                        System.out.println("¿La cadena es un numero?\n" + cadena.esNumero("133"));
                        System.out.println("¿La cadena es un numero?\n" + cadena.esNumero("12.44"));
                        System.out.println("¿La cadena es un numero?\n" + cadena.esNumero("12.44.3.2"));
                        System.out.println("¿La cadena es un numero?\n" + cadena.esNumero("1233texto42"));

                        //reemplazaCaracter
                        System.out.println("-----------------------------------");
                        System.out.println("Pruebas del metodo 'reemplazaCaracter'");
                        String nuevo = "";
                        nuevo = cadena.reemplazaCaracter("Palabra de prueba", 'a', 'o');
                        System.out.println("Tu cadena reemplazada es:\n" + nuevo);
                        nuevo = cadena.reemplazaCaracter("Palabra de prueba", 'z', 'h');
                        System.out.println("Tu cadena reemplazada es:\n" + nuevo);
                        nuevo = cadena.reemplazaCaracter("Palabra de prueba", 'P', 'H');
                        System.out.println("Tu cadena reemplazada es:\n" + nuevo);
                        nuevo = cadena.reemplazaCaracter("Palabra de prueba", 'p', 'w');
                        System.out.println("Tu cadena reemplazada es:\n" + nuevo);

                        //cuentaCaracter
                        System.out.println("-----------------------------------");
                        System.out.println("Pruebas del metodo 'cuentaCaracter'");
                        resultado = cadena.cuentaCaracter("Ferrocarrilero", 'r');
                        System.out.println("El numero de apariciones del caracter es:\n"
                                + resultado);
                        resultado = cadena.cuentaCaracter("Ferrocarrilero", 'i');
                        System.out.println("El numero de apariciones del caracter es:\n"
                                + resultado);
                        resultado = cadena.cuentaCaracter("Ferrocarrilero", 'h');
                        System.out.println("El numero de apariciones del caracter es:\n"
                                + resultado);

                        //esPalindromo
                        System.out.println("-----------------------------------");
                        System.out.println("Pruebas del metodo 'esPalindromo'");
                        System.out.println("¿Tu cadena es palindromo?\n"
                                + cadena.esPalindromo("oso baboso"));
                        System.out.println("¿Tu cadena es palindromo?\n"
                                + cadena.esPalindromo("o"));
                        System.out.println("¿Tu cadena es palindromo?\n"
                                + cadena.esPalindromo("anita lava la tina"));
                        System.out.println("¿Tu cadena es palindromo?\n"
                                + cadena.esPalindromo("Oso baboso"));
                        System.out.println("¿Tu cadena es palindromo?\n"
                                + cadena.esPalindromo("Hola mundo"));
                        System.out.println("¿Tu cadena es palindromo?\n"
                                + cadena.esPalindromo(" "));
                        //contiene
                        System.out.println("-----------------------------------");
                        System.out.println("Pruebas del metodo 'contiene'");
                        System.out.println("¿Tu cadena contiene la subcadena?\n"
                                + cadena.contiene("Hola mundo", "mundo"));
                        System.out.println("¿Tu cadena contiene la subcadena?\n"
                                + cadena.contiene("Hola mundo", "oso"));
                        System.out.println("¿Tu cadena contiene la subcadena?\n"
                                + cadena.contiene("Hola ", "Hola mundo"));
                        System.out.println("¿Tu cadena contiene la subcadena?\n"
                                + cadena.contiene("Hola mundo", "und"));

                        //sonIguales
                        System.out.println("-----------------------------------");
                        System.out.println("Pruebas del metodo 'sonIguales'");
                        System.out.println("¿Tus cadenas son iguales?\n"
                                + cadena.sonIguales("Hola mundo", "Hola mundo"));
                        System.out.println("¿Tus cadenas son iguales?\n"
                                + cadena.sonIguales("Hola mundo", "HoLa MuNDo"));
                        System.out.println("¿Tus cadenas son iguales?\n"
                                + cadena.sonIguales("Hola mundo", "Hola"));

                        //daSubcadena
                        System.out.println("-----------------------------------");
                        System.out.println("Pruebas del metodo 'daSubcadena'");
                        String subCadena = "";
                        subCadena = cadena.daSubcadena("Esta es una cadena", 0, 3);
                        System.out.println("La subcadena resultante es:\n"
                                + subCadena);
                        subCadena = cadena.daSubcadena("Esta es una cadena", -1, 3);
                        System.out.println("La subcadena resultante es:\n"
                                + subCadena);
                        subCadena = cadena.daSubcadena("Esta es una cadena", 0, 54);
                        System.out.println("La subcadena resultante es:\n"
                                + subCadena);
                        subCadena = cadena.daSubcadena("Esta es una cadena", 5, 10);
                        System.out.println("La subcadena resultante es:\n"
                                + subCadena);

                        break;
                    case 0:
                        System.out.println("Hasta la proxima*Dubstep*");
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo números entre 0 y 9");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }
        }
    }
}
