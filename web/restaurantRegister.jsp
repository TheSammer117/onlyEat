<%-- 
    Document   : restaurantRegister
    Created on : 2019-2-6, 17:46:38
    Author     : 82509
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
    </head>
   <body>
             
        <form action="FrontController" method="post">
            <table>
               <tr>
                    <td>Username: </td> <td><input type="text" name="username"  required/></td>
                </tr>
                <tr>
                    <td>Password: </td> <td><input type="password" name="password"  required/></td>
                </tr>
                <tr>
                    <td>Name: </td> <td><input type="text" name="name"  required/></td>
                </tr>
                <tr>
                    <td>Phone Number: </td> <td><input type="text" name="phone"  required/></td>
                </tr>
            </table>
            <input type="submit" value="RestaurantRegister" />
            <input type="hidden" name ="action" value="restaurantRegister" />
        </form>

        <%@ include file = "footer.jsp" %>
    </body>
</html>
