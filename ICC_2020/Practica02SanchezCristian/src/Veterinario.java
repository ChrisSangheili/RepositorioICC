/**
 * Practica 2 del Curso de ICC
 *
 * @author Cristian Alonso Sanchez Segura numCta: 314217547
 * @version 1.0
*/
public class Veterinario {

    /* Nombre del veterinario*/
    private String nombre;

    /* Una mascota que puede tener un amigo */
    private Mascota amigo;

    /* Una mascota que puede ter un amigo*/ //pero en ingles xd
    private Mascota friend;

    /**
     * El constructor de un veterinario.
     * @param nombre el nombre que tendra el veterinario.
    */
    public Veterinario(String nombre) {

        this.nombre = nombre;
    }

    /**
     * Metodo que crea una amistad
     * @param mascotaAmigo la mascota que tendrá un nuevo amigo
     * @param mascotaFriend la mascota que tendrá un nuevo amigo //pero en ingles xd
    */
    public void hacerAmigos(Mascota mascotaAmigo, Mascota mascotaFriend) {
        amigo = mascotaAmigo;
        friend = mascotaFriend;
        System.out.println("Ahora " + mascotaAmigo.getNombre() + " y "
                + mascotaFriend.getNombre() + ":\n¡Son mejores amigos!");
    }

    /**
     * Metodo para deshacer una amistad.
     * Solo se puede deshacer la ultima amistad que hizo el veterinario.
    */
    public void deshacerAmigos() {
        System.out.println("Ahora " + amigo.getNombre() + " y "
                + friend.getNombre() + ":\nYa no son amigos :c");
    }
    
    /**
     * Metodo para recordar la ultima amistad hecha.
    */
    public void recordarUltimaAmistad() {
        System.out.println("Los ultimos mejores amigos que hice son:\n"
                + amigo.getNombre() + " con " + friend.getNombre());
    }

    //Getter y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Mascota getAmigo() {
        return amigo;
    }

    public void setAmigo(Mascota amigo) {
        this.amigo = amigo;
    }

    public Mascota getFriend() {
        return friend;
    }

    public void setFriend(Mascota friend) {
        this.friend = friend;
    }

    /**
     * Metodo main
    */
    public static void main(String[] args) {

        Mascota yoko = new Mascota();

        Mascota coco = new Mascota("Coco", "Perro", "Bulldog", "Guau", 1, "Pasear por el parque.");

        Mascota pepe = new Mascota("Pepe", "Cotorro", "Cariamarillo", "Rrrrrr", 5, "Volar por la casa.");

        Mascota amborguesa = new Mascota("Amborguesa", "Gato", "Persa", "Miau", 3, "Esconderse en el sillon.");

        Mascota mike = new Mascota("Mike", "Pez", "Dorado", "Glu", 1, "Nadar en la alberca.");

        Mascota fisgon = new Mascota("Fisgon", "Conejillo de indias", "Cobaya Peruano", "Cui Cui", 2, "Roer los sillones.");

        Veterinario cris = new Veterinario("Cristian");

        //Se hicieron mejores amigos
        cris.hacerAmigos(mike, yoko);
        System.out.println("-----------------------------------------");
        cris.hacerAmigos(coco, pepe);
        System.out.println("-----------------------------------------");
        cris.hacerAmigos(amborguesa,fisgon);
        System.out.println("-----------------------------------------");
        cris.hacerAmigos(yoko,amborguesa);
        System.out.println("-----------------------------------------");
        cris.hacerAmigos(fisgon,coco);
        System.out.println("-----------------------------------------");
        cris.hacerAmigos(pepe,mike);
        System.out.println("-----------------------------------------");

        //Ahora a romper amistades :c
        System.out.println("\nEl veterinario solo puede deshacer "
            +"la ultima amistad que creo");

        cris.recordarUltimaAmistad();
        cris.deshacerAmigos();
        System.out.println("-----------------------------------------");
        //Los vuelvo a hacer amigos, porque eran los amigos que tenian antes.
        cris.hacerAmigos(yoko,mike);
        cris.hacerAmigos(coco,pepe);
        cris.recordarUltimaAmistad();
        cris.deshacerAmigos();
        System.out.println("-----------------------------------------");
        //Lo mismo aqui, eran los amigos que tenian antes, coco se quedo sin amigos.
        cris.hacerAmigos(fisgon,coco);
        cris.recordarUltimaAmistad();
        cris.deshacerAmigos();
        System.out.println("-----------------------------------------");
        cris.hacerAmigos(amborguesa,fisgon);

    }
}
