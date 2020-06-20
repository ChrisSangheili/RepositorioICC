
import java.util.Random;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Clase Buscaminas. Modela el videojuego de BuscaMinas
 *
 * @author Sanchez Segura Cristian Alonso No.Cuenta: 314217547
 * @version 1.0.
 */
public class BuscaMinas {

    public char[][] tablero;
    public char[][] tableroJugado;
    private int descubre;
    private Random rand = new Random();
    private boolean perdio = false;

    /**
     * Constructor de la clase BuscaMinas. Se selecciona la dificultad en un
     * rango de 1-4
     *
     * @param difucultad La dificultad que tendra el videojuego
     */
    public BuscaMinas(int dificultad) {
        switch (dificultad) {
            case 1:
                this.tablero = new char[8][8];
                this.tableroJugado = new char[8][8];
                this.descubre = 2;
                this.setMinas(10);
                this.setNumMinas();
                break;
            case 2:
                this.tablero = new char[16][16];
                this.tableroJugado = new char[16][16];
                this.descubre = 3;
                this.setMinas(40);
                this.setNumMinas();
                break;
            case 3:
                this.descubre = 4;
                this.tablero = new char[16][30];
                this.tableroJugado = new char[16][30];
                this.setMinas(99);
                this.setNumMinas();
                break;
            case 4:
                this.descubre = 5;
                this.tablero = new char[12][12];
                this.tableroJugado = new char[12][12];
                this.setMinas(50);
                this.setNumMinas();
                break;
        }
    }

    /**
     * Metodo que coloca las minas en el tablero.
     *
     * @param minas El numero de minas que se colocan en el tablero.
     */
    public void setMinas(int minas) {
        int x, y;
        while(minas>0){
            x = rand.nextInt(tablero.length);
            y = rand.nextInt(tablero[0].length);
            if (tablero[x][y] != 'x'){
                tablero[x][y] = 'x';
                minas--;
            }
        }
    }

    /**
     * Metodo que indica el numero de bombas que tiene cada casilla en sus
     * casillas vecinas.
     */
    public void setNumMinas() {
        for (int i = 0; i < this.tablero.length; i++) {
            for (int j = 0; j < this.tablero[i].length; j++) {
                int minas = 0;
                if (tablero[i][j] == 'x') {
                    continue;
                } else {

                    //caso 1
                    if (i > 0 && j > 0 && i < tablero.length - 1 && j < tablero[i].length - 1) {

                        if (tablero[i - 1][j - 1] == 'x') {
                            minas++;
                        }
                        if (tablero[i - 1][j] == 'x') {
                            minas++;
                        }
                        if (tablero[i - 1][j + 1] == 'x') {
                            minas++;
                        }
                        if (tablero[i][j + 1] == 'x') {
                            minas++;
                        }
                        if (tablero[i + 1][j + 1] == 'x') {
                            minas++;
                        }
                        if (tablero[i + 1][j] == 'x') {
                            minas++;
                        }
                        if (tablero[i + 1][j - 1] == 'x') {
                            minas++;
                        }
                        if (tablero[i][j - 1] == 'x') {
                            minas++;
                        }
                    }

                    //caso 2
                    if (i == 0) {
                        if (j == 0) {
                            if (tablero[i][j + 1] == 'x') {
                                minas++;
                            }
                            if (tablero[i + 1][j] == 'x') {
                                minas++;
                            }
                            if (tablero[i + 1][j + 1] == 'x') {
                                minas++;
                            }
                        } else if (j == tablero[i].length - 1) {
                            if (tablero[i][j - 1] == 'x') {
                                minas++;
                            }
                            if (tablero[i + 1][j - 1] == 'x') {
                                minas++;
                            }
                            if (tablero[i + 1][j] == 'x') {
                                minas++;
                            }
                        } else {
                            if (tablero[i][j - 1] == 'x') {
                                minas++;
                            }
                            if (tablero[i][j + 1] == 'x') {
                                minas++;
                            }
                            if (tablero[i + 1][j - 1] == 'x') {
                                minas++;
                            }
                            if (tablero[i + 1][j] == 'x') {
                                minas++;
                            }
                            if (tablero[i + 1][j + 1] == 'x') {
                                minas++;
                            }
                        }
                    }

                    //caso 3
                    if (i == tablero.length - 1) {
                        if (j == 0) {
                            if (tablero[i][j + 1] == 'x') {
                                minas++;
                            }
                            if (tablero[i - 1][j] == 'x') {
                                minas++;
                            }
                            if (tablero[i - 1][j + 1] == 'x') {
                                minas++;
                            }
                        } else if (j == tablero[i].length - 1) {
                            if (tablero[i][j - 1] == 'x') {
                                minas++;
                            }
                            if (tablero[i - 1][j - 1] == 'x') {
                                minas++;
                            }
                            if (tablero[i - 1][j] == 'x') {
                                minas++;
                            }
                        } else {
                            if (tablero[i - 1][j - 1] == 'x') {
                                minas++;
                            }
                            if (tablero[i][j - 1] == 'x') {
                                minas++;
                            }
                            if (tablero[i][j + 1] == 'x') {
                                minas++;
                            }
                            if (tablero[i - 1][j + 1] == 'x') {
                                minas++;
                            }
                        }
                    } //caso 4
                    else if (j == 0) {
                        //System.out.println("Caso4\ni-x: " + i + ". j-y: " + j);
                        //if(tablero[i-1][j] == 'x'){
                        //	minas++;
                        //}
                        //if(tablero[i-1][j+1] == 'x'){
                        //	minas++;
                        //}
                        //Estos casos estan comentados porque intentan acceder a una posicion
                        //invalida, pero ocurre de manera aleatoria, pues puede lanzar la excepcion
                        //o no lanzarla. Utilizando el metodo back, me di cuento que lanza la excepcion
                        //si no hay una bomba en la casilla <x-i>: 0 y <y-j>: 0.
                        if (tablero[i][j + 1] == 'x') {
                            minas++;
                        }
                        if (tablero[i + 1][j] == 'x') {
                            minas++;
                        }
                        if (tablero[i + 1][j + 1] == 'x') {
                            minas++;
                        }
                    } //caso 5
                    else if (j == tablero[i].length - 1) {
                        if (tablero[i][j - 1] == 'x') {
                            minas++;
                        }
                        if (tablero[i + 1][j] == 'x') {
                            minas++;
                        }
                        //if(tablero[i][j+1] == 'x')
                        //	minas++;
                        if (tablero[i + 1][j - 1] == 'x') {
                            minas++;
                        }
                        //if(tablero[i+1][j+1] == 'x')
                        //	minas++;
                    }
                    tablero[i][j] = (minas > 0) ? Character.forDigit(minas, 10) : 0;
                }
            }
        }
    }

