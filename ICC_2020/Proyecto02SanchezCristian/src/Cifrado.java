
import java.util.Random;
import java.util.Scanner;

public class Cifrado {

    /*Las letras del abecedario en minusculas.*/
    private static final String ABC_MINUS = "abcdefghijklmnñopqrstuvwxyz";

    /*Las letras del abecedario en mayusculas.*/
    private static final String ABC_MAYUS = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";

    /*La longitud del abecedario.*/
    private final int longitud = 27;

    /*El mensaje recibido.*/
    private String mensaje = "";

    /*El mensaje cifrado.*/
    private String cifrado = "";

    /*El numero random*/
    private Random rm = new Random(27l);

    /*La longitud del riel. Debido a nuestra implementación
     *este atributo es necesario, pues sin el no podriamos descifrar
     *el cifrado en rieles.
     */
    private int longitudRiel;

    /**
     * Metodo de acceso para obtener el mensaje.
     *
     * @return El mensaje.
     */
    public String getMensaje() {
        return mensaje;
    }

    /**
     * Metodo de acceso para obtener el mensaje descifrado.
     *
     * @return Mensaje descifrado.
     */
    public String getCifrado() {
        return cifrado;
    }

    /**
     * Metodo de acceso para obtener la longitud de los rieles, para el metodo
     * de cifradoRiel, pues necesitamos saber la longitud de los rieles.
     */
    public int getLongitudRiel() {
        return longitudRiel;
    }

    /**
     * Método que lee la cadena de entrada.
     *
     * @param sc Un objeto de tipo Scanner para leer el mensaje.
     * @return El mensaje sin caracteres especiales.
     */
    public String obtenCadena(Scanner sc) {
        String procesado = sc.nextLine();
        mensaje = procesado.replaceAll("[^\\p{L}\\p{Z}]", "");
        return mensaje;
    }

    /**
     * Trabaja con un atributo de la clase como cadena origen y regresa la
     * cadena cifrada. El primer if verifica si la cadena tiene algún espacio,
     * en caso de tenerlo se agrega a la cadena <cifrada> para no alterar la
     * longitud del mensaje.
     *
     * @param k El desplazamiento que se desea dar.
     * @return La cadena cifrada.
     */
    public String cifradoDeCesar(int k) {
        char letra;
        for (int i = 0; i < mensaje.length(); i++) {
            if (ABC_MAYUS.contains(Character.toString(mensaje.charAt(i)))
                    || ABC_MINUS.contains(Character.toString(mensaje.charAt(i)))) {
                if (ABC_MAYUS.contains(Character.toString(mensaje.charAt(i)))) {

                    int x = ABC_MAYUS.indexOf(mensaje.charAt(i));

                    int desplazo = (x + k) % longitud;

                    letra = ABC_MAYUS.charAt(desplazo);
                } else {
                    int x = ABC_MINUS.indexOf(mensaje.charAt(i));

                    int desplazo = (x + k) % longitud;

                    letra = ABC_MINUS.charAt(desplazo);
                }
                cifrado += Character.toString(letra);
            } else {
                cifrado += Character.toString(mensaje.charAt(i));
            }
        }
        return cifrado;
    }

    /**
     * Trabaja con un atributo donde se encuntra la cadena cifrada y regresa la
     * cadena original. El primer if verifica si la cadena tiene algún espacio,
     * en caso de tenerlo se agrega a la cadena <mensaje> para no alterar la
     * longitud del mensaje.
     *
     * @param k El desplazamiento original
     * @return La cadena descifrada sin blancos ni caracteres especiales
     */
    public String descifradoCesar(int k) {
        mensaje = "";
        char letra;
        for (int i = 0; i < cifrado.length(); i++) {
            if (ABC_MINUS.contains(Character.toString(cifrado.charAt(i)))
                    || ABC_MAYUS.contains(Character.toString(cifrado.charAt(i)))) {
                if (ABC_MINUS.contains(Character.toString(cifrado.charAt(i)))) {

                    int x = ABC_MINUS.indexOf(cifrado.charAt(i));

                    int desplazo = Math.floorMod((x - k), longitud);

                    letra = ABC_MINUS.charAt(desplazo);
                } else {
                    int x = ABC_MAYUS.indexOf(cifrado.charAt(i));

                    int desplazo = Math.floorMod((x - k), longitud);

                    letra = ABC_MAYUS.charAt(desplazo);
                }
                mensaje += Character.toString(letra);
            } else {
                mensaje += Character.toString(cifrado.charAt(i));
            }
        }
        return mensaje;
    }

