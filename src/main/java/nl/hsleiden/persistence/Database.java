/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.hsleiden.persistence;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database {
    private static String url = "jdbc:mysql://145.97.16.189:3306/abdouldb";
    
    private static String un = "abdoul";
    private static String pw = "abdoul";
    
    public Database(){
        try{
           Class.forName("com.mysql.jdbc.Driver");
       }catch(ClassNotFoundException e){
           e.printStackTrace();
       }
    }
    
    public Connection getConnection(){
        try{
        return DriverManager.getConnection(url,un,pw);
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }
    
    public void closeConnection(Connection con){
        try{
            con.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
