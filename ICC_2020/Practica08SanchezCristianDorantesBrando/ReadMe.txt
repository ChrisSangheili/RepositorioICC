Sanchez Segura Cristian Alonso No. Cuenta: 314217547
Brando Dorantes Perez No. Cuenta: 314255356

Especificaciones de la practica:

- Para crear cartas se utiliza un archivo ya creado, se llama "Cartas.txt", para no confundirnos utilizamos emoticonos, pero creo
  que no se ven en todas las maquinas, por tanto agregamos mas archivos con cartas para crear:
	"Cartas2.txt" - Creara cartas cuyo simbolo son letras.
	"Cartas3.txt" - Creara cartas cuyo simbolo son caritas con simbolos.
	"Cartas4.txt" - Creara cartas cuyo simbolo es el nombre de los colores.
	Para cambiar el archivo de donde se tomarán las cartas, solo se tiene que agregar el nombre del archivo correspondiente 
	al constructor del memorama, esto en el main de la clase Memorama.

- Se crean las cartas necesarias para un tablero de 4x4, es decir, se crean 16 cartas, todas se crean a partir de un solo archivo,
  esto, porque creimos que sería mejor leerlas de un solo archivo a crear 16 archivos donde cada uno seria una carta que leer.

- El archivo "Guardado.txt" es una partida guardada con las cartas que tienen emoticonos. 

- Para la creación y el pedido de archivos basta con escribir el nombre del archivo, el programa le coloca la extensión .txt

- Por lo anterior si se quieren crear archivos de guardado a mano y/o crear archvios donde se encuentren las cartas, los archivos
  deberan contar con la extensión .txt

- Al ser una versión básica, siempre se colocan las cartas en la misma posición :c Sería la única observación que le haría al programa.

Para compilar la practica.
$ cd Practica08SanchezCristianDorantesBrando
Practica08SanchezCristianDorantesBrando$ javac *.java
Practica08SanchezCristianDorantesBrando$ java Memorama