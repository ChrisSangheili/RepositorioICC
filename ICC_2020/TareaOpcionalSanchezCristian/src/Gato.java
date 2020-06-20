
/**
 * Clase Gato
 *
 * @author Sanchez Segura Cristian Alonso No. Cuenta: 314217547
 * @version 1.0
 */
import java.util.InputMismatchException;
import java.util.Scanner;

public class Gato {

    /**
     * Metodo para imprimir el tablero del gato
     *
     * @param gato Arreglo que representa las posiciones.
     */
    public static void imprime(String[][] gato) {
        for (int i = 0; i < gato.length; i++) {
            System.out.println(" -------------");
            for (int j = 0; j < gato[i].length; j++) {
                System.out.print(" | " + gato[i][j]);
            }
            System.out.print(" |");
            System.out.println();
        }

    }

    /**
     * Metodo que imprime las posiciones disponibles del gato
     *
     * @param gato El tablero del juego
     */
    public static void imprimirPosiciones(String[][] gato) {
        int pos = 1;
        System.out.println("Selecciona una posición en el tablero: ");
        System.out.println("Las casillas marcadas con 'x' y 'o' ya están ocupadas");
        for (int i = 0; i < gato.length; i++) {
            for (int j = 0; j < gato.length; j++) {
                if (gato[i][j] == "x" || gato[i][j] == "o") {
                    System.out.print(" " + gato[i][j]);
                } else {
                    System.out.print(" " + pos);
                }
                pos++;
            }
            System.out.println();
        }
    }

    /**
     * Metodo que verifica la posición de los signos en el tablero
     *
     * @param gato El tablero del juego
     * @param posicion La posicion en el arreglo
     * @return Si esta disponible o no la casilla
     */
    public static boolean casillaSinOcupar(String[][] gato, int posicion) {
        switch (posicion) {
            case 1:
                return gato[0][0] != " ";
            case 2:
                return gato[0][1] != " ";
            case 3:
                return gato[0][2] != " ";
            case 4:
                return gato[1][0] != " ";
            case 5:
                return gato[1][1] != " ";
            case 6:
                return gato[1][2] != " ";
            case 7:
                return gato[2][0] != " ";
            case 8:
                return gato[2][1] != " ";
            case 9:
                return gato[2][2] != " ";
            default:
                return false;
        }
    }

