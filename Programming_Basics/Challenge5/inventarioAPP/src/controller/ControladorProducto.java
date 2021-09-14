/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.conexion.Conexion;
import model.entidad.Producto;
/**
 *
 * @author niltonrodriguez
 */
public class ControladorProducto {
    
    /**
     * Class attributes
     */
    private Connection dbConnection;
    private PreparedStatement prepStat;
    
    /**
     * Method to enable the conection to the database.
     */
    public ControladorProducto(){
        Conexion connect = new Conexion();
        dbConnection = connect.getDbConnection();
    }
    
    /**
     * Data mapping method. (READ)
     * @return prodList List.
     */
    public List<Producto> products(){
        // Array with product table information.
        List<Producto> prodList = new ArrayList<>();
        // Object to prepare SQL query.
        String sqlQuery = "SELECT * FROM Productos";
        try{
            prepStat = dbConnection.prepareStatement(sqlQuery);
            // ResultSet is a matrix result of the query.
            ResultSet resSet = prepStat.executeQuery();
            // Iterate the table
            while(resSet.next()){
                // Instance a new object to store the matrix data in the array.
                prodList.add(new Producto(resSet.getInt(1), resSet.getString(2),
                                    resSet.getDouble(3), resSet.getInt(4)));
            }
        }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return prodList;
    }
    
    /**
     * Add Product Method. (CREATE)
     * @param product Producto.
     * @return addectedRow int.
     */
    public int addProduct(Producto product){
        int affectedRow = 0;
        // Object to prepare SQL query.
        String sqlQuery = "INSERT INTO Productos VALUE (?, ?, ?, ?)";
        try{
            prepStat = dbConnection.prepareStatement(sqlQuery);
            // Assign each attribute of the object to query value.
            prepStat.setInt(1, product.getCodigo());
            prepStat.setString(2, product.getNombre());
            prepStat.setDouble(3, product.getPrecio());
            prepStat.setInt(4, product.getInventario());
            // Get the number of affected rows.
            affectedRow = prepStat.executeUpdate();
        }
        catch(SQLException ex){
            if(ex.getErrorCode() == 1062){
                affectedRow = 2;
            }
        }
        return affectedRow;
    }
    
    /**
     * Update product method. (UPDATE)
     * @param product
     * @return 
     */
    public int updateProduct(Producto product){
        int affectedRow = 0;
        // Object to prepare SQL query.
        String sqlQuery = "UPDATE Productos SET nombre = ?, precio = ?," +
                "inventario = ? WHERE codigo = ?";
        try{
            prepStat = dbConnection.prepareStatement(sqlQuery);
            // Assign each attribute of the object to the query value.
            prepStat.setString(1, product.getNombre());
            prepStat.setDouble(2, product.getPrecio());
            prepStat.setInt(3, product.getInventario());
            prepStat.setInt(4, product.getCodigo());
            // Get the number of affected rows.
            affectedRow = prepStat.executeUpdate();
        }
        catch(SQLException ex){
            affectedRow = 0;
        }
        return affectedRow;
    }
    
    /**
     * Delete product Method (DELETE)
     * @param codigo int.
     */
    public void deleteProduct(int codigo){
        // Object to prepare SQL query.
        String sqlQuery = "DELETE FROM Productos WHERE codigo = ?";
        try{
            prepStat = dbConnection.prepareStatement(sqlQuery);
            // Assign each attribute of the object to the query value.
            prepStat.setInt(1, codigo);
            // Get the number of affected rows.
            prepStat.executeUpdate();
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    /**
     * Method to get the most expensive product in the database.
     * @return expensive String.
     */
    public String expensiveProduct(){
        String expensive = "";
        String sqlQuery = "SELECT nombre FROM Productos ORDER BY precio DESC " +
                "LIMIT 1";
        try{
            prepStat = dbConnection.prepareStatement(sqlQuery);
            // ResultSet is a matrix result of the query.
            ResultSet resSet = prepStat.executeQuery();
            // Assign the result to a variable.
            while(resSet.next()){
                expensive = resSet.getString(1);
            }
            
        }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return expensive;
    }
    
    /**
     * Method to get the creapest product in the database.
     * @return cheaper String.
     */
    public String cheaperProduct(){
        String cheaper = "";
        String sqlQuery = "SELECT nombre FROM Productos ORDER BY precio ASC " +
                "LIMIT 1";
        try{
            prepStat = dbConnection.prepareStatement(sqlQuery);
            // ResultSet is a matrix result of the query.
            ResultSet resSet = prepStat.executeQuery();
            // Assign the result to a variable.
            while(resSet.next()){
                cheaper = resSet.getString(1);
            }
        }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return cheaper;
    }
    
    /**
     * Method to get the average price of the database.
     * @return 
     */
    public String averagePrice(){
        double average = 0;
        String sqlQuery = "SELECT ROUND(AVG(precio), 1) FROM Productos";
        try{
            prepStat = dbConnection.prepareStatement(sqlQuery);
            // ResultSet is a matrix result of the query.
            ResultSet resSet = prepStat.executeQuery();
            // Assign the result to a variable.
            while(resSet.next()){
                average = resSet.getDouble(1);
            }
        }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return String.valueOf(average);
    }
    
    /**
     * Method to get the inventory total value.
     * @return totalString String.
     */
    public String totalInventory(){
        double total = 0;
        String totalString = "";
        String sqlQuery = "SELECT SUM(precio * inventario) FROM Productos";
        try{
            prepStat = dbConnection.prepareStatement(sqlQuery);
            // ResultSet is a matrix result of the query.
            ResultSet resSet = prepStat.executeQuery();
            // Assign the result to a variable.
            while(resSet.next()){
                total = resSet.getDouble(1);
            }
            totalString = String.format("%.1f", total);
        }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return totalString;
    }
    
    /**
     * Method to generate a report with the information of the most expensive
     * product, the cheapest product, the average price and the inventory total.
     * @return String.
     */
    public String geneateReport(){
        return "Producto de mayor precio: " + expensiveProduct() +
                "\nProducto de menor precio: " + cheaperProduct() +
                "\nPromedio de precios: " + averagePrice() +
                "\nValor total del inventario: " + totalInventory();
    }
}
