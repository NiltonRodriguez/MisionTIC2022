### Description
Reto 3: Agregando una interfaz gráfica para la tienda de Rosa

En este reto continuaremos trabajando con el sistema de inventario para la tienda de Rosa desarrollado en el Reto 2. Nuestro objetivo es implementar una interfaz gráfica a la cual podamos incorporar las funcionalidades desarrolladas previamente. A continuación, se presenta nuevamente el contexto del problema.

La tienda de Rosa vende diferentes productos, usualmente frutas, dulces y algunos tipos de carne. Con el propósito de mejorar el control sobre las ventas y el inventario de la tienda, Rosa decide construir una aplicación que le permita almacenar la información de los productos y realizar algunos cálculos sobre los datos.

La Tabla 1 presenta los productos disponibles a la fecha en el almacén.

*código*	*nombre*	*precio*	*inventario*<br>
1	Manzanas	9000.0	65<br>
2	Limones	2300.0	15<br>
3	Peras	2500.0	38<br>
4	Arandanos	9300.0	55<br>
5	Tomates	2100.0	42<br>
6	Fresas	4100.0	33<br>
7	Helado	4500.0	41<br>
8	Galletas	500.0	833<br>
9	Chocolates	3500.0	806<br>
10	Jamon	17000.0	10<br>
Tabla 1: Productos disponibles en la tienda.

Adicionalmente, con el propósito de tener una especificación más clara de los requerimientos del problema usted cuenta con las siguientes historias de usuario.

    Historia de usuario Nro. 	1
    Título: 	Generar informe.
    Descripción 	
        COMO:	Usuario.
        QUIERO:	Conocer el precio de los 3 productos con los precios más altos.
        PARA:	Para mantener la información de la tienda actualizada.
    Criterios de aceptación 	
        Los productos deben presentarse de mayor a menor.

    Historia de usuario Nro. 	2
    Título: 	Agregar productos.
    Descripción 	
        COMO:	Usuario.
        QUIERO:	Agregar nuevos productos a la aplicación.
        PARA:	Para mantener la información de la tienda actualizada.
    Criterios de aceptación 	
        Se debe validar que no se agreguen campos vacíos.
        Se debe generar un mensaje de confirmación mostrando que la operación se realizó correctamente.

    Historia de usuario Nro. 	3
    Título: 	Eliminar productos.
    Descripción 	
        COMO:	Usuario.
        QUIERO:	Eliminar productos en la aplicación.
        PARA:	Para mantener la información de la tienda actualizada.
    Criterios de aceptación 	
        Se debe generar un mensaje de confirmación mostrando que la operación se realizó correctamente.

    Historia de usuario Nro. 	4
    Título: 	Modificar productos.
    Descripción 	
        COMO:	Usuario.
        QUIERO:	Modificar los campos de nombre, precio e inventario de un producto.
        PARA:	Para mantener la información de la tienda actualizada.
    Criterios de aceptación 	
        Se debe validar que no se agreguen campos vacíos.
        Se debe generar un mensaje de confirmación mostrando que la operación se realizó correctamente.

    Historia de usuario Nro. 	5
    Título: 	Visualizar productos.
    Descripción 	
        COMO:	Usuario.
        QUIERO:	Visualizar toda la información de los productos de la tienda.
        PARA:	Mejorar el control sobre los productos disponibles.
    Criterios de aceptación 	
        El código del producto no se debe presentar.
        Los campos deben presentarse en el orden nombre, precio e inventario.

Antes de comenzar con el diseño de la interfaz gráfica debe tener disponible la solución propuesta para el Reto 2. Se debe contar con la implementación de los métodos agregar, actualizar, eliminar, generarInforme, verificarExistencia implementados en la clase BaseDatosProductos. Esta clase debe contener un HashMap listaProductos y tener cargados los datos presentados en la Tabla 1.El reto estará formado por dos partes: en la primera, modificaremos el método generarInforme y en la segunda se creará una interfaz gráfica.

NOTA: La calificación de la interfaz gráfica será asignada de forma manual por el profesor del curso. La evaluación automática solo se hará sobre la primera parte del reto "Actualizando el informe".

[Parte 1: Actualizando el informe.](/Programming_Basics/Challenge3/src/retoMasterTech)

