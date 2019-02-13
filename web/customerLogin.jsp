<%-- 
    Document   : customerLogin
    Created on : 06-Feb-2019, 11:42:30
    Author     : zbo97
--%>

<%@page import="Dtos.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <script src="Jquery/jquery-3.3.1.js"></script>
    <script src="Jquery/rememberMe.js">
        
    </script>
    <body>
        
        <form action="FrontController" method="post">
            <table>
                <tr><td>Username: </td><td><input name="username" required size=20 type="text" id="username"/> </td></tr>
                <tr><td>Password: </td><td> <input name="password" required size=50 type="password" id="pass"/> </td> </tr>
                <tr><td>Remember me</td><td><input name="remember-me" type="checkbox" value="remember-me" id="remember_me"/></td></tr>
            </table>
            <input type="submit" value="Login" />
            <input type="hidden" name ="action" value="customerLogin" />
        </form>
    </body>
</html>
