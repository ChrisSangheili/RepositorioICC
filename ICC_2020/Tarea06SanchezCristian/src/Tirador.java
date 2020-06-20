import java.util.Random;

/**
 *
 * Clase Tirador, personaje del juego de rol.
 *
 * @author Cristian Alonso Sanchez Segura
 * @version 1.0
 */
public class Tirador extends Personaje {

    /*Ataque del Tirador con el metodo megaCohete*/
    int[] ataqueMegaCohete = {20, 30, 40};

    /*Ataque del Tirador*/
    int ataque = 0;

    /*Contador para recuperar vida en metodo tiroCosmico*/
    int contadorTiroCosmico = 1;

    /*Contador para recuperar vida en metodo megaCohete*/
    int contadorMegaCohete = 1;

    /**
     * Constructor de la clase Tirador. Se le asigna un valor de 100 en la vida
     */
    public Tirador(String nombre) {
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
            return tiroCosmico();
        } else {
            System.out.println("\n");
            return megaCohete();
        }
    }

    /**
     * Metodo para atacar, provoca de 5 a 15 puntos de vida y cada 4 ataques
     * recupera 15 puntos de vida.
     */
    public int tiroCosmico() {
        if (contadorTiroCosmico == 3) {
            super.recuperarVida(20);
            contadorTiroCosmico = 1;
            ataque = 25;
            System.out.println("Tirador: " + super.getNombre()
                    + " Utilizó Tiro Cósmico, realizó: " + ataque + "pts de daño\n");
            return ataque;
        } else {
            ataque = 25;
            contadorTiroCosmico++;
            System.out.println("Tirador: " + super.getNombre()
                    + " Utilizó tiroCosmico, realizó: " + ataque + "pts de daño\n");
            return ataque;
        }
    }

    /**
     * Metodo megaCohete, provoca de 14 a 20 puntos de vida y cada 5 ataques
     * recupera 12 puntos de vida.
     */
    public int megaCohete() {
        if (contadorMegaCohete == 5) {
            super.recuperarVida(12);
            contadorMegaCohete = 1;
            ataque = ataqueMegaCohete[(int) (Math.random() * 3)];
            System.out.println("Tirador: " + super.getNombre()
                    + " Utilizó megaCohete, realizó: " + ataque + "pts de daño\n");
            return ataque;
        } else {
            ataque = ataqueMegaCohete[(int) (Math.random() * 3)];
            contadorMegaCohete++;
            System.out.println("Tirador: " + super.getNombre()
                    + " Utilizó distorsion, realizó: " + ataque + "pts de daño\n");
            return ataque;
        }
    }

    /**
     * Metodo para recuperar vida, recupera 12% de la vida total, se manda a
     * llamar despues de cada ataque.
     */
    @Override
    public void recuperar() {
        int prob = (int) (Math.random() * 10);
        int vidaRecuperada;
        if (prob == 2) {
            vidaRecuperada = (getVida() * 9) / 100;
            super.recuperarVida(vidaRecuperada);
            System.out.println("Tirador: " + super.getNombre()
                    + " Utilizó recuperar");
        }
    }

    /**
     * Metodo toString de la clase Tirador.
     *
     * @return Representacion de un Tirador.
     */
    @Override
    public String toString() {
        return "Tirador: " + super.getNombre() + ". Vida: " + getVida();
    }
}