    /**
     * Metodo para tirar en el tablero. Los indices ya deben estar verificados
     * para cumplir con los indices validos. Se descubrian n casillas vecinas
     * asignando 'o' si no hay una bomba en esa casilla. Si la casilla
     * seleccionada tiene una bomba, se termina la ejecucion y la variable
     * <perdio> se cambia a true.
     *
     * @param x La fila seleccionada en el tablero.
     * @param y La columna seleccionada en el tablero.
     */
    public void tirar(int x, int y) {
        //tablero[fila-x][columnas-y]
        // Decubre n casillas hacia abajo
        if (tablero[x][y] != 'x') {
            for (int i = x + 1; i <= x + this.descubre && i < tablero.length; i++) {
                if (tablero[i][y] == 'x') {
                    break;
                }
                tableroJugado[i][y] = 'o';
            }

            // Decubre n casillas hacia la izquieda 
            for (int i = y - 1; i >= y - this.descubre && i >= 0; i--) {
                if (tablero[x][i] == 'x') {
                    break;
                }
                tableroJugado[x][i] = 'o';
            }

            // Decubre n casillas hacia arriba 
            for (int i = x - 1; i >= x - this.descubre && i >= 0; i--) {
                if (tablero[i][y] == 'x') {
                    break;
                }
                tableroJugado[i][y] = 'o';
            }

            //Descubre n casillas hacia la derecha
            for (int i = y + 1; i <= y + this.descubre && i < tablero.length; i++) {
                if (tablero[x][i] == 'x') {
                    break;
                }
                tableroJugado[x][i] = 'o';
            }
        } else {
            perdio = true;
            System.out.println("¡Perdiste!\n¡Encontraste una bomba!");
            return;
        }
    }

    /**
     * Metodo que imprime el tablero que vera el jugador.
     *
     * @return El tablero del juego.
     */
    public String imprimir() {
        String tableroCadena = "";
        for (int i = 0; i < this.tablero.length; i++) {
            tableroCadena += "|";
            for (int j = 0; j < this.tablero[i].length; j++) {
                if (this.tableroJugado[i][j] == 'o') {
                    tableroCadena += (this.tablero[i][j] != 0) ? " " + this.tablero[i][j] + " |" : " - |";
                } else {
                    tableroCadena += "   |";
                }
            }
            tableroCadena += "\n";
        }
        return tableroCadena;
    }

