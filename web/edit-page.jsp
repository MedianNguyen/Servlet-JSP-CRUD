<%-- 
    Document   : edit-page
    Created on : Mar 24, 2015, 1:39:18 PM
    Author     : Median
--%>

<%@page import="db.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       
        <% User u = (User) request.getAttribute("user"); %>
         <h1>Hello  <%= u.getUsername() %>!</h1>
        
        <form action="User?action=update" method="post" >            
            <table >
                <tbody>                            
                    <tr><td>ID</td> 
                        <td><input name="uid" type="text" value="<%= u.getID()%>" disabled /> </td>                      
                    </tr>
                    <tr> 
                        <td>Name:</td>                       
                        <td><input name="name" type="text" value="<%= u.getName()%>" /> </td>
                    </tr>
                    <tr> 
                        <td>Username:</td>                       
                        <td><input name="username" type="text" value="<%= u.getUsername()%>" /> </td>
                    </tr>
                    <tr> 
                        <td>Password</td>                        
                        <td><input name="password" type="text" value="<%= u.getPassword()%>" /></td>
                    </tr>
                    <tr>
                        <td> Role </td>
                        <td><input name="role" type="text" value="<%= u.getRole()%>" /></td>                        
                    </tr>
                    
                    <tr>
                        <td colspan="2" ><input type="submit" value="Update"/></td>
                    </tr>
                </tbody>
                </table>          
            
            
        <div id="notification"> 
            <% if(request.getAttribute("error")!= null) {%>
            <%= request.getAttribute("error") %>
            <%}%>
        </div>
        </form>
        
    </body>
</html>
