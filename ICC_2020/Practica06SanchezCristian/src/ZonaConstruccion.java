/**
 * Clase que simula una zona con cierto número de construcciones.
 *
 * @author Pedro Ulises Cervantes González
 * @version 1.0
 */
public class ZonaConstruccion {

    /**
     * Las construcciones de la zona
     */
    protected Construccion[] construcciones;

    /**
     * Crea una nueva zona de construcción.
     *
     * @param nCons El número de construcciones que habrá.
     */
    public ZonaConstruccion(int nCons) {
        construcciones = new Construccion[nCons];
        for (int i = 0; i < nCons; i++) {
            construcciones[i] = new Construccion(this);
        }
    }

    /**
     * Devuelve las construcciones
     *
     * @return Las construcciones
     */
    public Construccion[] getConstrucciones() {
        return construcciones;
    }

    @Override
    public String toString() {
        String[][] consArray = new String[construcciones.length][];
        int max = 0;
        for (int i = 0; i < construcciones.length; i++) {
            consArray[i] = construcciones[i].toStringArray();
            if (max < consArray[i].length) {
                max = consArray[i].length;
            }
        }
        String cad = "";
        for (int i = max - 1; i >= 0; i--) {
            for (int j = 0; j < consArray.length; j++) {
                if (i >= consArray[j].length) {
                    cad += Construccion.cielo();
                } else {
                    cad += consArray[j][i];
                }
                if (j < consArray.length - 1) {
                    if (i > 0) {
                        cad += "  ";
                    } else {
                        cad += "TT";
                    }
                } else if (i > 0) {
                    cad += "\n";
                }
            }
        }
        return cad;
    }

    public static void main(String[] args) {
        ZonaConstruccion z = new ZonaConstruccion(5);
        System.out.println(z);
        Casa c = new Casa(z);
        Construccion cons = new Construccion(z);
        Construccion[] cons2 = z.getConstrucciones();
        for (int i = cons2.length-1;i>=0;i--) {
            System.out.println(cons2[i].toStringArray());
        }
        String[] casa = c.toStringArray();
        for (int i = casa.length-1; i>=0 ;i-- ) {
            System.out.println(casa[i]);
        }
    }
}
