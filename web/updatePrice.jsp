<%-- 
    Document   : updatePrice
    Created on : 2019-3-3, 19:53:08
    Author     : 82509
--%>
<%@page import="Dtos.Food"%>
<%@page import="Daos.FoodDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Price Page</title>
    </head>
    <body>
       <%@ include file = "Includes/rHeader.jsp" %>
        <%            int restaurantId = 0;
            int foodId = 0;
            try {
                restaurantId = Integer.parseInt(request.getParameter("restaurantId"));
                foodId = Integer.parseInt(request.getParameter("foodId"));
            } catch (NumberFormatException e) {
                String errorMessage = "Wrong userId";
                session.setAttribute("errorMessage", errorMessage);
                response.sendRedirect("error.jsp");
            }
            if (restaurantId != 0 && foodId != 0) {
                FoodDao fDao = new FoodDao("delivery");
                Food f = new Food();
                f = fDao.getFood(restaurantId, foodId);
        %>

        <div>
            <form action="FrontController" method="post">
                <table>
                    <tr>
                        <td>Food Name: </td> <td><input type="text" name="name" readonly="readonly" value="<%=f.getName()%>" required/></td>
                    </tr>
                    <tr>
                        <td>Price: </td> <td><input type="text" name="price" value="<%=f.getPrice()%>" required/></td>
                    </tr>

                </table>

                <input type="hidden" name ="action" value="updatePrice" />
                <input type="hidden" name ="restaurantId" value="<%=loggedInUser.getRestaurantId()%>" />
                <input type="hidden" name ="foodId" value="<%=f.getFoodId()%>" />
                <input type="submit" value="update the price" />
            </form>
        </div>
        <%
            }
        %>
    </body>
</html>
