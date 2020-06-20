/**
 * Clase para crear alebrijes.
 *
 * @author Sanchez Segura Cristian Alonso 
 * No. Cuenta: 314217547
 * @author Natalia Abasolo Cortes 
 * No. Cuenta: 314003119
 *
 * @version 1.0
*/
public class Alebrijes {

    /*Arreglo que representa a un alebrije*/
    String[] alebrije;

    /*Nombre del alebrije*/
    String nombre;

    /*Alebrije completo*/
    String alebrijeCompleto;

    /**
     * Constructor de un alebrije. Es un arreglo de tamaño 4, se inicializa con
     * un nombre para el alebrije.
     *
     * @param nombre Nombre que recibe el alebrije.
     */
    public Alebrijes(String nombre) {
        this.alebrije = new String[5];
        this.nombre = nombre;
    }

    /**
     * Metodo de acceso para el nombre del alebrije.
     *
     * @return El nombre del alebrije.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Metodo que modifica el nombre de un alebrije.
     *
     * @param nombre El nuevo nombre del alebrije.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Metodo que le coloca la cabeza al alebrije.
     *
     * @param cabeza La cabeza de un animal.
     * @param color Asigna el color de dicha parte al alebrije.
     */
    public void colocarCabeza(Animales cabeza, String color) {
        alebrije[0] = "cabeza de " + cabeza.getAnimal()
                + " color " + color + ", ";
    }

    /**
     * Metodo que coloca el cuerpo al alaberije
     *
     * @param cuerpo El cuerpo de un animal.
     * @param color Asigna el color de dicha parte al alebrije.
     */
    public void colocarCuerpo(Animales cuerpo, String color) {
        alebrije[1] = "cuerpo de " + cuerpo.getAnimal()
                + " color " + color + ", ";
    }

    /**
     * Metodo que coloca las patas al alebrije. Si el animal no tiene patas,
     * como por ejemplo una serpiente, no se le colocan las patas.
     *
     * @param patas Las patas de un animal
     * @param color Asigna el color de dicha parte al alebrije.
     */
    public void colocarPatas(Animales patas, String color) {
        if (patas.isPatas()) {
            alebrije[2] = "patas de " + patas.getAnimal() + " color "
                    + color + ", ";
        } else {
            alebrije[2] = "none";
        }
    }

    /**
     * Metodo que coloca las alas al alebrije. Si el animal tiene alas, se le
     * colocan, sino, se deja en blanco.
     *
     * @param alas Las alas de un animal.
     * @param color Asigna el color de dicha parte al alebrije.
     */
    public void colocarAlas(Animales alas, String color) {
        if (alas.isAlas()) {
            alebrije[3] = "alas de " + alas.getAnimal()
                    + " color " + color + ", ";
        } else {
            alebrije[3] = "none";
        }
    }

    /**
     * Metodo que coloca la cola al alebrije. Si el animal tiene alas, se le
     * colocan, sino, se deja en blanco.
     *
     * @param cola Las cola de un animal.
     * @param color Asigna el color de dicha parte al alebrije.
     */
    public void colocarCola(Animales cola, String color) {
        if (cola.isCola()) {
            alebrije[4] = "cola de " + cola.getAnimal()
                    + " color " + color + ".";
        } else {
            alebrije[4] = "none";
        }
    }

    /**
     * Metodo toString, representa un alebrije ya hecho
     *
     * @return El alebrije formado.
     */
    public String toString() {
        alebrijeCompleto = getNombre() + ": ";
        for (int i = 0; i < alebrije.length; i++) {
            if (alebrije[i] != null) {
                if (alebrije[i] != "none") {
                    alebrijeCompleto += alebrije[i];
                }
            }
        }
        return alebrijeCompleto;
    }
}
