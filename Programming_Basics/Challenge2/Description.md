### Description
Reto 2: Inventario para la tienda de Rosa

La tienda de Rosa vende diferentes productos, usualmente frutas, dulces y algunos tipos de carne. Con el propósito de mejorar el control sobre las ventas y el inventario de la tienda, Rosa decide construir una aplicación que le permita almacenar la información de los productos y realizar algunos cálculos sobre los datos.

Usted es contratado para desarrollar el sistema de inventario con las funcionalidades presentadas en el diagrama de casos de uso en el lenguaje de programación Java. Debido a que esta es una etapa inicial en el desarrollo de la aplicación, la base de datos será representada temporalmente mediante un HashMap llamado listaProductos que tendrá por llave el código del producto y por valor una instancia de la clase Producto que tendrá como atributos código, nombre, precio e inventario. La Tabla 1 presenta los productos disponibles a la fecha en el almacén.

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

Su misión es implementar todas las funcionalidades presentadas en el diagrama de casos de uso. Para esto es necesario construir 3 métodos que representen las operaciones de agregar, actualizar y eliminar. Estas funciones deben implementar una clase con el nombre BaseDatosProductos que contenga el HashMap listaProductos.

Adicionalmente, Rosa desea generar un informe que contenga: el nombre del producto con el precio mayor; el nombre del producto con el precio menor; el promedio de precios de todos los productos y el valor total del inventario a la fecha. Este último se obtiene multiplicando el precio de cada producto por el inventario disponible y luego sumando todos los resultados. Este método debe llamarse generarInforme implementarse en la clase BaseDatosProductos.

Por ejemplo, al generar el informe con los datos disponibles en la Tabla 1 obtendríamos:

    Producto precio mayor: Jamon.
    Producto precio menor: Galletas.
    Promedio de precios: 5480.0.
    Valor del inventario: 5041500.0.

Para evitar errores a la hora de agregar, actualizar y borrar productos, se debe implementar un método llamado verificarExistencia que permitirá comprobar si el producto existe o no en la base de datos. Este método debe implementarse en la clase BaseDatosProductos.

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
Salida La salida estará representada por una única línea formada por cuatro valores:

Nombre del producto con el precio mayor.<br>
Nombre delproducto con el precio menor.<br>
Promedio de precios.<br>
Valor del inventario.<br>
Estos 4 valores deben imprimirse después de realizar las operaciones solicitadas en la primera línea.
Los valores numéricos deben imprimirse con un número decimal.
En caso de solicitar ACTUALIZAR o BORRAR un producto que no existe (es decir, que el código del producto no se encuentra en la base de datos), se debe imprimir 'ERROR'.En caso de solicitar AGREGAR un producto cuyo código ya existe en la base de datos se debe imprimir 'ERROR'.

### Instructions for automatic scoring
Instrucciones para la calificación automática

Antes de enviar la solución del reto, por favor tenga en cuenta los siguientes aspectos:

Cada caso de prueba se especifica en dos líneas.
Cada línea debe contener los valores de los parámetros separados por un espacio.
Debe existir en el código, una clase principal llamada ´Reto2´.
En la clase ´Reto2´ debe existir un método llamado ´run´.
El código no debe contener variable Scanner, recuerde trabajarla como variable global en la clase Reto2 (no instanciarla en el método principal ´run´).
Es importante no utilizar ningún mensaje a la hora de capturar las entradas.
Únicamente debe imprimir los resultados finales. No imprima valores con cálculos intermedios.
La clase ´Reto2´ no debe ser de tipo public.
Si utiliza clases adicionales, estas no deben ser de tipo public.

## Test Cases

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

Jamon Melon 4988.2 5042410.0

Arandanos Galletas 4200.0 4871500.0

Helado Galletas 11530.0 5572000.0

ERROR