    /**
     * Regresa los tres rieles pegados. Traba a partir de un atributo donde se
     * encuentra la cadena origen.
     *
     * @return Una cadena con los rieles pegados sin blancos.
     */
    public String cifraRieles() {
        String sinEspacios = mensaje.replaceAll("\\s", "");
        String primerRiel = "";
        String segundoRiel = "";
        String tercerRiel = "";
        char letra;
        for (int i = 0; i < sinEspacios.length(); i++) {
            letra = sinEspacios.charAt(i);
            int modulo = i % 3;
            switch (modulo) {

                case 0:
                    primerRiel += Character.toString(letra);
                    break;
                case 1:
                    segundoRiel += Character.toString(letra);
                    break;
                case 2:
                    tercerRiel += Character.toString(letra);
                    break;

                default:
            }
        }
        longitudRiel = primerRiel.length();
        cifrado = primerRiel + segundoRiel + tercerRiel;
        return cifrado;
    }

    /**
     * Trabaja con un atributo donde se encuntra la cadena cifrada y regresa la
     * cadena original
     *
     * @return La cadena descifrada pero sin blancos ni caracteres especiales.
     */
    public String descifraRieles() {
        mensaje = "";
        String primerRiel = cifrado.substring(0, longitudRiel);
        String segundoRiel = cifrado.substring(longitudRiel, longitudRiel * 2);
        String tercerRiel = cifrado.substring(longitudRiel * 2, cifrado.length());
        for (int i = 0; i < primerRiel.length(); i++) {
            mensaje += Character.toString(primerRiel.charAt(i));
            mensaje += Character.toString(segundoRiel.charAt(i));
            if (i < tercerRiel.length()) {
                mensaje += Character.toString(tercerRiel.charAt(i));
            }
        }
        return mensaje;
    }

    /**
     * Revuelve el alfabeto. Trabaja a partir del alfabeto, que puede ser
     * estático y constante.
     *
     * @return El alfabeto revuelto.
     */
    public String revuelve() {
        String copiaABCMinus = ABC_MINUS;
        String revuelto = "";
        int ran;
        char letra;
        for (int i = 27; i > 0; i--) {
            ran = rm.nextInt(i);
            if (copiaABCMinus.length() != 0) {
                letra = copiaABCMinus.charAt(ran);
                revuelto += Character.toString(letra);
                copiaABCMinus = copiaABCMinus.replace(copiaABCMinus.charAt(ran), '\u0000');
                copiaABCMinus = copiaABCMinus.replaceAll("\u0000", "");
            } else {
                letra = copiaABCMinus.charAt(0);
                revuelto += Character.toString(letra);
            }
        }
        return revuelto;
    }

    /**
     * Trabaja con un atributo de la clase como cadena origine y regresa la
     * cadena cifrada.
     *
     * @param revuelto El alfabeto revuelto.
     * @return La cadena cifrada.
     */
    public String cifradoKamaSutra(String revuelto) {
        cifrado = "";
        String lower = mensaje.toLowerCase();
        char letra;
        for (int i = 0; i < lower.length(); i++) {
            int x = ABC_MINUS.indexOf(lower.charAt(i));
            letra = revuelto.charAt(x);
            cifrado += Character.toString(letra);
        }
        return cifrado;
    }

    /**
     * Trabaja con un atributo donde se encuentra la cadena cifrada y regresa la
     * cadena descifrada.
     *
     * @param revuelto El alfabeto que se usó para cifrar.
     * @return La cadena descifrada, sin blancos ni caracteres especiales.
     */
    public String descifraKamaSutra(String revuelto) {
        mensaje = "";
        char letra;
        for (int i = 0; i < cifrado.length(); i++) {
            int x = revuelto.indexOf(cifrado.charAt(i));
            letra = ABC_MINUS.charAt(x);
            mensaje += Character.toString(letra);
        }
        return mensaje;
    }

    public static void main(String[] args) {

        Cifrado cypher = new Cifrado();
        Scanner sc = new Scanner(System.in);
        String mensaje = cypher.obtenCadena(sc);
        String cifrado = cypher.cifradoDeCesar(5);

        System.out.println("\nTu mensaje original: " + mensaje);
        System.out.println("\nTu mensaje cifrado con el método Ceasar:\n" + cifrado + "\n"
            + "\nTu mensaje descifrado con el método Ceasar:\n" + cypher.descifradoCesar(5) + "\n");

        cifrado = cypher.cifraRieles();
        System.out.println("\nTu mensaje cifrado con el metodo de rieles:\n" + cifrado + "\n"
            + "\nTu mensaje descifrado con el metodo de rieles:\n" + cypher.descifraRieles() + "\n");
        cypher.descifraRieles();

        String alfabeto = cypher.revuelve();

        //String prueba = "ptezvkfxlwoaniqhrsdjubcygm";

        String cifra = cypher.cifradoKamaSutra(alfabeto);
        System.out.println("\nTu mensaje cifrado con el metodo KamaSutra:\n" + cifra);

        String descifra = cypher.descifraKamaSutra(alfabeto);
        System.out.println("\nTu mensaje descifrado con el metodo KamaSutra:\n" + descifra);

        System.out.println("\nAbecedario original: " + ABC_MINUS 
            + "\nAbecedario revuelto: " + alfabeto);
    }
}
