/**
 *
 * Clase Personaje, clase padre para generar personajes para el videojuego de
 * rol.
 *
 * @author Cristian Alonso Sanchez Segura
 * @version 1.0
 */
public class Personaje {

    /*Nombre del personaje*/
    protected String nombre;

    /*Vida del personaje*/
    protected int vida;

    /**
     * Constructor de la clase personaje, asigna un valor de 100 de vida al
     * personaje.
     */
    public Personaje(String nombre) {

        this.nombre = nombre;
        this.vida = 100;

    }

    /**
     * Metodo que recupera vida de un personaje. Rellena la vida faltante de tu
     * personaje hasta el valor que recibe.
     *
     * @param vidaRecuperada La cantidad de vida a recuperar.
     */
    protected void recuperarVida(int vidaRecuperada) {
        for (int i = 1; i <= vidaRecuperada; i++) {
            if (this.vida > 0 && this.vida < 100) {
                this.vida++;
            }
        }
        System.out.println(getNombre() + " recupero: " + vidaRecuperada
                + "pts de vida. Vida total: " + getVida());
    }

    /**
     * Metodo que devuelve el nombre del personaje.
     *
     * @return Nombre del personaje.
     */
    protected String getNombre() {
        return nombre;
    }

    /**
     * Metodo que asgina un nombre a un personaje.
     *
     * @param nombre El nombre del personaje.
     */
    protected void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Metodo que devuelve la vida del personaje.
     *
     * @return Vida del personaje.
     */
    protected int getVida() {
        return vida;
    }

    /**
     * Metodo que recibe el daño al personaje
     *
     * @param vidaRecibida Los puntos de vida que se restaran a la vida de
     * nuestro personaje.
     */
    public void setVida(int vidaRecibida) {
        this.vida = vida - vidaRecibida;
        System.out.println(getNombre() + " recibió: " + vidaRecibida
                + "pts de daño. Vida total: " + this.vida);
    }

    /**
     * Metodo que ataca a un enemigo, selecciona entre dos de los ataques del
     * personaje.
     *
     * @return el ataque realizado.
     */
    public int atacar() {
        return 0;
    }

    /**
     * Metodo para recuperar vida, recupera 10% de la vida total, se manda a
     * llamar despues de cada ataque.
     */
    public void recuperar() {

    }

    /**
     * Metodo toString de la clase personaje.
     *
     * @return Representacion de un personaje.
     */
    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Vida: " + vida;
    }

}
