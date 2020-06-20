/**
 * Clase que define acciones
 * sobre matrices.
 *
 * @author Sanchez Segura Cristian Alonso
 * @version 1.0 Abril 2020.
 */
public class Arreglos implements InterfazArreglos {

    /**
     * Regresa el espejo de una matriz.
     *
     * @param arreglo el arreglo a calcular su espejo.
     * @return Un arreglo con la representación de la matriz espejo del
     * parámetro.
     */
    //arreglo[fila][columnas]
    @Override
    public int[][] espejo(int[][] arreglo) {
        int[][] nuevoArreglo = new int[arreglo.length][arreglo[0].length];
        int contador = 0;
        for (int i = 0; i < arreglo.length; i++) {
            for (int j = arreglo[0].length - 1; j >= 0; j--) {
                if (contador >= arreglo[0].length) {
                    contador = 0;
                }
                nuevoArreglo[i][contador] = arreglo[i][j];
                contador++;
            }
        }
        return nuevoArreglo;
    }

    /**
     * Verifica si un tablero del juego gato tiene una partida ganada. Los
     * caracteres permitidos para almacenar en este arreglo son: 'O' para el
     * jugador 1 'X' para el jugador 2 '-' para las casillas vacías.
     *
     * @param tablero el tablero con la partida de gato.
     * @return O si el jugador 1 tiene una partida ganada. X si el jugador 2
     * tiene una partida ganada E en caso de empate N en caso de no existir
     * ganador
     */
    //arreglo[fila][columnas]
    @Override
    public char gato(char[][] tablero) {
        //Diagonales
        if (tablero[0][0] == 'O' && tablero[1][1] == 'O' && tablero[2][2] == 'O') {
            return 'O';
        } else if (tablero[0][0] == 'X' && tablero[1][1] == 'X' && tablero[2][2] == 'X') {
            return 'X';
        }
        if (tablero[0][2] == 'O' && tablero[1][1] == 'O' && tablero[2][0] == 'O') {
            return 'O';
        } else if (tablero[0][2] == 'X' && tablero[1][1] == 'X' && tablero[2][0] == 'X') {
            return 'X';
        }
        //Empate Horizontal O
        if (tablero[0][0] == 'O' && tablero[0][1] == 'O' && tablero[0][2] == 'O') {
            if (tablero[2][0] == 'X' && tablero[2][1] == 'X' && tablero[2][2] == 'X') {
                return 'E';
            } else if (tablero[1][0] == 'X' && tablero[1][1] == 'X' && tablero[1][2] == 'X') {
                return 'E';
            }
        }
        //Empate vertical O
        if (tablero[0][0] == 'O' && tablero[1][0] == 'O' && tablero[2][0] == 'O') {
            if (tablero[0][2] == 'X' && tablero[1][2] == 'X' && tablero[2][2] == 'X') {
                return 'E';
            } else if (tablero[0][1] == 'X' && tablero[1][1] == 'X' && tablero[2][1] == 'X') {
                return 'E';
            }
        }

        //Empate Horizontal X
        if (tablero[0][0] == 'X' && tablero[0][1] == 'X' && tablero[0][2] == 'X') {
            if (tablero[2][0] == 'O' && tablero[2][1] == 'O' && tablero[2][2] == 'O') {
                return 'E';
            } else if (tablero[1][0] == 'O' && tablero[1][1] == 'O' && tablero[1][2] == 'O') {
                return 'E';
            }
        }
        //Empate vertical X
        if (tablero[0][0] == 'X' && tablero[1][0] == 'X' && tablero[2][0] == 'X') {
            if (tablero[0][2] == 'O' && tablero[1][2] == 'O' && tablero[2][2] == 'O') {
                return 'E';
            } else if (tablero[0][1] == 'O' && tablero[1][1] == 'O' && tablero[2][1] == 'O') {
                return 'E';
            }
        }

        //Horizontales
        for (char[] gato1 : tablero) {
            if (gato1[0] == 'O' && gato1[1] == 'O' && gato1[2] == 'O') {
                return 'O';
            } else if (gato1[0] == 'X' && gato1[1] == 'X' && gato1[2] == 'X') {
                return 'X';
            }
        }
        //Verticales
        for (int i = 0; i < tablero.length; i++) {
            if (tablero[0][i] == 'O' && tablero[1][i] == 'O' && tablero[2][i] == 'O') {
                return 'O';
            } else if (tablero[0][i] == 'X' && tablero[1][i] == 'X' && tablero[2][i] == 'X') {
                return 'X';
            }
        }

        return 'N';
    }

