/**
 * Clase genérica para listas ligadas ordenadas.
 *
 * Las listas nos permiten agregar elementos al inicio o al final de estas,
 * eliminar elementos, comprobar si un elemento está o no en la lista, junto con
 * otras operaciones básicas.
 *
 * Las listas no aceptan a <code>null<code> como elemento.
 *
 * @author Sanchez Segura Cristian Alonso.
 * No. cuenta: 314217547
 * @version 1.0 23/04/20
 */

public class ListaOrdenada implements ListaOrdenadaInterfaz{

    /* Primer elemento de la lista. */
    private Nodo cabeza;
    /* Último elemento de la lista. */
    private Nodo rabo;
    /* Número de elementos en la lista. */
    private int longitud;
    /* Ultimo agregado a la lista.*/
    private int ultimoAgregado;

    /**
    * Metodo de acceso para la cabeza de una lista
    * 
    * @return La cabeza de la lista
    */
    public Nodo getCabeza() {
        return cabeza;
    }

    /** 
    * Metodo de acceso para la cola de la lista,
    * el ultimo nodo
    * 
    * @return El ultimo nodo de la lista
    */
    public Nodo getRabo() {
        return rabo;
    }

    /**
    * Metodo de acceso para saber la longitud de la lista
    * El metodo longitud y tamanio son iguales
    * 
    * @return La longitd de la lista. Si esta vacia devuelve cero.
    */
    public int getLongitud() {
        return longitud;
    }

    /**
     * Devuelve el tamaño de la lista.
     *
     * @return El tamaño de la lista. Si está vacía devuelve cero.
     */
    @Override
    public int tamanio() {
        return longitud;
    }

    /**
     * Devuelve la cola de la lista.
     *
     * @return Una lista con todos los elementos de le invocante menos el
     * primero. Regresa null si la lista es vacia.
     */
    @Override
    public ListaOrdenadaInterfaz cola() {
        if (estaVacia()) {
            return null;
        }
        ListaOrdenada list = copia();
        list.eliminaPrimero();
        return list;
    }

    /**
     * Inserta un elemento en el lugar que le corresponde de la lista, desplazando todos los
     * demás elementos.
     * 
     * @param objeto El elemento a insertar.
     */
    @Override
    public void insertaEnOrden(Object objeto){

        if (objeto == null) {
            System.out.println("El objeto es null");
        }
        if (estaVacia()) {
            insertaPrimero(objeto);
            ultimoAgregado = (Integer)objeto;
            return;
        }
        if ((Integer)objeto < (Integer)cabeza.elemento) {
            insertaPrimero(objeto);
            ultimoAgregado = (Integer)objeto;
            return;
        }

        if((Integer)objeto > (Integer)rabo.elemento){
        	insertaFinal(objeto);
        	ultimoAgregado = (Integer)objeto;
        	return;
        }
        
        int pos = indice((Integer)ultimoAgregado);
        if((Integer)objeto > ultimoAgregado){
        	inserta(objeto,pos+1);
        	ultimoAgregado = (Integer)objeto;
        	return;
        }else{
        	inserta(objeto,pos-1);
        	ultimoAgregado = (Integer)objeto;
        	return;
        }
    }

    /**
     * Elimina el primer elemento de la lista y actualiza la cabeza de la lista
     */
    @Override
    public void eliminaPrimero() {
        if (estaVacia()) {
            System.out.println("No hay elementos en la lista");
        }
        Object n = cabeza.elemento;
        if (longitud == 1) {
            cabeza = null;
            rabo = null;
        }
        if (longitud > 1) {
            cabeza = cabeza.siguiente;
            cabeza.anterior = null;
        }
        longitud--;
    }

    /**
     * Elimina un elemento en la posición especificada de la lista, desplazando
     * todos los demás elementos.
     *
     * @param indice La posición donde se eliminará el objeto. La posición debe
     * ser mayor o igual a cero, y menor al tamaño de la lista.
     */
    @Override
    public void elimina(int indice) {
        Object n = obten(indice);
        elimina(n);
    }

    /**
     * Devuelve el primer elemento de la lista.
     *
     * @return El primer elemento de la lista. Si la lista está vacía, devuelve
     * null.
     */
    @Override
    public Object obtenPrimero() {
        if (estaVacia()) {
            System.out.println("No hay elementos en la lista");
            return null;
        }
        return cabeza.elemento;
    }

    /**
     * Devuleve el elemento en la posición especificada de la lista.
     *
     * @param indice La posición donde se encuentra el objeto. La posición debe
     * ser mayor o igual a cero, y menor al tamaño de la lista.
     * @return El elemento en la posición especificada. Si la posición es
     * inválida devuelve null.
     */
    @Override
    public Object obten(int indice) {
        if (indice < 0 || indice >= longitud) {
            return null;
        }
        Nodo n = cabeza;
        int aux = 0;
        while (aux < indice) {
            n = n.siguiente;
            aux++;
        }
        return n.elemento;
    }

    /**
     * Busca un elemento en la lista y devuelve la primera posición donde
     * aparece.
     *
     * @return El índice del objeto. Si no lo encuentra, devuelve -1.
     */
    @Override
    public int indice(Object objeto) {
        Nodo n = cabeza;
        int aux = 0;
        while (n != null) {
            if (n.elemento.equals(objeto)) {
                return aux;
            }
            aux++;
            n = n.siguiente;
        }
        return -1;

    }

    /**
     * Menciona si la lista no tiene elementos
     *
     * @return true si la lista no tiene elementos, false en otro caso.
     */
    @Override
    public boolean estaVacia() {
        return longitud == 0;
    }

