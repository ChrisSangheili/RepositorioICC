
/**
 * Clase para crear alebrijes.
 *
 * @author Sanchez Segura Cristian Alonso No. Cuenta: 314217547
 * @author Brando Dorantes Perez No. Cuenta: 314255356
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

    /*Alebrije creado*/
    String alebrijeCreado;

    /*Cabeza del alebrije*/
    Animales cabeza;

    /*Color de la cabeza del alebrije*/
    String colorCabeza;

    /*Cabeza del alebrije*/
    Animales cuerpo;

    /*Color del cuerpo del alebrije*/
    String colorCuerpo;

    /*Cabeza del alebrije*/
    Animales patas;

    /*Color de las patas del alebrije*/
    String colorPatas;

    /*Cabeza del alebrije*/
    Animales cola;

    /*Color de la cola del alebrije*/
    String colorCola;

    /**
     * Constructor de un alebrije. Es un arreglo de tamaño 4, se inicializa con
     * un nombre para el alebrije.
     *
     * @param nombre Nombre que recibe el alebrije. public Alebrijes(String
     * nombre) { this.alebrije = new String[5]; this.nombre = nombre; }
     */
    /**
     * Constructor de un alebrije. Es un arreglo de tamaño 4, se inicializa con
     * un nombre para el alebrije.
     *
     * @param nombre Nombre que recibe el alebrije.
     */
    public Alebrijes(String nombre) {
        this.alebrije = new String[4];
        this.nombre = nombre;
    }

    public Alebrijes(String alebrijeCreado, boolean nuevo) {
        this.alebrije = new String[4];
        this.alebrijeCreado = alebrijeCreado;
        toAlebrije(alebrijeCreado);

    }

    private void toAlebrije(String alebrijeCreado) {

        String[] alebrijeNuevo = alebrijeCreado.split(",");
        setNombre(alebrijeNuevo[0]);
        Animales cabezaA = new Animales(alebrijeNuevo[1]);
        colocarCabeza(cabezaA, alebrijeNuevo[2]);
        Animales cuerpoA = new Animales(alebrijeNuevo[3]);
        colocarCuerpo(cuerpoA, alebrijeNuevo[4]);
        Animales patasA = new Animales(alebrijeNuevo[5]);
        colocarPatasAux(patasA, alebrijeNuevo[6]);
        Animales colaA = new Animales(alebrijeNuevo[7]);
        colocarColaAux(colaA, alebrijeNuevo[8]);
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
     * Metodo de acceso para La cabeza del alebrije.
     *
     * @return La cabeza del alebrije.
     */
    public Animales getCabeza() {
        return cabeza;
    }

    /**
     * Metodo que modifica la cabeza de un alebrije.
     *
     * @param cabeza La nueva cabeza del alebrije.
     */
    public void setCabeza(Animales cabeza) {
        this.cabeza = cabeza;
    }

    /**
     * Metodo de acceso para el color de la cabeza del alebrije.
     *
     * @return El color de la cabeza del alebrije.
     */
    public String getColorCabeza() {
        return colorCabeza;
    }

    /**
     * Metodo que modifica el color de la cabeza de un alebrije.
     *
     * @param coloCabeza El nuevo color de la cabeza del alebrije.
     */
    public void setColorCabeza(String colorCabeza) {
        this.colorCabeza = colorCabeza;
    }

    /**
     * Metodo de acceso para el cuerpo del alebrije.
     *
     * @return El cuerpo del alebrije.
     */
    public Animales getCuerpo() {
        return cuerpo;
    }

    /**
     * Metodo que modifica el cuerpo de un alebrije.
     *
     * @param cuerpo El nuevo cuerpo del alebrije.
     */
    public void setCuerpo(Animales cuerpo) {
        this.cuerpo = cuerpo;
    }

    /**
     * Metodo de acceso para el color del cuerpo del alebrije.
     *
     * @return El color del cuerpo del alebrije.
     */
    public String getColorCuerpo() {
        return colorCuerpo;
    }

    /**
     * Metodo que modifica el color del cuerpo de un alebrije.
     *
     * @param colorCuerpo El nuevo color del cuerpo del alebrije.
     */
    public void setColorCuerpo(String colorCuerpo) {
        this.colorCuerpo = colorCuerpo;
    }

    /**
     * Metodo de acceso para las patas del alebrije.
     *
     * @return Las patas del alebrije.
     */
    public Animales getPatas() {
        return patas;
    }

    /**
     * Metodo que modifica las patas de un alebrije.
     *
     * @param patas Las nuevas patas del alebrije.
     */
    public void setPatas(Animales patas) {
        this.patas = patas;
    }

    /**
     * Metodo de acceso para el color de las patas del alebrije.
     *
     * @return El color de las patas del alebrije.
     */
    public String getColorPatas() {
        return colorPatas;
    }

    /**
     * Metodo que modifica el color de las patas de un alebrije.
     *
     * @param colorPatas El nuevo color de las patas del alebrije.
     */
    public void setColorPatas(String colorPatas) {
        this.colorPatas = colorPatas;
    }

    /**
     * Metodo de acceso para la cola del alebrije.
     *
     * @return La cola del alebrije.
     */
    public Animales getCola() {
        return cola;
    }

    /**
     * Metodo que modifica la cola de un alebrije.
     *
     * @param cola La nueva cola del alebrije.
     */
    public void setCola(Animales cola) {
        this.cola = cola;
    }

    /**
     * Metodo de acceso para el color de la cola del alebrije.
     *
     * @return El color de la cola del alebrije.
     */
    public String getColorCola() {
        return colorCola;
    }

    /**
     * Metodo que modifica el color de la cabeza de un alebrije.
     *
     * @param colorCola El nuevo color de la cabeza del alebrije.
     */
    public void setColorCola(String colorCola) {
        this.colorCola = colorCola;
    }

    /**
     * Metodo que le coloca la cabeza al alebrije.
     *
     * @param cabeza La cabeza de un animal.
     * @param color Asigna el color de dicha parte al alebrije.
     */
    public void colocarCabeza(Animales cabeza, String color) {
        this.cabeza = cabeza;
        this.colorCabeza = color;
        alebrije[0] = "cabeza de " + this.cabeza.getAnimal()
                + " color " + this.colorCabeza + ", ";
    }

    /**
     * Metodo que coloca el cuerpo al alaberije
     *
     * @param cuerpo El cuerpo de un animal.
     * @param color Asigna el color de dicha parte al alebrije.
     */
    public void colocarCuerpo(Animales cuerpo, String color) {
        this.cuerpo = cuerpo;
        this.colorCuerpo = color;
        alebrije[1] = "cuerpo de " + this.cuerpo.getAnimal()
                + " color " + this.colorCuerpo + ", ";
    }

    /**
     * Metodo que coloca las patas al alebrije. Si el animal no tiene patas,
     * como por ejemplo una serpiente, no se le colocan las patas.
     *
     * @param patas Las patas de un animal
     * @param color Asigna el color de dicha parte al alebrije.
     */
    public void colocarPatas(Animales patas, String color) {
        this.patas = patas;
        this.colorPatas = color;
        if (patas.isPatas()) {
            alebrije[2] = "patas de " + this.patas.getAnimal() + " color "
                    + this.colorPatas + ", ";
        } else {
            alebrije[2] = "none";
        }
    }

    /**
     * Metodo que coloca las patas al alebrije. Si el animal no tiene patas,
     * como por ejemplo una serpiente, no se le colocan las patas.
     *
     * @param patas Las patas de un animal
     * @param color Asigna el color de dicha parte al alebrije.
     */
    public void colocarPatasAux(Animales patas, String color) {
        this.patas = patas;
        this.colorPatas = color;
        alebrije[2] = "patas de " + this.patas.getAnimal() + " color "
                + this.colorPatas + ", ";
    }

    /**
     * Metodo que coloca la cola al alebrije. Si el animal tiene alas, se le
     * colocan, sino, se deja en blanco.
     *
     * @param cola Las cola de un animal.
     * @param color Asigna el color de dicha parte al alebrije.
     */
    public void colocarCola(Animales cola, String color) {
        this.cola = cola;
        this.colorCola = color;
        if (cola.isCola()) {
            alebrije[3] = "cola de " + this.cola.getAnimal()
                    + " color " + this.colorCola + ".";
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
    public void colocarColaAux(Animales cola, String color) {
        this.cola = cola;
        this.colorCola = color;
        alebrije[3] = "cola de " + this.cola.getAnimal()
                + " color " + this.colorCola + ".";
    }

    /**
     * Metodo toString, representa un alebrije ya hecho.
     *
     * @return El alebrije formado.
     */
    @Override
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

    /**
     * Devuelve la representacion de un alebrije para la escritura de ficheros.
     *
     * @return La cadena con la representacion de un alebrije.
     */
    public String toFichero() {
        return nombre + "," + cabeza.getAnimal() + "," + colorCabeza + "," + cuerpo.getAnimal() + ","
                + colorCuerpo + "," + patas.getAnimal() + "," + colorPatas + "," + cola.getAnimal() + ","
                + colorCola;
    }
}
