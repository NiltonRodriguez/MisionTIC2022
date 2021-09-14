/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entidad;

/**
 *
 * @author niltonrodriguez
 */
public class Producto {
    
    /**
     * Product attributes.
     */
    private int codigo;
    private String nombre;
    private double precio;
    private int inventario;
    
    /**
     * Product constructor.
     * @param codigo int.
     * @param nombre String.
     * @param precio double.
     * @param inventario int.
     */
    public Producto(int codigo, String nombre, double precio, int inventario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.inventario = inventario;
    }
    
    /**
     * Inventario getter.
     * @return inventario int.
     */
    public int getInventario() {
        return inventario;
    }
    
    /**
     * Inventario setter.
     * @param inventario int.
     */
    public void setInventario(int inventario) {
        this.inventario = inventario;
    }
    
    /**
     * Codigo getter.
     * @return codigo int.
     */
    public int getCodigo() {
        return codigo;
    }
    
    /**
     * Codigo setter.
     * @param codigo int.
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    /**
     * Nombre getter.
     * @return nombre String.
     */
    public String getNombre() {
        return nombre;
    }
    
    /**
     * Nombre setter.
     * @param nombre String.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * Precio getter.
     * @return precio double.
     */
    public double getPrecio() {
        return precio;
    }
    
    /**
     * Precio setter.
     * @param precio double.
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    /**
     * Product to String.
     */
    public void displayProducto(){
        System.out.println("Código: " + codigo + " Nombre: " + nombre + 
                " Precio: " + precio + " Inventario: " + inventario);
    }
    
}
