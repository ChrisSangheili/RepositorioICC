import java.util.Random;

/**
 *
 * Clase Mago, personaje del juego de rol.
 *
 * @author Cristian Alonso Sanchez Segura
 * @version 1.0
 */
public class Mago extends Personaje {

    /*Ataque del Mago con el metodo Volar*/
    int[] ataqueVolar = {5, 6, 7, 8, 9, 10};

    /*Ataque del Mago*/
    int ataque = 0;

    /*Contador para recuperar vida en metodo Encantar*/
    int contadorEncantar = 1;

    /*Contador para recuperar vida en metodo Volar*/
    int contadorVolar = 1;

    /**
     * Constructor de la clase Mago. Se le asigna un valor de 100 en la vida
     */
    public Mago(String nombre) {
        super(nombre);
    }

    /**
     * Metodo que ataca a un enemigo, selecciona entre dos de los ataques del
     * personaje.
     *
     * @return el ataque realizado.
     */
    @Override
    public int atacar() {
        int ataque = (int) (Math.random() * 2);
        if (ataque == 0) {
            System.out.println("\n");
            return encantar();
        } else {
            System.out.println("\n");
            return volar();
        }
    }

    /**
     * Metodo para atacar, provoca de 20 puntos de vida y cada 4 ataques
     * recupera 30 puntos de vida.
     */
    public int encantar() {
        if (contadorEncantar == 5) {
            super.recuperarVida(30);
            contadorEncantar = 1;
            ataque = 20;
            System.out.println("Mago: " + super.getNombre()
                    + " Utilizó encantar, realizó: " + ataque + "pts de daño\n");
            return ataque;
        } else {
            ataque = 20;
            contadorEncantar++;
            System.out.println("Mago: " + super.getNombre()
                    + " Utilizó encantar, realizó: " + ataque + "pts de daño\n");
            return ataque;
        }
    }

    /**
     * Metodo Volar, provoca de 5 a 15 puntos de vida y cada 5 ataques recupera
     * 10 puntos de vida.
     */
    public int volar() {
        if (contadorVolar == 2) {
            super.recuperarVida(10);
            contadorVolar = 1;
            ataque = ataqueVolar[(int) (Math.random() * 5)];
            System.out.println("Mago: " + super.getNombre()
                    + " Utilizó volar, realizó: " + ataque + "pts de daño\n");
            return ataque;
        } else {
            ataque = ataqueVolar[(int) (Math.random() * 5)];
            contadorVolar++;
            System.out.println("Mago: " + super.getNombre()
                    + " Utilizó volar, realizó: " + ataque + "pts de daño\n");
            return ataque;
        }
    }

    /**
     * Metodo para recuperar vida, recupera 15% de la vida total, se manda a
     * llamar despues de cada ataque.
     */
    @Override
    public void recuperar() {
        int prob = (int) (Math.random() * 10);
        int vidaRecuperada;
        if (prob == 6) {
            vidaRecuperada = (getVida() * 15) / 100;
            super.recuperarVida(vidaRecuperada);
            System.out.println("Mago: " + super.getNombre()
                    + " Utilizó recuperar");
        }
    }

    /**
     * Metodo toString de la clase Mago.
     *
     * @return Representacion de un Mago.
     */
    @Override
    public String toString() {
        return "Mago: " + super.getNombre() + ". Vida: " + getVida();
    }
}
