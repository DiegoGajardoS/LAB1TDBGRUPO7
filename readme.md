# TBD Laboratorio 1 GRUPO 7

## Base de datos

## PostgreSQL

Para la creacion de la base de datos es necesario usar el software indicado en las primeras sesiones de clases llamado pgadmin4.

Una vez que se ingresa al software pgadmin4, este solicitara la password con la que previamente se instalo, esta password debe ser reemplazada en el archivo DatabaseContext, ubicado en la ruta '\lab1 grupo 7\backend\lab1\src\main\java\grupo7\tbd\lab1\repositories\DatabaseContext'
especificamente en la linea 14 de ese archivo, lo ultimo antes del parentesis que esta entre "" es la password.

Luego de ingresar la password en el software se debe crear una base de datos en alguno de los servidores mostrados en el panel izquierdo del software (siempre que estos sean del usuario postgres, de no ser asi se debe tambien cambiar el usuario en el archivo DatabaseContext, se debe dar click derecho y seleccionar Create Database, nombrarla por ej como: lab1

Luego se deben crear las tablas de la base de datos, para ello se debe copiar el texto presente en el archivo BD.sql, que se encuentra ubicado en la ruta '\lab1 grupo 7\database'

Estos datos se deben copiar en el espacio que se genere al seleccionar Query Tool en pgadmin4, luego se debe dar a Execute (el boton con el simbolo de play)

Luego se debe poblar la base de datos, para ello se debe realizar el mismo paso anterior pero con el archivo dump.sql, tambien presente en la ruta '\lab1 grupo 7\database'

Luego para la creaccion de la funcion trigger, se debe realizar el mismo paso con el archivo triggerFunction.sql tambien presente en la ruta '\lab1 grupo 7\database'

Finalmente para la creacion del trigger, se debe realizar el mismo procedimiento con el archivo trigger.sql tambien presente en la ruta '\lab1 grupo 7\database'

## Frontend

Para poder desplegar la vista de la funcionalidad, primero se tiene que inicializar la base de datos, para esto se abre una terminal en la carpeta '\lab1 grupo 7\backend\lab1' y se ejecuta el comando 'gradle bootRun' (sin las comillas).

Una vez inicializado, se abre otra terminal (distinta a donde se inicializo la base de datos) pero esta vez en la carpeta '\lab1 grupo 7\frontend' y se ejecuta el comando 'npm run dev' (sin comillas).

Ya inicializado el frontend, se copia (desde la terminal), la dirección 'http://localhost:8081' (sin comillas) y se pega en el navegador, desplegandose la vista de listado de tareas.
