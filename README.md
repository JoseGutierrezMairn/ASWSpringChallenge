# ASW Spring challenge
En este repositorio se encuentra una aplicación hecha con el framework spring, es un api rest que se encarga de 
procesar las peticiones http de un usuario.
Se trata de una aplicación que provee una solución de agendamiento de turnos para que 
los clientes de varios comercios puedan reservar con anticipación un espacio de atención en un 
servicio específico que presta cada comercio
## Prerrequisitos
Debemos tener los siguientes programas instalados o cuentas para poder hacer uso de las herramientas:
~~~
* Maven
* Git
* Java
* Java IDE de Spring tool suite
~~~

# Instalando 
Para descargar el proyecto realizaremos los siguientes pasos desde el **Simbolo del sistema** o **Command prompt**:  
1. Nos dirigimos a la ubicación donde queremos descargar el proyecto desde el simbolo del sistema.  
2. Escribimos el siguiente comando para realizar la descarga:  
~~~
git clone https://github.com/JoseGutierrezMairn/AREP-AppSegura.git
~~~
3. Esperamos a que el simbolo de sistema nos diga que ya se realizó la descarga  
4. El proyecto ya se encuentra en nuestros computadores y está listo para ser editado o probado.

![descargaRepo](https://github.com/JoseGutierrezMairn/ASWSpringChallenge/blob/master/img/descargaRepo.gif)
  
# Documentación
Para compilar el código con maven solo debemos correr el siguiente codigo en el símbolo del sistema ubicado en la raíz del proyecto (Carpeta que contiene el archivo README.md)
`mvn package`

Para ejecutar el programa de manera local primero debemos tener el xampp corriendo el proceso de mysql y la base de datos
diseñada en dbeaver en una base de datos MariaDB, se puede crear con el script adjunto en la carpeta DataBase de este repositorio.
Xampp corriendo:
![xampp](https://github.com/JoseGutierrezMairn/ASWSpringChallenge/blob/master/img/xampp.PNG?raw=true)

Modelo entidad relación de la base de datos:
![xampp](https://github.com/JoseGutierrezMairn/ASWSpringChallenge/blob/master/img/modelER.PNG?raw=true)  

Ahora debemos ir a nuestro IDE, importar el proyecto el path donde se encuentre guardado y correr nuestro código:  
Importar proyecto:
![importarProyecto](https://github.com/JoseGutierrezMairn/ASWSpringChallenge/blob/master/img/importarProyecto.gif)  

Correr proyecto en spring tool suite:
![correrProyecto](https://github.com/JoseGutierrezMairn/ASWSpringChallenge/blob/master/img/correrProyecto.gif)

## Pruebas
Para probar la aplicación de manera local se recomienda usar postman.

### Petciones CRUD Servicios  

~~~
Probando peticiones en el CRUD Servicios
~~~

Tener en cuenta que el path base para realizar peticiones a los servicios es:  

~~~
http://localhost:9003/api/v1/servicio/
~~~

#### Peticiones Get
* Consultar todos los servicios en la base de datos
![getAll](https://github.com/JoseGutierrezMairn/ASWSpringChallenge/blob/master/img/getAllServicios.PNG?raw=true)  

* Consultar el servicio con id = 2  
![GetServicio](https://github.com/JoseGutierrezMairn/ASWSpringChallenge/blob/master/img/getServicio.PNG?raw=true)  

#### Petición Put  
Para realizar la petición put (Crear servicio u otra entidad dependiendo del path configurado en postman) hay que enviar un cuerpo para actualizar datos de los datos de la entidad de la siguiente manera
* Actualizar servicio
![actualizar](https://github.com/JoseGutierrezMairn/ASWSpringChallenge/blob/master/img/updateServicio.PNG?raw=true)  

#### Petición Post  
Al igual que cuando se actualiza un dato, debemos enviar un cuerpo en la petición para crear el nuevo servicio.
* Crear servicio
![crear](https://github.com/JoseGutierrezMairn/ASWSpringChallenge/blob/master/img/crearServicio.PNG?raw=true)  

#### Petición Delete
Para esta petición solo tenemos que enviar el id como parámetro en la url para eliminar el servicio que queremos
* Eliminar servicio

![eliminar](https://github.com/JoseGutierrezMairn/ASWSpringChallenge/blob/master/img/eliminarServicio.PNG?raw=true)  


### Peticiones CRUD comercios  

~~~
Probando peticiones en el CRUD comercios
~~~

Tener en cuenta que el path base para realizar peticiones a los comercios es:  

~~~
http://localhost:9003/api/v1/comercio/
~~~

#### Peticiones Get
* Consultar todos los comercios en la base de datos
Al igual que los servicios se puede probar en la aplicación postman, usando la siguiente ruta:

~~~
http://localhost:9003/api/v1/comercio/all
~~~

* Consultar el comercio con id = 1  
Puara consultar un comercio con un id específico puedes usar la siguiente plantilla en postman:
~~~
http://localhost:9003/api/v1/comercio/consult?id=1
~~~

#### Petición Put  
Para realizar la petición put (Crear comercio u otra entidad dependiendo del path configurado en postman) hay que enviar un cuerpo para actualizar datos de los datos de la entidad de la siguiente manera
* Actualizar comercio
~~~
http://localhost:9003/api/v1/comercio/update
~~~

Configure el cuerpo de la misma manera como se configura en el CRUD servicios, es importante agregar el id de un comercio que ya exista en la base de datos, de otra manera, el servicio no actualizará ni agregará nada nuevo a la base de datos, esta es una plantilla con la que puede armar el cuerpo de la solicitud:
~~~
{
        "idComercio": 1,
        "nomComercio": "Comercio actualizado",
        "aforoMax": 555
}
~~~



#### Petición Post  
Al igual que cuando se actualiza un dato, debemos enviar un cuerpo en la petición para crear el nuevo comercio.
* Crear comercio
Path para crear un nuevo comercio:

~~~
http://localhost:9003/api/v1/comercio/create
~~~

Plantilla cuerpo de solicitud:
~~~
{
        "nomComercio": "Nuevo comercio",
        "aforoMax": 23
}
~~~

#### Petición Delete
Para esta petición solo tenemos que enviar el id como parámetro en la url para eliminar el comercio que queremos
* Eliminar comercio

path para eliminar un comercio:
~~~
http://localhost:9003/api/v1/comercio/delete?id=1
~~~
### Peticiones entidad turnos
Las peticiones para la entidad turnos son un poco distintas, están disponibles dos consultas para esta entidad, el path base para interactuar con el api rest es:
~~~
http://localhost:9003/api/v1/turno/
~~~

* Consultar los turnos que tiene un servicio
![turnosPorServicio](https://github.com/JoseGutierrezMairn/ASWSpringChallenge/blob/master/img/turnosPorServicio.PNG?raw=true)  

* Consultar los turnos por comercio
![turnosPorComercio](https://github.com/JoseGutierrezMairn/ASWSpringChallenge/blob/master/img/turnosPorComercio.PNG?raw=true)  

# Autor
* [Jose Gutierrez](https://github.com/JoseGutierrezMairn)