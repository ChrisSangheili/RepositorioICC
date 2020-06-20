
/**
 * Tarea 02 del Curso de ICC
 *
 * @author Cristian Alonso Sanchez Segura numCta: 314217547
 * @version 1.0
 */
public class Calculadora {

    /* Variable para el nombre de la calculadora*/
    public String nombre;

    /* Variable para el color de la calculadora*/
    public String color;

    /**
     * Constructor de la clase calculadora.
     *
     * @param nombre nombre que tendra la calculadora
     * @param color color que tendra la calculadora
     */
    public Calculadora(String nombre, String color) {
        this.nombre = nombre;
        this.color = color;
    }

    /**
     * Metodo que hace la conjuncion de dos booleanos
     * @param bool1
     * @param bool2
    */
    public void conjuncion(boolean bool1, boolean bool2){
        System.out.println("La conjuncion logica de " + bool1 + " y "
            + bool2 + " es: " + (bool1&&bool2));
     }
    /**
     * Metodo que hace la disyuncion de dos booleanos
     * @param bool1
     * @param bool2
    */
    public void disyuncion(boolean bool1, boolean bool2){
        System.out.println("La disyuncion logica de " + bool1 + " y "
            + bool2 + " es: " + (bool1||bool2));
    }

    /**
     * Metodo que hace la impliacion de dos booleanos
     * @param bool1
     * @param bool2
    */
    public void implicacion(boolean bool1, boolean bool2){
        System.out.println("La implicacion logica de " + bool1 + " y "
            + bool2 + " es: " + (!bool1||bool2));
    }
     /**
     * Metodo que hace la doble impliacion de dos booleanos
     * @param bool1
     * @param bool2
    */   
    public void dobleImplicacion(boolean bool1, boolean bool2){
        System.out.println("La doble implicacion logica de " + bool1 + " y "
            + bool2 + " es: " + ((!bool1||bool2) && (!bool2||bool1)));
    }
    /**
     * Metodo que suma dos numeros
     *
     * @param sumando1
     * @param sumando2
     */
    public void sumarBinario(int sumando1, int sumando2) {
        System.out.println("La suma de: " + sumando1 + " y " + sumando2
                + " es: " + (sumando1 + sumando2));

    }

    /**
     * Metodo que suma dos numeros de forma iterativa y sufija.
     *
     * @param sumando1
     * @param sumando2
     */
    public void sumarSufijo(int sumando1, int sumando2) {
        System.out.println("La suma sufija iterativa de: " + sumando1 + " y "
                + sumando2 + " es:");
        for (int i = 0; i <= sumando2; i++) {
            System.out.println((sumando1++));
        }
    }

    /**
     * Metodo que suma dos numeros de forma iterativa y posfija.
     *
     * @param sumando1
     * @param sumando2
     */
    public void sumarPosfijo(int sumando1, int sumando2) {
        System.out.println("La suma posfija iterativa de: " + sumando1 + " y "
                + sumando2 + " es:");
        for (int i = 0; i < sumando2; i++) {
            System.out.println((++sumando1));

        }
    }

    /**
     * Metodo que resta dos numeros.
     *
     * @param restando1
     * @param restando2
     */
    public void restarBinario(int restando1, int restando2) {
        System.out.println("La resta de: " + restando1 + " y " + restando2
                + " es: " + (restando1 - restando2));

    }

    /**
     * Metodo que resta dos numeros de forma iterativa y sufija.
     *
     * @param restando1
     * @param restando2
     */
    public void restarSufijo(int restando1, int restando2) {
        System.out.println("La resta sufija iterativa de: " + restando1 + " y "
                + restando2 + " es:");
        for (int i = 0; i <= restando2; i++) {
            System.out.println((restando1--));
        }
    }

    /**
     * Metodo que resta dos numeros de forma iterativa y posfija.
     *
     * @param restando1
     * @param restando2
     */
    public void restarPosfijo(int restando1, int restando2) {
        System.out.println("La resta posfija iterativa de: " + restando1 + " y "
                + restando2 + " es:");
        for (int i = 0; i < restando2; i++) {
            System.out.println((--restando1));

        }
    }

    /**
     * Metodo que multiplca dos numeros de forma iterativa.
     *
     * @param multiplicando
     * @param multiplicador
     */
    public void multiplicar(int multiplicando, int multiplicador) {
        System.out.println("La multiplicacion iterativa de: " + multiplicando + " y "
                + multiplicador + " es:");
        int contador = multiplicando;
        for (int i = 0; i < multiplicador; i++) {
            System.out.println(contador);
            contador += multiplicando;

        }
    }

    /**
     * Metodo que divide dos numeros de forma iterativa.
     *
     * @param dividendo
     * @param divisor
     */
    public void dividir(int dividendo, int divisor) {
        System.out.println("La division iterativa de: " + dividendo + " y "
                + divisor + " es:");
        int cociente = 0;
        for (int i = 0; dividendo > 0; i++) {
            System.out.println("Cociente: " + cociente);
            System.out.println("Dividendo: " + dividendo);
            System.out.println("Resto: " + (dividendo));

            dividendo = dividendo - divisor;
            cociente++;
        }
    }

