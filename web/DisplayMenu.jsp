<%-- 
    Document   : DisplayMenu
    Created on : 15-Feb-2019, 11:50:46
    Author     : samiwise
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="Dtos.Food"%>
<%@page import="Daos.FoodDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu</title>
    </head>
    <body>
        <a href="index.jsp">Back to index</a>
        <h1>Menu</h1>
        <%
            //get menu from session
            ArrayList<Food> menu = (ArrayList<Food>) session.getAttribute("menu");

            if (menu != null && !menu.isEmpty()) {


        %>
        <table>
            <tr>
                <th>Name</th>
                <th>Price</th>
            </tr>
            <% for (Food f : menu) {
            %>
            <tr>
            <tdt><%= f.getName()%></tdt>
            <tdt><%= f.getPrice()%></tdt>
        </tr>
        <%
                }
            } else {
                out.println("No menu found. Please try again.");
            }
        %>
</body>
</html>