    /**
     * Combina la lista invocante con una nueva lista.
     * 
     * @param otra La lista con la que se combinará.
     * @return Una lista ordenada con los elementos de ambas listas. Esta lista 
     *         es independiente a las otras dos.
     */
    public ListaOrdenadaInterfaz combina(ListaOrdenadaInterfaz otra){
    	return null;
    }

    /**
     * Vacia la lista. Elimina todos los elementos.
     */
    @Override
    public void limpia() {
        longitud = 0;
        cabeza = null;
        rabo = null;
    }

    //Metodos auxiliares

    /**
     * Inserta un elemento en la posición especificada de la lista, desplazando
     * todos los demás elementos.
     *
     * @param objeto El elemento a insertar.
     * @param indice La posición donde se insertará el objeto. La posición debe
     * ser mayor o igual a cero, y menor o igual al tamaño de la lista.
     */
    public boolean inserta(Object objeto, int indice) {
        if (objeto == null) {
            return false;
        }
        if (indice < 1) {
            insertaPrimero(objeto);
            return true;
        }
        if (indice >= longitud) {
            insertaFinal(objeto);
            return true;
        }
        Nodo n = new Nodo(objeto);
        Nodo m = cabeza;
        while (indice-- > 1) {
            m = m.siguiente;
        }
        n.anterior = m;
        n.siguiente = m.siguiente;
        m.siguiente.anterior = n;
        m.siguiente = n;
        longitud++;
        return true;
    }

    /**
     * Inserta un elemento al principio de la lista, desplazando todos los demás
     * elementos.
     *
     * @param objeto El elemento a insertar.
     */
    public void insertaPrimero(Object objeto) {
        if (objeto == null) {
            System.out.println("El objeto es null");
        }
        Nodo n = new Nodo(objeto);
        if (estaVacia()) {
            cabeza = n;
            rabo = n;
        } else {
            cabeza.anterior = n;
            n.siguiente = cabeza;
            cabeza = n;
        }
        longitud++;
    }

    /**
     * Metodo auxiliar que elimina un elemento de la lista. Si el elemento no
     * está contenido en la lista, el método no la modifica.
     *
     * @param elemento el elemento a eliminar.
     */
    public void elimina(Object elemento) {
        if (elemento == null) {
            return;
        }
        Nodo n = encuentraNodoAux(elemento);
        if (n == null) {
            return;
        }
        if (cabeza == rabo) {
            cabeza = null;
            rabo = null;
            longitud--;
            return;
        }
        if (cabeza == n) {
            eliminaPrimero();
            return;
        }
        if (rabo == n) {
            eliminaUltimo();
            return;
        }

        n.anterior.siguiente = n.siguiente;
        n.siguiente.anterior = n.anterior;
        longitud--;
    }

    /**
     * Es un metodo auxiliar que busca y regresa el nodo que contenga al
     * elemento
     *
     * @return el nodo con el elemento buscado
     */
    private Nodo encuentraNodoAux(Object elemento) {
        Nodo n = cabeza;
        while (n != null) {
            if (n.elemento.equals(elemento)) {
                return n;
            } else {
                n = n.siguiente;
            }
        }
        return n;
    }

    /**
     * Inserta un elemento al final de la lista.
     *
     * @param objeto el objeto a agregar a la lista.
     */
    public void insertaFinal(Object objeto) {
        if (objeto == null) {
            System.out.println("El objeto es null");
        }
        Nodo n = new Nodo(objeto);
        if (estaVacia()) {
            rabo = n;
            cabeza = n;
        } else {
            rabo.siguiente = n;
            n.anterior = rabo;
            rabo = n;
        }
        longitud++;
    }

    /**
     * Metodo auxiliar que elimina el último elemento de la lista y lo regresa.
     *
     * @return el último elemento de la lista antes de eliminarlo.
     */
    public Object eliminaUltimo() {
        if (estaVacia()) {
            System.out.println("No hay elementos en la lista");
            return null;
        }
        Object n = rabo.elemento;
        if (longitud == 1) {
            cabeza = null;
            rabo = null;
        }
        if (longitud > 1) {
            rabo = rabo.anterior;
            rabo.siguiente = null;
        }
        longitud--;
        return n;
    }

    /**
     * Metodo auxiliar que regresa una copia de la lista. La copia tiene los
     * mismos elementos que la lista que manda llamar el método, en el mismo
     * orden.
     *
     * @return una copia de la lista.
     */
    public ListaOrdenada copia() {
        ListaOrdenada list = new ListaOrdenada();
        Nodo n = cabeza;
        while (n != null) {
            list.insertaFinal(n.elemento);
            n = n.siguiente;
        }
        return list;
    }

    /**
     * Regresa una representación en cadena de la lista.
     *
     * @return una representación en cadena de la lista.
     */
    @Override
    public String toString() {
        if (estaVacia()) {
            return "[]";
        }
        Nodo n = cabeza;
        String aux = "[" + n.elemento;
        n = n.siguiente;
        while (n != null) {
            aux += ", " + n.elemento;
            n = n.siguiente;
        }
        aux += "]";
        return aux;
    }
    public static void main(String[] args) {
    	
    	ListaOrdenada list = new ListaOrdenada();
    	Integer cien = 100;
    	Integer quince = 15;
    	Integer diez = 10;
    	Integer cinco = 5;
        Integer uno = 1;
        Integer dos = 2;
        Integer tres = 3;
    	System.out.println(list);
    	list.insertaEnOrden(quince);
        System.out.println(list);
    	list.insertaEnOrden(diez);
        System.out.println(list);
    	list.insertaEnOrden(cinco);
    	System.out.println(list);
    	list.insertaEnOrden(cien);
        System.out.println(list);
        list.insertaEnOrden(uno);
        System.out.println(list);
        list.insertaEnOrden(dos);
        System.out.println(list);
        list.insertaEnOrden(tres);
        System.out.println(list);
    }
}