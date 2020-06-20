import java.util.Random;

/**
 *
 * Clase Asesino, personaje del juego de rol.
 *
 * @author Cristian Alonso Sanchez Segura
 * @version 1.0
 */
public class Asesino extends Personaje {

    /*Ataque del Asesino con el metodo cuchillada*/
    int[] ataqueCuchillada = {22, 24, 26, 28, 30, 40};

    /*Ataque del Asesino con el metodo distorsion*/
    int[] ataqueDistorsion = {15, 16, 17, 18, 20, 14};

    /*Ataque del Asesino*/
    int ataque = 0;

    /*Contador para recuperar vida en metodo cuchillada*/
    int contadorCuchillada = 1;

    /*Contador para recuperar vida en metodo distorsion*/
    int contadorDistorsion = 1;

    /**
     * Constructor de la clase Asesino. Se le asigna un valor de 100 en la vida
     */
    public Asesino(String nombre) {
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
            return cuchillada();
        } else {
            System.out.println("\n");
            return distorsion();
        }
    }

    /**
     * Metodo para atacar, provoca de 30 a 50 puntos de vida y cada 4 ataques
     * recupera 15 puntos de vida.
     */
    public int cuchillada() {
        if (contadorCuchillada == 3) {
            super.recuperarVida(15);
            contadorCuchillada = 1;
            ataque = ataqueCuchillada[(int) (Math.random() * 5)];
            System.out.println("Asesino: " + super.getNombre()
                    + " Utilizó cuchillada, realizó: " + ataque + "pts de daño\n");
            return ataque;
        } else {
            ataque = ataqueCuchillada[(int) (Math.random() * 5)];
            contadorCuchillada++;
            System.out.println("Asesino: " + super.getNombre()
                    + " Utilizó cuchillada, realizó: " + ataque + "pts de daño\n");
            return ataque;
        }
    }

    /**
     * Metodo distorsion, provoca de 14 a 20 puntos de vida y cada 5 ataques
     * recupera 12 puntos de vida.
     */
    public int distorsion() {
        if (contadorDistorsion == 5) {
            super.recuperarVida(12);
            contadorDistorsion = 1;
            ataque = ataqueDistorsion[(int) (Math.random() * 5)];
            System.out.println("Asesino: " + super.getNombre()
                    + " Utilizó distorsion, realizó: " + ataque + "pts de daño\n");
            return ataque;
        } else {
            ataque = ataqueDistorsion[(int) (Math.random() * 5)];
            contadorDistorsion++;
            System.out.println("Asesino: " + super.getNombre()
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
        if (prob == 5) {
            vidaRecuperada = (getVida() * 12) / 100;
            super.recuperarVida(vidaRecuperada);
            System.out.println("Asesino: " + super.getNombre()
                    + " Utilizó recuperar");
        }
    }

    /**
     * Metodo toString de la clase Asesino.
     *
     * @return Representacion de un Asesino.
     */
    @Override
    public String toString() {
        return "Asesino: " + super.getNombre() + ". Vida: " + getVida();
    }
}
