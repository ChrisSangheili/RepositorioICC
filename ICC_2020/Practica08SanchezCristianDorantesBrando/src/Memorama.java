
import java.util.Scanner;
import java.io.*;

/**
 * Clase que crea un memora
 *
 * @author Sanchez Segura Cristian Alonso No. Cuenta: 314217547
 * @author Brando Dorantes Perez No. Cuenta: 314255356
 */
public class Memorama {

    /*Arreglo bidimensional de cartas*/
    Carta[][] memorama;

    /*Lista donde se guardan las cartas.*/
    ListaLigada cartas = new ListaLigada();

    /*Nombre del archivo con las cartas a crear*/
    String nombreArchivo;

    /**
     * Constructor de la clase memorama, crea un arreglo bidimensional de tamaño
     * 4. Utiliza un archivo para crear las cartas del memorama. Despues de
     * crear las cartas, se le asignan al memorama.
     *
     */
    public Memorama(String nombreArchivo) {
        this.memorama = new Carta[4][4];
        this.nombreArchivo = nombreArchivo;
        creaCartas(nombreArchivo);
        crearMemorama();
    }

    /**
     * Metodo de acceso para el nombre del archivo con las cartas a crear
     *
     * @return El nombre del archivo donde se encuentran las cartas a crear.
     */
    public String getNombreArchivo() {
        return nombreArchivo;
    }

    /**
     * Metodo de modificacion para el nombre del archivo.
     *
     * @param nuevoNombre Nuevo nombre del archivo.
     */
    public void setNombreArchivo(String nuevoNombre) {
        this.nombreArchivo = nuevoNombre;
    }

