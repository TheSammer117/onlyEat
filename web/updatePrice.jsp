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
        <div class="container text-center">
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
                <h2 class="text-left">You can modify your item information here:</h2>
                <form action="FrontController" method="post">
                    <table class="table table-borderless mt-lg-5">
                        <tr>
                            <td scope="row">Item Name: <input size="14" type="text" name="name" readonly="readonly" value="<%=f.getName()%>" required/></td>
                        </tr>
                        <tr>
                            <td scope="row">Price: <input type="number" name="price" value="<%=f.getPrice()%>" required/></td>
                        </tr>

                    </table>

                    <input type="hidden" name ="action" value="updatePrice" />
                    <input type="hidden" name ="restaurantId" value="<%=loggedInUser.getRestaurantId()%>" />
                    <input type="hidden" name ="foodId" value="<%=f.getFoodId()%>" />
                    <input type="submit" class="btn btn-secondary" value="Update" />
                </form>
            </div>
            <%
                }
            %>
        </div>
        <%@ include file="Includes/footer.jsp" %> 
    </body>
</html>
