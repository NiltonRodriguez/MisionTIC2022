/**
 *
 * @author niltonrodriguez
 */
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*
* Recomendaciones Generales:
*
*    -> El método run() funcionará como nuestro método principal
*    -> No declarar objetos de tipo Scanner, utilizar el método read() para solicitar datos al usuario.
*    -> Si requiere utilizar varias clases, estas NO deben ser tipo public.
*/
class Reto2{
    /**
     * Main function.
     * @param args 
     */
    public static void main(String[] args){
        Reto2 solucion = new Reto2();
        solucion.run();
    }
    
    /**
    *  Este debe ser el único objeto de tipo Scanner en el código
    */
    private final Scanner scanner = new Scanner(System.in);

    /**
    * Este método es usado para solicitar datos al usuario
    * @return  Lectura de la siguiente linea del teclado
    */
    public String read(){
        return this.scanner.nextLine();
    }

    /**
    * método principal
    */
    public void run(){
        /*
        solución propuesta
        */
        // Declarar el HashMap para almacenar los productos.
        Map<String, List<String>> inventario = new HashMap<>();
        // Declarar las ArrayList para los valores del HashMap.
        List<String> manzanas = new ArrayList<>(
            Arrays.asList("Manzanas", "9000.0", "65"));
        List<String> limones = new ArrayList<>(
            Arrays.asList("Limones", "2300.0", "15"));
        List<String> peras = new ArrayList<>(
            Arrays.asList("Peras", "2500.0", "38"));
        List<String> arandanos = new ArrayList<>(
            Arrays.asList("Arandanos", "9300.0", "55"));
        List<String> tomates = new ArrayList<>(
            Arrays.asList("Tomates", "2100.0", "42"));
        List<String> fresas = new ArrayList<>(
            Arrays.asList("Fresas", "4100.0", "33"));
        List<String> helado = new ArrayList<>(
            Arrays.asList("Helado", "4500.0", "41"));
        List<String> galletas = new ArrayList<>(
            Arrays.asList("Galletas", "500.0", "833"));
        List<String> chocolates = new ArrayList<>(
            Arrays.asList("Chocolates", "3500.0", "806"));
        List<String> jamon = new ArrayList<>(
            Arrays.asList("Jamon", "17000.0", "10"));
        // Inicializar el HashMap del inventario.
        inventario.put("1", manzanas);
        inventario.put("2", limones);
        inventario.put("3", peras);
        inventario.put("4", arandanos);
        inventario.put("5", tomates);
        inventario.put("6", fresas);
        inventario.put("7", helado);
        inventario.put("8", galletas);
        inventario.put("9", chocolates);
        inventario.put("10", jamon);
        
        // Declarar las variables iniciales.
        String code;
        String product;
        String price;
        String amount;
        String option; 
        String input;
        boolean error = false;
        // Leer la operación a realizar.
        option = read();
        // Leer los valores del producto.
        input = read();
        // Asignar los valores a la variable correspondiente.
        String spareInput[] = input.trim().split("\\s+");
        code = spareInput[0];
        product = spareInput[1];
        price = spareInput[2];
        amount = spareInput[3];
        
        // Realizar las operaciones.
        // Verificar errores con los valores ingresados.
        error = operation(inventario, code, product, price, amount, 
                option, error);
        
        // Mostrar el resultado si no es error.
        if(!error){
            System.out.println(String.format("%s %s %.1f %.1f", 
                    expensive(inventario), cheapest(inventario), 
                    average(inventario), totalInventory(inventario)));
        }
    }
    /**
     * Realizar la operacions solicitada.
     * @param inventario HashMap con el inventario.
     * @param code String key con el numero identificador del producto.
     * @param product String Nombre del producto.
     * @param price String Precio del producto.
     * @param amount String Cantidad del producto.
     * @param option String Operacion solicitada.
     * @param error Boolean estado de error.
     * @return error Boolean estado de error actualizado.
     */
    public boolean operation(Map<String, List<String>> inventario, 
            String code, String product, String price, String amount, 
            String option, boolean error){
        /* Realizar la operación correspondiente. */
        switch(option){
            case "AGREGAR":
                // Si el codigo existe, enviar mensaje de error.
                if(inventario.containsKey(code)){
                    System.out.println("ERROR");
                    error = true;
                }
                // Agregar el nuevo producto.
                else{
                    inventario.put(code, new ArrayList<>());
                    inventario.get(code).add(product);
                    inventario.get(code).add(price);
                    inventario.get(code).add(amount);
                }
                break;
            case "ACTUALIZAR":
                // Actualziar el producto.
                if(inventario.containsKey(code)){
                    inventario.replace(code, new ArrayList<>());
                    inventario.get(code).add(product);
                    inventario.get(code).add(price);
                    inventario.get(code).add(amount);
                }
                // Si el codigo no existe, enviar mensaje de error.
                else{
                    System.out.println("ERROR");
                    error = true;
                }
                break;
            case "BORRAR":
                // Borar el producto.
                if(inventario.containsKey(code)){
                    inventario.remove(code);
                }
                // Si el codigo no existe, enviar mensaje de error.
                else{
                    System.out.println("ERROR");
                    error = true;
                }
                break;
            default:
                System.out.println("ERROR");
                error = true;
                break;
        }
        return error;
    }
    
