<%-- 
    Document   : create-page
    Created on : Mar 24, 2015, 3:42:46 PM
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
       
        <form action="User?action=create" method="post" >            
            <table >
                <tbody>                            
                    
                    <tr> 
                        <td>Name:</td>                       
                        <td><input name="name" type="text" " /> </td>
                    </tr>
                    <tr> 
                        <td>Username:</td>                       
                        <td><input name="username" type="text"  /> </td>
                    </tr>
                    <tr> 
                        <td>Password</td>                        
                        <td><input name="password" type="text"  /></td>
                    </tr>
                    <tr>
                        <td> Role </td>
                        <td><input name="role" type="text"  /></td>                        
                    </tr>
                    
                    <tr>
                        <td colspan="2" ><input type="submit" value="Create"/></td>
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
