/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import db.User;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.UserCRUD;

/**
 *
 * @author Median
 */
public class UserController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {        
        String action = request.getParameter("action");
        String id = request.getParameter("id");
        UserCRUD userUD = new UserCRUD();
        ArrayList<User> allUsers = null;
        try {
            allUsers = userUD.getAllUsers();
        } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Enumeration<String> attributeNames = request.getAttributeNames();
        System.out.println(attributeNames.toString());
        
        if(action.equals("create")){
            try {
                String username = request.getParameter("username");
                String pass = request.getParameter("password");
                String name = request.getParameter("name");
                String role = request.getParameter("role");
                ArrayList<User> allUsers1 = userUD.getAllUsers();
                int newID =  allUsers1.get(allUsers1.size()-1).getID()+1;
                User newUser = new User(newID, username, pass, name, role);
                userUD.createNewUser(newUser);
                
            } catch (SQLException ex) {
                Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            }
            RequestDispatcher rd = request.getRequestDispatcher("crud-page.jsp");
            try {
                request.setAttribute("allUsers", userUD.getAllUsers());
            } catch (SQLException ex) {
                Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            }
            rd.forward(request, response);
        }
        
        if(action.equals("edit")){            
            User user = userUD.getUser(Integer.parseInt(id));
            RequestDispatcher rd = request.getRequestDispatcher("/edit-page.jsp");
            request.setAttribute("user", user);
            rd.forward(request, response);
        }
        
        if(action.equals("update")){            
            String username = request.getParameter("username");
            String pass = request.getParameter("password");
            String name = request.getParameter("name");
            String role = request.getParameter("role");
            int uid = Integer.parseInt(request.getParameter("uid"));            
            User editedUser = new User(uid, username, pass, name, role);
            userUD.updateUser(editedUser);
            RequestDispatcher rd = request.getRequestDispatcher("/crud-page.jsp");
            try {
                request.setAttribute("allUsers", userUD.getAllUsers());
            } catch (SQLException ex) {
                Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            }
            rd.forward(request, response);
        }
        
        if(action.equals("delete")){
            
            boolean isDeleted = userUD.deleteUser(Integer.parseInt(id));
            if(!isDeleted){
                request.setAttribute("error", "Something wrong! Can't delete user");
            }
            try {
                request.setAttribute("allUsers",userUD.getAllUsers());
            } catch (SQLException ex) {
                Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            }
            RequestDispatcher rd = request.getRequestDispatcher("/crud-page.jsp");            
            rd.forward(request, response);
        }
                
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
