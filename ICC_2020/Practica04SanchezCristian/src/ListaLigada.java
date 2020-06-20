/**
 * Clase genérica para listas ligadas.
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
public class ListaLigada implements ListaInterfaz {

    /* Primer elemento de la lista. */
    private Nodo cabeza;
    /* Último elemento de la lista. */
    private Nodo rabo;
    /* Número de elementos en la lista. */
    private int longitud;

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
    public ListaInterfaz cola() {
        if (estaVacia()) {
            return null;
        }
        ListaLigada list = copia();
        list.eliminaPrimero();
        return list;
    }

    /**
     * Inserta un elemento al principio de la lista, desplazando todos los demás
     * elementos.
     *
     * @param objeto El elemento a insertar.
     */
    @Override
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
     * Inserta un elemento en la posición especificada de la lista, desplazando
     * todos los demás elementos.
     *
     * @param objeto El elemento a insertar.
     * @param indice La posición donde se insertará el objeto. La posición debe
     * ser mayor o igual a cero, y menor o igual al tamaño de la lista.
     */
    @Override
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
     * Inserta un elemento al final de la lista.
     *
     * @param objeto el objeto a agregar a la lista.
     */
    @Override
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
     * Concatena la lista invocante con una nueva lista.
     *
     * @param otra La lista con la que se concatenará.
     * @return La lista que resulta de la concatenación. Esta lista es
     * independiente a las otras dos.
     */
    @Override
    public ListaInterfaz concatena(ListaInterfaz otra) {
        ListaLigada listLinked = (ListaLigada) otra;
        ListaLigada concat = copia();
        Nodo n = listLinked.getCabeza();
        while (n != null) {
            concat.insertaFinal(n.elemento);
            n = n.siguiente;
        }
        return concat;

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
    public ListaLigada copia() {
        ListaLigada list = new ListaLigada();
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
        // Creamos la primer lista
        ListaLigada lista = new ListaLigada();

        //Imprimimos la lista
        System.out.println("Prueba toString");
        System.out.println("Lista recien creada.");
        System.out.println(lista);
        System.out.println("--------------------");

        //Verificamos el método tamanio
        System.out.println("Método tamaño");
        System.out.println("Longitud de la lista vacia");
        System.out.println(lista.tamanio());
        System.out.println("--------------------");

        //Verificamos el método cola
        System.out.println("Método cola");
        System.out.println(lista.cola());
        System.out.println("Regresa null porque la lista esta vacía");
        System.out.println("--------------------");

        //Verificamos el método insertaPrimero
        System.out.println("Método insertaPrimero");
        Integer diez = 10;
        lista.insertaPrimero(diez);
        System.out.println("Se agregó un elemento a la lista");
        System.out.println(lista);
        System.out.println("--------------------");

        //Verificamos el método inserta
        System.out.println("Método inserta");
        Integer dos = 2;
        lista.inserta(dos, 1);
        System.out.println("Se agregó un elemento en la lista, con el índice 1");
        System.out.println(lista);
        System.out.println("--------------------");

        //Verificamos el método insertaFinal
        System.out.println("Método insertaFinal");
        Integer cien = 100;
        lista.insertaFinal(cien);
        System.out.println("Se agregó un elemento al final de la lista");
        System.out.println(lista);
        System.out.println("--------------------");

        //Verificamos el método obtenPrimero
        System.out.println("Método obtenPrimero\nDebe devolver 10");
        System.out.println(lista.obtenPrimero());
        System.out.println("--------------------");

        //Verificamos el método obten
        System.out.println("Método obten, pasaremos como índice 2\n"
                + "Debe devolver 100");
        System.out.println(lista.obten(2));
        System.out.println("--------------------");

        //Verificamos el método eliminaPrimero
        System.out.println("Método eliminaPrimero");
        lista.eliminaPrimero();
        System.out.println("Lista modificada.\n" + lista);
        System.out.println("--------------------");

        //Verificamos el metodo elimina
        System.out.println("Metodo elimina\nPasamos como objeto 100\n"
                + "Debe eliminar el 100");
        lista.elimina(cien);
        System.out.println("Lista modificada\n" + lista);
        System.out.println("--------------------");

        //Verificamos el metodo indice
        System.out.println("Metodo indice\nPasamos como objeto 2"
                + "\nDebe devolver 0, que es la posición del objeto en la lista.");
        System.out.println(lista.indice(dos));
        System.out.println("--------------------");

        //Verificamos el metodo estaVacia
        System.out.println("Metodo estaVacia\nDebe devolver false, pues"
                + " tiene un elemento");
        System.out.println(lista.estaVacia());
        System.out.println("--------------------");

        //Verificamos el metodo concatena
        System.out.println("Metodo concatena");
        System.out.println("Creamos una nueva lista, la llenaremos con String"
                + "\nLas listas no deben ser heterogeneas, pero es para que sea mas "
                + "facil identificar.");
        System.out.println("Llenamos la lista original con enteros del 100 al 500\n"
                + "Se llenaran con enteros de 50 en 50");
        lista.limpia();
        for (int i = 100; i <= 500; i += 50) {
            lista.insertaFinal(i);
        }
        System.out.println("La lista con enteros modificada\n" + lista);
        System.out.println("\nLlenamos la lista con Strings");
        ListaLigada string = new ListaLigada();
        string.insertaFinal("C");
        string.insertaFinal("o");
        string.insertaFinal("n");
        string.insertaFinal("c");
        string.insertaFinal("a");
        string.insertaFinal("t");
        string.insertaFinal("e");
        string.insertaFinal("n");
        string.insertaFinal("a");
        System.out.println("Lista con strings modificada\n" + string);

        ListaLigada concatenada = (ListaLigada) lista.concatena(string);
        System.out.println("\nLista concatenada\n" + concatenada);
        System.out.println("--------------------");

        //Verificamos una vez mas el metodo tamanio
        System.out.println("Metodo tamaño\nProbamos con la nueva lista"
                + " concatenada");
        System.out.println(concatenada.tamanio());
        System.out.println("--------------------");

        //Verificamos una vez mas el metodo cola
        System.out.println("Metodo cola");
        System.out.println(concatenada.cola());
        System.out.println("--------------------");

        //Verificamos el metodo limpia
        System.out.println("Metodo limpia");
        System.out.println("Debe mostrar la lista vacia de longitud 0");
        concatenada.limpia();
        System.out.println("Lista limpiada: " + concatenada
                + "\nTamaño de la lista: " + concatenada.tamanio());
    }
}
