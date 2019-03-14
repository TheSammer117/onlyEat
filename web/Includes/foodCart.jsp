<%-- 
    Document   : foodCart
    Created on : 12-Mar-2019, 13:34:32
    Author     : samiwise
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Daos.ShoppingCart"%>
<%@page import="Dtos.Food"%>
<%@page import="Daos.FoodDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cart</title>
    </head>
    <body>
        <%
                if (session.getAttribute("foodId") == null) {
                    %>empty<%
                } else {    
            %>
        <h1>Shopping Cart</h1>
        <table >
            <tr><th>Food</th><th>Price</th></tr>

            <%
                Food food = null;
            
                    try {
                        food = (Food) session.getAttribute("food");
                    } catch (NumberFormatException e) {
                        String errorMessage = "Food Id wasnt a number";
                        session.setAttribute("errorMessage", errorMessage);
                        response.sendRedirect("error.jsp");
                    }
                    
                    ShoppingCart sc = new ShoppingCart();
                    sc.addToCart(food);
                    ArrayList<Food> foodCart = sc.displayCart();
                    for (Food f : foodCart) {
            %><tr><td><%=f.getName()%></td><td><%=f.getPrice()%></td></tr>
            <%
                    }
                }
            %>
        </table>
    </body>
</html>
