<%-- 
    Document   : customerRegister
    Created on : 06-Feb-2019, 11:20:57
    Author     : zbo97
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer Register</title>
    </head>
    <body>
        <%@ include file = "Includes/internationalisationHeader.jsp" %>
        <%@ include file = "Includes/cHeader.jsp" %>
        <div class="container text-center mt-5" >
            <form class="form-signin" action="FrontController" method="post">
                <img width="150" height="150" class="mb-4" alt="logo" src="Images/Logo.png" />
                <table class="table table-borderless">
                    <tr>
                        <td scope="row"><input size="20" type="text"  placeholder="Username" name="username"  required /></td>
                    </tr>
                    <tr>
                        <td scope="row"><input size="20" type="password" placeholder="Password" name="password"  required/></td>
                    </tr>
                    <tr>
                        <td scope="row"><input size="20" type="text" placeholder="Your First Name" name="firstName"  required/></td>
                    </tr>
                    <tr>
                        <td scope="row"><input size="20" type="text" placeholder="Your Last Name" name="lastName"  required/></td>
                    </tr>
                    <tr>
                        <td scope="row"><input size="20" type="text" placeholder="Your Phone Number" name="phone"  required/></td>
                    </tr>
                </table>
                <input type="submit" class="btn btn-info" value="<%=dataBundle.getString("cRegister_b3")%>" />
                <input type="hidden" name ="action" value="customerRegister" />
            </form>
            <br/>
            <label><%=dataBundle.getString("cRegister_label1")%></label><a href="customerLogin.jsp"><b> <%=dataBundle.getString("cRegister_b1")%></b></a>
            <br/>
            <label><%=dataBundle.getString("cRegister_label2")%></label><a href="restaurantRegister.jsp"><b> <%=dataBundle.getString("cRegister_b2")%> </b></a>
        </div>
        <%@ include file="Includes/footer.jsp" %> 
    </body>
</html>