    /**
     * Crea una cadena a partir de un arreglo bidimensional de caracteres Cada
     * subarreglo será una palabra en la frase. Cada palabra estará separada por
     * un espacio.
     *
     * @param frase el arreglo con la frase.
     * @return la frase formada a partir de caracteres.
     */
    @Override
    public String construyeFrase(char[][] frase) {
        String resultado = "";
        for (int i = 0; i < frase.length; i++) {
            for (int j = 0; j < frase[0].length; j++) {
                if (j == frase[0].length - 1) {
                    resultado += Character.toString(frase[i][j]) + " ";
                } else {
                    resultado += Character.toString(frase[i][j]);
                }
            }
        }
        return resultado.replaceAll(" +", " ");
    }

    /**
     * Separa números impares de pares.
     *
     * @param numeros un arreglo de numeros enteros.
     * @return un arreglo bidimensional con los numeros separados
     */
    @Override
    public int[][] separaNumeros(int[] numeros) {
        int contador = 1;
        int par = 0;
        int impar = 0;
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] % 2 == 0) {
                contador++;
            }
        }
        int[][] separa = new int[2][contador];
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] % 2 == 0) {
                separa[0][par] = numeros[i];
                par++;
            } else {
                separa[1][impar] = numeros[i];
                impar++;
            }
        }

        return separa;
    }

    /**
     * Encuentre el número más repetido en un arreglo.
     *
     * @param numeros un arreglo de numeros enteros.
     * @return el entero más repetido del arreglo.
     */
    @Override
    public int masRepetido(int[] numeros) {
        int repetido = 0;
        for (int i = 0; i < numeros.length - 1; i++) {
            for (int j = i + 1; j < numeros.length; j++) {
                if (numeros[i] == numeros[j]) {
                    repetido = numeros[i];
                } else {
                    repetido = numeros[0];
                }
            }
        }
        return repetido;
    }

    /**
     * Permite saber si todos los elementos de un arreglo están contenidos en
     * otro.
     *
     * @param contenido un arreglo de numeros enteros
     * @param contenedor un arreglo donde verificar si el arreglo contiene todos
     * los elementos de contenido.
     * @return true si contiene todos los elementos, false en otro caso.
     */
    @Override
    public boolean estaContenido(int[] contenido, int[] contenedor) {
        int[] copia = contenido;
        int contador = 0;
        for (int i = 0; i < contenido.length; i++) {
            for (int j = 0; j < contenedor.length; j++) {
                if (contenido[i] == contenedor[j]) {
                    contador++;
                    break;
                }
            }
        }

        return contador == copia.length;
    }

    /**
     * Construye tantos niveles del triángulo de Pascal como se soliciten.
     *
     * @param n la cantidad de niveles del triangulo a construir.
     * @return un arreglo con la representación del tríangulo de pascal con n
     * niveles.
     */
    @Override
    public int[][] pascal(int n) {
        int[][] pascal = new int[n][n];
        int[] aux = new int[1];
        for (int i = 1; i <= n; i++) {
            int[] aux2 = new int[i];
            for (int j = 0; j < i; j++) {
                if (j == 0 || j == (i - 1)) {
                    aux2[j] = 1;
                    pascal[i - 1][j] = aux2[j];
                } else {
                    aux2[j] = aux[j] + aux[j - 1];
                    pascal[i - 1][j] = aux2[j];
                }
            }
            aux = aux2;
        }
        return pascal;
    }

    /**
     * Elimina los elementos repetidos de un arreglo.
     *
     * @param arreglo el arreglo del cual eliminar repetidos.
     * @return un arreglo sin elementos repetidos.
     */
    @Override
    public int[] colapsa(int[] arreglo) {
        int contador = 0;
        for (int i = 0; i < arreglo.length; i++) {
            for (int j = 0; j < arreglo.length - 1; j++) {
                if (i != j) {
                    if (arreglo[i] == arreglo[j]) {
                        arreglo[j] = -1;
                    }
                }
            }
        }
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] != -1) {
                contador++;
            }
        }
        int[] colapsa = new int[contador];
        int con = 0;
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] != -1) {
                colapsa[con] = arreglo[i];
                con++;
            }
        }
        return colapsa;
    }

    /**
     * Metodo que representa un arreglo de enteros
     *
     * @param arreglo Arreglo a representar
     */
    public void muestraArreglo(int arreglo[]) {
        String cadena = "{";
        for (int i = 0; i < arreglo.length; i++) {
            cadena += " " + Integer.toString(arreglo[i]);
        }
        cadena += " }";
        System.out.println(cadena);
    }

    /**
     * Metodo que representa un matriz de enteros
     *
     * @param arreglo La matriz a representar
     */
    public void muestraMatrizInt(int arreglo[][]) {
        for (int[] arreglo1 : arreglo) {
            System.out.print("|");
            for (int j = 0; j < arreglo1.length; j++) {
                System.out.print(arreglo1[j]);
                if (j != arreglo1.length - 1) {
                    System.out.print("\t");
                }
            }
            System.out.println("|");
        }
    }

    /**
     * Metodo que representa un matriz de char
     *
     * @param arreglo La matriz a representar
     */
    public void muestraMatrizChar(char arreglo[][]) {
        for (char[] arreglo1 : arreglo) {
            System.out.print("|");
            for (int j = 0; j < arreglo1.length; j++) {
                System.out.print(arreglo1[j]);
                if (j != arreglo1.length - 1) {
                    System.out.print("\t");
                }
            }
            System.out.println("|");
        }
    }

    public static void main(String[] args) {

        //Metodo espejo
        Arreglos array = new Arreglos();
        int[][] original = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        int[][] modificado;

        System.out.println("Metodo espejo\nOriginal");
        array.muestraMatrizInt(original);
        System.out.println("Modificado");
        modificado = array.espejo(original);
        array.muestraMatrizInt(modificado);
        System.out.println("...............");

        int[][] originalDos = {{1, 2, 3}, {5, 6, 7}};
        int[][] modificaDos;
        System.out.println("Original");
        array.muestraMatrizInt(originalDos);
        System.out.println("Modificado");
        modificaDos = array.espejo(originalDos);
        array.muestraMatrizInt(modificaDos);
        System.out.println("...............");

        int[][] originalTres = {{1, 2}, {5, 6}, {6, 8}};
        int[][] modificadoTres;
        System.out.println("Original");
        array.muestraMatrizInt(originalTres);
        System.out.println("Modificado");
        modificadoTres = array.espejo(originalTres);
        array.muestraMatrizInt(modificadoTres);

        //Metodo Gato
        System.out.println("------------------------------");
        System.out.println("Metodo Gato");
        char[][] tablero = {{'-', '-', '-'}, {'X', 'O', 'X'}, {'-', 'X', 'O'}};
        array.muestraMatrizChar(tablero);
        System.out.println("Resultado: " + array.gato(tablero));
        System.out.println("...............");

        char[][] tableroTres = {{'X', '-', 'O'}, {'X', '-', 'O'}, {'X', '-', 'O'}};
        array.muestraMatrizChar(tableroTres);
        System.out.println("Resultado: " + array.gato(tableroTres));
        System.out.println("...............");

        char[][] tableroCuatro = {{'X', '-', '-'}, {'X', 'O', 'O'}, {'X', '-', 'O'}};
        array.muestraMatrizChar(tableroCuatro);
        System.out.println("Resultado: " + array.gato(tableroCuatro));
        System.out.println("...............");

        char[][] tableroCinco = {{'O', '-', 'X'}, {'X', 'O', 'O'}, {'X', '-', 'O'}};
        array.muestraMatrizChar(tableroCinco);
        System.out.println("Resultado: " + array.gato(tableroCinco));
        System.out.println("------------------------------");

        //Metodo construyeFrase
        System.out.println("Metodo construyeFrase:");
        char[][] mundo = {{'h', 'o', 'l', 'a', ' '}, {'m', 'u', 'n', 'd', 'o'}, {'l', 'o', 'c', 'o', ' '}};
        array.muestraMatrizChar(mundo);
        System.out.println("Frase: " + array.construyeFrase(mundo));
        System.out.println("...............");

        char[][] caracteres = {{'e', 's', 't', 'a', ' ', ' ', ' ', ' ', ' ', ' '}, {'e', 's', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '}, {'u', 'n', 'a', ' ', ' ', ' ', ' ', ' ', ' ', ' '}, {'f', 'r', 'a', 's', 'e', ' ', ' ', ' ', ' ', ' '}, {'c', 'o', 'n', ' ', ' ', ' ', ' ', ' ', ' ', ' '}, {'c', 'a', 'r', 'a', 'c', 't', 'e', 'r', 'e', 's'}};
        array.muestraMatrizChar(caracteres);
        System.out.println("Frase: " + array.construyeFrase(caracteres));
        System.out.println("...............");

        //Metodo separaNumeros
        System.out.println("Metodo SeparaNumeros:");
        int[] numeros = {1, 2, 3, 4, 5, 6, 7};
        int[][] numerosSeparados = array.separaNumeros(numeros);
        array.muestraMatrizInt(numerosSeparados);
        System.out.println("...............");
        int[] numeros2 = {5, 5, 2, 4, 5, 8, 12};
        int[][] num2 = array.separaNumeros(numeros2);
        array.muestraMatrizInt(num2);
        System.out.println("...............");
        int[] numeros3 = {30, 8, 2, 4};
        int[][] num3 = array.separaNumeros(numeros3);
        array.muestraMatrizInt(num3);
        System.out.println("...............");
        System.out.println("------------------------------");

        //Metodo masRepetido
        System.out.println("Metodo masRepetido:");
        int[] repetido = {3, 3, 10, 13, 24, 3};
        array.muestraArreglo(repetido);
        System.out.println("El mas repetido: " + array.masRepetido(repetido));
        System.out.println("...............");
        int[] repetidoDos = {1, 2, 3, 4, 5, 6};
        array.muestraArreglo(repetidoDos);
        System.out.println("El mas repetido: " + array.masRepetido(repetidoDos));
        System.out.println("...............");
        int[] repetidoTres = {4, 4, 2, 2};
        array.muestraArreglo(repetidoTres);
        System.out.println("El mas repetido: " + array.masRepetido(repetidoTres));
        System.out.println("------------------------------");

        //Metodo estaContenido
        System.out.println("Metodo estaContenido:");
        int[] numCon = {2, 7, 11, 3, 5};
        int[] numContenedor = {5, 5, 2, 4, 5, 8, 12};
        array.muestraArreglo(numCon);
        array.muestraArreglo(numContenedor);
        System.out.println("Esta contenido : " + array.estaContenido(numCon, numContenedor));
        System.out.println("...............");

        int[] numCon2 = {2, 7, 5};
        int[] numContenedor2 = {7, 5, 2, 4, 5};
        array.muestraArreglo(numCon2);
        array.muestraArreglo(numContenedor2);
        System.out.println("Esta contenido : " + array.estaContenido(numCon2, numContenedor2));
        System.out.println("...............");

        int[] numCon3 = {2, 7, 12, 8};
        int[] numContenedor3 = {7, 5, 2};
        array.muestraArreglo(numCon3);
        array.muestraArreglo(numContenedor3);
        System.out.println("Esta contenido : " + array.estaContenido(numCon3, numContenedor3));
        System.out.println("...............");

        int[] numCon4 = {2, 7, 7, 7};
        int[] numContenedor4 = {7, 5, 2};
        array.muestraArreglo(numCon4);
        array.muestraArreglo(numContenedor4);
        System.out.println("Esta contenido : " + array.estaContenido(numCon4, numContenedor4));
        System.out.println("------------------------------");

        //Metodo pascal
        System.out.println("Metodo Pascal:");
        int[][] pascalCuatro = new int[4][4];
        pascalCuatro = array.pascal(4);
        array.muestraMatrizInt(pascalCuatro);
        System.out.println("...............");

        int[][] pascalCinco = new int[5][5];
        pascalCinco = array.pascal(5);
        array.muestraMatrizInt(pascalCinco);
        System.out.println("...............");

        int[][] pascalDiez = new int[10][10];
        pascalDiez = array.pascal(10);
        array.muestraMatrizInt(pascalDiez);
        System.out.println("------------------------------");

        //Metodo Colapsa
        System.out.println("Metodo colapsa:");
        int[] colapsa = {2, 2, 3, 3, 5};
        array.muestraArreglo(colapsa);
        array.muestraArreglo(array.colapsa(colapsa));
        System.out.println("...............");

        int[] colapsaDos = {2, 1, 3, 2, 5};
        array.muestraArreglo(colapsaDos);
        array.muestraArreglo(array.colapsa(colapsaDos));
        System.out.println("...............");

        int[] colapsaTres = {2, 1, 2, 2, 5, 1, 2, 3, 2, 5, 1};
        array.muestraArreglo(colapsaTres);
        array.muestraArreglo(array.colapsa(colapsaTres));

    }
}