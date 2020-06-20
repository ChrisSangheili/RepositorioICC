/**
 * Practica 2 del Curso de ICC
 *
 * @author Cristian Alonso Sanchez Segura numCta: 314217547
 * @version 1.0
*/
public class Mascota {

    /* Nombre de la mascota.*/
    public String nombre;

    /* Especie de la mascota. Ej. perro*/
    public String especie;

    /* La raza a la que pertenece.*/
    private String raza;

    /* El sonido que produce la mascota.*/
    public String sonido;

    /* La edad de la mascota, esta representada en años.*/
    public int edad;

    /* Lo que adora la mascota de su dueño.*/
    public String adora;

    /* Los recuerdos que tiene la mascota.*/
    public String recuerdos;

    /* Si es adorable la mascota, todas lo son*/
    public final boolean adorable = true;

    /* Variable estatica que cuenta el numero de mascotas que se crean.*/
    private static int numMascotas = 0;

    /**
     * Constructor de la clase mascota
     */
    public Mascota(String nombre, String especie, String raza, String sonido, int edad, String adora) {
        this.nombre = nombre;
        this.especie = especie;
        this.raza = raza;
        this.sonido = sonido;
        this.edad = edad;
        this.adora = adora;
        this.recuerdos = "";
        this.numMascotas = numMascotas + 1;
    }

    /**
     * Constructor por defecto de la clase mascota. Crea una mascota de nombre:
     * Yoko, especie: perro, raza; Husky, sonido: guau, edad: 2 años.
     */
    public Mascota() {
        this.nombre = "Yoko";
        this.especie = "Perro";
        this.raza = "Husky";
        this.sonido = "guau";
        this.edad = 1;
        this.adora = "Juegan mucho.";
        this.recuerdos = "";
        this.numMascotas = numMascotas + 1;
    }

    public void recordar(String nombre, String adora) {

        this.recuerdos = recuerdos + " " + nombre + ". Su recuerdo es: " + adora;
    }

    /**
     * Metodo que devuelve el numero de mascotas que se han creado.
     *
     * @return numMascotas
     */
    public int getNumMascotas() {
        return numMascotas;
    }

    /**
     * Metodo que asigna el numero de mascotas que se han creado.
     *
     * @param numMascotas
     */
    public void setNumMascotas(int numMascotas) {
        this.numMascotas = numMascotas;
    }

    //Getters y Setters de la clase
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSonido() {
        return sonido;
    }

    public void setSonido(String sonido) {
        this.sonido = sonido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getAdora() {
        return adora;
    }

    public void setAdora(String adora) {
        this.adora = adora;
    }

    public String getRecuerdos() {
        return recuerdos;
    }

    public void setRecuerdos(String recuerdos) {
        this.recuerdos = recuerdos;
    }

    public boolean getAdorable() {
        return adorable;
    }

    /**
     * Se sobreescribe el metodo toString en el que mostramos toda la
     * informacion de una mascota.
     */
    @Override
    public String toString() {
        return "Mascota:\n" + "Nombre " + nombre + ", Especie " + especie + ", Raza "
                + raza + ", Sonido " + sonido + ", Edad " + edad + ", Adora " + adora + ", Adorable "
                + adorable + ".\n Recuerdos: " + recuerdos;
    }

    public static void main(String[] args) {

        /* Mascota creada con los valores por default*/
        Mascota yoko = new Mascota();

        Mascota coco = new Mascota("Coco", "Perro", "Bulldog", "Guau", 1, "Pasear por el parque.");

        Mascota pepe = new Mascota("Pepe", "Cotorro", "Cariamarillo", "Rrrrrr", 5, "Volar por la casa.");

        Mascota amborguesa = new Mascota("Amborguesa", "Gato", "Persa", "Miau", 3, "Esconderse en el sillon.");

        Mascota mike = new Mascota("Mike", "Pez", "Dorado", "Glu", 1, "Nadar en la alberca.");

        Mascota fisgon = new Mascota("Fisgon", "Conejillo de indias", "Cobaya Peruano", "Cui Cui", 2, "Roer los sillones.");

        /* En el parque comenzaron a contarse lo que adoran las mascotas de su dueño.*/
        //Yoko
        yoko.recordar(coco.getNombre(), coco.getAdora());
        yoko.recordar(pepe.getNombre(), pepe.getAdora());
        yoko.recordar(amborguesa.getNombre(), amborguesa.getAdora());

        //Coco
        coco.recordar(yoko.getNombre(), yoko.getAdora());
        coco.recordar(pepe.getNombre(), pepe.getAdora());
        coco.recordar(amborguesa.getNombre(), amborguesa.getAdora());

        //Amborguesa
        amborguesa.recordar(fisgon.getNombre(), fisgon.getAdora());
        amborguesa.recordar(mike.getNombre(), mike.getAdora());
        amborguesa.recordar(yoko.getNombre(), yoko.getAdora());

        //Fisgon
        fisgon.recordar(mike.getNombre(), mike.getAdora());
        fisgon.recordar(coco.getNombre(), coco.getAdora());
        fisgon.recordar(amborguesa.getNombre(), amborguesa.getAdora());

        //Mike
        mike.recordar(fisgon.getNombre(), fisgon.getAdora());
        mike.recordar(pepe.getNombre(), pepe.getAdora());
        mike.recordar(coco.getNombre(), coco.getAdora());

        //Pepe
        pepe.recordar(amborguesa.getNombre(), amborguesa.getAdora());
        pepe.recordar(fisgon.getNombre(), fisgon.getAdora());
        pepe.recordar(yoko.getNombre(), amborguesa.getAdora());

        //Ya se conocieron y se contaron todo en el parque
        System.out.println(yoko);

        System.out.println("-----------------------------------------");
        System.out.println(coco);

        System.out.println("-----------------------------------------");
        System.out.println(amborguesa);

        System.out.println("-----------------------------------------");
        System.out.println(fisgon);

        System.out.println("-----------------------------------------");
        System.out.println(mike);

        System.out.println("-----------------------------------------");
        System.out.println(pepe);

        //El contador de mascotas creadas.
        System.out.println("-----------------------------------------");
        System.out.println("\nVariable estatica que cuenta el numero de mascotas creadas.");
        System.out.println("Yoko: " + yoko.getNumMascotas());
        System.out.println("Coco: " + coco.getNumMascotas());
        System.out.println("Amborguesa: " + amborguesa.getNumMascotas());
        System.out.println("Fisgon: " + fisgon.getNumMascotas());
        System.out.println("Mike: " + mike.getNumMascotas());
        System.out.println("Pepe: " + pepe.getNumMascotas());

    }

}
