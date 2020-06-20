
/**
 * Clase para crear animales.
 *
 * @author Sanchez Segura Cristian Alonso No. Cuenta: 314217547
 * @author Brando Dorantes Perez No. Cuenta: 314255356
 *
 * @version 1.0
 */
public class Animales {

    /*Animal que se creara*/
    String animal;

    /*Alas de un animal*/
    boolean alas;

    /*Patas de un animal*/
    boolean patas;

    /*Cola de una animal*/
    boolean cola;

    /**
     * Constructor que crea un animal, y recibe si tiene o no alguna parte de su
     * cuerpo.
     *
     * @param animal Tipo de animal que se crea.
     * @param alas Si tiene alas el animal creado.
     * @param patas Si tiene patas el animal creado.
     * @param cola Si tiene cola el animal creado.
     */
    public Animales(String animal, boolean alas, boolean patas, boolean cola) {
        this.animal = animal;
        this.alas = alas;
        this.patas = patas;
        this.cola = cola;
    }

    /**
     * Constructor que crea un animal, y recibe si tiene o no alguna parte de su
     * cuerpo.
     *
     * @param animal Tipo de animal que se crea.
     *
     */
    public Animales(String animal) {
        this.animal = animal;
    }

    /**
     * Metodo de acceso para el animal.
     *
     * @return el tipo de animal.
     */
    public String getAnimal() {
        return animal;
    }

    /**
     * Metodo que modifica nuestro animal
     *
     * @param animal Nuevo tipo de animal.
     */
    public void setAnimal(String animal) {
        this.animal = animal;
    }

    /**
     * Metodo que devuelve true si el animal tiene alas o false si no tiene esta
     * parte en su cuerpo.
     *
     * @return true si tiene alas, false en otro caso.
     */
    public boolean isAlas() {
        return alas;
    }

    /**
     * Metodo que modifica un atributo de un animal, cambia si el animal tiene
     * esa parte del cuerpo o ya no.
     *
     * @param alas true o false, si el animal cuenta con esa parte del cuerpo.
     */
    public void setAlas(boolean alas) {
        this.alas = alas;
    }

    /**
     * Metodo que devuelve true si el animal tiene patas o false si no tiene
     * esta parte en su cuerpo.
     *
     * @return true si tiene patas, false en otro caso.
     */
    public boolean isPatas() {
        return patas;
    }

    /**
     * Metodo que modifica un atributo de un animal, cambia si el animal tiene
     * esa parte del cuerpo o ya no.
     *
     * @param patas true o false, si el animal cuenta con esa parte del cuerpo.
     */
    public void setPatas(boolean patas) {
        this.patas = patas;
    }

    /**
     * Metodo que devuelve true si el animal tiene cola o false si no tiene esta
     * parte en su cuerpo.
     *
     * @return true si tiene cola, false en otro caso.
     */
    public boolean isCola() {
        return cola;
    }

    /**
     * Metodo que modifica un atributo de un animal, cambia si el animal tiene
     * esa parte del cuerpo o ya no.
     *
     * @param cola true o false, si el animal cuenta con esa parte del cuerpo.
     */
    public void setCola(boolean cola) {
        this.cola = cola;
    }

    /**
     * Devuelve la representacion de un animal
     *
     * @return La cadena con la representación de un animal
     */
    @Override
    public String toString() {
        return "Animal: " + animal + ". Tiene patas: " + isPatas()
                + ", tiene alas: " + isAlas() + ", tiene cola: " + isCola();
    }

    /**
     * Devuelve la representacion de un animal para la escritura de ficheros.
     *
     * @return La cadena con la representacion de un animal.
     */
    public String toFichero() {
        return animal + "," + isPatas() + "," + isAlas() + "," + isCola() + ",";
    }

}
