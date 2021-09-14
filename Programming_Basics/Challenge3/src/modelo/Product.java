/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author niltonrodriguez
 */
public class Product {
    /**
     * Class Atrributes
     */
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
