/**
 * Clase que implementa los algoritmos de ordenamiento selectionSort e
 * insertionSort.
 *
 * @author Sanchez Segura Cristian Alonso
 * @version 1.0 Abril 2020.
 */
public class Ordenador implements InterfazOrdenador {

    /**
     * Permite ordenar un arreglo de enteros con selectionSort.
     *
     * @param numeros el arreglo de números a ordenar.
     */
    @Override
    public int[] selectionSort(int[] numeros) {
        int[] sort = new int[numeros.length];
        for (int i = numeros.length - 1; i > 0; i--) {
            int valorMax = 0;
            for (int j = 0; j < i; j++) {
                if (numeros[j + 1] > numeros[valorMax]) {
                    valorMax = j + 1;
                }
            }
            intercambia(numeros, i, valorMax);
        }
        sort = numeros;
        return sort;
    }

    /**
     * Permite ordenar un arreglo de enteros con insertionSort.
     *
     * @param numeros el arreglo de números a ordenar.
     */
    @Override
    public int[] insertionSort(int[] numeros) {

        int[] insertion = new int[numeros.length];
        int valor = 0;
        int llave = 0;
        for (int i = 1; i < numeros.length; ++i) {
            valor = numeros[i];
            llave = i - 1;
            while (llave >= 0 && numeros[llave] > valor) {
                numeros[llave + 1] = numeros[llave];
                llave = llave - 1;
            }
            numeros[llave + 1] = valor;
        }
        insertion = numeros;
        return insertion;
    }

    /**
     * Metodo que intercambia dos elementos en un arreglo
     *
     * @param arreglo Arreglo en el cual se intercambiarán los elementos
     * @param primer Indice del primer elemento a intercambiar
     * @param segundo Indice del segundo elemento a intercambiar
     */
    public void intercambia(int[] arreglo, int primer, int segundo) {
        int valor = arreglo[segundo];
        arreglo[segundo] = arreglo[primer];
        arreglo[primer] = valor;
    }

    /**
     * Metodo que representa un arreglo de enteros
     *
     * @param arreglo Arreglo a representar
     */
    public void muestraArreglo(int arreglo[]) {
        String cadena = "{";
        for (int i = 0; i < arreglo.length; i++) {
            cadena += " " + Integer.toString(arreglo[i]);
        }
        cadena += " }";
        System.out.println(cadena);
    }

    public static void main(String[] args) {

        Ordenador sort = new Ordenador();

        System.out.println("Selection Sort\nArreglo desordenado");
        int[] desordenado = {2, 1, 2, 2, 5, 1, 2, 3, 2, 5, 1};
        sort.muestraArreglo(desordenado);
        int[] selection = sort.selectionSort(desordenado);
        System.out.println("Arreglo ordenado");
        sort.muestraArreglo(selection);

        System.out.println("\nArreglo desordenado");
        int[] desordenado2 = {1, 4, 2, 6, 7, 3, 8, 3, 8, 2, 1, 12, 641, 232, -12};
        sort.muestraArreglo(desordenado2);
        int[] selection2 = sort.selectionSort(desordenado2);
        System.out.println("Arreglo ordenado");
        sort.muestraArreglo(selection2);

        System.out.println("\nArreglo desordenado");
        int[] desordenado3 = {4, 27, 8, 3, 5, 1, 4, 8, 4, 6};
        sort.muestraArreglo(desordenado3);
        int[] selection3 = sort.selectionSort(desordenado3);
        System.out.println("Arreglo ordenado");
        sort.muestraArreglo(selection3);

        //
        System.out.println("\nInsertion Sort\nArreglo desordenado");
        int[] inserDes = {5,7,-1,3,5,-6,2,124,5112,-12,31,32};
        sort.muestraArreglo(inserDes);
        int[] insertion = sort.insertionSort(inserDes);
        System.out.println("Arreglo ordenado");
        sort.muestraArreglo(insertion);

        System.out.println("\nArreglo desordenado");
        int[] inserDes2 = {12,52,67,23,51,1345,123,432,1231,90};
        sort.muestraArreglo(inserDes2);
        int[] insertion2 = sort.insertionSort(inserDes2);
        System.out.println("Arreglo ordenado");
        sort.muestraArreglo(insertion2);

        System.out.println("\nArreglo desordenado");
        int[] inserDes3 = {9,8,7,6,5,4,3,2,1};
        sort.muestraArreglo(inserDes3);
        int[] insertion3 = sort.insertionSort(inserDes3);
        System.out.println("Arreglo ordenado");
        sort.muestraArreglo(insertion3);
    }
}
