/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author niltonrodriguez
 */
public class Database {
    
    /**
     * Database Atributes.
     */
    Map<Integer, Product> listaProductos;
    
    /**
     * Database Constructor.
     */
    public Database(){
        // Instance the HashMap.
        this.listaProductos = new HashMap<>();
        // Initialize the product information.
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
            if(this.listaProductos.get(key).getPrice() > first){
                third = second;
                second = first;
                thirdProd = secondProd;
                secondProd = firstProd;
                first = this.listaProductos.get(key).getPrice();
                firstProd = this.listaProductos.get(key).getName();
            }
            else if(this.listaProductos.get(key).getPrice() < first &&
                    this.listaProductos.get(key).getPrice() > second){
                third = second;
                thirdProd = secondProd;
                second = this.listaProductos.get(key).getPrice();
                secondProd = this.listaProductos.get(key).getName();
            }
            else if(this.listaProductos.get(key).getPrice() < second &&
                    this.listaProductos.get(key).getPrice() > third){
                third = this.listaProductos.get(key).getPrice();
                thirdProd = this.listaProductos.get(key).getName();
            }
        }
        return firstProd + " " + secondProd + " " + thirdProd;
    }
    
    /**
     * Method to get the database size.
     * @return int
     */
    public int totalProducts(){
        return this.listaProductos.size();
    }
    
    /**
     * Database getter.
     * @return Collection product values.
     */
    public Collection<Product> getProducts(){
        return this.listaProductos.values();
    }
    
    /**
     * Product getter.
     * @return Product.
     */
    public Product getProduct(int index){
        return this.listaProductos.get(index);
    }
 
}
