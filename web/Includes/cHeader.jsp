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
        <link rel="stylesheet" href="Styles/main.css">
    </head>
    <body>
        <div class="container">
            <%             Customer loggedInUser = (Customer) session.getAttribute("loggedInUser");
                if (loggedInUser != null) {
            %>
            <h1>Hello <%= loggedInUser.getUsername()%></h1>
            <nav > 
                <ul class="nav nav-pills">
                    <li class="nav-item"> <a class="nav-link active" href="index.jsp">Home</a></li>
                    <li class="nav-item"> <a class="nav-link active" href="FrontController?action=logout">Logout</a></li>
                    <li class="nav-item">  <a class="nav-link active" href="customerProfile.jsp?customerId=<%=loggedInUser.getCustomerId()%>">View My Profile</a></li>
                    <li class="nav-item">    <a class="nav-link active" href="FrontController?action=viewRestaurants">View restaurant list</a></li>
                </ul>
            </nav>
            <%
            } else {
            %>
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <a class="navbar-brand" href="index.jsp">
                    <img src="Images/Logo.png" width="30" height="30" class="d-inline-block align-top" alt="logo"/> Only Eat
                </a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo01" aria-controls="navbarTogglerDemo01" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarTogglerDemo01">
                    <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
                        <li class="nav-item active ml-lg-3 pl-lg-3">
                            <a class="nav-link" href="index.jsp">Home <span class="sr-only">(current)</span></a>
                        </li>
                        <li class="nav-item ml-lg-5 pl-lg-5">
                            <a class="nav-link" href="customerLogin.jsp">Sign In</a>
                        </li>
                        <li class="nav-item ">
                            <a class="nav-link" href="customerRegister.jsp">Register</a>
                        </li>
                    </ul>
                </div>
            </nav>
            <%
                }
            %>
        </div>
        <script src="Jquery/jquery-3.3.1.js"></script>
        <script src="Styles/bootstrap-4.3.1/js/bootstrap.bundle.js"></script>
        <script src="Styles/bootstrap-4.3.1/js/bootstrap.js"></script>
    </body>
</html>
