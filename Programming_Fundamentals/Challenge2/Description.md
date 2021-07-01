### Description
Reto 2: Multas por exceso de velocidad

Debido a la alta accidentalidad presentada en el último año en las carreteras del territorio nacional, el Gobierno Colombiano ha decidido implementar controles que permitan sancionara a los conductores que no respeten los límites de velocidad establecidos por los organismos de control. Con este fin, el Ministerio de Transporte ha decidido implementar radares de tramo en las carreteras con mayores índices de accidentalidad en el país.

Los radares de tramo funcionan colocando dos cámaras en dos puntos alejados de una carretera con el fin de comprobar cuánto tiempo tarda un conductor recorrer dicho tramo. Estos radares no mide la velocidad de paso, sino el tiempo de paso representado como la velocidad media de un conductor en un trayecto con una longitud determinada.

Formalmente, los radares de tramo se basan en el teorema de Lagrange (también conocido como el teorema de valor medio o de Bonnet-Lagrange), el cual nos dice que dice tenemos una función continua en un intervalo cerrado, y derivable en un intervalo abierto, entonces algún punto de ese intervalo abierto la función tendrá una derivada instantánea igual a la pendiente media de la curva en el intervalo cerrado.

Aunque estos conceptos pueden asustar en un principio, su interpretación es muy simple: si hacemos un viaje desde Bogotá a Tunja y nuestra velocidad media es de 100 Km/h, necesariamente en algún punto del trayecto nuestra velocidad habrá sido de 100 Km/h. Esto quiere decir que si la velocidad media supera la velocidad máxima permitida, gracias al teorema anterior, sabremos que en algún punto del trayecto se superó la velocidad máxima permitida. Por ejemplo, si colocamos las cámaras separadas 10 Km en un tramo cuya velocidad máxima es de 110 Km/h, y un conductor tarda 5 minutos en ser visto por la segunda cámara, sabremos que su velocidad media ha sido de 120 Km/h, y por tanto, en algún sitio ha superado la velocidad permitida.

Usted hace parte del equipo de desarrollo encargado de construir el software que procesará los datos registrados por las cámaras.Su misión es crear un programa en Python que permita saber si un conductor debe ser multado o no.

### Inputs
Entrada	El programa recibirá 3 parámetros:<br>
La distancia en metros que separa dos cámaras.
La velocidad máxima permitida en ese trayecto en (Km/h).
El tiempo en segundos que tarda el conductor en recorrer el trayecto.
### Outputs
Salida<br>	El programa imprimirá una línea indicando si el conductor debe ser multado o no. Se debe considerar lo siguiente:
Imprimirá OK si el conductor no superó la velocidad máxima.
Imprimirá MULTA si se superó la velocidad máxima en menos de un 25% de la velocidad permitida.
Imprimirá CURSO SENSIBILIZACION si la velocidad fue superada en un 25% o más de la velocidad permitida. En este caso además de la multa deberá realizar un curso de sensibilización.
Debido a que los sistemas pueden fallar y registrar valores errados (por ejemplo, indicando que el tiempo que ha tardado el conductor es negativo). En esos casos, se deberá imprimir VALORES NEGATIVOS.

### Instructions for automatic scoring
Instrucciones para la calificación automática

Antes de enviar la solución del reto, por favor tenga en cuenta los siguientes aspectos:
Cada caso de prueba se especifica en una única línea.
Cada línea debe contener los valores de los parámetros separados por un espacio.
Es importante no utilizar ningún mensaje a la hora de capturar las entradas, es decir, al utilizar la función input() no agregue ningún texto para capturar los datos.
Como ejemplo considere el caso de prueba 9165 110 300, el cual corresponde a la medición entre dos cámaras separadas por 9165 metros; una velocidad máxima permitida de 110 (Km/h) y un conductor que tarda 300 segundos en recorrer el trayecto.
Los resultados deben imprimirse siempre en mayúscula sostenida.

## Test cases

***Entradas de ejemplo***<br>
9165 110 300<br> 9165 110 299<br> -1000 -50 -100<br> 12000 80 359

***Salida de ejemplo***<br>
OK<br> MULTA<br> VALORES NEGATIVOS<br> CURSO SENSIBILIZACION<br>
