<%-- 
    Document   : restaurantHeader
    Created on : 2019-2-6, 17:50:27
    Author     : 82509
--%>

<%@page import="Daos.FoodTypeDao"%>
<%@page import="Dtos.Food"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Daos.FoodDao"%>
<%@page import="Dtos.Restaurant"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    </head>
    <script src="Jquery/jquery-3.3.1.js"></script>
    <script src="Jquery/rememberMe.js">
    </script>
    <body>

        <%             Restaurant loggedInUser = (Restaurant) session.getAttribute("loggedInRestaurant");
            if (loggedInUser != null) {
        %>
        <a href="FrontController?action=logout">Logout</a>
        <%
        } else {
        %>
        <div>
            <p>Please login here</p>
            <%
                String sessionExpired = (String) session.getAttribute("sessionExpired");
                if (sessionExpired != null) {
                    out.println("<b>" + sessionExpired + "</b>");
                    session.removeAttribute("sessionExpired");

                }
            %>
            <form action="FrontController" method="post">
                <table>
                    <tr><td>Username: </td><td><input name="username" required size=20 type="text" id="username"/> </td></tr>
                    <tr><td>Password: </td><td> <input name="password" required size=50 type="password" id="pass"/> </td> </tr>
                    <tr><td>Remember me</td><td><input name="remember-me" type="checkbox" value="remember-me" id="remember_me"/></td></tr>
                </table>
                <input type="submit" value="Login" />
                <input type="hidden" name ="action" value="restaurantLogin" />

            </form>
            <a href="restaurantRegister.jsp">Register</a>
        </div>
        <%
            }
        %>

    </body>
</html>
