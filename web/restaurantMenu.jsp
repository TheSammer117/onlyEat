<%-- 
    Document   : restaurantMenu
    Created on : 2019-3-12, 19:17:31
    Author     : 82509
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu Page</title>
    </head>
    <body>
        <%@ include file = "restaurantHeader.jsp" %>
        <%            int restaurantId = loggedInUser.getRestaurantId();
            FoodDao f1 = new FoodDao("delivery");
            ArrayList<Food> foods = new ArrayList();
            foods = f1.getFoodByRestaurantId(restaurantId);
            FoodTypeDao ftDao = new FoodTypeDao("delivery");
        %>

        <p>Menu :</p>
        <%
            if (foods != null && !foods.isEmpty()) {
        %>
        <table>
            <tr>
                <th>food Id</th>
                <th>name</th>
                <th>price</th>
                <th>type</th>
            </tr>
            <%
                for (int i = 0; i < foods.size(); i++) {
                    int typeId = foods.get(i).getTypeId();
                    String name = ftDao.getNameById(typeId);
            %>
            <tr>
                <td><%=foods.get(i).getFoodId()%></td>
                <td><%=foods.get(i).getName()%></td>
                <td><%=foods.get(i).getPrice()%></td>
                <td><%=name%></td>
                <td>
                    <form action="updatePrice.jsp" method="post">
                        <input type="hidden" name ="restaurantId" value="<%=restaurantId%>" />
                        <input type="hidden" name ="foodId" value="<%=foods.get(i).getFoodId()%>" />
                        <input type="submit" value="Update the Price" /> 
                    </form>
                </td>
                <td>
                    <form action="FrontController" method="post">
                        <input type="hidden" name ="action" value="deleteFood" />
                        <input type="hidden" name ="restaurantId" value="<%=restaurantId%>" />
                        <input type="hidden" name ="foodId" value="<%=foods.get(i).getFoodId()%>" />
                        <input type="submit" value="Delete the Food" /> 
                    </form>
                </td>                
            </tr>
            <%}
                }%>
        </table>
        <form action="AddFood.jsp" method="post">
            <input type="submit" value="Add the food" /> 
        </form>
    </body>
</html>
