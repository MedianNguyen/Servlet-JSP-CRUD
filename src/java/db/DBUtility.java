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
 * @author Median
 */
public class DBUtility {

    public static Connection getConnection() throws SQLException {
        Connection connection = null;
         try {
            Class.forName("com.mysql.jdbc.Driver");             
            connection = DriverManager.getConnection("jdbc:mysql://localhost/crud_example","root", "");             
         } catch (ClassNotFoundException  ex) { //multicatch statement not support in 1.6
             Logger.getLogger(DBUtility.class.getName()).log(Level.SEVERE, null, ex);         }
         return connection;
    }
    
}