    /**
     * Metodo que imprime el tablero donde se encuentran las bombas y el numero
     * de vecinos con bombas.
     *
     * @return El tablero del juego para ver las bombas.
     */
    public String imprimirBack() {
        String tableroCadena = "";
        for (int i = 0; i < this.tablero.length; i++) {
            tableroCadena += "|";
            for (int j = 0; j < this.tablero[i].length; j++) {
                tableroCadena += (this.tablero[i][j] != 0) ? " " + this.tablero[i][j] + " |" : "   |";
            }
            tableroCadena += "\n";
        }
        return tableroCadena;
    }

    /**
     * Metodo que verifica si el jugador gano o perdio. Si cayo en una bomba o
     * si lleno el tablero sin caer en una casilla con bomba
     *
     * @return true si el jugador gano o cayo en una bomba false si aun no llena
     * el tablero o no ha caido en una bomba.
     */
    public boolean terminaElJuego() {
        //Si el usuario perdio, regresamos true e imprimimos "Perdio"
        /*Si no, revisamos que todo el tablero "tableroJugado" este lleno, recuerda que no se estan llenando las casillas
		**donde originalmente estan las bombas, por lo que esto implica contemplar ese caso. Si el tablero esta lleno
		**(con la exepcion anterior), entonces el usuario gana
         */
        int total = (tablero.length) * (tablero[0].length);
        int lleno = 0;
        for (int i = 0; i < this.tablero.length; i++) {
            for (int j = 0; j < this.tablero[i].length; j++) {
                if(tableroJugado[i][j] == 'o'){
                    lleno++;
                }
                if (tablero[i][j] == 'x') {
                    total--;
                }
            }
        }
        if (total == lleno) {
            System.out.println("!Ganaste¡ Llenaste el tablero");
            return true;
        }
        return perdio;
    }

