<%-- 
    Document   : restaurantHeader
    Created on : 2019-2-6, 17:50:27
    Author     : 82509
--%>

<%@page import="Dtos.Restaurant"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    </head>
    <body>
        <%
            Restaurant loggedInUser = (Restaurant) session.getAttribute("loggedInRestaurant");
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
                    <tr>
                        <td> Username  : </td><td> <input name="username" required size=20 type="text" /> </td> 
                    </tr>
                    <tr>
                        <td> Password  : </td><td> <input name="password" required size=50 type="password" /> </td> 
                    </tr>
                </table>
                <input type="submit" value="RestaurantLogin" />
                <input type="hidden" name ="action" value="restaurantLogin" />
                <label for="remember-me">
                    <input name="aaaa" type="checkbox" onclick="remember();">
                     remeber me 
                </label>
            </form>
            <a href="restaurantRegister.jsp">Register</a>
        </div>



        <%
            }
        %>
    </body>
</html>
