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
        <link rel="stylesheet" href="Styles/bootstrap-4.3.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="Styles/bootstrap-4.3.1/css/custom.css">
        <link rel="stylesheet" href="Styles/main.css">
    </head>

    <body>
        <div class="container">
            <%             Restaurant loggedInUser = (Restaurant) session.getAttribute("loggedInRestaurant");
                if (loggedInUser != null) {
            %>
            <nav class="navbar navbar-expand-lg navbar-light " style="background-color: #e3f2fd;">
                <a class="navbar-brand"  href="restaurantIndex.jsp">
                    <img src="Images/Logo.png" width="30" height="30" class="d-inline-block align-top" alt="logo"/> Only Eat
                </a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo01" aria-controls="navbarTogglerDemo01" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarTogglerDemo01">
                    <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
                        <li class="nav-item active ml-lg-5">
                            <a class="nav-link" href="restaurantIndex.jsp">Home <span class="sr-only">(current)</span></a>
                        </li>
                        <li class="nav-item   my-2 my-lg-0">
                            <a class="nav-link" href="FrontController?action=logout">Logout</a>
                        </li>
                    </ul>
                </div>
            </nav>
            <%
            } else {
            %>
            <nav class="navbar navbar-expand-lg navbar-light" style="background-color: #e3f2fd;">
                <a class="navbar-brand" href="restaurantIndex.jsp">
                    <img src="Images/Logo.png" width="30" height="30" class="d-inline-block align-top" alt="logo"/> Only Eat
                </a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo01" aria-controls="navbarTogglerDemo01" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarTogglerDemo01">
                    <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
                        <li class="nav-item active ml-lg-5">
                            <a class="nav-link" href="restaurantIndex.jsp">Home <span class="sr-only">(current)</span></a>
                        </li>
                        <li class="nav-item ml-lg-5">
                            <a class="nav-link" href="restaurantLogin.jsp">Sign In</a>
                        </li>
                        <li class="nav-item ">
                            <a class="nav-link" href="restaurantRegister.jsp">Register</a>
                        </li>
                    </ul>
                </div>
            </nav>
            <%
                }
            %>
        </div>
    </body>
</html>
