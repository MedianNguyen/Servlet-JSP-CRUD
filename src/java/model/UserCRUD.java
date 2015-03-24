/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import db.DBUtility;
import db.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Median
 */
public class UserCRUD {
    public ArrayList<User> getAllUsers() throws SQLException{
        ArrayList<User> allUsers = new ArrayList<User>();
        Statement st = DBUtility.getConnection().createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM USER");
        while (rs.next()){
            int id = rs.getInt(1);
            String username = rs.getString(2);
            String password = rs.getString(3);
            String name = rs.getString("name");
            String role = rs.getString(5);
            User user = new User(id, username, password, name, role);
            allUsers.add(user);
        }        
        return allUsers;
    }
}
