import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Clase para crear una fabrica.
 *
 * @author Sanchez Segura Cristian Alonso 
 * No. Cuenta: 314217547
 * @author Natalia Abasolo Cortes 
 * No. Cuenta: 314003119
 *
 * @version 1.0
*/
public class Fabricas {

    /*Catalogo de animales*/
    ListaLigada catalogo = new ListaLigada();

    /*Catalogo de alebrijes creados*/
    ListaLigada alebrijesCreados = new ListaLigada();

    /*Alebrije*/
    Alebrijes nuevoAlebrije;

    /*Nombre de la fabrica*/
    String nombre;

    /**
     * Constructor de una fabrica de alebrijes, asigna un nombre.
     *
     * @param nombre El nombre de la fabrica.
     */
    public Fabricas(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Metodo de acceso para el nombre de la fabrica.
     *
     * @return El nombre de la fabrica.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Metodo que devuelve la longitud del catalogo de animales.
     *
     * @return La longitud del catalogo de animales.
     */
    public int longitud() {
        return catalogo.getLongitud();
    }

    /**
     * Metodo que modifica el nombre de la fabrica.
     *
     * @param nombre El nuevo nombre de la fabrica.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Metodo que agrega animales ya hechos al catalogo.
     *
     */
    public void catalogoPrecargado() {
        Animales perro = new Animales("Perro", false, true, true);
        Animales gato = new Animales("Gato", false, true, true);
        Animales leon = new Animales("Leon", false, true, true);
        Animales pato = new Animales("Pato", true, true, true);

        agregarAnimal(perro);
        agregarAnimal(gato);
        agregarAnimal(leon);
        agregarAnimal(pato);
    }

    /**
     * Metodo que elimina el catalogo actual de animales.
     */
    public void eliminarCatalogo() {
        catalogo.limpia();
    }

    /**
     * Metodo que devuelve si un catalogo de animales esta vacio
     *
     * @return True si esta vacio, false en otro caso.
     */
    public boolean catalogoVacio() {
        return catalogo.estaVacia();
    }

    /**
     * Metodo que devuelve si un catalogo de alebrijes esta vacio
     *
     * @return True si esta vacio, false en otro caso.
     */
    public boolean alebrijesVacio() {
        return alebrijesCreados.estaVacia();
    }

    /**
     * Metodo que agrega un animal al catalogo.
     *
     * @param animal El animal agregado.
     */
    public void agregarAnimal(Animales animal) {
        catalogo.insertaFinal(animal);
    }

    /**
     * Metodo que elimina un animal del catalogo.
     *
     * @param indice Indice del animal que se quiere eliminar.
     */
    public void eliminarAnimal(int indice) {
        catalogo.elimina(indice);
    }

    /**
     * Metodo que muestra el catalogo de animales.
     *
     * @return Los animales disponibles.
     */
    public String mostrarCatalogo() {
        return catalogo.toString();
    }

    /**
     * Metodo que muestra el catalogo de alebrijes creados.
     *
     * @return Los alebrijes creados.
     */
    public String mostrarAlebrijes() {
        return alebrijesCreados.toString();
    }

    /**
     * Metodo que crea al alebrije y lo nombra.
     *
     * @param nombre Nombre del alebrije.
     */
    public void nombrarAlebrije(String nombre) {

        nuevoAlebrije = new Alebrijes(nombre);
    }

    /**
     * Metodo que coloca la cabeza del alebrije. Lo hace a partir del animal del
     * catalogo.
     *
     * @param cabeza Indice del animal en el catalogo, se tomará la cabeza del
     * animal.
     * @param colorCabeza el color que tendrá la cabeza.
     */
    public void colocarCabeza(int cabeza, String colorCabeza) {
        nuevoAlebrije.colocarCabeza(devolverAnimal(cabeza), colorCabeza);
    }

    /**
     * Metodo que coloca la cabeza del alebrije. Lo hace a partir del animal del
     * catalogo.
     *
     * @param cuerpo Indice del animal en el catalogo, se tomará el cuerpo del
     * animal.
     * @param colorCuerpo el color que tendrá el cuerpo.
     */
    public void colocarCuerpo(int cuerpo, String colorCuerpo) {
        nuevoAlebrije.colocarCuerpo(devolverAnimal(cuerpo), colorCuerpo);
    }

    /**
     * Metodo que coloca la cabeza del alebrije. Lo hace a partir del animal del
     * catalogo.
     *
     * @param patas Indice del animal en el catalogo, se tomará las patas del
     * animal.
     * @param colorPatas el color que tendrán las Patas.
     */
    public void colocarPatas(int patas, String colorPatas) {
        nuevoAlebrije.colocarPatas(devolverAnimal(patas), colorPatas);
    }

    /**
     * Metodo que coloca la cabeza del alebrije. Lo hace a partir del animal del
     * catalogo.
     *
     * @param Alas Indice del animal en el catalogo, se tomará las Alas del
     * animal.
     * @param colorAlas el color que tendrán las Alas.
     */
    public void colocarAlas(int alas, String colorAlas) {
        nuevoAlebrije.colocarAlas(devolverAnimal(alas), colorAlas);
    }

    /**
     * Metodo que coloca la cabeza del alebrije. Lo hace a partir del animal del
     * catalogo. Ademas termina de crear al alebrije y lo agrega a un catalogo
     * de alebrijes ya creados.
     *
     * @param cola Indice del animal en el catalogo, se tomará la Cola del
     * animal.
     * @param colorCola el color que tendrá la Cola.
     */
    public void colocarCola(int cola, String colorCola) {
        nuevoAlebrije.colocarCola(devolverAnimal(cola), colorCola);
    }

    /**
     * Metodo que termina de crear y agregar al catalogo de alebrijes un
     * alebrije nuevo.
     *
     * @return El alebrije terminado
     */
    public Alebrijes terminarAlebrije() {

        alebrijesCreados.insertaFinal(nuevoAlebrije);

        return nuevoAlebrije;
    }

    /**
     * Metodo que devuelve un animal del catalogo a partir de su indice.
     *
     * @return Animal devuelto.
     */
    public Animales devolverAnimal(int indice) {
        return (Animales) catalogo.obten(indice);
    }

    /**
     * Metodo toString de una fabrica
     *
     * @return la representacion de una fabrica en cadena
     */
    @Override
    public String toString() {
        return this.nombre + ".";
    }

    public static void main(String[] args) {

        Fabricas fab = new Fabricas("El Nuevo Axolotl");
        System.out.println("Bienevenido a la fabrica: " + fab);
        Scanner sn = new Scanner(System.in);
        Animales animalNuevo;
        boolean salir = false;
        int cabeza, cuerpo, patas, alas, cola;
        boolean patasB, alasB, colaB;
        int opcion; //Guardaremos la opcion del usuario
        int indice;
        String nombre;
        String colorCabeza, colorCuerpo, colorPatas;
        String colorAlas, colorCola;

        while (!salir) {

            System.out.println("1. Ver Catalogo\n" + "2. Agregar animal al catalogo\n"
                    + "3. Eliminar animal del catalogo.\n" + "4. Utilizar catalogo precargado.\n"
                    + "5. Crear alebrije.\n" + "6. Ver alebrijes creados.\n"
                    + "7. Eliminar catalogo actual de animales.\n" + "0. Salir.\n");

            try {

                System.out.println("\nEscribe una de las opciones\n");
                opcion = sn.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.println("\nCatalogo disponible:");
                        if (fab.catalogoVacio()) {
                            System.out.println("No tienes animales en tu catalogo\n");
                        } else {
                            System.out.println("Todos los animales disponibles:");
                            System.out.println(fab.mostrarCatalogo());
                        }
                        break;
                    case 2:
                        System.out.println("Agrega un animal al catalogo de animales:\n");
                        System.out.println("Ingresa un animal. Ej: perro, gato, serpiente, oso, etc.");
                        nombre = sn.next();
                        System.out.println("Un poco mas de información de tu animal.\n"
                                + "Escribe 1(Sí)/0(No) para mas info del animal\n"
                                + "¿Tu animal tiene patas?");
                        patas = sn.nextInt();
                        System.out.println("¿Tu animal tiene alas?");
                        alas = sn.nextInt();
                        System.out.println("¿Tu animal tiene cola?");
                        cola = sn.nextInt();
                        if (patas == 1) {
                            patasB = true;
                        } else {
                            patasB = false;
                        }
                        if (alas == 1) {
                            alasB = true;
                        } else {
                            alasB = false;
                        }
                        if (cola == 1) {
                            colaB = true;
                        } else {
                            colaB = false;
                        }
                        animalNuevo = new Animales(nombre, alasB, patasB, colaB);
                        fab.agregarAnimal(animalNuevo);
                        break;
                    case 3:
                        if (fab.catalogoVacio()) {
                            System.out.println("No tienes animales en tu catalogo para eliminar.");
                        } else {
                            System.out.println("Utiliza el indice del animal que quieras eliminar.");
                            indice = sn.nextInt();
                            if (indice < 0 || indice > fab.longitud()) {
                                System.out.println("Indice inválido");
                            } else {
                                System.out.println("Eliminaste el animal: " + fab.devolverAnimal(indice));
                                fab.eliminarAnimal(indice);
                            }
                        }
                        break;
                    case 4:
                        System.out.println("\nUtilizaras el catalogo precargado.\n");
                        fab.catalogoPrecargado();
                        break;
                    case 5:
                        if (fab.catalogoVacio()) {
                            System.out.println("No tienes animales en tu catalogo para crear alebrijes :(");
                        } else {
                            System.out.println("Ponle un nombre a tu alebrije.");
                            nombre = sn.next();
                            fab.nombrarAlebrije(nombre);
                            System.out.println("Del catalogo de animales, puedes seleccionar un animal con su indice "
                                    + "para colocar la parte de su cuerpo en tu alebrije, ademas de asignarle un color");
                            System.out.println(fab.mostrarCatalogo());
                            System.out.println("Selecciona la cabeza de tu alebrije");
                            cabeza = sn.nextInt();
                            System.out.println("Escoge el color de la cabeza.");
                            colorCabeza = sn.next();
                            fab.colocarCabeza(cabeza, colorCabeza);

                            System.out.println("Selecciona el cuerpo de tu alebrije");
                            cuerpo = sn.nextInt();
                            System.out.println("Escoge el color del cuerpo");
                            colorCuerpo = sn.next();
                            fab.colocarCuerpo(cuerpo, colorCuerpo);

                            System.out.println("Selecciona las patas de tu alebrije");
                            patas = sn.nextInt();
                            System.out.println("Escoge el color de las patas");
                            colorPatas = sn.next();
                            fab.colocarPatas(patas, colorPatas);

                            System.out.println("\n¿Quieres que tu alebrije tenga alas? 1(Sí)/0(No)\nRecuerda que debes tener un animal "
                                    + "con alas en tu catalogo, de lo contrario, no se le asignaran alas.");
                            alas = sn.nextInt();
                            if (alas == 1) {
                                System.out.println("Selecciona las alas de tu alebrije");
                                indice = sn.nextInt();
                                System.out.println("Escoge el color de las alas");
                                colorAlas = sn.next();
                                fab.colocarAlas(indice, colorAlas);
                            }
                            System.out.println("Selecciona la cola de tu alebrije");
                            cola = sn.nextInt();
                            System.out.println("Escoge el color de la cola.");
                            colorCola = sn.next();
                            fab.colocarCola(cola, colorCola);

                            System.out.println("Terminaste de crear a tu alebrije\n"
                                    + fab.terminarAlebrije() + "\n¡Felicidades!");
                        }
                        break;
                    case 6:
                        if (fab.alebrijesVacio()) {
                            System.out.println("\nNo has creado alebrijes :(\n");
                        } else {
                            System.out.println("\nAlebrijes que has creado :)\n");
                            System.out.println(fab.mostrarAlebrijes());
                        }
                        break;
                    case 7:
                        fab.eliminarCatalogo();
                        System.out.println("Se ha eliminado el catalogo actual de alebrijes.\n");
                        break;
                    case 0:
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo números entre 0 y 6");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }
        }

    }
}
