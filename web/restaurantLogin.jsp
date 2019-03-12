<%-- 
    Document   : restaurantLogin
    Created on : 2019-3-12, 21:02:07
    Author     : 82509
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Restaurant Login Page</title>
    </head>
    <body>
              <%@ include file = "Includes/rHeader.jsp" %>
              <form action="FrontController" method="post">
                <table>
                    <tr><td>Username: </td><td><input name="username" required size=20 type="text" id="username"/> </td></tr>
                    <tr><td>Password: </td><td> <input name="password" required size=50 type="password" id="pass"/> </td> </tr>
                    <tr><td>Remember me</td><td><input name="remember-me" type="checkbox" value="remember-me" id="remember_me"/></td></tr>
                </table>
                <input type="submit" value="Login" />
                <input type="hidden" name ="action" value="restaurantLogin" />

            </form>
    </body>
</html>
