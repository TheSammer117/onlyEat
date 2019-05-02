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
        
    </head>
    <script src="Jquery/jquery-3.3.1.js"></script>
    <script src="Jquery/rememberMe.js"></script>
    <body>
        <%@ include file = "Includes/internationalisationHeader.jsp" %>
        <%@ include file = "Includes/cHeader.jsp" %>
        <div class="container text-center mt-5 " >
            <form class="form-signin" action="FrontController" method="post">
                <img width="150" height="150" class="mb-4" alt="logo" src="Images/Logo.png" />
                <table class="table table-borderless">
                    <tr><td scope="row"><%=dataBundle.getString("menu_checkout")%> <input name="username" required size="20" type="text" id="username"/> </td></tr>
                    <tr><td scope="row"><%=dataBundle.getString("menu_checkout")%> <input name="password" required size="20" type="password" id="pass"/> </td> </tr>
                    <tr><td scope="row" colspan="2"><%=dataBundle.getString("menu_checkout")%> <input name="remember-me" type="checkbox" value="remember-me" id="remember_me" /></td></tr>
                </table>
                <input type="submit" class="btn btn-info" value="Login" />
                <input type="hidden" name ="action" value="customerLogin" />
            </form>
            <br/>
            <label><%=dataBundle.getString("cLogin_label1")%></label><a href="customerRegister.jsp"><b> <%=dataBundle.getString("cLogin_b1")%></b></a>
            <br/>
            <label><%=dataBundle.getString("cLogin_label2")%></label><a href="restaurantLogin.jsp"><b> <%=dataBundle.getString("cLogin_b2")%> </b></a><label>here</label>
        </div>
        <%@ include file="Includes/footer.jsp" %> 
    </body>
</html>
