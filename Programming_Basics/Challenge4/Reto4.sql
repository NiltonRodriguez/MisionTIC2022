SELECT nombre, inventario FROM Productos WHERE precio >= 9200;

SELECT AVG(precio) AS promedio FROM Productos;

SELECT nombre, precio FROM Productos WHERE nombre LIKE "A%" OR nombre LIKE "P%" ORDER BY nombre ASC;

SELECT COUNT(*) AS total FROM Productos WHERE precio > 3000 AND precio < 10000;

SELECT SUM(precio * inventario) AS total_inventario FROM Productos;