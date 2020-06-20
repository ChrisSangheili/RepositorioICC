import java.util.Random;

/**
 *
 * Clase Guerrero, personaje del juego de rol.
 *
 * @author Cristian Alonso Sanchez Segura
 * @version 1.0
 */
public class Guerrero extends Personaje {

    /*Ataque del guerrero con el metodo combatir*/
    int[] ataqueCombatir = {5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};

    /*Ataque del guerrero con el metodo cabalgar*/
    int[] ataqueCabalgar = {10, 11, 12, 13, 14, 15};

    /*Ataque del guerrero*/
    int ataque = 0;

    /*Contador para recuperar vida en metodo combatir*/
    int contadorCombatir = 1;

    /*Contador para recuperar vida en metodo cabalgar*/
    int contadorCabalgar = 1;

    /**
     * Constructor de la clase guerrero. Se le asigna un valor de 100 en la vida
     */
    public Guerrero(String nombre) {
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
            return combatir();
        } else {
            System.out.println("\n");
            return cabalgar();
        }
    }

    /**
     * Metodo para atacar, provoca de 5 a 15 puntos de vida y cada 4 ataques
     * recupera 30 puntos de vida.
     */
    public int combatir() {
        if (contadorCombatir == 4) {
            super.recuperarVida(30);
            contadorCombatir = 1;
            ataque = ataqueCombatir[(int) (Math.random() * 10)];
            System.out.println("Guerrero: " + super.getNombre()
                    + " Utilizó combatir, realizó: " + ataque + "pts de daño\n");
            return ataque;
        } else {

            ataque = ataqueCombatir[(int) (Math.random() * 10)];
            contadorCombatir++;
            System.out.println("Guerrero: " + super.getNombre()
                    + " Utilizó combatir, realizó: " + ataque + "pts de daño\n");
            return ataque;
        }
    }

    /**
     * Metodo cabalgar, provoca de 10 a 15 puntos de vida y cada 5 ataques
     * recupera 10 puntos de vida.
     */
    public int cabalgar() {
        if (contadorCabalgar == 5) {
            super.recuperarVida(10);
            contadorCabalgar = 1;
            ataque = ataqueCabalgar[(int) (Math.random() * 5)];
            System.out.println("Guerrero: " + super.getNombre()
                    + " Utilizó cabalgar, realizó: " + ataque + "pts de daño\n");
            return ataque;
        } else {
            ataque = ataqueCabalgar[(int) (Math.random() * 5)];
            contadorCabalgar++;
            System.out.println("Guerrero: " + super.getNombre()
                    + " Utilizó cabalgar, realizó: " + ataque + "pts de daño\n");
            return ataque;
        }
    }

    /**
     * Metodo para recuperar vida, recupera 10% de la vida total, se manda a
     * llamar despues de cada ataque.
     */
    @Override
    public void recuperar() {
        int prob = (int) (Math.random() * 10);
        int vidaRecuperada;
        if (prob == 8) {
            vidaRecuperada = (getVida() * 10) / 100;
            super.recuperarVida(vidaRecuperada);
            System.out.println("Guerrero: " + super.getNombre()
                    + " Utilizó recuperar\n");
        }
    }

    /**
     * Metodo toString de la clase Guerrero.
     *
     * @return Representacion de un Guerrero.
     */
    @Override
    public String toString() {
        return "Guerrero: " + super.getNombre() + ". Vida: " + getVida();
    }
}
