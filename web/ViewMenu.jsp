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
        <div class="shoppingCart">
            
        </div>
        <a href="index.jsp">Back to index</a>
        <div class="menu">
        <h1>Menu</h1>
        
        <%
            
            String idVal = request.getParameter("restId");
            
            if(idVal != null){
                int restId = 0;
                try{
                    restId = Integer.parseInt(idVal);
                } catch(NumberFormatException e){
                    String errorMessage = "Text was supplied for RestaurantId (instead of a number)";
                    session.setAttribute("errorMessage", errorMessage);
                    response.sendRedirect("error.jsp");
                }
                
                FoodDao mDao = new FoodDao("delivery");
                ArrayList<Food> menu = mDao.getFoodByRestaurantId(restId);
                if(menu != null){
            }
           /** //get menu from session
            ArrayList<Food> menu = (ArrayList<Food>) session.getAttribute("menu");

            if (menu != null && !menu.isEmpty()) {**/


        %>
        <table>
            <tr>
                <th>Name</th>
                <th>Price</th>
            </tr>
            <% for (Food f : menu) {
            %>
            <tr><!--form for adding food to cart-->
            <td><%= f.getName()%></td>
            <td><%= f.getPrice()%></td>
        </tr>
        </table>
       <%
                }
            } else {
                out.println("No menu found. Please try again.");
            }
        %> 
        </div>
</body>
</html>
