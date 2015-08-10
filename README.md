# MiClima.org

## Información base

Aplicación que gestiona un listado de datos climatológicos en una base de datos.

Existen cuatro páginas:

+ Principal: muestra una imagen, junto con dos botones que enlazan al listado y al formulario de nuevo dato.
+ Listado de datos: muestra los datos **validados** de la base de datos.
+ Vista de detalle de dato: Si se hace doble click en un dato del listado, aparece su página de detalle.
+ Añadir dato: crea un nuevo dato y lo añade a la base de datos.

Creada por Rodrigo de Blas

## Entorno
+ Hardware

	+ Intel i7 3.1GHz 8GB RAM (Windows 7)
	+ MacBook Pro Intel i5 2.4GHz 8GB RAM
	
	
+ Software

	+ Eclipse Luna - Mars
	+ Java JDK 1.8
	+ JSF 2.2
	+ Apache Maven 3.3
	+ MyBatis 3.2.8
	+ Spring 4.1.6
	+ PostgreSQL 9.4
	+ Apache Tomcat 8.0.23

## Despliegue

1. Ir al directorio donde esté el fichero `pom.xml`
2. Ejecutar el comando 
    ```
    mvn clean install
    ```
3. Ejecutar el comando
    ```
    mvn tomcat8:run
    ```
4. La aplicación estará desplegada en la ruta:
    ```
    localhost:8080/miclima.org/
    ```

## Listado de datos

Muestra una tabla con los datos **validados** que se encuentren en la Base de Datos. Este listado en forma de tabla se encuentra paginado, puediéndose realizar operaciones de ordenación y filtrado (ver más abajo).

### Campos
Los datos mostrados incluyen los siguientes campos:
+ Localidad
+ Fecha (dd/mm/aaaa)
+ Temperatura (ºC)
+ Humedad (%)
+ Precipitación (mm)
+ Tipo de día (soleado, lluvioso...)

### Operaciones
Las operaciones permitidas sobre el listado son:
+ Ordenación
    + Localidad
    + Temperatura
+ Filtrado
    + Localidad

## Detalle de dato
Al hacer click en un dato del listado se muestra su página de detalle. Ésta muestra los siguientes datos:
+ Localidad
+ Fecha (dd/mm/aaaa)
+ Temperatura (ºC)
+ Humedad (%)
+ Precipitación (mm)
+ Tipo de día (soleado, lluvioso...)

## Añadir Dato
Permite añadir a la base de datos un nuevo dato climatológico. Para ello muestra un formulario a rellenar por el usuario con los siguientes campos:

+ Validado
    + Permite decidir si el dato está comprobado (aparecerá en el listado) o no (no aparecerá).
+ Localidad
    + Permite seleccionar la localidad del dato de una lista predefinida.
+ Temperatura, humedad, precipitación
    + Valores numéricos relativos a información sobre el dato.
+ Fecha
    + Fecha del dato (dd/mm/aaaa). Permite seleccionarla de un calendario.
+ Tipo de día
    + Permite seleccionar el tipo de día (nublado, lluvioso, soleado,...) de una lista predefinida.