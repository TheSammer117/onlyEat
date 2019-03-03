<%-- 
    Document   : error
    Created on : 29-Nov-2018, 15:37:45
    Author     : d00189969
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error</title>
    </head>
    <body>
        <%
            Object msg = session.getAttribute("errorMessage");
            String error = (String) msg;
            if (error != null) {

        %>
        <div> <%= error %> </div>
        <%
            }
            session.removeAttribute("errorMessage");
        %> 
    </body>
</html>
