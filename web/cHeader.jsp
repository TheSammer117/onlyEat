<%-- 
    Document   : cHeader
    Created on : 13-Feb-2019, 19:15:59
    Author     : zbo97
--%>

<%@page import="Dtos.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <%             Customer loggedInUser = (Customer) session.getAttribute("loggedInUser");
            if (loggedInUser != null) {
        %>
        <h1>Hello <%= loggedInUser.getUsername() %></h1>
        <a href="FrontController?action=logout">Logout</a>
        <a href="customerProfile.jsp?customerId=<%=loggedInUser.getCustomerId() %>">View My Profile</a>
        <%
        } else {
        %>
        <h1>You are not logged in</h1>
        <a href="customerLogin.jsp">Login</a>
        <%
            }
        %>
    </body>
</html>
