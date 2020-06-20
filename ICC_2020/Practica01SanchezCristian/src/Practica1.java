/**
* Practica 1 del curso ICC.
 * @author Cristian Alonso Sanchez Segura
 * @version 1.0
*/
public class Practica1{

	public static void main(String[] args) {
		
		//Actividad 1
		/* 
		 * byte: El tipo de dato byte es un entero de 8 bits complemento a dos. 
		 * Su valor mínimo es -128 y el máximo 127. Se puede utilizar para ahorrar memoria
		 * arreglos grandes.
		*/
		byte cuatro;
		byte dos;

		/*
		 * short: El tipo de dato short es un entero de 16 bits complemento a dos.
		 * Puede utilizar short para ahorrar memoria en grandes arreglos
		*/
		short uno;
		short tres;

		/*
		 * int: El tipo de dato int es un entero de 32 bits complemento a dos.
		 * Su valor mínimo es -2,147,483,648 y el máximo 2,147,483,647.
		 * Este tipo de dato normalmente será lo suficiente grande para 
		 * representar los valores que ocupemos.
		*/
		int cuatroCientos;
		int unMilMillon;

		/*
		 * long: El tipo de dato long es un entero de 64 bits complemento a dos. 
		 * Su valor mínimo es -9,223,372,036,854,775,808 y el máximo 
		 * 9,223,372,036,854,775,807. Se requiere escribir una l al final 
		 * del numero, para indicar que estamos usando long
		*/
		long nueveBillones;
		long tresMilMillones;

		/*
		 * float: El tipo de dato float es un dato en coma flotante IEEE 754 de
		 * 32 bits y precisión simple. Al igual que con byte y short, se 
		 * recomienda usar un float (en vez de un double) si necesita ahorrar 
		 * memoria. Y se requiere indicar con una f al final del numero, para
		 * especificar que se usará float.
		*/
		float dosPuntoTres;
		float cienPuntoCeroUno;

		/*
		 * double: El tipo de dato double es un dato en coma flotante IEEE 754 
		 * de 64 bits y precisión doble. Se requiere escribir un d al final del
		 * numero para indicar que es un double.
		*/
		double cienPuntoTresMilMillones;
		double tresMilMillonesPuntoCienMilMillones;

		/*
		 * boolean: Es un tipo de dato que permite la
		 * facilidad de verificaciones
		*/
		boolean verdadero;
		boolean falso;

		/*
		 * char: El tipo de dato char es un solo carácter Unicode de 16 bits. 
		 * Tiene un valor mínimo de '\u0000' y un máximo de '\uffff'.
		*/
		char a;
		char h;

		//Actividad 2
		/* byte */
		cuatro = 4;
		dos = 2;

		/* short */
		uno = 1;
		tres = 3;

		/* int */
		cuatroCientos = 400;
		unMilMillon = 1000000000;

		/* long */
		nueveBillones = 9000000000000l;
		tresMilMillones = 3000000000l;

		/* float */
		dosPuntoTres = 2.3f;
		cienPuntoCeroUno = 100.01f;

		/* double */
		cienPuntoTresMilMillones = 100.3000000000d;
		tresMilMillonesPuntoCienMilMillones = 3000000000.100000000000d;

		/* boolean */
		verdadero = true;
		falso = false;

		/* char */
		a = 'a';
		h = 'h';

		//Actividad 3

		/* Utilizamos boolean para la verificacion de falso o verdadero */
		boolean booleanTrue = true;

		/* Utilizamos int porque es un numero entero básico*/
		int cientoVeitisiete = 127;

		/* Utilizamos int porque es un numero entero básico,
		 * aunque es mayor que 127, entra en el rango de int
		*/
		int treintaYDosMil = 32000;

		/* Utilice int ya que el numero aun entra en el rango, pero
		 * para este punto, lo recomendable sería usar long, en caso
		 * de que la variable sobrepase el rango de int, y tengamos
		 * algún error
		*/
		int dosMilMillones = 2000000000;

		/* Utilizamos long, ya que no podríamos representarlo con el rango
		 * de int
		*/
		long doscientosMilMillones = 200000000000l;

		/* Utilizamos char ya que es un único caracter */
		char b = 'b';

		/* Utilizamos float ya que es un número de punto flotante, y podemos
		 * representarlo con el rango de float */
		float unoPuntodosMil = 1.2000f;

		/* Se puede utilizar tanto float como double, ya que ambos tienen el rango
		 * suficiente para representar el digito, pero use double, para utilizar
		 * todos los datos primitivos de java.
		*/
		double unoPuntoDoscientosMilMillones = 1.200000000000d;


		//Actividad 4

		// 1
		float y = 2f;

		System.out.println("Este es y: " + y);

		// 2
		float x = 0f;

		x = ((y*y*y)*(y/((y*y)+1)));
		System.out.println("Este es x: " + x);

		// 3
		double z = 0d;
		z = x*((x+30)/((y*y)+((x*x)/y)));
		System.out.println("Este es z: " + z);

		//4
		boolean w = true && false || true || true;
		System.out.println("Este es w: " + w);

		//5
		boolean v = false || w && w || false || !false;
		System.out.println("Este es v: " + v);

	}
}