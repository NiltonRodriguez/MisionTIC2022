/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author niltonrodriguez
 */
public class Conexion {
    /**
     * Connection attributes.
     */
    private String database = "Reto5";
    private String user = "root";
    // Fill the quotes with your MySQL root user password. Must be a String.
    private String Password = "";
    private String url = "jdbc:mysql://localhost/" + database;
    private Connection dbConnection = null;

    /**
     * Connection Method.
     */
    public Conexion(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            dbConnection = DriverManager.getConnection(url, user, Password);
            System.out.println("Conectado con la base de datos " + database);
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    /**
     * Connection getter.
     * @return dbConnection.
     */
    public Connection getDbConnection() {
        return dbConnection;
    }
}