    /*Metodo main*/
    public static void main(String[] args) {

        Scanner sn = new Scanner(System.in);
        BuscaMinas bm;
        int coordX, coordY;
        int opcion, caso1, caso2;
        int dificultad;
        boolean salir = false;
        boolean regresar = false;

        while (!salir) {
            System.out.println("\nBienvenido al juego BuscaMinas\n");
            System.out.println("1. Jugar");
            System.out.println("2. Jugar como admin");
            System.out.println("0. Salir");

            try {

                System.out.println("Selecciona una opcion");
                opcion = sn.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.println("Has seleccionado Jugar");

                        while (!regresar) {
                            System.out.println("Selecciona la dificultad");
                            System.out.println("1. Principiante: --Tablero: 8x8 Minas: 10--");
                            System.out.println("2. Intermedio:   --Tablero: 16x16 Minas: 40--");
                            System.out.println("3. Experto:      --Tablero: 16x30 Minas: 99--");
                            System.out.println("4. Personalizado:--Tablero: 12x12 Minas: 50--");
                            System.out.println("0. Regresar");

                            try {

                                caso1 = sn.nextInt();

                                switch (caso1) {
                                    //
                                    case 1:
                                        System.out.println("BuscaMinas -- Principiante--");
                                        bm = new BuscaMinas(1);
                                        do {
                                            System.out.println(bm.imprimir());
                                            System.out.println("Ingrese fila -> 0-" + (bm.tablero.length - 1));
                                            coordX = sn.nextInt();
                                            System.out.println("Ingrese columna -> 0-" + (bm.tablero[0].length - 1));
                                            coordY = sn.nextInt();

                                            bm.tirar(coordX, coordY);

                                        } while (!bm.terminaElJuego());
                                        break;
                                    case 2:
                                        System.out.println("BuscaMinas -- Intermedio--");
                                        bm = new BuscaMinas(2);
                                        do {
                                            System.out.println(bm.imprimir());
                                            System.out.println("Ingrese fila -> 0-" + (bm.tablero.length - 1));
                                            coordX = sn.nextInt();
                                            System.out.println("Ingrese columna -> 0-" + (bm.tablero[0].length - 1));
                                            coordY = sn.nextInt();
                                            bm.tirar(coordX, coordY);

                                        } while (!bm.terminaElJuego());
                                        break;
                                    case 3:
                                        System.out.println("BuscaMinas -- Experto--");
                                        bm = new BuscaMinas(3);
                                        do {
                                            System.out.println(bm.imprimir());
                                            System.out.println("Ingrese fila -> 0-" + (bm.tablero.length - 1));
                                            coordX = sn.nextInt();
                                            System.out.println("Ingrese columna -> 0-" + (bm.tablero[0].length - 1));
                                            coordY = sn.nextInt();
                                            bm.tirar(coordX, coordY);

                                        } while (!bm.terminaElJuego());
                                        break;
                                    case 4:
                                        System.out.println("BuscaMinas -- Personalizado--");
                                        bm = new BuscaMinas(4);
                                        do {
                                            System.out.println(bm.imprimir());
                                            System.out.println("Ingrese fila -> 0-" + (bm.tablero.length - 1));
                                            coordX = sn.nextInt();
                                            System.out.println("Ingrese columna -> 0-" + (bm.tablero[0].length - 1));
                                            coordY = sn.nextInt();
                                            bm.tirar(coordX, coordY);

                                        } while (!bm.terminaElJuego());
                                        break;
                                    case 0:
                                        regresar = true;
                                        break;
                                    default:
                                        System.out.println("Solo números entre 0 y 2");
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Debes insertar un número");
                                sn.next();
                            }
                        }

                        break;
                    case 2:
                        while (!regresar) {
                            System.out.println("Podras ver las minas\nSelecciona la dificultad");
                            System.out.println("1. Principiante: --Tablero: 8x8 Minas: 10--");
                            System.out.println("2. Intermedio:   --Tablero: 16x16 Minas: 40--");
                            System.out.println("3. Experto:      --Tablero: 16x30 Minas: 99--");
                            System.out.println("4. Personalizado:--Tablero: 12x12 Minas: 50--");
                            System.out.println("0. Regresar");

                            try {

                                caso2 = sn.nextInt();

                                switch (caso2) {
                                    //
                                    case 1:
                                        System.out.println("BuscaMinas -- Principiante--");
                                        bm = new BuscaMinas(1);
                                        do {
                                            System.out.println("\nBack del juego.");
                                            System.out.println(bm.imprimirBack());

                                            System.out.println("\nTablero del juego");
                                            System.out.println(bm.imprimir());
                                            System.out.println("Ingrese fila -> 0-" + (bm.tablero.length - 1));
                                            coordX = sn.nextInt();
                                            System.out.println("Ingrese columna -> 0-" + (bm.tablero[0].length - 1));
                                            coordY = sn.nextInt();
                                            bm.tirar(coordX, coordY);

                                        } while (!bm.terminaElJuego());
                                        break;
                                    case 2:
                                        System.out.println("BuscaMinas -- Intermedio--");
                                        bm = new BuscaMinas(2);
                                        do {
                                            System.out.println("\nBack del juego.");
                                            System.out.println(bm.imprimirBack());

                                            System.out.println("\nTablero del juego");
                                            System.out.println(bm.imprimir());
                                            System.out.println("Ingrese fila -> 0-" + (bm.tablero.length - 1));
                                            coordX = sn.nextInt();
                                            System.out.println("Ingrese columna -> 0-" + (bm.tablero[0].length - 1));
                                            coordY = sn.nextInt();
                                            bm.tirar(coordX, coordY);

                                        } while (!bm.terminaElJuego());
                                        break;
                                    case 3:
                                        System.out.println("BuscaMinas -- Experto--");
                                        bm = new BuscaMinas(3);
                                        do {
                                            System.out.println("\nBack del juego.");
                                            System.out.println(bm.imprimirBack());

                                            System.out.println("\nTablero del juego");
                                            System.out.println(bm.imprimir());
                                            System.out.println("Ingrese fila -> 0-" + (bm.tablero.length - 1));
                                            coordX = sn.nextInt();
                                            System.out.println("Ingrese columna -> 0-" + (bm.tablero[0].length - 1));
                                            coordY = sn.nextInt();
                                            bm.tirar(coordX, coordY);

                                        } while (!bm.terminaElJuego());
                                        break;
                                    case 4:
                                        System.out.println("BuscaMinas -- Personalizado--");
                                        bm = new BuscaMinas(4);
                                        do {
                                            System.out.println("\nBack del juego.");
                                            System.out.println(bm.imprimirBack());
                                            System.out.println("\nTablero del juego");
                                            System.out.println(bm.imprimir());
                                            System.out.println("Ingrese fila -> 0-" + (bm.tablero.length - 1));
                                            coordX = sn.nextInt();
                                            System.out.println("Ingrese columna -> 0-" + (bm.tablero[0].length - 1));
                                            coordY = sn.nextInt();
                                            bm.tirar(coordX, coordY);

                                        } while (!bm.terminaElJuego());
                                        break;
                                    case 0:
                                        regresar = true;
                                        break;
                                    default:
                                        System.out.println("Solo números entre 0 y 2");
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Debes insertar un número");
                                sn.next();
                            }
                        }
                    case 0:
                        System.out.println("Gracias por jugar.");
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo números entre 0 y 2");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }
        }
    }
}
