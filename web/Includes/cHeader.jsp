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
         <link rel="stylesheet" href="Styles/bootstrap-4.3.1/css/bootstrap.min.css">
         <link rel="stylesheet" href="Styles/bootstrap-4.3.1/css/custom.css">
    </head>
    <body>
        <%             Customer loggedInUser = (Customer) session.getAttribute("loggedInUser");
            if (loggedInUser != null) {
        %>
        <h1>Hello <%= loggedInUser.getUsername() %></h1>
        <nav > 
            <ul class="nav nav-pills">
                <li class="nav-item"> <a class="nav-link active" href="index.jsp">Home</a></li>
                <li class="nav-item"> <a class="nav-link active" href="FrontController?action=logout">Logout</a></li>
                <li class="nav-item">  <a class="nav-link active" href="customerProfile.jsp?customerId=<%=loggedInUser.getCustomerId() %>">View My Profile</a></li>
                <li class="nav-item">    <a class="nav-link active" href="FrontController?action=viewRestaurants">View restaurant list</a></li>
            </ul>
        </nav>
        <%
        } else {
        %>
        <h1>You are not logged in</h1>
        <nav >
             <ul class="nav nav-pills">
                 <li class="nav-item"> <a href="customerLogin.jsp">Login</a></li>
                 <li class="nav-item"><a href="customerRegister.jsp">Register</a></li>
             </ul>
        </nav>
        <%
            }
        %>
         <script src="Jquery/jquery-3.3.1.js"></script>
            <script src="Styles/bootstrap-4.3.1/js/bootstrap.bundle.js"></script>
            <script src="Styles/bootstrap-4.3.1/js/bootstrap.js"></script>
    </body>
</html>
