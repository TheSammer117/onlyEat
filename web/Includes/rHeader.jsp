<%-- 
    Document   : rHeader
    Created on : 2019-3-12, 21:31:08
    Author     : 82509
--%>

<%@page import="Dtos.Restaurant"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
          <script src="Jquery/jquery-3.3.1.js"></script>
    <script src="Jquery/rememberMe.js"></script>
    <body>
        <%             Restaurant loggedInUser = (Restaurant) session.getAttribute("loggedInRestaurant");
            if (loggedInUser != null) {
        %>
        <h1>Hello <%= loggedInUser.getUsername()%></h1>
        <a href="restaurantIndex.jsp">Home</a>
        <a href="restaurantMenu.jsp?RestaurantId=<%=loggedInUser.getRestaurantId()%>">View My Menu</a>
        <a href="FrontController?action=restaurantLogout">Logout</a>
        <%
        } else {
        %>
        <div>    
            <a href="restaurantIndex.jsp">Home</a>
            <a href="restaurantLogin.jsp">Sign In</a>
            <a href="restaurantRegister.jsp">Register</a>
        </div>
        <%
            }
        %>

    </body>
</html>
