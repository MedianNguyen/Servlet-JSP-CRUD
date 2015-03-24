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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    
    public User getUser(int id) {
        try {
            Connection connection = DBUtility.getConnection();
            PreparedStatement st = connection.prepareStatement("select * from user where id = ?");
            st.setInt(1, id);            
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
             return  new User(rs.getInt("id"), rs.getString("username"), rs.getString("password"),
                        rs.getString("name"), rs.getString("role"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Authenticator.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void updateUser(User u){
        try {
            Connection connection = DBUtility.getConnection();
            String updateQuery = "UPDATE USER SET  USERNAME = ?,PASSWORD = ?, NAME = ?, ROLE = ? "
                    + " WHERE ID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
            
            preparedStatement.setString(1, u.getUsername());
            preparedStatement.setString(2, u.getPassword());
            preparedStatement.setString(3, u.getName());
            preparedStatement.setString (4, u.getRole());
            preparedStatement.setInt(5, u.getID());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean deleteUser(int id) {
        boolean result = false;
        try {
            Connection connection = DBUtility.getConnection();
            String deleteQuery = "DELETE FROM USER WHERE ID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
            preparedStatement.setInt(1, id);
            // execute delete SQL statement
            preparedStatement.executeUpdate();
            result = true;
        } catch (SQLException ex) {
            Logger.getLogger(UserCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
}