Debido a algunos cambios en el modelo de negocio, Rosa solicita modificar el informe generado con la información de los productos. En este caso, se requiere actualizar la función generarInforme desarrollada en el reto anterior para que muestre el nombre de los 3 productos con los precios más altos.

Por ejemplo, al generar el informe con los datos disponibles en la Tabla 1 obtendríamos:

Jamon Arandanos Manzanas.

### Inputs
Entrada Cada uno de los casos de prueba estará compuesto por dos líneas.

La primera línea estará formada por una cadena de texto que identifica la operación a realizar. En este caso, las operaciones válidas son:<br>
ACTUALIZAR.<br>
BORRAR.<br>
AGREGAR.<br>
La segunda línea estará formada por 4 valores (código, nombre, precio, inventario) que representan el producto sobre el cual se quiere realizar la operación.
En el caso de la operación ACTUALIZAR la segunda línea debe contener el código y los nuevos valores del producto.
En el caso de la operación BORRAR se deben especificar todos los atributos del producto a eliminar.
### Outputs
Salida La salida estará representada por una única línea formada por tres valores que representan los tres productos con los precios más altos ordenados de mayor a menor. Los nombres estarán separados por un espacio.

Estos 3 valores deben imprimirse después de realizar las operaciones solicitadas en la primera línea.
En caso de solicitar ACTUALIZAR o BORRAR un producto que no existe (es decir, que el código del producto no se encuentra en la base de datos), se debe imprimir "ERROR".
En caso de solicitar AGREGAR un producto cuyo código ya existe en la base de datos se debe imprimir "ERROR".

***Entrada***

AGREGAR<br>
11 Melon 70 13

BORRAR<br>
10 Jamon 15000 10

ACTUALIZAR<br>
7 Helado 65000 11

BORRAR<br>
14 Maiz 45000 12

***Salida***

Jamon Arandanos Manzanas

Arandanos Manzanas Helado

Helado Jamon Arandanos

ERROR

[Parte 2: Implementando una interfaz gráfica con Swing.](/Programming_Basics/Challenge3/src/forms)

El dueño del almacén le entrega el siguiente diseño de la interfaz gráfica (ver figura 2). En el diseño se incluyen las ventanas emergentes que surgen como resultado de realizar algunas validaciones y los aspectos que el desea tener en la interfaz de la aplicación.Su objetivo es construir una interfaz gráfica similar a la presentada en el diseño. Lo más importante es que la interfaz permita incorporar las funcionalidades de ACTUALIZAR, BORRAR, AGREGAR e INFORMES desarrolladas en el reto anterior. Para esto, se sugiere seguir los siguientes pasos:

Identifique los diferentes paneles que puede contener la interfaz. Recuerde que los paneles servirán como contenedores para los componentes (Botones, etiquetas, cuadros de texto etc.).
Luego de declarar los paneles seleccione el Layout más conveniente y agregue los componentes que aparecen en la interfaz.
Luego de tener una apariencia similar a la presentada en el diseño, es necesario capturar y programa los eventos de cada componente para que realice la acción deseada.
Se deben implementar las validaciones requeridas y presentadas en el diseño.
Luego de capturar los eventos deben enlazarse con las funciones implementadas en el reto anterior y con la nueva versión de la función generarInforme.
Verifique el correcto funcionamiento de todos los componentes, así como de las validaciones requeridas.

### Instructions for automatic scoring
Instrucciones para la calificación automática

Antes de enviar la solución del reto, por favor tenga en cuenta los siguientes aspectos:

Cada caso de prueba se especifica en dos líneas.
Cada línea debe contener los valores de los parámetros separados por un espacio.
Debe existir en el código, una clase principal llamada "Reto3".
En la clase "Reto3" debe existir un método llamado "run".
El código no debe contener variable Scanner, recuerde trabajarla como variable global en la clase Reto3 (no instanciarla en el método principal "run").
Es importante no utilizar ningún mensaje a la hora de capturar las entradas.
Únicamente debe imprimir los resultados finales. No imprima valores con cálculos intermedios.
La clase "Reto3" no debe ser de tipo public.
Si utiliza clases adicionales, estas no deben ser de tipo public.
Recuerde que la calificación automática únicamente aplica para la primera parte del reto. No agregue código asociado a la interfaz gráfica. Esta será calificada de forma manual por el profesor del curso.
