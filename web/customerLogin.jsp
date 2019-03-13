<%-- 
    Document   : customerLogin
    Created on : 06-Feb-2019, 11:42:30
    Author     : zbo97
--%>

<%@page import="Dtos.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link rel="stylesheet" href="Styles/bootstrap-4.3.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="Styles/bootstrap-4.3.1/css/custom.css">
    </head>
    <script src="Jquery/jquery-3.3.1.js"></script>
    <script src="Jquery/rememberMe.js">

    </script>
    <body>
        <%@ include file = "Includes/cHeader.jsp" %>
        <div class="container text-center mt-5 " >
            <form class="form-signin" action="FrontController" method="post">
                <img width="150" height="150" class="mb-4" alt="logo" src="Images/Logo.png" />
                <table class="table table-borderless">
                    <tr><td scope="row">Username: <input name="username" required size="20" type="text" id="username"/> </td></tr>
                    <tr><td scope="row">Password: <input name="password" required size="20" type="password" id="pass"/> </td> </tr>
                    <tr><td scope="row" colspan="2">Remember Me <input name="remember-me" type="checkbox" value="remember-me" id="remember_me" /></td></tr>
                </table>
                <input type="submit" class="btn btn-info" value="Login" />
                <input type="hidden" name ="action" value="customerLogin" />
            </form>
            <br/>
            <label>New to Only Eat? </label><a href="customerRegister.jsp"><b>Create Account</b></a>
        </div>
        <%@ include file="Includes/footer.jsp" %> 
    </body>
</html>
