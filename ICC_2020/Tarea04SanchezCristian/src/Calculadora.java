
/**
 * Clase Calculadora
 *
 * @author Sanchez Segura Cristian Alonso No. Cuenta: 314217547
 * @version 1.0
 */
import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculadora {

    /**
     * Color de la calculadora
     */
    private String color;

    /**
     * Marca de la calculadora
     */
    private String marca;

    /**
     * Propietario de la calculadora
     */
    private String nombreDuenio;

    /**
     * Constructor de una calculadora.
     *
     * @param color color de la calculadora.
     * @param marca marca de la calculadora.
     * @param nombreDuenio propietario de la calculadora.
     */
    public Calculadora(String color, String tamaño, String marca, String duenio) {
        this.color = color;
        this.marca = marca;
        this.nombreDuenio = duenio;
    }

    /**
     * Constructor por default de una calculadora.
     */
    public Calculadora() {
        this.color = "Negro";
        this.marca = "Patito";
        this.nombreDuenio = "Sin dueño";
    }

    /**
     * Metodo toString para representar una calculadora
     */
    @Override
    public String toString() {
        return "Calculadora de: " + this.getDuenio() + ".\n Color: " + this.getColor() + ". \n Marca: " + this.getMarca();
    }

    /**
     * Modifica el color de la calculadora.
     *
     * @param color color de la calculadora.
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Modifica la marca de la calculadora.
     *
     * @param marca marca de la calculadora.
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * Modifica el duenio de la calculadora
     *
     * @param duenio duenio de la calculadora.
     */
    public void setDuenio(String duenio) {
        this.nombreDuenio = duenio;
    }

    /**
     * Regresa el color de la calculadora.
     *
     * @return el color de la calculadora.
     */
    //Métodos de Acceso, permiten ver el estado de una instancia (getters inlcuyen return, no llevan parámetros).
    public String getColor() {
        return this.color;
    }

    public String getMarca() {
        return this.marca;
    }

    public String getDuenio() {
        return this.nombreDuenio;
    }

    /**
     * Realiza una suma de dos numeros enteros.
     *
     * @param a primer numero
     * @param b segundo numero
     * @return a+b
     */
    public int sumarBinaria(int a, int b) {
        return a + b;
    }

    /**
     * Realiza una resta de dos numeros enteros.
     *
     * @param a primer numero
     * @param b segundo numero
     * @return a-b
     */
    public int restarBinaria(int a, int b) {
        return a - b;
    }

    /**
     * Realiza una multiplicación de dos numeros enteros.
     *
     * @param a primer numero
     * @param b segundo numero
     * @return a*b
     */
    public int multiplicar(int a, int b) {
        return a * b;
    }

    /**
     * Realiza una división de doa numeros enteros.
     *
     * @param a primer numero
     * @param b segundo numero
     * @return a/b
     */
    public int dividir(int a, int b) {
        if (b > 0) {
            return a / b;
        } else {
            return -1000; //Se pudo regresar cualquier otro numero "absurdo"
        }
    }

    /**
     * Obtiene el modulo de dos numeros enteros.
     *
     * @param a primer numero
     * @param b segundo numero
     * @return a%b
     */
    public int modular(int a, int b) {
        return a % b;
    }

    /**
     * Obtiene la suma de dos numeros enteros haciendo operaciones unarias
     * Postfijo
     *
     * @param a primer numero
     * @param b segundo numero
     * @return a+b
     */
    public int sumarPostfijo(int a, int b) {
        for (int i = 0; i < b; i++) {
            System.out.println("iteracion: " + i + " actual " + a + " x++ " + a++);

        }
        return a;
    }

    /**
     * Obtiene la resta de dos numeros enteros haciendo operaciones unarias
     * Postfijo
     *
     * @param a primer numero
     * @param b segundo numero
     * @return a-b
     */
    public int restarPostfijo(int a, int b) {
        for (int i = 0; i < b; i++) {
            System.out.println("iteracion: " + i + " actual " + a + " x-- " + a--);
        }
        return a;
    }

    /**
     * Obtiene la suma de dos numeros enteros haciendo operaciones unarias
     * Sufijo
     *
     * @param a primer numero
     * @param b segundo numero
     * @return a+b
     */
    public int sumarSufijo(int a, int b) {
        for (int i = 0; i < b; i++) {
            System.out.println("iteracion: " + i + " actual " + a + " ++x " + ++a);

        }
        return a;
    }

    /**
     * Obtiene la resta de dos numeros enteros haciendo operaciones unarias
     * Sufijo
     *
     * @param a primer numero
     * @param b segundo numero
     * @return a-b
     */
    public int restarSufijo(int a, int b) {
        for (int i = 0; i < b; i++) {
            System.out.println("iteracion: " + i + " actual " + a + " --x " + --a);
        }
        return a;
    }

    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario
        int primerValor;
        int segundoValor;
        int resultado;
        String nombre;
        String marca;
        String color;
        System.out.println("Calculadora de " + calculadora.getDuenio() + " te saluda. =)");
        while (!salir) {

            System.out.println("0. Salir\n" + "1. Configurar los datos de la calculadora\n"
                    + "2. Obtener datos\n" + "3. Hacer suma binaria\n"
                    + "4. Hacer resta binaria\n" + "5. Hacer multiplicación\n"
                    + "6. Hacer división\n" + "7. Hacer modulo\n"
                    + "8. Hacer suma operador incremento postfijo\n"
                    + "9. Hacer suma operador incremento sufijo\n"
                    + "10. Hacer resta operador incremento postfijo\n"
                    + "11. Hacer resta operador incremento sufijo\n");

            try {

                System.out.println("Escribe una de las opciones");
                opcion = sn.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.println("Has seleccionado la configuración de la calculadora.");
                        System.out.println("Vamos a configurar los datos de su calculadora:");
                        System.out.println("Ingresa tu nombre.");
                        nombre = sn.next();
                        System.out.println("Ingresa la marca de tu calculadora.");
                        marca = sn.next();
                        System.out.println("Ingresa el color de tu calculadora.");
                        color = sn.next();

                        calculadora.setDuenio(nombre);
                        calculadora.setMarca(marca);
                        calculadora.setColor(color);

                        System.out.println("Se guardo tu configuración.");
                        break;
                    case 2:
                        System.out.println("Datos de tu calculadora.");
                        System.out.println(calculadora.toString());
                        break;
                    case 3:
                        try {
                            System.out.println("Has seleccionado la operación suma binaria.");
                            System.out.println("Ingresa el primer valor.");
                            primerValor = sn.nextInt();
                            System.out.println("Ingresa el segundo valor que se sumará.");
                            segundoValor = sn.nextInt();
                            resultado = calculadora.sumarBinaria(primerValor, segundoValor);
                            System.out.println("Resultado -> " + resultado);
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("Debes insertar un número");
                            break;
                        }
                    case 4:
                        try {
                            System.out.println("Has seleccionado la operación resta binaria.");
                            System.out.println("Ingresa el primer valor.");
                            primerValor = sn.nextInt();
                            System.out.println("Ingresa el segundo valor que restará.");
                            segundoValor = sn.nextInt();
                            resultado = calculadora.restarBinaria(primerValor, segundoValor);
                            System.out.println("Resultado -> " + resultado);
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("Debes insertar un número");
                            break;
                        }
                    case 5:
                        try {
                            System.out.println("Has seleccionado la operación multiplicación.");
                            System.out.println("Ingresa el primer valor.");
                            primerValor = sn.nextInt();
                            System.out.println("Ingresa el segundo valor que multiplicará.");
                            segundoValor = sn.nextInt();
                            resultado = calculadora.multiplicar(primerValor, segundoValor);
                            System.out.println("Resultado -> " + resultado);
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("Debes insertar un número");
                            break;
                        }
                    case 6:
                        try {
                            System.out.println("Has seleccionado la operacion de dividir");
                            System.out.println("Ingresa el primer valor.");
                            primerValor = sn.nextInt();
                            System.out.println("Ingresa el segundo valor que dividrá.");
                            segundoValor = sn.nextInt();
                            resultado = calculadora.dividir(primerValor, segundoValor);
                            System.out.println("Resultado -> " + resultado);
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("Debes insertar un número");
                            break;
                        }
                    case 7:
                        try {
                            System.out.println("Has seleccionado la operación modulo.");
                            System.out.println("Ingresa el primer valor.");
                            primerValor = sn.nextInt();
                            System.out.println("Ingresa el modulo.");
                            segundoValor = sn.nextInt();
                            resultado = calculadora.modular(primerValor, segundoValor);
                            System.out.println("Resultado -> " + resultado);
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("Debes insertar un número");
                            break;
                        }
                    case 8:
                        try {
                            System.out.println("Has seleccionado la operación suma incremento postfijo.");
                            System.out.println("Ingresa el primer valor.");
                            primerValor = sn.nextInt();
                            System.out.println("Ingresa el segundo valor.");
                            segundoValor = sn.nextInt();
                            resultado = calculadora.sumarPostfijo(primerValor, segundoValor);
                            System.out.println("Resultado -> " + resultado);
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("Debes insertar un número");
                            break;
                        }
                    case 9:
                        try {
                            System.out.println("Has seleccionado la operación suma incremento sufijo.");
                            System.out.println("Ingresa el primer valor.");
                            primerValor = sn.nextInt();
                            System.out.println("Ingresa el segundo valor.");
                            segundoValor = sn.nextInt();
                            resultado = calculadora.sumarSufijo(primerValor, segundoValor);
                            System.out.println("Resultado -> " + resultado);
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("Debes insertar un número");
                            break;
                        }
                    case 10:
                        try {
                            System.out.println("Has seleccionado la operación resta operador incremento postfijo.");
                            System.out.println("Ingresa el primer valor.");
                            primerValor = sn.nextInt();
                            System.out.println("Ingresa el segundo valor.");
                            segundoValor = sn.nextInt();
                            resultado = calculadora.restarPostfijo(primerValor, segundoValor);
                            System.out.println("Resultado -> " + resultado);
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("Debes insertar un número");
                            break;
                        }
                    case 11:
                        try {
                            System.out.println("Has seleccionado la operación resta operador incremento sufijo.");
                            System.out.println("Ingresa el primer valor.");
                            primerValor = sn.nextInt();
                            System.out.println("Ingresa el segundo valor.");
                            segundoValor = sn.nextInt();
                            resultado = calculadora.restarSufijo(primerValor, segundoValor);
                            System.out.println("Resultado -> " + resultado);
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("Debes insertar un número");
                            break;
                        }
                    case 0:
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo números entre 0 y 11");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }
        }
        System.out.println("Calculadora de " + calculadora.getDuenio() + " fuera.");
    }
}
