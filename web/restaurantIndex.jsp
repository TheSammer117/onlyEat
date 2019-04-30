<%-- 
    Document   : index
    Created on : 2019-2-5, 19:25:47
    Author     : 82509
--%>

<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="Dtos.OrderDetail"%>
<%@page import="Daos.CustomerOrderDao"%>
<%@page import="Daos.FoodTypeDao"%>
<%@page import="Dtos.Food"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Daos.FoodDao"%>
<%@page import="Dtos.Restaurant"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Restaurant</title>
    </head>
    <script src="Jquery/jquery-3.3.1.js"></script>
    <script type="text/javascript">
        var auto = setInterval( function(){
            $('#reloadContent').load('reloadWindow.jsp').fadeIn("slow");
        }, 5000);
    </script>
    <body>
        <%@ include file = "Includes/internationalisationHeader.jsp" %>
        <div id="reloadContent"></div>   
        
        <%@ include file="Includes/footer.jsp" %> 
    </body>
</html>
