Sanchez Segura Cristian Alonso No. Cuenta: 314217547
Brando Dorantes Perez No. Cuenta: 314255356

Especificaciones del proyecto:

- Al iniciar el programa se cargará un catalogo de animales a partir del archivo "Animales.txt"

- Se encuentran ejemplos para utilizar, el nombre de los archivos es:
	#"Pedido.txt" - Crea un alebrije sobre pedido.
	#"Animales.txt" - Catalogo de animales
	#"Yoko.txt" - Alebrije creado y guardado de forma individual en un fichero.

- Sigue estando la opción de utilizar el catalogo precargado sin utilizar archivos, si se usa esta opción
  y ya existe un catalogo actual de animales, este borrará el catalogo actual para usar el precargado.

- Igualmente, si se carga un catalogo nuevo, se elimina el actual.

- Para el nombre de ficheros, solo es necesario escribir el nombre del archivo.

- Todos los archivos que se leen y se escriben usan la extension .txt

- Si la extension .txt no se encuentra no se podrá cargar un archivo.

- Guardar catalogo de alebrijes y de animales sobreescribe los archivos, es decir, si se utiliza un archivo existente
  se borrará su contenido.

- Actualizar alebrijes y animales, actualizan su archivo correspondiente donde se están guardando los catalogos.
  Es decir, si se guarda un catalogo, y despues se guarda otro catalogo con un nombre de archivo diferente, 
  al actualizar el catalogo se actualizará el segundo catalogo.

- El formato para crear catalogos de un archivo es el siguiente:
	"nombreAnimal,¿TieneAlas?,¿TienePatas?,¿TieneCola?"
	Ejemplos:
		Perro,false,true,true
		Serpiente,false,false,true
		Pato,true,true,true

- El formato para leer un alebrije ya creado es el siguiente
	"nombreAlebrije,cabezaAlebrije,colorCabeza,cuerpoAlebrije,colorCuerpo,patasAlebrije,colorPatas,colaAlebrije,colorCola"
	Ejemplos:
		Yoko,Pato,Azul,Mono,Verde,Gato,Rojo,Leon,

		Cris,Serpiente,Morado,Gato,Gris,Leon,Rojo,Perro,Blanco
- El formato para realizar un pedido de un alebrije
	Nombre:nombreAlebrije#Cabeza:cabezaAlebrije,colorCabeza#Cuerpo:cuerpoAlebrije,colorCuerpo#Patas:patasAlebrije,colorPatas#Cola:colaAlebrije,colorCola
	Ejemplos:
		"Nombre:Coco#Cabeza:Conejo,Amarillo#Cuerpo:Mono,Rojo#Patas:Perro,Verdes#Cola:Pato,Blanco"

- Las dos acciones anteriores, se busca que existan los animales en el catalogo para poder cargar los alebrijes y hacerle las
  respectivas modificaciones

- Puede fallar al crear alebrijes, ya que puede crear alebrijes cargados de un fichero, y que los animales necesarios para 
  su creación no se encuentren en el catalogo actual de animales. Se espera que casi no suceda esto, pero podría pasar.

- Al guardar un alebrije en un archivo por separado, se eliminará del catalogo actual de alebrijes y se guardará para
  poderle hacer modificaciones.

- Se pueden modificar alebrijes ya creados utilizando el índice en el que se encuentran en su catalogo respectivo de alebrijes.

- Siempre que se pida una parte de algun animal, como la cabeza, cuerpo o cola, se tiene que ingresar el indice de un animal, el 
  el indice es la posición donde se encuentra en el catalogo actual de animales.

- Al finalizar el programa no se guarda ni se crea ningún archivo, por lo que, si no se quiere perder información, se debe guardar en ficheros y/o actualizar los ficheros con las opciones de actualizar.

- El profesor me hizo una observación del proyecto anterior, y es que no se podían modificar animales, yo creí que no sería necesario, pero igual agregue los metodos correspondientes para modificar un animal, es decir los getter y setter, pero no lo agregue al main del proyecto, es decir, desde el main no se pueden modificar animales.  
