# TBD Laboratorio 3 GRUPO 7

## Base de datos

## PostgreSQL

Para la creacion de la base de datos es necesario usar el software indicado en las primeras sesiones de clases llamado pgadmin4.

Una vez que se ingresa al software pgadmin4, este solicitara la password con la que previamente se instalo, esta password debe ser reemplazada en el archivo DatabaseContext, ubicado en la ruta '\lab1 grupo 7\backend\lab1\src\main\java\grupo7\tbd\lab1\repositories\DatabaseContext'
especificamente en la linea 14 de ese archivo, lo ultimo antes del parentesis que esta entre "" es la password.

Luego de ingresar la password en el software se debe crear una base de datos en alguno de los servidores mostrados en el panel izquierdo del software (siempre que estos sean del usuario postgres, de no ser asi se debe tambien cambiar el usuario en el archivo DatabaseContext, se debe dar click derecho y seleccionar Create Database, nombrarla por ej como: lab1

Luego se deben crear las tablas de la base de datos, para ello se debe copiar el texto presente en el archivo BD.sql, que se encuentra ubicado en la ruta '\lab1 grupo 7\database'

Estos datos se deben copiar en el espacio que se genere al seleccionar Query Tool en pgadmin4, luego se debe dar a Execute (el boton con el simbolo de play)

Luego se debe poblar la base de datos, para ello se debe realizar el mismo paso anterior pero con el archivo dump.sql, tambien presente en la ruta '\lab1 grupo 7\database'

Luego se deben cargar las regiones, para ello se realiza el mismo paso anterior pero con los datos en el archivo llamado division_regional.sql tambien presente en la ruta '\lab1 grupo 7\database'

## MongoDB


1)	Descargar MongoDBCompass desde la página: 
https://www.mongodb.com/try/download/community 
Seleccionar opción “On-premises MongoDB locally” y luego download.
2)	Instalar MongoDBCompass
3)	Abrir MongoDBCompass
4)	Conectar a un despliegue de MongoDB
5)	Presionar en la parte superior “Databases”
6)	Crear una base de datos con el botón verde “Create database”.
7)	Ingresar “TBD-LAB3” (Omitiendo doble comilla al escribirlo en la aplicación) En “Database Name” y en “Collection Name” ingresar “Emergencias” o “Tarea” (Nuevamente omitiendo comillas)
8)	Presionar “Create Database”
9)	Presionar click izquierdo en la base de datos “TBD-LAB3”, que ahora se muestra en la barra de la izquierda.
10)	Presionar click izquierdo en la colección de “Emergencias” o “Tareas”, según la que haya creado.
11)	Seleccionar la sección “Documents” de la parte superior
12)	Presionar click izquierdo donde dice “ADD DATA”
13)	Presionar la opción “Insert Document” que se muestra
14)	Borrar todo lo que se muestra en la ventana que aparece
15)	Copiar el contenido del script que corresponde a la colección (“Tarea” o “Emergenica”)
16)	Pegar el script en la ventana que se muestra en el paso 14
17)	Presionar “Insert”
18)	Crear la colección que falte entre “Tarea” o “Emergencia”, para ello, presionar en la base de datos “TBD-LAB3” que se muestra en la barra de la izquierda
19)	Presionar el botón verde “Create collection” que se muestra en la parte superior
20)	Ingresar el nombre de la colección restante
21)	Presionar “Create Collection”
22)	Seguir los pasos desde el 10 al 17 con la colección restante.

## OPCIONAL: Luego para la creaccion de la funcion trigger, se debe realizar el mismo paso con el archivo triggerFunction.sql tambien presente en la ruta '\lab1 grupo 7\database'

	  Finalmente para la creacion del trigger, se debe realizar el mismo procedimiento con el archivo trigger.sql tambien presente en la ruta '\lab1 grupo 7\database'

## Frontend

Para poder desplegar la vista de la funcionalidad, primero se tiene que inicializar la base de datos, para esto se abre una terminal en la carpeta '\lab1 grupo 7\backend\lab1' y se ejecuta el comando 'gradle bootRun' (sin las comillas).

Una vez inicializado, se abre otra terminal (distinta a donde se inicializo la base de datos) pero esta vez en la carpeta '\lab1 grupo 7\frontend' y se ejecuta el comando 'npm run dev' (sin comillas). En caso de que esta funcionalidad no sea reconocida
se debe ejecutar el comando npm install y luego npm run dev

Ya inicializado el frontend, se copia (desde la terminal), la dirección 'http://localhost:8081' (sin comillas) y se pega en el navegador, desplegandose la vista de inicio, en ella se puede seleccionar la opcion de mapa
vista que mostrara un mapa inicialmente sin ningun marcador, en la seccion inferior se puede ver un formulario donde se pide un id, este id corresponde al id de un voluntario, y dependiendo de si hay emergencias presentes en la
misma region del voluntario, estas se mostraran en el mapa.

En caso de no tener no se mostrara ningun marcador.
