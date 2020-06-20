
/**
 * Clase que crea una carta
 *
 * @author Sanchez Segura Cristian Alonso No. Cuenta: 314217547
 * @author Brando Dorantes Perez No. Cuenta: 314255356
 */
public class Carta {

    /*Simbolo que representa a la carta*/
    String simbolo;

    /*Se puede ver la carta*/
    boolean visible;

    /**
     * Constructor de la clase Carta
     *
     * @param simbolo El simbolo que tendrá
     */
    public Carta(String simbolo) {
        this.simbolo = simbolo;
    }

    /**
     * Constructor de la clase Carta
     *
     * @param simbolo El simbolo que tiene.
     * @param visible Si la carta es visible.
     */
    public Carta(String simbolo, String visible) {
        this.simbolo = simbolo;
        if (visible.equals("true")) {
            this.visible = true;
        } else {
            this.visible = false;
        }
    }

    /**
     * Metodo que devuelve el simbolo de una carta.
     *
     * @return el simbolo de una carta.
     */
    public String getSimbolo() {
        return simbolo;
    }

    /**
     * Metodo que modifica el simbolo de una carta.
     *
     * @param simbolo Simbolo nuevo de la carta.
     */
    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    /**
     * Metodo que devuelve si una carta es visible.
     *
     * @return True si es visible, false si no es visible.
     */
    public boolean isVisible() {
        return visible;
    }

    /**
     * Metodo que modifica la visibilidad de una carta.
     *
     * @param visible True si es visible, false si no es visible.
     */
    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    /**
     * Metodo que voltea una carta, es decir, la vuelve visible o invisible.
     */
    public void voltear() {
        this.visible = !visible;
    }

    /**
     * Metodo que devuelve una representación de una carta para utilizarse en un
     * archivo.
     */
    public String toArchivo() {
        return this.simbolo + "," + this.visible;
    }

    /**
     * Metodo toString de la clase carta
     *
     * @return la representacion de la carta.
     */
    @Override
    public String toString() {
        if (isVisible()) {
            return simbolo;
        }
        return "  ";
    }
}
