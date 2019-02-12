<%-- 
    Document   : index
    Created on : 06-Feb-2019, 18:39:49
    Author     : zbo97
--%>

<%@page import="Dtos.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Only Eat</title>
    </head>
    <body>
        <%             Customer loggedInUser = (Customer) session.getAttribute("loggedInUser");
            if (loggedInUser != null) {
        %>
        <h1>Hello <%= loggedInUser.getUsername() %></h1>
        <a href="FrontController?action=logout">Logout</a>
        <%
        } else {
        %>
        <a href="customerLogin.jsp">Login</a>
        <%
            }
        %>
    </body>
</html>
