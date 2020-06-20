/**
 * Proyecto 01 del Curso de ICC
 *
 * @author Cristian Alonso Sanchez Segura numCta: 314217547
 * @version 1.0
 *
 * Los servicios que debe ofrecer un numero complejo de la forma a + bi
 */
public class Complejo implements ServiciosComplejo {

    /* La parte real del numero complejo*/
    private double real;

    /* La parte imaginaria del numero complejo*/
    private double imaginario;

    /**
     * Constructor por defecto de un numero complejo. La parte real tiene un
     * valor de 2.3 La parte imaginaria tiene un valor de 5.1
     */
    public Complejo() {
        real = 2.3d;
        imaginario = 5.1d;
    }

    /**
     * Constructor de un numero complejo
     *
     * @param real Es la parte real de un numero complejo
     * @param imaginario Es la parte imaginaria de un numero complejo
     */
    public Complejo(double real, double imaginario) {
        this.real = real;
        this.imaginario = imaginario;
    }

    /**
     * Suma dos numeros complejos y entrega el resultado.
     *
     * @param c El segundo complejo (El primero es el objeto con que se invoca
     * ).
     * @return El complejo que corresponde a: 
     * (a+bi) + (c + di) = (a + c) + (b + d)i
     */
    public Complejo suma(Complejo c) {
        double realSuma = this.real + c.getReal();
        double imaginarioSuma = this.imaginario + c.getImaginario();
        Complejo resultado = new Complejo(realSuma, imaginarioSuma);

        return resultado;
    }

    /**
     * Multiplica dos numeros complejos y entrega el resultado .
     *
     * @param otro El segundo complejo (El primero es el objeto con que se
     * invoca ).
     * @return El complejo que corresponde a:
     * (a + bi) * (c + di) = (ac - bd) + (ad + bc)i
     */
    public Complejo multiplica(Complejo otro) {
        double realMulti = (this.real * otro.getReal()) - (imaginario * otro.getImaginario());
        double imaginarioMulti = (this.real * otro.getImaginario()) + (this.imaginario * otro.getReal());
        Complejo resultado = new Complejo(realMulti, imaginarioMulti);

        return resultado;

    }

    /**
     * Calcula el cuadrado del complejo con que se invoca .
     *
     * @return El complejo que corresponde a: (a + bi)^2
     */
    public Complejo cuadrado() {
        //La parte real del cuadrado de un complejo
        double realCuadrado = ((this.real * this.real) - (this.imaginario * this.imaginario));

        //La parte imaginaria del cuadrado de un complejo
        double imaginarioCuadrado = (this.real * this.imaginario) * 2;

        Complejo resultado = new Complejo(realCuadrado, imaginarioCuadrado);
        return resultado;
    }

    /**
     * Calcula el cubo del complejo con que se invoca .
     *
     * @return El complejo que corresponde a: (a + bi)^3
     */
    public Complejo cubo() {
        Complejo cuadrado = this.cuadrado();
        return this.multiplica(cuadrado);
    }

    /**
     * Calcula el conjugado del complejo con que se invoca .
     *
     * @return El complejo que corresponde a: a + bi = a - bi
     */
    public Complejo conjugado() {
        double realConj = this.real;
        double imaginarioConj = this.imaginario * -1;
        Complejo resultado = new Complejo(realConj, imaginarioConj);
        return resultado;
    }

    /**
     * Calcula el inverso multiplicativo del complejo con que se invoca .
     *
     * @return El complejo que corresponde a: (a + bi)^-1 = a + bi/ a^2 + b^2
     */
    public Complejo inverso() {
        if (this.real == 0 && this.imaginario == 0) {
            return null;
        }

        double inverso = (this.real * this.real)
                + (this.imaginario * this.imaginario);
        double realInverso = this.real / inverso;
        double imaginarioInverso = this.imaginario / inverso;
        Complejo resultado = new Complejo(realInverso, imaginarioInverso);

        return resultado.conjugado();
    }

    /**
     * Divide dos numeros complejos y entrega el resultado .
     *
     * @param otro El segundo complejo (El primero es el objeto con que se
     * invoca ).
     * @return El complejo que corresponde a:
     *  a + bi/c + di = (a + bi) * (c + di)^-1
     */
    public Complejo divide(Complejo otro) {

        Complejo resultado = this.multiplica(otro.inverso());
        return resultado;
    }

    /**
     * Calcula el modulo del complejo con que se invoca .
     *
     * @return El complejo que corresponde a: |a + bi| = sqrt(a^2 + b^2)
     */
    public double modulo() {

        double resultado = Math.sqrt((this.real * this.real) + (this.imaginario * imaginario));
        return resultado;
    }

    /**
     * Compara dos numeros complejos para saber si son iguales .
     *
     * @param otro El segundo complejo (El primero es el objeto con que se
     * invoca ).
     * @return true si son iguales , false en otro caso. 
     * a = c y b = d implica (a + bi) = (c + di)
     */
    public boolean esIgual(Complejo otro) {
        boolean esIgual = ((this.real == otro.getReal()) && (this.imaginario == otro.getImaginario()));
        return esIgual;
    }

