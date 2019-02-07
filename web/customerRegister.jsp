<%-- 
    Document   : customerRegister
    Created on : 06-Feb-2019, 11:20:57
    Author     : zbo97
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer Register</title>
    </head>
    <body>
        <form action="FrontController" method="post">
            <table>
                <tr>
                    <td>Username: </td><td><input type="text" name="username"  required/></td>
                </tr>
                <tr>
                    <td>Password: </td> <td><input type="password" name="password"  required/></td>
                </tr>
                <tr>
                    <td>First Name: </td> <td><input type="text" name="firstName"  required/></td>
                </tr>
                <tr>
                    <td>Last Name: </td> <td><input type="text" name="lastName"  required/></td>
                </tr>
                <tr>
                    <td>Phone Number: </td> <td><input type="text" name="phone"  required/></td>
                </tr>
            </table>
            <input type="submit" value="register" />
            <input type="hidden" name ="action" value="customerRegister" />
        </form>
        <a href="index.jsp">Back to Index</a>
    </body>
</html>
