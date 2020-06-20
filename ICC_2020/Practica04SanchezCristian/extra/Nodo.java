/**
 * Clase Nodo privada para uso interno de la clase ListaLigada.
 *
 * @author Sanchez Segura Cristian Alonso.
 * No. cuenta: 314217547
 * @version 1.0 23/04/20
 */
public class Nodo {

    /*El elemento del nodo.*/
    public Object elemento;
    /* El nodo anterior. */
    public Nodo anterior;
    /* El nodo siguiente. */
    public Nodo siguiente;

    /* Construye un nodo con un elemento. */
    public Nodo(Object elemento) {
        this.elemento = elemento;
    }

    /*Metodo de acceso del elemento*/
    public Object getElemento() {
        return elemento;
    }

    /*Metodo mutante del elemento*/
    public void setElemento(Object elemento) {
        this.elemento = elemento;
    }

    /*Metodo de acceso del nodo anterior*/
    public Nodo getAnterior() {
        return anterior;
    }

    /*Metodo mutante del nodo anterior*/
    public void setAnterior(Nodo anterior) {
        this.anterior = anterior;
    }

    /*Metodo de acceso del nodo siguiente*/
    public Nodo getSiguiente() {
        return siguiente;
    }

    /*Metodo mutante del nodo siguiente*/
    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

}
