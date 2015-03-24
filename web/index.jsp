<%-- 
    Document   : index
    Created on : Mar 24, 2015, 8:24:01 AM
    Author     : Median
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Index Page</title>
    </head>
    <div class="main_menu" style="font-size: larger;font-weight: bolder; margin-bottom:4px;">
    <b>Login</b></div>
    <form action="Login" method="post" name="form_login">
        <div id="LoginForm" >
            Username: <input name="username" type="text"/>
            Password: <input name="password" type="password"/>
            <input type="submit" value="Login"/>
        </div>
        <div> 
            <% if(request.getAttribute("error")!= null) {%>
            <%= request.getAttribute("error") %>
            <%}%>
        </div>
    </form>
</html>