    /**
     * Metodo que realiza una jugada
     *
     * @param gato El tablero del juego
     * @param signo Cruz o Circulo
     */
    public static void jugada(String[][] gato, String signo) {
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int posicion;

        while (!salir) {
            try {
                imprimirPosiciones(gato);
                System.out.println("Escribe el número de casilla para tirar: ");
                posicion = sn.nextInt();
                if (casillaSinOcupar(gato, posicion)) {
                    switch (posicion) {
                        case 1:
                            gato[0][0] = signo;
                            break;
                        case 2:
                            gato[0][1] = signo;
                            break;
                        case 3:
                            gato[0][2] = signo;
                            break;
                        case 4:
                            gato[1][0] = signo;
                            break;
                        case 5:
                            gato[1][1] = signo;
                            break;
                        case 6:
                            gato[1][2] = signo;
                            break;
                        case 7:
                            gato[2][0] = signo;
                            break;
                        case 8:
                            gato[2][1] = signo;
                            break;
                        case 9:
                            gato[2][2] = signo;
                            break;
                    }
                    salir = true;
                } else {
                    System.out.println("Casilla no válida.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Escribe un numero.");
                posicion = sn.nextInt();
            }
        }
    }

    /**
     * Metodo que verifica si se gana por renglones
     *
     * @param gato El tablero del juego
     * @param signo Cruz o circulo
     * @return Si se ha ganado o no
     */
    public static boolean ganaPorRenglon(String[][] gato, String signo) {

        for (String[] gato1 : gato) {
            if (gato1[0] == signo && gato1[1] == signo && gato1[2] == signo) {
                return true;
            }
        }
        return false;
    }

    /**
     * Metodo que verifica si se gana por columnas
     *
     * @param gato El tablero del juego
     * @param signo Cruz o circulo
     * @return Si se ha ganado o no
     */
    public static boolean ganaPorColumna(String[][] gato, String signo) {

        for (int i = 0; i < gato.length; i++) {
            if (gato[0][i] == signo && gato[1][i] == signo && gato[2][i] == signo) {
                return true;
            }
        }
        return false;
    }

    /**
     * Metodo que verifica si se gana por diagonales, busca de izquiera a
     * derecha.
     *
     * @param gato El tablero del juego
     * @param signo Cruz o circulo
     * @return Si se ha ganado o no
     */
    public static boolean ganaPorDiagonales(String[][] gato, String signo) {
        if (gato[0][0] == signo && gato[1][1] == signo && gato[2][2] == signo) {
            return true;
        }
        if (gato[0][2] == signo && gato[1][1] == signo && gato[2][0] == signo) {
            return true;
        }

        return false;
    }

    /**
     * Metodo que verifica si hay ganador.
     *
     * @param gato El tablero del juego
     * @param signo Cruz o circulo
     * @return Si hay ganador
     */
    public static boolean hayGanador(String[][] gato, String signo) {
        if (ganaPorRenglon(gato, signo)) {
            return true;
        }
        if (ganaPorColumna(gato, signo)) {
            return true;
        }
        if (ganaPorDiagonales(gato, signo)) {
            return true;
        }
        return false;
    }

    /**
     * Metodo que verifica si hay casillas disponibles para tirar
     *
     * @param gato El tablero del juego
     * @return Si hay espacio para tirar
     */
    public static boolean hayEspacio(String[][] gato) {
        for (String[] gato1 : gato) {
            for (int j = 0; j < gato.length; j++) {
                if (gato1[j] == "-") {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Inicializa el tablero con "-"
     *
     * @param gato El tablero del juego
     */
    public static void inicializarTablero(String[][] gato) {
        for (int i = 0; i < gato.length; i++) {
            for (int j = 0; j < gato.length; j++) {
                gato[i][j] = "-";
            }
        }
    }

    /**
     * Metodo main
     */
    public static void main(String[] args) {
        String gato[][] = new String[3][3];
        Scanner sn = new Scanner(System.in);
        String jugadorX = "x";
        boolean terminar = false;
        boolean salir = false;
        int opcion;

        while (!salir) {

            System.out.println("1. Iniciar juego.\n" + "2. Instrucciones.\n"
                    + "3. Salir.");
            try {
                System.out.println("Selecciona una de las opciones.");
                opcion = sn.nextInt();

                switch (opcion) {

                    case 1:
                        inicializarTablero(gato);
                        imprime(gato);
                        while (!terminar) {
                            try {
                                jugada(gato, jugadorX);
                                imprime(gato);
                                if (hayGanador(gato, jugadorX)) {
                                    System.out.println("Gana " + jugadorX + "\nJuego terminado.");
                                    terminar = true;
                                } else {
                                    if (!hayEspacio(gato)) {
                                        System.out.println("Empante. No hay mas donde tirar.");
                                        terminar = true;
                                    } else {
                                        if (jugadorX == "x") {
                                            jugadorX = "o";
                                        } else {
                                            jugadorX = "x";
                                        }
                                    }
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Debes insertar un numero.\n"
                                        + "Verifica que este disponible para tirar.");
                            }
                        }
                        break;
                    case 2:
                        System.out.println("Al iniciar el juego, el primer jugador\n"
                                + "será 'x' y el segundo jugador tendra 'o'.\n"
                                + "Se intercambiara al jugador en cada tiro, es decir,\n"
                                + "cuando el jugador 1 tire 'x', el siguiente turno\n"
                                + "tirara 'o'.");
                        break;
                    case 3:
                        System.out.println("Gracias por jugar :)");
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo numeros del 1 al 3");

                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un numero");
                sn.nextInt();
            }
        }
    }
}