    /**
     * Determinar el producto de mayor precio.
     * @param inventario HashMap con el inventario.
     * @return mostExpensive String el nombre del producto de mayor precio.
     */
    public String expensive(Map<String, List<String>> inventario){
        /*  */
        // String actualProduct;
        String mostExpensive = "";
        double actualPrice;
        double reference = 0.0;
        // Iterar el Hashmap del inventario.
        for(String key : inventario.keySet()){
            actualPrice = Double.parseDouble(inventario.get(key).get(1));
            // Verificar si el precio actual es mayor al de referencia.
            if(actualPrice > reference){
                // Asignar el nuevo precio a la referencia.
                reference = actualPrice;
                // Asignar el nuevo producto.
                mostExpensive = inventario.get(key).get(0);
            }
        }
        return mostExpensive;
    }
    
    /**
     * Determinar el producto de menor precio.
     * @param inventario HashMap con el inventario
     * @return cheapest String el nombre del producto de menor precio.
     */
    public String cheapest(Map<String, List<String>> inventario){
        //String actualProduct;
        String cheapest = "";
        double actualPrice;
        double reference = 10000.0;
        for(String key : inventario.keySet()){
            actualPrice = Double.parseDouble(inventario.get(key).get(1));
            // Verificar si el precio actual es mayor al de referencia.
            if(actualPrice < reference){
                // Asignar el nuevo precio a la referencia.
                reference = actualPrice;
                // Asignar el nuevo producto.
                cheapest = inventario.get(key).get(0);
            }
        }
        return cheapest;
    }
    
    /**
     * Calcular el promedio de precios del inventario.
     * @param inventario HashMap con el inventario.
     * @return average double El promedio de precios.
     */
    public double average(Map<String, List<String>> inventario){
        // String actualProduct;
        double actualPrice;
        double totalPrice = 0;
        double average;
        for(String key : inventario.keySet()){
            actualPrice = Double.parseDouble(inventario.get(key).get(1));
            // Sumar los precios.
            totalPrice += actualPrice;
        }
        
        // Calcular el promedio.
        average = totalPrice / inventario.size();
        return average;
    }
    
    /**
     * Calcular el valor total del inventario.
     * @param inventario HashMap con el inventario
     * @return totalInventory double El valor total del inventario.
     */
    public double totalInventory(Map<String, List<String>> inventario){
        // String actualProduct;
        double actualPrice;
        int actualAmount;
        double totalInventory = 0;
        for(String key : inventario.keySet()){
            actualPrice = Double.parseDouble(inventario.get(key).get(1));
            actualAmount = Integer.parseInt(inventario.get(key).get(2));
            // Multiplicar los precios.
            totalInventory += actualPrice * actualAmount;
        }

        return totalInventory;
    }
}
