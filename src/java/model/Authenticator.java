/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import db.DBUtility;
import db.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Median
 */
public class Authenticator {
    private User currentUser; 

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }
    public boolean authenticate(String username, String password){
        boolean result = false;        
        User user = getUser(username);
        if(user!=null && user.getPassword().equalsIgnoreCase(password)){
            result = true;
            currentUser = user;
        }
        return result;        
    }

    private User getUser(String username) {
        try {
            Connection connection = DBUtility.getConnection();
            PreparedStatement st = connection.prepareStatement("select * from user where username = ?");
            st.setString(1, username);            
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return  new User(rs.getInt("id"), username, rs.getString("password"),
                                rs.getString("name"), rs.getString("role"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Authenticator.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
