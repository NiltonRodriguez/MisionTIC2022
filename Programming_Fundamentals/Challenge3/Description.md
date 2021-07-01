### Description
Reto 3: Compra de Vehículo

Alejandro quiere comprar el vehículo de sus sueños, sin embargo sus sueños se ven limitados por su presupuesto. Para esto, ha ahorrado durante varios años y sumado a su capacidad de endeudamiento, sabe qué gama de vehículo quiere comprar. Alejandro, aún no decide qué vehículo concretamente quiere y por tal razón ha pedido al asesor del concesionario que le envíe un catálogo de vehículos para poder tomar la mejor decisión de compra.
Si bien, Alejandro aún no decide qué carro comprar, sí sabe con certeza qué características debería tener el carro de sus sueños:
Que mínimo tenga una cilindrada de 1200 cc. Sí es de 1200 cc, Alejandro accederá y lo compraría.
Que máximo tenga una cilindrada de 3600 cc., para Alejandro 3600 es un motor muy grande y no lo compraría.
Que sea del año 2018 en adelante.
Que tenga un recorrido de hasta 30000 kilómetros.
Si el consumo de combustible es de 35 kilómetros por galón o mas, definitivamente no compraría ese vehículo.
El precio del vehículo no debe superar el valor ahorrado más su capacidad de endeudamiento.
El catálogo incluye además de esta información, el precio. Alejandro cuenta con un ahorro de doce mil dólares,y su capacidad de endeudamiento es de catorce mil dólares. El hermano de Alejandro tiene un vehículo de trece mil quinientos dólares y él quiere tener un carro que sea más costoso que el de su hermano, por tal razón Alejandro quiere saber el tamaño de la deuda que debe adquirir. (Valor del vehículo menos el capital ahorrado).
Usted hace parte del equipo de desarrollo del concesionario. El asesor del concesionario le ofrece a Alejandro la posibilidad de automatizar la revisión del catálogo, así que debe construir el software que procesará los datos del catálogo.Su misión es crear un programa en Python que permita mostrarle al cliente la lista de los carros que cumplen con sus requerimientos y por supuesto el valor de la deuda que debe adquirir.

### Inputs
Entrada	La entrada estará conformada por N + 1 líneas:<br>
La primera línea recibirá un número N que equivale a la cantidad de registros del catálogo. Cada registro representa un vehículo para la venta.
Cada una de las siguientes N líneas estará formada por 5 números separados por espacios que representan las diferentes características de un vehículo. Por ejemplo,la fila 1300 2019 25000 40 25000 representa un vehículo con 1300 cc de cilindrada, modelo 2019, un recorrido de 25000 kilómetros, un consumo de 40 kilómetros por galón y un valor total de 25000 dólares.
### Outputs
Salida<br>
El programa imprimirá el valor de la deuda que debe adquirir Alejandro para comprar los vehículos que cumplen con los criterios.
Si no existe ningún registro en el catálogo que cumpla los criterios de Alejandro, el programa imprimirá 'NO DISPONIBLE'.

### Instructions for automatic scoring
Instrucciones para la calificación automática

Antes de enviar la solución del reto, por favor tenga en cuenta los siguientes aspectos:
Cada línea debe contener los valores de los parámetros separados por un espacio.
Es importante no utilizar ningún mensaje a la hora de capturar las entradas, es decir, al utilizar la función input()no agregue ningún texto para capturar los datos.
El resultado ´NO DISPONIBLE´ siempre debe imprimirse en mayúscula.

## Test cases

***Entrada***

3<br>
2100 2019 29000 25 27500<br>
2400 2016 17500 25 25000<br>
3300 2020 2000 25 17500

5<br>
2700 2019 16000 30 17500<br>
1500 2017 15000 20 20000<br>
1600 2020 22500 25 20000<br>
3600 2016 18000 35 27500<br>
3400 2020 2500 25 15000

5<br>
2900 2016 8000 30 20000<br>
1300 2018 13500 35 27500<br>
3200 2017 14500 30 17500<br>
1300 2017 17500 35 15000<br>
2500 2017 14000 25 20000

***Salida***

5500

5500<br>
8000<br>
3000

NO DISPONIBLE
