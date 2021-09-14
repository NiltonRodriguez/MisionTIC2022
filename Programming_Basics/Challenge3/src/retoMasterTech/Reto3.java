/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package retoMasterTech;

/**
 *
 * @author niltonrodriguez
 */
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
/*
* Recomendaciones Generales:
*
*    -> El método run() funcionará como nuestro método principal
*    -> No declarar objetos de tipo Scanner, utilizar el método read() para solicitar datos al usuario.
*    -> Si requiere utilizar varias clases, estas NO deben ser tipo public.
*/
class Reto3{
     /**
      * Main function
      * @param args 
      */
    public static void main(String[] args){
        Reto3 solucion = new Reto3();
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
        // Database inicialization.
        Database database = new Database();
        // Prompt the operation.
        String option = read();
        // Prompt the product info.
        String input = read();
        // Assign each value to its variable.
        String spareInput[] = input.split("\\s+");
        String codigo = spareInput[0];
        String nombre = spareInput[1];
        String precio = spareInput[2];
        String cantidad = spareInput[3];
        boolean error = false;
        /**
         * Operations
         */
        // Verify errors with the input values.
        // Operate acording to the input operation.
        error = database.operaciones(option, codigo, nombre, precio, cantidad, error);
        // Display the report.
        if(!error){
            System.out.println(database.generarInforme());
        }
    }
}

/**
 * Database Class
 * @author niltonrodriguez
 */
class Database {
    
    /**
     * Database Atributes.
     */
    Map<Integer, Product> listaProductos;
    
    /**
     * Database Constructor.
     */
    public Database(){
        // Instance a new HashMap.
        this.listaProductos = new HashMap<>();
        // Fill the database initial values.
        this.listaProductos.put(1, new Product("1", "Manzanas", 
                "9000.0", "65"));
        this.listaProductos.put(2, new Product("2", "Limones", "2300.0","15"));
        this.listaProductos.put(3, new Product("3", "Peras", "2500.0", "38"));
        this.listaProductos.put(4, new Product("4", "Arandanos", 
                "9300.0", "55"));
        this.listaProductos.put(5, new Product("5", "Tomates", "2100.0", "42"));
        this.listaProductos.put(6, new Product("6", "Fresas", "4100.0", "33"));
        this.listaProductos.put(7, new Product("7", "Helado", "4500.0", "41"));
        this.listaProductos.put(8, new Product("8", "Galletas", 
                "500.0", "833"));
        this.listaProductos.put(9, new Product("9", "Chocolates", 
                "3500.0", "806"));
        this.listaProductos.put(10, new Product("10", "Jamon", 
                "17000.0", "10"));    
    }
    
     /**
      * Add product method.
      * @param producto Product.
      */
    public void agregar(Product producto){
        this.listaProductos.put(producto.getCode(), producto);
    }
    
    /**
     * Update product method.
     * @param code int.
     * @param producto Product.
     */
    public void actualizar(Product producto){
        this.listaProductos.replace(producto.getCode(), producto);
        /*
        this.listaProductos.get(code).setName(name);
        this.listaProductos.get(code).setPrice(price);
        this.listaProductos.get(code).setAmount(amount);
        */
    }
    
    /**
     * Erase product method.
     * @param code int.
     */
    public void eliminar(int code){
        this.listaProductos.remove(code);
    }
    
    /**
     * Product existence verification method.
     * @param code int
     * @return boolean
     */
    public boolean verificarExistencia(int code){
        return this.listaProductos.containsKey(code);
    }
    
    /**
     * Display the information of the top 3 expesinve products.
     * @return String
     */
    public String generarInforme(){
        // Declare the case variables.
        double first = 2000;
        double second = 1500;
        double third = 0;
        String firstProd = "";
        String secondProd = "";
        String thirdProd = "";
        for(int key : this.listaProductos.keySet()){
            // Check the product with the higher price.
            if(this.listaProductos.get(key).getPrice() > first){
                // Reassign the variables.
                third = second;
                second = first;
                thirdProd = secondProd;
                secondProd = firstProd;
                first = this.listaProductos.get(key).getPrice();
                firstProd = this.listaProductos.get(key).getName();
            }
            // Check the product with the second higher price.
            else if(this.listaProductos.get(key).getPrice() < first &&
                    this.listaProductos.get(key).getPrice() > second){
                // Reassignt the variables.
                third = second;
                thirdProd = secondProd;
                second = this.listaProductos.get(key).getPrice();
                secondProd = this.listaProductos.get(key).getName();
            }
            // Check the product with the third higher price.
            else if(this.listaProductos.get(key).getPrice() < second &&
                    this.listaProductos.get(key).getPrice() > third){
                // Reassign the variables.
                third = this.listaProductos.get(key).getPrice();
                thirdProd = this.listaProductos.get(key).getName();
            }
        }
        return firstProd + " " + secondProd + " " + thirdProd;
    }
    
    
    /**
     * Method to do the actions according to the input operation.
     * @param operation String.
     * @param code String.
     * @param name String.
     * @param price String.
     * @param amount String.
     * @param error boolean.
     * @return error boolean updated error state.
     */
    public boolean operaciones(String operation, String code, String name,
            String price, String amount, boolean error){
        
        Product nuevoProducto = new Product(code, name, price, amount);
        switch(operation){
            case "AGREGAR":
                if(verificarExistencia(nuevoProducto.getCode())){
                    System.out.println("ERROR");
                    error = true;
                }
                else{
                    agregar(nuevoProducto);
                }
                break;
            case "ACTUALIZAR":
                if(verificarExistencia(nuevoProducto.getCode())){
                    actualizar(nuevoProducto);
                }
                else{
                    System.out.println("ERROR");
                    error = true;
                }
                break;
            case "BORRAR":
                if(verificarExistencia(nuevoProducto.getCode())){
                    eliminar(nuevoProducto.getCode());
                }
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
}

/**
 * Product Class
 * @author niltonrodriguez
 */
class Product {
    
    private int code;
    private String name;
    private double price;
    private int amount;
    
    /**
     * Class Constructor.
     * @param code int código identificador.
     * @param nombre String nombre del producto.
     * @param price double precio del producto.
     * @param amount int cantidad en el inventario.
     */
    public Product(String code, String nombre, String price, String amount) {
        this.code = Integer.valueOf(code);
        this.name = nombre;
        this.price = Double.valueOf(price);
        this.amount = Integer.valueOf(amount);
    }
    
    /**
     * Amount Getter
     * @return int.
     */
    public int getAmount() {
        return amount;
    }
     /**
      * Amount Setter.
      * @param amount String.
      */
    public void setAmount(String amount) {
        this.amount = Integer.valueOf(amount);
    }
    
    /**
     * Code Getter
     * @return int
     */
    public int getCode() {
        return code;
    }
    
    /**
     * Code setter.
     * @param code String
     */
    public void setCode(String code) {
        this.code = Integer.valueOf(code);
    }
    
    /**
     * Name Getter
     * @return String
     */
    public String getName() {
        return name;
    }
    
    /**
     * Name Setter.
     * @param nombre String.
     */
    public void setName(String nombre) {
        this.name = nombre;
    }
    
    /**
     * Price getter.
     * @return double.
     */
    public double getPrice() {
        return price;
    }
    
    /**
     * Price setter
     * @param price 
     */
    public void setPrice(String price) {
        this.price = Double.valueOf(price);
    }
}

