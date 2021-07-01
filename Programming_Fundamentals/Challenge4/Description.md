### Description
Reto 4: Detectando copia en los exámenes de programación

Uno de los profesores de programación de la Universidad Sergio Arboleda está comenzando a perder su memoria. Hace algún tiempo, cuando comenzó a trabajar como docente, no únicamente conocía perfectamente todos los nombres y apellidos de sus estudiantes, sino que además contaba con una habilidad increíble para detectar copia en los exámenes de programación. Estaba tan seguro de sus capacidades que mientras los estudiantes se concentraban en analizar los problemas y diseñar algoritmos, él se sentaba en la última fila del salón a preparar futuras clases sin preocuparse por los intentos de algunos estudiantes por hacer trampa.

La habilidad del profesor se basa en su memoria fotográfica. Cuando el profesor calificaba era capaz de recordar a la perfección si había visto un examen con las mismas respuestas o no, y si las encontraba acusaba siempre al segundo estudiante de copiar. Lamentablemente, durante los últimos meses su memoria fotográfica ya no funciona como antes y ahora solo recuerda algunos de los últimos exámenes que ha calificado.

Debido a estas circunstancias, el profesor ha decidido solicitar su ayuda para construir un programa en Python que le permita comprobar si la perdida de su memoria fotográfica podría tener como consecuencia una disminución en la cantidad de copias que se detectan durante los exámenes.

### Inputs
Entrada	La entrada estará formada por dos líneas:<br>
La primera línea aparecerán dos números N y K que indican el número de exámenes a calificar y el número de exámenes que el profesor es capaz de recordar (1≤N≤10000,1≤K≤1000).
La segunda línea contiene N números (entre 1 y 100) separados por espacios que representan las respuestas de cada uno de los exámenes.
Dos exámenes se consideran copiados si están representados por el mismo número.
### Outputs
Salida<br>
El programa imprimirá dos números separados por un espacio.
El primero representará el número total de exámenes copiados.
El segundo representará la cantidad de copias detectadas por el profesor considerando que al calificar un examen solo es capaz de recordar los K exámenes anteriores.

### Instructions for automatic scoring
Instrucciones para la calificación automática

Antes de enviar la solución del reto, por favor tenga en cuenta los siguientes aspectos:
Cada caso de prueba se especifica con dos líneas.
Cada línea debe contener los valores de los parámetros requeridos separados por un espacio.
Es importante no utilizar ningún mensaje a la hora de capturar las entradas, es decir, al utilizar la función input()no agregue ningún texto para capturar los datos.
Los resultados se muestran en una única línea. Los dos valores requeridos deben estar separados por un espacio.

## Test cases

***Entrada***

5 1<br>
1 2 3 1 2

5 2<br>
1 2 3 1 2

5 3<br>
1 2 3 1 2

5 1<br>
1 1 1 1 1

***Salida***

2 0

2 0

2 2

4 4
