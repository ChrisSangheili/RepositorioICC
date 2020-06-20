/**
 * Clase que simula una casa.
 *
 * @author Pedro Ulises Cervantes González
 *
 * @author Sanchez Segura Cristian Alonso
 * @version 2.0
 */
public class Casa extends Construccion {

    /**
     * El precio base de una casa
     */
    protected static double precioBase = 500000;

    /**
     * El precio actual de la construcción
     */
    protected double precioActual;

    /**
     * La zona de construcción donde estará
     */
    protected ZonaConstruccion zona;

    /**
     * Crea una nueva construcción.
     *
     * @param zona La zona donde estará
     */
    public Casa(ZonaConstruccion zona) {
        super(zona);
        this.zona = zona;
        precioActual = precioBase;
    }

    /**
     * Recalcula el precio actual.
     */
    @Override
    protected void recalculaPrecioActual() {
        
    }

    @Override
    public String[] toStringArray() {
        String[] array = new String[8];
        array[7] = "  ______  ";
        array[6] = " /      \\ ";
        array[5] = "/________\\";
        array[4] = "|        |";
        array[3] = "| _  [][]|";
        array[2] = "|| | [][]|";
        array[1] = "|| |     |";
        array[0] = "TTTTTTTTTT";
        return array;
    }
}