    /**
     * Devuelve una cadena en formato adecuado que representa al complejo que
     * invoca el metodo .
     *
     * @return Una cadena con formato adecuado .
     */
    public String muestra() {
        if (this.imaginario >= 0) {
            return "(" + String.format("%.3f", this.real)
                    + " + " + String.format("%.3f", this.imaginario) + "i)";
        } else {
            return "(" + String.format("%.3f", this.real)
                    + "  " + String.format("%.3f", this.imaginario) + "i)";
        }
    }

    //Getter, Setter y toString
    /**
     * Devuelve la parte real de un complejo
     *
     * @return real de un numero complejo
     */
    public double getReal() {
        return real;
    }

    /**
     * Asigna el valor real al numero complejo
     *
     * @param real El valor de la parte real de un complejo
     */
    public void setReal(double real) {
        this.real = real;
    }

    /**
     * Devuelve la parte imaginaria de un numero complejo
     *
     * @return imaginario de un numero complejp
     */
    public double getImaginario() {
        return imaginario;
    }

    /**
     * Asigna el valor imaginario al numero complejo
     *
     * @param imaginario El valor de la parte imaginaria de un complejo
     */
    public void setImaginario(double imaginario) {
        this.imaginario = imaginario;
    }

    /**
     * Metodo toString de la clase.
     */
    @Override
    public String toString() {
        if (this.imaginario >= 0) {
            return "(" + String.format("%.3f", this.real)
                    + " + " + String.format("%.3f", this.imaginario) + "i)";
        } else {
            return "(" + String.format("%.3f", this.real)
                    + "  " + String.format("%.3f", this.imaginario) + "i)";
        }
    }

    public static void main(String[] args) {
        Complejo c1 = new Complejo();
        Complejo c2 = new Complejo(3.0, 6.0);
        Complejo prueba = new Complejo(-1.0, 2.0);
        Complejo bran = new Complejo(7, 5);
        Complejo resultado = c1.cuadrado();
        double modulo;

        //Metodo suma
        resultado = c1.suma(c2);
        System.out.println("Suma de dos numeros complejos:\n" + c1.muestra()
                + " + " + c2.muestra() + " = " + resultado + "\n");

        //Metodo multiplica
        resultado = c1.multiplica(bran);
        System.out.println("Multiplicacion de dos numeros complejos:\n" + c1.muestra()
                + " * " + bran.muestra() + " = " + resultado + "\n");

        //Metodo cuadrado
        resultado = bran.cuadrado();
        System.out.println("Un numero complejo elevado al cuadrado:\n" + bran.muestra()
                + "^2 = " + resultado + "\n");

        //Metodo cubo
        resultado = c1.cubo();
        System.out.println("Un numero complejo elevado al cubo:\n" + c1.muestra()
                + "^3 = " + resultado + "\n");

        //Metodo conjugado
        resultado = prueba.conjugado();
        System.out.println("El conjugado de un numero complejo:\n" + prueba.muestra()
                + " = " + resultado + "\n");

        //Metodo inverso
        resultado = c2.inverso();
        System.out.println("El inverso de un numero complejo:\n" + c2.muestra()
                + "^-1 = " + resultado + "\n");

        //Metodo divide
        resultado = c1.divide(c2);
        System.out.println("Division de dos numeros complejos:\n" + c1.muestra()
                + " / " + c2.muestra() + " = " + resultado + "\n");

        resultado = bran.divide(c2);
        System.out.println("Division de dos numeros complejos:\n" + bran.muestra()
                + " / " + c2.muestra() + " = " + resultado + "\n");

        //Metodo modulo
        modulo = c1.modulo();
        System.out.println("Modulo de un numero complejo:\n" + c1.muestra()
                + " = " + modulo + "\n");

        //Metodo esIgual
        System.out.println("Verifica si dos numeros complejos son inguales:\n "
                + c1.muestra() + " == " + bran.muestra() + " = " + c1.esIgual(bran) + "\n");

        System.out.println("Verifica si dos numeros complejos son inguales:\n "
                + prueba.muestra() + " == " + c2.muestra() + " = " + prueba.esIgual(c2) + "\n");

        System.out.println("Verifica si dos numeros complejos son inguales:\n "
                + c1.muestra() + " == " + c1.muestra() + " = " + c1.esIgual(c1) + "\n");

        //Metodo muestra
        System.out.println("Muestra la representación de un numero complejo.");
        System.out.println("Complejo 1:\n" + c1.muestra() + "\n");
        System.out.println("Complejo 2:\n" + c2.muestra() + "\n");
        System.out.println("Complejo 3:\n" + prueba.muestra() + "\n");
        System.out.println("Complejo 4:\n" + bran.muestra() + "\n");
        System.out.println("Complejo 5:\n" + resultado.muestra() + "\n");

    }

}
