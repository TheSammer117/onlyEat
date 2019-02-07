<%-- 
    Document   : customerLogin
    Created on : 06-Feb-2019, 11:42:30
    Author     : zbo97
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <form action="FrontController" method="post">
            <table>
                <tr><td>Username: </td><td><input name="username" required size=20 type="text" /> </td></tr>
                <tr><td>Password: </td><td> <input name="password" required size=50 type="password" /> </td> </tr>
            </table>
            <input type="submit" value="Login" />
            <input type="hidden" name ="action" value="customerLogin" />
        </form>
    </body>
</html>
