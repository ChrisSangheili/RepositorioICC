public class Preguntas{
	
	public static void main(String[] args) {

		//Pregunta 1.1
		char[] arregloCaracteres = new char[1];
		System.out.println(arregloCaracteres[0] == 0);

		//Pregunta 1.2
		arregloCaracteres[0] ='a';
		System.out.println(arregloCaracteres[0]);

		//Pregunta 1.3
		//System.out.println(arregloCaracteres[-1]);

		//Pregunta 1.4
		int maxIndex = arregloCaracteres.length;
		//System.out.println(arregloCaracteres[maxIndex]);


		//Pregunta 2
		int minas = 4;
		char minasC = Character.forDigit(minas,10);
		int minas2 = 11;
		char minasC2 = Character.forDigit(minas2,10);
		System.out.println(minasC);
		System.out.println(minasC2);
	}
}