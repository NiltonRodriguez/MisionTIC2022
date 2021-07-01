### Description
Reto 5: Inventario para la tienda de Juan

La tienda de Juan vende diferentes productos, usualmente frutas, dulces y algunos tipos de carne. Con el propósito de mejorar el control sobre las ventas y el inventario de la tienda, Juan decide construir una aplicación que le permita almacenar la información de los productos y realizar algunos cálculos sobre los datos.

En la primera parte del reto se debe construir una base de datos que almacene la información de los productos disponibles en la tienda. Debido a que Juan no cuenta con un servidor de base de datos, solicita que temporalmente la base de datos sea representada mediante un diccionario de Python llamado productos que tendrá por llave el código del producto y por valor una lista formada por los atributos: nombre, precio e inventario. La Tabla 1 presenta los productos disponibles a la fecha.

*código*	*nombre*	*precio*	*inventario*<br>
1  	Naranjas	7000.0	35<br>
2	Limones	2500.0	15<br>
3	Peras	2700.0	65<br>
4	Arandanos	9300.0	34<br>
5	Tomates	2100.0	42<br>
6	Fresas	9100.0	20<br>
7	Helado	4500.0	41<br>
8	Galletas	500.0	8<br>
9	Chocolates	4500.0	80<br>
10	Jamon	17000.0	48<br>
Tabla 1: Productos disponibles en la tienda.


Para simular de una manera más realista la base de datos, es necesario construir 3 funciones que representen las operaciones de: AGREGAR, ACTUALIZAR y BORRAR los productos disponibles. Se debe implementar una función independiente por cada una de las acciones mencionadas. En este caso, para poder realizar las operaciones de ACTUALIZAR o BORRAR es necesario especificar todos los atributos del producto.

Adicionalmente, Juan está interesado en analizar los datos de los productos disponibles y conocer: el nombre del producto con el precio mayor; el nombre del producto con el precio menor; el promedio de precios de todos los productos y el valor total del inventario a la fecha. Este último se obtiene multiplicando el precio de cada producto por el inventario disponible y luego sumando todos los resultados. Por ejemplo, al calcular estos 4 valores para los datos disponibles en la Tabla 1 obtendríamos :
Producto precio mayor: Jamon
Producto precio menor: Galletas
Promedio de precios: 5920.0
Valor del inventario: 2408900.0

### Inputs
Entrada	Cada uno de los casos de prueba estará compuesto por dos líneas.<br>
La primera línea estará formada por una cadena de texto que identifica la operación a realizar. En este caso, las operaciones validas son:<br>
ACTUALIZAR.<br>
BORRAR.<br>
AGREGAR.<br>
La segunda línea estará formada por 4 valores (código, nombre, precio, inventario) que representan el producto sobre el cual se quiere realizar la operación.
En el caso de la operación ACTUALIZAR la segunda línea debe contener el código y los nuevos valores del producto.
En el caso de la operación BORRAR se deben especificar todos los atributos del producto a eliminar.
### Outputs
Salida	La salida estará representada por una única línea formada por cuatro valores:<br>
Nombre del producto con el precio mayor.
Nombre delproducto con el precio menor.
Promedio de precios.
Valor del inventario.
Estos 4 valores deben imprimirse después de realizar las operaciones solicitadas en la entrada de datos.
Los valores numéricos deben imprimirse con un número decimal.
En caso de solicitar ACTUALIZAR o BORRAR un producto que no existe (es decir, que el código del producto no se encuentra en la base de datos), se debe imprimir 'ERROR'.
En caso de solicitar AGREGAR un producto cuyo código ya existe en la base de datos se debe imprimir 'ERROR'.

### Instructions for automatic scoring
Instrucciones para la calificación automática

Antes de enviar la solución del reto, por favor tenga en cuenta los siguientes aspectos:
Cada caso de prueba se especifica con dos líneas.
Cada línea debe contener los valores de los parámetros requeridos separados por un espacio.
Es importante no utilizar ningún mensaje a la hora de capturar las entradas, es decir, al utilizar la función input() no agregue ningún texto para capturar los datos.
Los resultados se muestran en una única línea. Los dos valores requeridos deben estar separados por un espacio.

## Test cases

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

Jamon Melon 5388.2 2409810.0

Arandanos Galletas 4688.9 1592900.0

Helado Galletas 11970.0 2939400.0

ERROR
