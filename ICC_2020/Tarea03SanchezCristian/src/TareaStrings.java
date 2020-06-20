
/**
 * Clase que implementa metodos para
 * trabajar con cadenas.
 *
 * @author Cristian Alonso Sanchez Segura. NoCuenta 314217547
 * @version 1.0 Marzo de 2020.
 */
public class TareaStrings {

    static String cadenaOriginal = "    Hola ComPutologOs, No S&lG&n en Cu&rEnteN&    ";
    String cadenaDelObjeto = "Soy una cadena del objeto";

    /**
     * Metodo que copia una cadena
     *
     * @param original La cadena original
     * @return la cadena copiada
     */
    public String copiarCadena(String original) {
        String copia = original;
        return copia;
    }

    /**
     * Metodo que devuelve la longitud de una cadena.
     *
     * @param cadena La cadena para encontrar su longitud
     * @return el entero con la longitud de la cadena
     */
    public int longitud(String cadena) {
        int longitud = cadena.length();
        return longitud;
    }

    /**
     * Metodo que reemplaza los caracateres de la cadena por otros.
     *
     * @param aCambiar Cadena o caracter que se quieren cambiar.
     * @param cambio Cadena o caracter que se cambian.
     * @return La cadena cambiada.
     */
    public String reemplaza(String cadena, String aCambiar, String cambio) {
        String cadenaCambiada = cadena.replaceAll(aCambiar, cambio);
        return cadenaCambiada;
    }

    /**
     * Metodo que quita los espacios al inicio o al final de una cadena.
     *
     * @param cadena Se le quitaran los espacios.
     * @return cadena sin espacios.
     */
    public String quitaEspaciosInicialesFinales(String cadena) {
        String sinEspacios = cadena.trim();
        return sinEspacios;
    }

    /**
     * Metodo que devuelve el caracter de una cadena en la posicion pasada.
     *
     * @param cadena Cadena de la cual queremos el char
     * @param indice int que corresponde a la posición del caracter en la
     * cadena.
     * @return el caracter.
     */
    public char caracterEnIndice(String cadena, int indice) {
        char indiceChar = cadena.charAt(indice);
        return indiceChar;
    }

    /**
     * Metodo que devuelve true si dos cadenas son iguales, false si no lo son.
     *
     * @param cadena1 Primer cadena
     * @param cadena2 Segunda cadena
     * @return true si son iguales, false en otro caso.
     */
    public boolean sonIgualesSinDistincion(String cadena1, String cadena2) {
        String cadenaLower1 = cadena1.toLowerCase();
        String cadenaLower2 = cadena2.toLowerCase();
        return cadenaLower1.equals(cadenaLower2);
    }

    /**
     * Metodo que devueve el indice de la primera aparicion de la subcadena
     * buscada.
     *
     * @param cadena La cadena original
     * @param subcadena La subcadena a buscar
     * @return el indice donde se encuentra la primera aparicion de la
     * subcadena.
     */
    public int indiceDeSubcadena(String cadena, String subcadena) {
        int indice = cadena.indexOf(subcadena);
        return indice;
    }

    /**
     * Metodo que devuelve un arreglo de Strings a partir de un delimitar
     *
     * @param cadena La cadena original
     * @param delimitador La cadena o subcadena que va a delimitar el arreglo.
     * @return El arrelgo se strings
     */
    public String[] subCadenas(String cadena, String delimitador) {
        return cadena.split(delimitador);
    }

    /**
     * Metodo que devuelve un char en un su representacion de String
     *
     * @param a el caracter
     * @return la representacion del caracter en String.
     */
    public String valorDelCaracterACadena(char a) {
        String nuevo = "";
        return nuevo.valueOf(a);
    }

    public static void main(String[] args) {
        /*          Pruebas para los metodos implementados
         */
        TareaStrings prueba = new TareaStrings();
        String cadena1, cadena2, cadena3;
        int index1;

        /*0*/
        System.out.println(cadenaOriginal.charAt(cadenaOriginal.length() - 1));
        /*1*/
        cadena1 = prueba.quitaEspaciosInicialesFinales(cadenaOriginal);
        /*2*/
        cadena2 = prueba.reemplaza(cadena1, "&", prueba.valorDelCaracterACadena(prueba.caracterEnIndice(cadena1, 3)));
        System.out.println(prueba.reemplaza(cadena1, "&", prueba.valorDelCaracterACadena(prueba.caracterEnIndice(cadena1, 3))));
        /*3*/
        System.out.println(prueba.sonIgualesSinDistincion("HOLA COMPUTOLOGOS, NO SALGAN EN CUARENTENA", cadena2));
        //Esta impresion debe devolver true;
        /*4*/
        index1 = prueba.indiceDeSubcadena(cadena2, "ComPutologOs");
        /*5*/
        System.out.println(prueba.subCadenas(cadena2, " ")[index1] + " == CuarEnteNa");
        //Esta impresion debe devolver "CuarEnteNa == CuarEnteNa"

        System.out.println("");


        /*              RECORDANDO 
         */

 /*6*/
        prueba.cadenaDelObjeto = cadena2;
        /*7*/
        cadenaOriginal = cadena2;
        /*8*/
        TareaStrings prueba2 = new TareaStrings();
        System.out.println(prueba.cadenaDelObjeto == cadena2);
        //Revisemos cual es el valor de la variable _cadenaOriginal_ de los objetos prueba y prueba1
        /*9*/
        System.out.println("Cadena original en prueba " + prueba.cadenaOriginal);
        /*10*/
        System.out.println("Cadena original en prueba2 " + prueba2.cadenaOriginal);
        //Revisemos cual es el valor de la variable _cadenaDelObjeto_ de los objetos prueba y prueba1
        System.out.println("");
        /*11*/
        System.out.println("Cadena del objeto en prueba " + prueba.cadenaDelObjeto);
        /*12*/
        System.out.println("Cadena del objeto en prueba2 " + prueba2.cadenaDelObjeto);

    }
}