    /**
     * Metodo que saca el modulo dos numeros de forma iterativa.
     *
     * @param mod1
     * @param mod1
     */
    public void modulo(int mod1, int mod2) {
        System.out.println("El modulo iterativo de: " + mod1 + " y "
                + mod2 + " es:");
        for (int i = 0; mod1 > 0; i++) {
            System.out.println("Modulo: " + (mod1));

            mod1 = mod1 - mod2;
        }
    }

    /**
     * Metodo que ordena tres numeros de forma, nos dice si hay un numero mayor,
     * uno mejor, y/o si son iguales.
     *
     * @param numero1
     * @param numero2
     * @param numero3
     */
    public void ordenar(int numero1, int numero2, int numero3) {
        if (numero1 == numero2 && numero2 == numero3) {
            System.out.println("Los numeros: " + numero1 + ", " + numero2
                    + ", " + numero3 + "; son iguales");
        }
        if (numero1 == numero2 && numero2 > numero3) {
            System.out.println("Los numeros " + numero1 + " y " + numero2
                    + " son iguales, el menor es " + numero3);
        }
        if (numero1 == numero2 && numero2 < numero3) {
            System.out.println("Los numeros " + numero1 + " y " + numero2
                    + " son iguales, el mayor es " + numero3);
        }
        if (numero1 == numero3 && numero3 > numero2) {
            System.out.println("Los numeros " + numero1 + " y " + numero3
                    + " son iguales, el menor es " + numero3);
        }
        if (numero1 == numero3 && numero3 < numero2) {
            System.out.println("Los numeros " + numero1 + " y " + numero3
                    + " son iguales, el mayor es " + numero3);
        }

        if (numero1 > numero2 && numero1 > numero3) {

            if (numero2 > numero3) {

                System.out.println("El numero " + numero1 + " es el mayor,"
                        + " el numero " + numero3 + "es el menor y no hay numeros iguales.");
            }
            if (numero2 < numero3) {
                System.out.println("El numero " + numero1 + " es el mayor,"
                        + " el numero " + numero2 + "es el menor y no hay numeros iguales.");
            }
        }
        if (numero2 > numero1 && numero2 > numero3) {
            if (numero1 > numero3) {
                System.out.println("El numero " + numero2 + " es el mayor,"
                        + " el numero " + numero3 + "es el menor y no hay numeros iguales.");
            }
            if (numero1 < numero3) {
                System.out.println("El numero " + numero2 + " es el mayor,"
                        + " el numero " + numero1 + "es el menor y no hay numeros iguales.");
            }
        }
        if (numero3 > numero1 && numero3 > numero2) {
            if (numero1 > numero2) {
                System.out.println("El numero " + numero3 + " es el mayor,"
                        + " el numero " + numero2 + "es el menor y no hay numeros iguales.");
            }
            if (numero1 < numero2) {
                System.out.println("El numero " + numero3 + " es el mayor,"
                        + " el numero " + numero1 + "es el menor y no hay numeros iguales.");
            }
        }
    }

    //Metodos getter y setter, por eso no los comento xd
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Metodo toString
    */
    @Override
    public String toString() {
        return "Calculadora de Harvard\n" + "Propietario: " + nombre + "\nColor: " + color;
    }
    
    public static void main(String[] args) {

        Calculadora calculadora = new Calculadora("Director", "rojo");
        System.out.println(calculadora);

        System.out.println("-----------------------------------");
        calculadora.conjuncion(true,false);//false
        System.out.println("-----------------------------------");
        calculadora.disyuncion(false,true);//true
        System.out.println("-----------------------------------");
        calculadora.implicacion(false,true);//true
        System.out.println("-----------------------------------");
        calculadora.dobleImplicacion(false,false);//true
        System.out.println("-----------------------------------");
        calculadora.sumarBinario(3,10);
        System.out.println("-----------------------------------");
        calculadora.sumarSufijo(3,10);
        System.out.println("-----------------------------------");
        calculadora.sumarPosfijo(3,10);
        System.out.println("-----------------------------------");
        calculadora.restarBinario(10,8);
        System.out.println("-----------------------------------");
        calculadora.restarSufijo(10,8);
        System.out.println("-----------------------------------");
        calculadora.restarPosfijo(10,8);
        System.out.println("-----------------------------------");
        calculadora.multiplicar(3,3);
        System.out.println("-----------------------------------");
        calculadora.dividir(15,3);
        System.out.println("-----------------------------------");
        calculadora.modulo(3,2);
        System.out.println("-----------------------------------");
        calculadora.ordenar(19,2,4);
        System.out.println("-----------------------------------");
        calculadora.ordenar(27,27,27);
        System.out.println("-----------------------------------");
        calculadora.ordenar(10,10,1);
        System.out.println("-----------------------------------");

        Integer x = 10;

    }
}
