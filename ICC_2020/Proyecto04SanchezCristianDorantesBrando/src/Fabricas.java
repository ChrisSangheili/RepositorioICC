
import java.util.Scanner;
import java.util.InputMismatchException;
import java.io.*;

/**
 * Clase para crear una fabrica.
 *
 * @author Sanchez Segura Cristian Alonso No. Cuenta: 314217547
 * @author Brando Dorantes Perez No. Cuenta: 314255356
 *
 * @version 2.0
 */
public class Fabricas {

    /*Catalogo de animales*/
    ListaLigada catalogo = new ListaLigada();

    /*Catalogo de alebrijes creados*/
    ListaLigada alebrijesCreados = new ListaLigada();

    /*Alebrije*/
    Alebrijes nuevoAlebrije, alebrijeAux;

    /*Animal*/
    Animales animalNuevo;

    /*Nombre de la fabrica*/
    String nombre;

    /*Nombre del fichero del catalogo*/
    String nombreCatalogo;

    /*Nombre del fichero del catalogo de alebrijes*/
    String nombreAlebrijes;

    /*Scanner*/
    Scanner sn = new Scanner(System.in);

    /**
     * Constructor de una fabrica de alebrijes, asigna un nombre.
     *
     * @param nombre El nombre de la fabrica.
     */
    public Fabricas(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Constructor de una fabrica de alebrijes, asigna un nombre.
     *
     * @param nombre El nombre de la fabrica.
     * @param nombreCatalogo El nombre del catalogo.
     */
    public Fabricas(String nombre, String nombreCatalogo) {
        this.nombre = nombre;
        this.nombreCatalogo = nombreCatalogo;
    }

    /**
     * Metodo de acceso para el nombre del fichero del catalogo.
     *
     * @return El nombre del fichero.
     */
    public String getNombreCatalogo() {
        return nombreCatalogo;
    }

    /**
     * Metodo de acceso para el catalogo de animales
     *
     * @return Catalogo de animales.
     */
    public ListaLigada getCatalogo() {
        return catalogo;
    }

    /**
     * Metodo que modifica el catalogo de animales
     *
     * @param catalogo Nuevo catalogo de animales
     */
    public void setCatalogo(ListaLigada catalogo) {
        this.catalogo = catalogo;
    }

    /**
     * Metodo de acceso para el nombre de la fabrica.
     *
     * @return El nombre de la fabrica.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Metodo que carga animales ya hechos a partir de un fichero.
     *
     * @param nombreFichero El nombre del archivo del que se cargara el catalogo
     * de animales.
     */
    public void cargaCatalogoFichero(String nombreFichero) {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        Animales animal;
        String linea;
        try {
            archivo = new File(nombreFichero + ".txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            while ((linea = br.readLine()) != null) {
                animal = creaAnimal(linea);
                agregarAnimal(animal);
            }
        } catch (Exception e) {
            System.out.println("Formato invalido");
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /**
     * Metodo que agrega un alebrije al catalogo de alebrijes a partir de un
     * fichero.
     *
     * @param nombreFichero Nombre del fichero con un alebrije.
     * @return Alebrije creado a partir del fichero.
     */
    public Alebrijes agregarAlebrijeFichero(String nombreFichero) {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        String linea;
        try {
            archivo = new File(nombreFichero + ".txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            while ((linea = br.readLine()) != null) {
                nuevoAlebrije = new Alebrijes(linea, true);
                //terminarAlebrije();
            }
        } catch (Exception e) {
            System.out.println("Formato invalido");
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return nuevoAlebrije;
    }

    /**
     * Metodo que crea un alebrije al catalogo de alebrijes a partir de un
     * pedido. Para poder crear un alebrije es necesario contar con los animales
     * en el catalogo de animales.
     *
     * @param nombreFichero Nombre del fichero con un alebrije.
     * @return Alebrije creado a partir de un fichero
     */
    public Alebrijes pedido(String nombreFichero) {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        String linea;
        try {
            archivo = new File(nombreFichero + ".txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            while ((linea = br.readLine()) != null) {
                alebrijeAux = creaAlebrije(linea);
                //terminarAlebrije();
            }
            System.out.println("Fichero cargado con exito");
        } catch (Exception e) {
            System.out.println("Formato invalido");
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return alebrijeAux;
    }

    /**
     * Metodo que procesa una linea de un archivo, para crear un animal
     *
     * @param animal Contiene una linea de un archivo de texto.
     * @return Animal creado apartir de una cadena de un archivo.
     */
    public Animales creaAnimal(String animal) throws ExcepcionFormato {
        boolean alas, cola, patas;
        String[] animalN = animal.split(",");
        if (animalN.length < 5) {
            if (animalN[1].equals("true")) {
                alas = true;
            } else {
                alas = false;
            }
            if (animalN[2].equals("true")) {
                patas = true;
            } else {
                patas = false;
            }
            if (animalN[3].equals("true")) {
                cola = true;
            } else {
                cola = false;
            }
            animalNuevo = new Animales(animalN[0], alas, patas, cola);
            return animalNuevo;
        } else {
            throw new ExcepcionFormato("Formato invalido");
        }
    }

    /**
     * Metodo que procesa una linea de un archivo, para crear un alebrije.
     *
     * @param alebrije Contiene una linea de un archivo de texto.
     * @return Alebrije creado a partir de una cadena de un archivo.
     */
    public Alebrijes creaAlebrije(String alebrije) throws ExcepcionFormato {
        String[] alebrijeNuevo = alebrije.split("#");
        if (alebrijeNuevo.length < 6) {
            String[] nombre = alebrijeNuevo[0].split(":");//0
            nombrarAlebrije(nombre[1].trim());
            //nuevoAlebrije = new Alebrijes(nombre[1]);

            String[] cabeza = alebrijeNuevo[1].split(",");//1
            String[] cabeza1 = cabeza[0].split(":");
            Animales cabezaA = devolverAnimal(indiceAnimal(cabeza1[1]));
            if (existeAnimal(cabeza1[1])) {
                colocarCabeza(indiceAnimal(cabeza1[1].trim()), cabeza[1]);
            } else {
                System.out.println("No existe el animal en el catalago "
                        + "para utilizarlo como cabeza del alebrije.");
                return null;
            }

            String[] cuerpo = alebrijeNuevo[2].split(",");//2
            String[] cuerpo1 = cuerpo[0].split(":");
            if (existeAnimal(cuerpo1[1])) {
                colocarCuerpo(indiceAnimal(cuerpo1[1].trim()), cuerpo[1]);
            } else {
                System.out.println("No existe el animal en el catalago "
                        + "para utilizarlo como cuerpo del alebrije.");
                return null;
            }

            String[] patas = alebrijeNuevo[3].split(",");//3
            String[] patas1 = patas[0].split(":");
            if (existeAnimal(patas1[1])) {
                colocarPatas(indiceAnimal(patas1[1].trim()), patas[1]);
            } else {
                System.out.println("No existe el animal en el catalago "
                        + "para utilizarlo como las patas del alebrije.");
                return null;
            }

            String[] cola = alebrijeNuevo[4].split(",");//3
            String[] cola1 = cola[0].split(":");
            if (existeAnimal(cola1[1])) {
                colocarCola(indiceAnimal(cola1[1].trim()), cola[1]);
            } else {
                System.out.println("No existe el animal en el catalago "
                        + "para utilizarlo como la cola del alebrije.");
                return null;
            }
            //System.out.println(nuevoAlebrije);
            return nuevoAlebrije;
        } else {
            throw new ExcepcionFormato("Formato invalido");
        }
    }

    /**
     * Metodo que verifica que un animal exista en el catalogo de animales
     *
     * @param animal Animal a buscar en el catalogo de animales
     * @return Devuelve true si existe el animal, false en otro caso.
     */
    private boolean existeAnimal(String animal) {
        boolean existe = false;
        Animales animalC;
        String aux;
        if (catalogo.getLongitud() == 0) {
            System.out.println("No se puede crear un alebrije con un catalogo "
                    + "de animales vacio");
            return false;
        }
        for (int i = 0; i < catalogo.getLongitud(); i++) {
            animalC = (Animales) catalogo.obten(i);
            aux = animalC.getAnimal().toLowerCase().trim();
            if (aux.equals(animal.toLowerCase().trim())) {
                return true;
            } else {
                existe = false;
            }
        }
        return existe;
    }

    /**
     * Metodo que devuelve el indice de un animal a partir del nombre del animal
     *
     * @param animal Nombre del animal
     * @return Indice del animal en el catalogo.
     */
    public int indiceAnimal(String animal) {
        Animales animalC;
        int indiceN;
        String aux;

        for (int i = 0; i < catalogo.getLongitud(); i++) {
            animalC = devolverAnimal(i);
            aux = animalC.getAnimal().toLowerCase().trim();
            if (aux.equals(animal.toLowerCase().trim())) {
                return i;
            } else {
                indiceN = -1;
            }
        }
        return -1;
    }

    /**
     * Metodo que modifica el nombre del fichero del catalogo.
     *
     * @param nombre El nuevo nombre del fichero.
     */
    public void setNombreCatalogo(String nombreCatalogo) {
        this.nombreCatalogo = nombreCatalogo;
    }

    /**
     * Metodo que devuelve la longitud del catalogo de animales.
     *
     * @return La longitud del catalogo de animales.
     */
    public int longitud() {
        return catalogo.getLongitud();
    }

    /**
     * Metodo que modifica el nombre de la fabrica.
     *
     * @param nombre El nuevo nombre de la fabrica.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Metodo que agrega animales ya hechos al catalogo.
     *
     */
    public void catalogoPrecargado() {
        Animales perro = new Animales("Perro", false, true, true);
        Animales gato = new Animales("Gato", false, true, true);
        Animales leon = new Animales("Leon", false, true, true);
        Animales pato = new Animales("Pato", true, true, true);
        Animales mono = new Animales("Mono", false, true, true);
        Animales conejo = new Animales("Conejo", false, true, true);

        if (catalogoVacio()) {
            agregarAnimal(perro);
            agregarAnimal(gato);
            agregarAnimal(leon);
            agregarAnimal(pato);
            agregarAnimal(conejo);
            agregarAnimal(mono);
        } else {
            eliminarCatalogo();
            agregarAnimal(perro);
            agregarAnimal(gato);
            agregarAnimal(leon);
            agregarAnimal(pato);
            agregarAnimal(conejo);
            agregarAnimal(mono);
        }
    }

    /**
     * Metodo que elimina el catalogo actual de animales.
     */
    public void eliminarCatalogo() {
        catalogo.limpia();
    }

    /**
     * Metodo que devuelve si un catalogo de animales esta vacio
     *
     * @return True si esta vacio, false en otro caso.
     */
    public boolean catalogoVacio() {
        return catalogo.estaVacia();
    }

    /**
     * Metodo que devuelve si un catalogo de alebrijes esta vacio
     *
     * @return True si esta vacio, false en otro caso.
     */
    public boolean alebrijesVacio() {
        return alebrijesCreados.estaVacia();
    }

    /**
     * Metodo que agrega un animal al catalogo.
     *
     * @param animal El animal agregado.
     */
    public void agregarAnimal(Animales animal) {
        catalogo.insertaFinal(animal);
    }

    /**
     * Metodo que elimina un animal del catalogo.
     *
     * @param indice Indice del animal que se quiere eliminar.
     */
    public void eliminarAnimal(int indice) {
        catalogo.elimina(indice);
    }

    /**
     * Metodo que elimina un alebrije del catalogo.
     *
     * @param indice Indice del alebrije que se quiere eliminar.
     */
    public void eliminarAlebrije(int indice) {
        alebrijesCreados.elimina(indice);
    }

    /**
     * Metodo que muestra el catalogo de animales.
     *
     * @return Los animales disponibles.
     */
    public String mostrarCatalogo() {
        return catalogo.toString();
    }

    /**
     * Metodo que muestra el catalogo de alebrijes creados.
     *
     * @return Los alebrijes creados.
     */
    public String mostrarAlebrijes() {
        return alebrijesCreados.toString();
    }

    /**
     * Metodo que crea al alebrije y lo nombra.
     *
     * @param nombre Nombre del alebrije.
     */
    public void nombrarAlebrije(String nombre) {

        nuevoAlebrije = new Alebrijes(nombre);
    }

    /**
     * Metodo que coloca la cabeza del alebrije. Lo hace a partir del animal del
     * catalogo.
     *
     * @param cabeza Indice del animal en el catalogo, se tomará la cabeza del
     * animal.
     * @param colorCabeza el color que tendrá la cabeza.
     */
    public void colocarCabeza(int cabeza, String colorCabeza) {
        nuevoAlebrije.colocarCabeza(devolverAnimal(cabeza), colorCabeza);
    }

    /**
     * Metodo que coloca el cuerpo del alebrije. Lo hace a partir del animal del
     * catalogo.
     *
     * @param cuerpo Indice del animal en el catalogo, se tomará el cuerpo del
     * animal.
     * @param colorCuerpo el color que tendrá el cuerpo.
     */
    public void colocarCuerpo(int cuerpo, String colorCuerpo) {
        nuevoAlebrije.colocarCuerpo(devolverAnimal(cuerpo), colorCuerpo);
    }

    /**
     * Metodo que coloca las patas del alebrije. Lo hace a partir del animal del
     * catalogo.
     *
     * @param patas Indice del animal en el catalogo, se tomará las patas del
     * animal.
     * @param colorPatas el color que tendrán las Patas.
     */
    public void colocarPatas(int patas, String colorPatas) {
        nuevoAlebrije.colocarPatas(devolverAnimal(patas), colorPatas);
    }

    /**
     * Metodo que coloca la cola del alebrije. Lo hace a partir del animal del
     * catalogo. Ademas termina de crear al alebrije y lo agrega a un catalogo
     * de alebrijes ya creados.
     *
     * @param cola Indice del animal en el catalogo, se tomará la Cola del
     * animal.
     * @param colorCola el color que tendrá la Cola.
     */
    public void colocarCola(int cola, String colorCola) {
        nuevoAlebrije.colocarCola(devolverAnimal(cola), colorCola);
    }

    /**
     * Metodo que termina de crear y agregar al catalogo de alebrijes un
     * alebrije nuevo.
     *
     * @return El alebrije terminado
     */
    public Alebrijes terminarAlebrije() {

        alebrijesCreados.insertaFinal(nuevoAlebrije);

        return nuevoAlebrije;
    }

    /**
     * Metodo que agrega un alebrije a la lista de alebrijes
     *
     * @param alebrije El alebrije a agregar a la lista.
     */
    public void agregarAlebrije(Alebrijes alebrije) {
        alebrijesCreados.insertaFinal(alebrije);
    }

    /**
     * Metodo que devuelve un animal del catalogo a partir de su indice.
     *
     * @return Animal devuelto.
     */
    public Animales devolverAnimal(int indice) {
        return (Animales) catalogo.obten(indice);
    }

    /**
     * Metodo que devuelve un animal del catalogo a partir de su indice.
     *
     * @return Animal devuelto.
     */
    public Alebrijes devolverAlebrijes(int indice) {
        return (Alebrijes) alebrijesCreados.obten(indice);
    }

    /**
     * Metodo que devuelve un alebrije.
     *
     * @return alebrije creado.
     */
    public Alebrijes getAlebrije() {
        return this.nuevoAlebrije;
    }

    /**
     * Metodo que guarda en un archivo todo el catalogo de animales actuales.
     *
     * @param nombreFichero El nombre que se le asigna al fichero,
     */
    public void guardaCatalogo(String nombreFichero) {
        nombreCatalogo = nombreFichero;
        FileWriter fichero = null;
        PrintWriter pw = null;
        Animales animal;
        try {
            fichero = new FileWriter(nombreFichero + ".txt");
            pw = new PrintWriter(fichero);
            for (int i = 0; i < catalogo.getLongitud(); i++) {
                animal = devolverAnimal(i);
                pw.println(animal.toFichero());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fichero) {
                    fichero.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /**
     * Metodo que actualiza el archivo donde se encuentra el catalogo de
     * animales.
     *
     */
    public void actualizaCatalogo() {
        if (nombreCatalogo != null) {
            FileWriter fichero = null;
            PrintWriter pw = null;
            Animales animal;
            try {
                fichero = new FileWriter(nombreCatalogo + ".txt");
                pw = new PrintWriter(fichero);
                for (int i = 0; i < catalogo.getLongitud(); i++) {
                    animal = devolverAnimal(i);
                    pw.println(animal.toFichero());
                }
                System.out.println("¡Se ha actualizado tu fichero del catalogo de animales!");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (null != fichero) {
                        fichero.close();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        } else {
            System.out.println("No has creado un fichero con un catalogo "
                    + "para actualizar");
        }
    }

    /**
     * Metodo que guarda en un archivo todo el catalogo de alebrijes actuales.
     *
     * @param nombreFichero El nombre que se le asigna al fichero,
     */
    public void guardaAlebrijes(String nombreFichero) {
        nombreAlebrijes = nombreFichero;
        FileWriter fichero = null;
        PrintWriter pw = null;
        Alebrijes alebrijes;
        try {
            fichero = new FileWriter(nombreAlebrijes + ".txt");
            pw = new PrintWriter(fichero);
            for (int i = 0; i < alebrijesCreados.getLongitud(); i++) {
                alebrijes = devolverAlebrijes(i);
                pw.println(alebrijes.toFichero());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fichero) {
                    fichero.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /**
     * Metodo que actualiza el archivo donde se encuentra el catalogo de
     * alebrijes.
     *
     */
    public void actualizaAlebrijes() {
        if (nombreAlebrijes != null) {
            FileWriter fichero = null;
            PrintWriter pw = null;
            Alebrijes alebrijes;
            try {
                fichero = new FileWriter(nombreAlebrijes + ".txt");
                pw = new PrintWriter(fichero);
                for (int i = 0; i < alebrijesCreados.getLongitud(); i++) {
                    alebrijes = devolverAlebrijes(i);
                    pw.println(alebrijes.toFichero());
                }
                System.out.println("¡Se ha actualizado tu fichero del catalogo de alebrijes!");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (null != fichero) {
                        fichero.close();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        } else {
            System.out.println("No has creado un fichero con un catalogo "
                    + "para actualizar");
        }
    }

    /**
     * Metodo que guarda en un archivo todo el catalogo de animales actuales.
     *
     * @param nombreFichero El nombre que se le asigna al fichero
     * @param alebrije EL alebrije a guardar.
     */
    public void creaAlebrijeFichero(String nombreFichero, Alebrijes alebrije) {
        FileWriter fichero = null;
        PrintWriter pw = null;
        Alebrijes alebrijes = alebrije;
        try {
            fichero = new FileWriter(nombreFichero + ".txt");
            pw = new PrintWriter(fichero);
            pw.println(alebrijes.toFichero());
            System.out.println("Se ha creado con exito tu fichero.");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fichero) {
                    fichero.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /**
     * Metodo que modifica las caracteristicas de un animal
     * 
     * @return animal modificado
    */
    public void modificaAnimal(int indice){
        boolean salir = false;
        int opcion;
        try{
            String nombre;
            int alas,patas,cola;
            animalNuevo = devolverAnimal(indice);
            while(!salir){
                System.out.println("¿Que deseas modificar del animal?\n"
                    + "1. Nombre.\n" + "2. Tiene Alas\n" + "3. Tiene patas\n"
                    + "4. Tiene cola\n" + "5. Terminar edicion.\n"
                    + "0. Salir sin realizar cambios.");
                opcion = sn.nextInt();
                switch(opcion){
                    case 1:
                        System.out.println("Ingresa un nuevo nombre");
                        nombre = sn.next();
                        animalNuevo.setAnimal(nombre);
                        System.out.println("Nombre cambiado");
                        break;
                    case 2:
                        System.out.println("¿Tiene alas? 1(Si)/0(No)");
                        alas = sn.nextInt();
                        if (alas == 1) {
                            animalNuevo.setAlas(true);
                            break;
                        }else{
                            animalNuevo.setAlas(false);
                        }
                        break;
                    case 3:
                        System.out.println("¿Tiene patas? 1(Si)/0(No)");
                        patas = sn.nextInt();
                        if (patas == 1) {
                            animalNuevo.setPatas(true);
                            break;
                        }else{
                            animalNuevo.setPatas(false);
                            break;
                        }
                        
                    case 4:
                        System.out.println("¿Tiene cola? 1(Si)/0(No)");
                        cola = sn.nextInt();
                        if (cola == 1) {
                            animalNuevo.setCola(true);
                            break;
                        }else{
                            animalNuevo.setCola(false);
                            break;
                        }
                        
                    case 5:
                        System.out.println("Edición Terminada");
                        eliminarAnimal(indice);
                        agregarAnimal(animalNuevo);
                        salir = true;
                        break;
                    case 0:
                        System.out.println("¡Sin cambios!");
                        salir = true;
                    default:
                        System.out.println("Debes ingresar un numero");
                }

            }
            
        }catch(InputMismatchException e){
            System.out.println("Debes insertar un número");
            sn.next();
        }
    }

    /**
     * Metodo toString de una fabrica
     *
     * @return la representacion de una fabrica en cadena
     */
    @Override
    public String toString() {
        return this.nombre + ".";
    }

    public static void main(String[] args) {

        Fabricas fab = new Fabricas("El Nuevo Axolotl");
        System.out.println("Bienevenido a la fabrica: " + fab);
        Scanner sn = new Scanner(System.in);
        Animales animalNuevo;
        boolean salir = false;
        int cabeza, cuerpo, patas, alas, cola;
        boolean patasB, alasB, colaB;
        int opcion; //Guardaremos la opcion del usuario
        int indice;
        String nombre;
        String colorCabeza, colorCuerpo, colorPatas;
        String colorAlas, colorCola;
        String nombreFichero;
        fab.cargaCatalogoFichero("Animales");

        while (!salir) {

            System.out.println("1. Ver Catalogo\n" + "2. Agregar animal al catalogo\n"
                    + "3. Eliminar animal del catalogo.\n" + "4. Utilizar catalogo precargado.\n"
                    + "5. Crear alebrije.\n" + "6. Ver alebrijes creados.\n"
                    + "7. Eliminar catalogo actual de animales.\n"
                    + "8. Cargar un catalogo de un fichero.\n"
                    + "9. Cargar alebrije creado.\n" + "10. Pedido a partir de un archivo.\n"
                    + "11. Guardar catalogo.\n" + "12. Guardar Alebrijes.\n" + "13. Actualizar catalogo.\n"
                    + "14. Actualizar alebrijes.\n" + "15. Modificar alebrjie.\n"
                    + "16. Guardar Alebrije en un archivo nuevo\n" 
                    + "17. Editar animales del catalogo.\n" + "0. Salir.\n");

            try {

                System.out.println("\nEscribe una de las opciones\n");
                opcion = sn.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.println("\nCatalogo disponible:");
                        if (fab.catalogoVacio()) {
                            System.out.println("No tienes animales en tu catalogo\n");
                        } else {
                            System.out.println("Todos los animales disponibles:");
                            System.out.println(fab.mostrarCatalogo());
                        }
                        break;
                    case 2:
                        System.out.println("Agrega un animal al catalogo de animales:\n");
                        System.out.println("Ingresa un animal. Ej: perro, gato, serpiente, oso, etc.");
                        nombre = sn.next();
                        System.out.println("Un poco mas de información de tu animal.\n"
                                + "Escribe 1(Sí)/0(No) para mas info del animal\n"
                                + "¿Tu animal tiene patas?");
                        patas = sn.nextInt();
                        System.out.println("¿Tu animal tiene alas?");
                        alas = sn.nextInt();
                        System.out.println("¿Tu animal tiene cola?");
                        cola = sn.nextInt();
                        if (patas == 1) {
                            patasB = true;
                        } else {
                            patasB = false;
                        }
                        if (alas == 1) {
                            alasB = true;
                        } else {
                            alasB = false;
                        }
                        if (cola == 1) {
                            colaB = true;
                        } else {
                            colaB = false;
                        }
                        animalNuevo = new Animales(nombre, alasB, patasB, colaB);
                        fab.agregarAnimal(animalNuevo);
                        break;
                    case 3:
                        if (fab.catalogoVacio()) {
                            System.out.println("No tienes animales en tu catalogo para eliminar.");
                        } else {
                            System.out.println("Utiliza el indice del animal que quieras eliminar.");
                            indice = sn.nextInt();
                            if (indice < 0 || indice > fab.longitud()) {
                                System.out.println("Indice inválido");
                            } else {
                                System.out.println("Eliminaste el animal: " + fab.devolverAnimal(indice));
                                fab.eliminarAnimal(indice);
                            }
                        }
                        break;
                    case 4:
                        System.out.println("\nUtilizaras el catalogo precargado.\n");
                        fab.catalogoPrecargado();
                        break;
                    case 5:
                        if (fab.catalogoVacio()) {
                            System.out.println("No tienes animales en tu catalogo para crear alebrijes :(");
                        } else {
                            System.out.println("Ponle un nombre a tu alebrije.");
                            nombre = sn.next();
                            fab.nombrarAlebrije(nombre);
                            System.out.println("Del catalogo de animales, puedes seleccionar un animal con su indice "
                                    + "para colocar la parte de su cuerpo en tu alebrije, ademas de asignarle un color");
                            System.out.println(fab.mostrarCatalogo());
                            System.out.println("Selecciona la cabeza de tu alebrije");
                            cabeza = sn.nextInt();
                            System.out.println("Escoge el color de la cabeza.");
                            colorCabeza = sn.next();
                            fab.colocarCabeza(cabeza, colorCabeza);

                            System.out.println("Selecciona el cuerpo de tu alebrije");
                            cuerpo = sn.nextInt();
                            System.out.println("Escoge el color del cuerpo");
                            colorCuerpo = sn.next();
                            fab.colocarCuerpo(cuerpo, colorCuerpo);

                            System.out.println("Selecciona las patas de tu alebrije");
                            patas = sn.nextInt();
                            System.out.println("Escoge el color de las patas");
                            colorPatas = sn.next();
                            fab.colocarPatas(patas, colorPatas);

                            System.out.println("Selecciona la cola de tu alebrije");
                            cola = sn.nextInt();
                            System.out.println("Escoge el color de la cola.");
                            colorCola = sn.next();
                            fab.colocarCola(cola, colorCola);

                            System.out.println("Terminaste de crear a tu alebrije\n"
                                    + fab.terminarAlebrije() + "\n¡Felicidades!");

                            Alebrijes prueba = fab.getAlebrije();
                            System.out.println(prueba.toFichero());
                        }
                        break;
                    case 6:
                        if (fab.alebrijesVacio()) {
                            System.out.println("\nNo has creado alebrijes :(\n");
                        } else {
                            System.out.println("\nAlebrijes que has creado :)\n");
                            System.out.println(fab.mostrarAlebrijes());
                        }
                        break;
                    case 7:
                        fab.eliminarCatalogo();
                        System.out.println("Se ha eliminado el catalogo actual de alebrijes.\n");
                        break;
                    case 8:
                        System.out.println("Inserta nombre del fichero con el catalogo");
                        nombreFichero = sn.next();
                        File archivoAux = new File(nombreFichero + ".txt");
                        if (!archivoAux.exists()) {
                            System.out.println("No existe o no se encuentra el archivo: " + nombreFichero);
                            break;
                        } else {
                            ListaLigada aux = fab.getCatalogo();
                            fab.eliminarCatalogo();
                            fab.cargaCatalogoFichero(nombreFichero);
                            if (fab.longitud() == 0) {
                                fab.setCatalogo(aux);
                                break;
                            }
                            System.out.println("Fichero cargado con exito");
                            break;
                        }

                    case 9:
                        if (!fab.catalogoVacio()) {
                            System.out.println("Inserta nombre del fichero con el alebrije creado.");
                            nombreFichero = sn.next();
                            File fileAux = new File(nombreFichero + ".txt");
                            Alebrijes pedido;
                            if (!fileAux.exists()) {
                                System.out.println("No existe o no se encuentra el archivo: " + nombreFichero);
                                break;
                            } else {
                                pedido = fab.agregarAlebrijeFichero(nombreFichero);
                                System.out.println(pedido);
                                int opcion3;
                                boolean salir3 = false;
                                while (!salir3) {
                                    System.out.println("¿Qué deseas modificar?\n"
                                            + "0. Nombre.\n" + "1. Cabeza.\n" + "2. Cuerpo.\n" + "3. Patas\n"
                                            + "4. Cola\n" + "5. Ver catalogo de animales disponibles\n"
                                            + "6. Terminar edicion.\n");
                                    System.out.println("Puedes ver el catalogo actual de animales.");
                                    System.out.println("Del catalogo de animales, puedes seleccionar un animal con su indice "
                                            + "para colocar la parte de su cuerpo en tu alebrije, ademas de asignarle un color");
                                    try {
                                        opcion3 = sn.nextInt();
                                        switch (opcion3) {
                                            case 0:
                                                System.out.println("Cambie el nombre a tu alebrije.");
                                                nombre = sn.next();
                                                pedido.setNombre(nombre);
                                                break;
                                            case 1:
                                                System.out.println("Seleciona un animal disponible."
                                                        + " para colocar la cabeza del alebrije");
                                                System.out.println("Selecciona la cabeza de tu alebrije");
                                                cabeza = sn.nextInt();
                                                System.out.println("Escoge el color de la cabeza.");
                                                colorCabeza = sn.next();
                                                pedido.setCabeza(fab.devolverAnimal(cabeza));
                                                pedido.setColorCabeza(colorCabeza);
                                                fab.colocarCabeza(cabeza, colorCabeza);
                                                break;
                                            case 2:
                                                System.out.println("Selecciona el cuerpo de tu alebrije");
                                                cuerpo = sn.nextInt();
                                                System.out.println("Escoge el color del cuerpo");
                                                colorCuerpo = sn.next();
                                                pedido.setCuerpo(fab.devolverAnimal(cuerpo));
                                                pedido.setColorCuerpo(colorCuerpo);
                                                fab.colocarCuerpo(cuerpo, colorCuerpo);
                                                break;
                                            case 3:
                                                System.out.println("Selecciona las patas de tu alebrije");
                                                patas = sn.nextInt();
                                                System.out.println("Escoge el color de las patas");
                                                colorPatas = sn.next();
                                                pedido.setPatas(fab.devolverAnimal(patas));
                                                pedido.setColorPatas(colorPatas);
                                                fab.colocarPatas(patas, colorPatas);
                                                break;
                                            case 4:
                                                System.out.println("Selecciona la cola de tu alebrije");
                                                cola = sn.nextInt();
                                                System.out.println("Escoge el color de la cola.");
                                                colorCola = sn.next();
                                                pedido.setCola(fab.devolverAnimal(cola));
                                                pedido.setColorCola(colorCola);
                                                fab.colocarCola(cola, colorCola);
                                                break;
                                            case 5:
                                                System.out.println("Animales disponibles.");
                                                System.out.println(fab.mostrarCatalogo());
                                                break;
                                            case 6:
                                                System.out.println("Edicion terminada");
                                                //fab.eliminarAlebrije(indice);
                                                fab.agregarAlebrije(pedido);
                                                System.out.println("¡Alebrije modificado!\n" + pedido);
                                                salir3 = true;
                                                break;
                                            default:
                                                System.out.println("Solo numeros entre 0 y 6");
                                        }
                                    } catch (InputMismatchException e) {
                                        System.out.println("Debes insertar un numero");
                                        sn.next();
                                    }
                                }
                                break;
                            }
                        } else {
                            System.out.println("No cuentas con los animales necesarios para "
                                    + "cargar tu alebrije.");
                            break;
                        }
                    case 10:
                        if (!fab.catalogoVacio()) {
                            System.out.println("Inserta nombre del fichero con el pedido del alebrije.");
                            nombreFichero = sn.next();
                            File fileAux = new File(nombreFichero + ".txt");
                            Alebrijes pedido;
                            if (!fileAux.exists()) {
                                System.out.println("No existe o no se encuentra el archivo: " + nombreFichero);
                                break;
                            } else {
                                pedido = fab.pedido(nombreFichero);
                                System.out.println(pedido);
                                int opcion3;
                                boolean salir3 = false;
                                while (!salir3) {
                                    System.out.println("¿Qué deseas modificar?\n"
                                            + "0. Nombre.\n" + "1. Cabeza.\n" + "2. Cuerpo.\n" + "3. Patas\n"
                                            + "4. Cola\n" + "5. Ver catalogo de animales disponibles\n"
                                            + "6. Terminar edicion.\n");
                                    System.out.println("Puedes ver el catalogo actual de animales.");
                                    System.out.println("Del catalogo de animales, puedes seleccionar un animal con su indice "
                                            + "para colocar la parte de su cuerpo en tu alebrije, ademas de asignarle un color");
                                    try {
                                        opcion3 = sn.nextInt();
                                        switch (opcion3) {
                                            case 0:
                                                System.out.println("Cambie el nombre a tu alebrije.");
                                                nombre = sn.next();
                                                pedido.setNombre(nombre);
                                                break;
                                            case 1:
                                                System.out.println("Seleciona un animal disponible."
                                                        + " para colocar la cabeza del alebrije");
                                                System.out.println("Selecciona la cabeza de tu alebrije");
                                                cabeza = sn.nextInt();
                                                System.out.println("Escoge el color de la cabeza.");
                                                colorCabeza = sn.next();
                                                pedido.setCabeza(fab.devolverAnimal(cabeza));
                                                pedido.setColorCabeza(colorCabeza);
                                                fab.colocarCabeza(cabeza, colorCabeza);
                                                break;
                                            case 2:
                                                System.out.println("Selecciona el cuerpo de tu alebrije");
                                                cuerpo = sn.nextInt();
                                                System.out.println("Escoge el color del cuerpo");
                                                colorCuerpo = sn.next();
                                                pedido.setCuerpo(fab.devolverAnimal(cuerpo));
                                                pedido.setColorCuerpo(colorCuerpo);
                                                fab.colocarCuerpo(cuerpo, colorCuerpo);
                                                break;
                                            case 3:
                                                System.out.println("Selecciona las patas de tu alebrije");
                                                patas = sn.nextInt();
                                                System.out.println("Escoge el color de las patas");
                                                colorPatas = sn.next();
                                                pedido.setPatas(fab.devolverAnimal(patas));
                                                pedido.setColorPatas(colorPatas);
                                                fab.colocarPatas(patas, colorPatas);
                                                break;
                                            case 4:
                                                System.out.println("Selecciona la cola de tu alebrije");
                                                cola = sn.nextInt();
                                                System.out.println("Escoge el color de la cola.");
                                                colorCola = sn.next();
                                                pedido.setCola(fab.devolverAnimal(cola));
                                                pedido.setColorCola(colorCola);
                                                fab.colocarCola(cola, colorCola);
                                                break;
                                            case 5:
                                                System.out.println("Animales disponibles.");
                                                System.out.println(fab.mostrarCatalogo());
                                                break;
                                            case 6:
                                                System.out.println("Edicion terminada");
                                                //fab.eliminarAlebrije(indice);
                                                fab.agregarAlebrije(pedido);
                                                System.out.println("¡Alebrije modificado!\n" + pedido);
                                                salir3 = true;
                                                break;
                                            default:
                                                System.out.println("Solo numeros entre 0 y 6");
                                        }
                                    } catch (InputMismatchException e) {
                                        System.out.println("Debes insertar un numero");
                                        sn.next();
                                    }
                                }
                                break;
                            }
                        } else {
                            System.out.println("No cuentas con los animales necesarios para "
                                    + "completar tu pedido.");
                            break;
                        }

                    case 11:
                        System.out.println("Escribe el nombre del archivo donde se guardara "
                                + "el catalogo de animales.\n" + "Si existe el archivo se sobreescribira.");
                        nombreFichero = sn.next();
                        fab.guardaCatalogo(nombreFichero);
                        System.out.println("¡Fichero con el catalogo de animales creado con exito!");
                        break;
                    case 12:
                        System.out.println("Escribe el nombre del archivo donde se guardara "
                                + "el catalogo de alebrijes creados.\n" + "Si existe el archivo se sobreescribira.");
                        nombreFichero = sn.next();
                        fab.guardaAlebrijes(nombreFichero);
                        System.out.println("¡Fichero con el catalogo de alebrijes creado con exito!");
                        break;
                    case 13:
                        fab.actualizaCatalogo();
                        break;
                    case 14:
                        fab.actualizaAlebrijes();
                        break;
                    case 15:
                        if (fab.alebrijesVacio()) {
                            System.out.println("No tienes alebrijes para modificar");
                            break;
                        } else {
                            Alebrijes brije;
                            System.out.println(fab.mostrarAlebrijes());
                            System.out.println("Selecciona un alebrije con su indice.");
                            indice = sn.nextInt();
                            brije = fab.devolverAlebrijes(indice);
                            int opcion2;
                            boolean salir2 = false;
                            while (!salir2) {
                                System.out.println("¿Qué deseas modificar?\n"
                                        + "0. Nombre.\n" + "1. Cabeza.\n" + "2. Cuerpo.\n" + "3. Patas\n"
                                        + "4. Cola\n" + "5. Ver catalogo de animales disponibles\n"
                                        + "6. Terminar edicion.\n");
                                System.out.println("Puedes ver el catalogo actual de animales.");
                                System.out.println("Del catalogo de animales, puedes seleccionar un animal con su indice "
                                        + "para colocar la parte de su cuerpo en tu alebrije, ademas de asignarle un color");
                                try {
                                    opcion2 = sn.nextInt();
                                    switch (opcion2) {
                                        case 0:
                                            System.out.println("Cambie el nombre a tu alebrije.");
                                            nombre = sn.next();
                                            brije.setNombre(nombre);
                                            break;
                                        case 1:
                                            System.out.println("Seleciona un animal disponible."
                                                    + " para colocar la cabeza del alebrije");
                                            System.out.println("Selecciona la cabeza de tu alebrije");
                                            cabeza = sn.nextInt();
                                            System.out.println("Escoge el color de la cabeza.");
                                            colorCabeza = sn.next();
                                            brije.setCabeza(fab.devolverAnimal(cabeza));
                                            brije.setColorCabeza(colorCabeza);
                                            fab.colocarCabeza(cabeza, colorCabeza);
                                            break;
                                        case 2:
                                            System.out.println("Selecciona el cuerpo de tu alebrije");
                                            cuerpo = sn.nextInt();
                                            System.out.println("Escoge el color del cuerpo");
                                            colorCuerpo = sn.next();
                                            fab.colocarCuerpo(cuerpo, colorCuerpo);
                                            break;
                                        case 3:
                                            System.out.println("Selecciona las patas de tu alebrije");
                                            patas = sn.nextInt();
                                            System.out.println("Escoge el color de las patas");
                                            colorPatas = sn.next();
                                            fab.colocarPatas(patas, colorPatas);
                                            break;
                                        case 4:
                                            System.out.println("Selecciona la cola de tu alebrije");
                                            cola = sn.nextInt();
                                            System.out.println("Escoge el color de la cola.");
                                            colorCola = sn.next();
                                            fab.colocarCola(cola, colorCola);
                                            break;
                                        case 5:
                                            System.out.println("Animales disponibles.");
                                            System.out.println(fab.mostrarCatalogo());
                                            break;
                                        case 6:
                                            System.out.println("Edicion terminada");
                                            fab.eliminarAlebrije(indice);
                                            fab.agregarAlebrije(brije);
                                            System.out.println("¡Alebrije modificado!\n" + brije);
                                            salir2 = true;
                                            break;
                                        default:
                                            System.out.println("Solo numeros entre 0 y 6");
                                    }
                                } catch (InputMismatchException e) {
                                    System.out.println("Debes insertar un numero");
                                    sn.next();
                                }
                            }

                        }
                        break;
                    case 16:
                        if (fab.alebrijesVacio()) {
                            System.out.println("No tienes alebrijes para guardar");
                        } else {
                            System.out.println(fab.mostrarAlebrijes());
                            System.out.println("\nSelecciona un alebrije con su indice para guardarlo en un fichero.\n"
                                    + "Se guardará en un fichero aparte, y se eliminara de tu catalogo de "
                                    + "alebrijes actual.");
                            indice = sn.nextInt();
                            System.out.println("Escribe el nombre del archivo que quieres crear.");
                            nombreFichero = sn.next();
                            Alebrijes brije = fab.devolverAlebrijes(indice);
                            fab.eliminarAlebrije(indice);
                            fab.creaAlebrijeFichero(nombreFichero, brije);
                        }
                        break;
                    case 17:
                        System.out.println(fab.mostrarCatalogo());
                        System.out.println("Ingresa el indice del animal que quieres modificar.");
                        indice = sn.nextInt();
                        fab.modificaAnimal(indice);
                        break;
                    case 0:
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo números entre 0 y 16");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }
        }
    }
}
