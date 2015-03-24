<%-- 
    Document   : crud-page
    Created on : Mar 24, 2015, 8:37:31 AM
    Author     : Median
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="db.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        
        <div> <h1><a href="create-page.jsp"> Add new User </a></h1></div>
        <div> <h1> All users </h1>
            <% ArrayList<User> allUsers = (ArrayList) request.getAttribute("allUsers"); %>
            <div>
                <table style="border: 1px solid black;" cellpadding="6" cellspacing="0">
                <thead> <th>ID</th><th>Name</th><th>Username</th><th>Password</th><th>Role</th> 
                <th colspan="2"> Update & Delete </th>
                </thead>
                <tbody>
                <%for (User u : allUsers) { %>              
                
                    <tr>
                        <td><%= u.getID()%></td>
                        <td><%= u.getName() %></td>
                        <td><%= u.getUsername()%></td>
                        <td><%= u.getPassword()%></td>
                        <td><%= u.getRole()%></td>
                        <td><a href="User?action=edit&id=<%= u.getID()%>" > Edit </a></td>
                        <td><a href="User?action=delete&id=<%= u.getID()%>" > Delete </a></td>
                    </tr>                       
                
                <% } %>
                </tbody>
                </table>
            </div>        
        </div>
        
    </body>
</html>
