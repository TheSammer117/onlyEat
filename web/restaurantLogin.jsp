<%-- 
    Document   : restaurantLogin
    Created on : 2019-3-12, 21:02:07
    Author     : 82509
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Restaurant Login Page</title>
    </head>
    <script src="Jquery/jquery-3.3.1.js"></script>
    <script src="Jquery/rememberMe.js"></script>
    <body>
        <%@ include file = "Includes/rHeader.jsp" %>
        <div class="container text-center mt-5 " >
            <form class="form-signin" action="FrontController" method="post">
                <img width="150" height="150" class="mb-4" alt="logo" src="Images/Logo.png" />
                <table class="table table-borderless">
                    <tr><td scope="row">Username: <input name="username" required size="20" type="text" id="username"/> </td></tr>
                    <tr><td scope="row">Password: <input name="password" required size="20" type="password" id="pass"/> </td> </tr>
                    <tr><td scope="row">Remember me <input name="remember-me" type="checkbox" value="remember-me" id="remember_me"/></td></tr>
                </table>
                <input type="submit" class="btn btn-info" value="Login" />
                <input type="hidden" name ="action" value="restaurantLogin" />

            </form>
            <br/>
            <label>A Customer? </label><a href="customerLogin.jsp"><b> Customer Login</b></a>
        </div>
        <%@ include file="Includes/footer.jsp" %> 
    </body>
</html>