    /**
     * Metodo que crea cartas a partir de un archivo.
     *
     * @param nombreArchivo Archivo donde se encuentra el simbolo que tendran
     * las cartas.
     */
    private void creaCartas(String nombreArchivo) {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        Carta carta;

        try {
            archivo = new File(nombreArchivo + ".txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            String linea;
            while ((linea = br.readLine()) != null) {
                carta = new Carta(linea);
                cartas.insertaFinal(carta);
                //System.out.println(linea);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /**
     * Asigna las cartas necesarias para el memorama de 4x4.
     *
     * En esta versión, las cartas siempre tienen la misma posición en el
     * arreglo.
     */
    /*
    private void crearMemorama() {
        int contador = 0;
        for (int i = 0; i < memorama.length; i++) {
            for (int j = 0; j < memorama[i].length; j++) {
                if (contador < 8) {
                    memorama[i][j] = (Carta) cartas.obten(contador);
                    contador++;
                } else {
                    contador = 0;
                    memorama[i][j] = (Carta) cartas.obten(contador);
                    contador++;
                }
            }
        }
    }
     */
    /**
     * Asigna las cartas necesarias para el memorama de 4x4.
     *
     * En esta versión, las cartas siempre tienen la misma posición en el
     * arreglo.
     */
    private void crearMemorama() {
        int contador = 0;
        for (int i = 0; i < memorama.length; i++) {
            for (int j = 0; j < memorama[i].length; j++) {
                memorama[i][j] = (Carta) cartas.obten(contador);
                contador++;
            }
        }
    }

    /**
     * Metodo que deja jugar al memorama
     *
     */
    public void juegaPartida(int cartaUnoX, int cartaUnoY,
            int cartaDosX, int cartaDosY) throws InvalidCardException {

        if ((cartaUnoX == cartaDosX) && (cartaUnoY == cartaDosY)) {
            throw new InvalidCardException("Estas intentando voltear la misma carta.");
        }
        if ((memorama[cartaUnoX][cartaUnoY].isVisible()) || (memorama[cartaDosX][cartaDosY].isVisible())) {
            throw new InvalidCardException("Alguna de las cartas ya esta volteada");
        }

        memorama[cartaUnoX][cartaUnoY].voltear();
        memorama[cartaDosX][cartaDosY].voltear();

        imprimir();

        if (volteaCartas(memorama[cartaUnoX][cartaUnoY], memorama[cartaDosX][cartaDosY])) {
            System.out.println("Encontraste las cartas iguales");
            imprimir();
        } else {
            System.out.println("Sigue intentado");
            memorama[cartaUnoX][cartaUnoY].voltear();
            memorama[cartaDosX][cartaDosY].voltear();
            imprimir();
        }
    }

    /**
     * Metodo que oculta todas las figuras del memorama.
     *
     */
    public void juegoNuevo() {
        for (int i = 0; i < memorama.length; i++) {
            for (int j = 0; j < memorama[i].length; j++) {
                memorama[i][j].setVisible(false);
            }
        }
    }

    /**
     * Metodo que limpia la lista de cartas.
     */
    public void limpia() {
        cartas.limpia();
    }

    /**
     * Metodo que carga una partida ya guardada.
     *
     * @param nombreArchivo El nombre del archivo donde se encuentra la partida
     * guardada.
     */
    public void cargaPartida(String nombreArchivo) {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        Carta carta;

        try {
            archivo = new File(nombreArchivo + ".txt");
            if (archivo.exists()) {
                fr = new FileReader(archivo);
                br = new BufferedReader(fr);
                String[] datos;

                String linea;
                limpia();
                while ((linea = br.readLine()) != null) {
                    datos = linea.split(",");
                    carta = new Carta(datos[0], datos[1]);
                    cartas.insertaFinal(carta);
                }
                crearMemorama();
            } else {
                System.out.println("No existe el archivo: " + nombreArchivo + ".txt");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /**
     * Metodo que guarda la partida actual, es decir, guarda las cartas que ya
     * han sido volteadas.
     *
     * @param nombreArchivo El nombre que se le asignará al archivo.
     */
    public void guardaPartida(String nombreArchivo) {
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter(nombreArchivo + ".txt");
            pw = new PrintWriter(fichero);
            for (int i = 0; i < memorama.length; i++) {
                for (int j = 0; j < memorama[i].length; j++) {
                    pw.println(memorama[i][j].toArchivo());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fichero) {
                    fichero.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /**
     * Metodo que verifica si dos cartas tienen el mismo simbolo Devuelve true
     * si ambas tienen el mismo simbolo, false de no ser así
     *
     * @return true si ambas tienen el mismo simbolo, false en caso contrario.
     */
    public boolean volteaCartas(Carta carta1, Carta carta2) {
        return carta1.getSimbolo().equals(carta2.getSimbolo());
    }

    /**
     * Metodo que imprime el tablero que vera el jugador.
     *
     */
    public void imprimir() {
        for (int i = 0; i < memorama.length; i++) {
            //System.out.print(i + "|");
            System.out.print("|");
            for (int j = 0; j < memorama[i].length; j++) {
                System.out.print("(" + i + "," + j + ")" + memorama[i][j]);
                if (j != memorama[i].length - 1) {
                    System.out.print("|\t|");
                }
            }
            System.out.println("|");
        }
    }

    public static void main(String[] args) {

        Memorama memorama = new Memorama("Cartas");//Cartas con emoticonos
        
        //Memorama memorama = new Memorama("Cartas2");//Cartas con letras
        //Memorama memorama = new Memorama("Cartas");//Caritas
        //Memorama memorama = new Memorama("Cartas");//Colores

        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario
        int cux = 0; //Abreviaciones para cartaUnoX.
        int cuy = 0; //Abreviaciones para cartaUnoY.
        int cdx = 0; //Abreviaciones para cartaDosX.
        int cdy = 0; //Abreviaciones para cartaDosY.
        String nombreArchivo;

        while (!salir) {

            System.out.println("1. Jugar nueva partida.\n"
                    + "2. Jugar Partida Actual.\n" + "3. Guardar Partida.\n"
                    + "4. Cargar Partida.\n" + "0. Salir\n");
            try {

                System.out.println("Escribe una de las opciones");
                opcion = sn.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.println("Se han ocultado las cartas.");
                        memorama.juegoNuevo();
                        break;
                    case 2:
                        System.out.println("Juega tu partida actual.");
                        memorama.imprimir();
                        try {
                            System.out.println("Ingresa el indice de las cartas que "
                                    + "quieres voltear.\n" + "Primera Carta, valor x");
                            cux = sn.nextInt();
                            System.out.println("Primera Carta, valor y");
                            cuy = sn.nextInt();
                            System.out.println("Segunda Carta, valor x");
                            cdx = sn.nextInt();
                            System.out.println("Segunda Carta, valor y");
                            cdy = sn.nextInt();
                        } catch (Exception e) {
                            System.out.println("Debes ingresar un numero");
                            sn.next();
                        }
                        try {
                            memorama.juegaPartida(cux, cuy, cdx, cdy);
                        } catch (InvalidCardException e) {
                            System.out.println("Carta inválida.");
                        }
                        break;
                    case 3:
                        System.out.println("Escribe el nombre del archivo donde quieras "
                                + "guardar tu partida");
                        nombreArchivo = sn.next();
                        memorama.guardaPartida(nombreArchivo);
                        System.out.println("¡Partida guardada con exito!");
                        break;
                    case 4:
                        System.out.println("Escribe el nombre de un archivo que tenga guardada "
                                + "una partida.");
                        nombreArchivo = sn.next();
                        File aux = new File(nombreArchivo + ".txt");
                        if (aux.exists()) {
                            memorama.cargaPartida(nombreArchivo);
                            System.out.println("¡Partida cargada con exito!");
                            break;
                        }
                        System.out.println("No existe el archivo: " + nombreArchivo);
                        break;
                    case 0:
                        System.out.println("Hasta la proxima*Dubstep*");
                        salir = true;
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
