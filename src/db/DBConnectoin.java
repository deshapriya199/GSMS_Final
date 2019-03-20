/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SANJAYA
 */
public class DBConnectoin {
    private static final DBConnectoin dBConnectoin=new DBConnectoin();
    private static Connection conn;

     private DBConnectoin() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "4522");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBConnectoin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBConnectoin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }  
     
     public static synchronized Connection getDBConnection() {            
        return conn;
    }    
}
