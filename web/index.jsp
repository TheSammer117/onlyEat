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
        <%@ include file = "Includes/cHeader.jsp" %>
        <div class="container">
        <%            String successMessage = (String) session.getAttribute("successMessage");
            if (successMessage != null) {
        %>
        <h3><%=successMessage%></h3>
        <%
            }
            session.removeAttribute("successMessage");

        %>
        </div>
       <!-- <aside>
           <%-- <%@ include file="Includes/asideRestaurantList.jsp" %> --%>
        </aside>-->
    </body>
</html>
