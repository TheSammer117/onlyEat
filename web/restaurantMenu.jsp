<%-- 
    Document   : restaurantMenu
    Created on : 2019-3-12, 19:17:31
    Author     : 82509
--%>

<%@page import="Dtos.Food"%>
<%@page import="Daos.FoodTypeDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Daos.FoodDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu Page</title>
    </head>

    <body>
        <div class="container">
            <%@ include file = "Includes/rHeader.jsp" %>
            <%            int restaurantId = loggedInUser.getRestaurantId();
                FoodDao f1 = new FoodDao("delivery");
                ArrayList<Food> foods = new ArrayList();
                foods = f1.getFoodByRestaurantId(restaurantId);
                FoodTypeDao ftDao = new FoodTypeDao("delivery");
            %>

            <h2>Menu :</h2>
            <%
                if (foods != null && !foods.isEmpty()) {
            %>
            <table class="table table-hover table-primary ">
                <thead>
                    <tr>
                        <th>food Number</th>
                        <th>name</th>
                        <th>price</th>
                        <th>type</th>
                    </tr>
                </thead>
                <%
                    for (int i = 0; i < foods.size(); i++) {
                        int typeId = foods.get(i).getTypeId();
                        String name = ftDao.getNameById(typeId);
                %>
                <tbody>
                    <tr>
                        <td><%=foods.get(i).getFoodId()%></td>
                        <td><%=foods.get(i).getName()%></td>
                        <td><%=foods.get(i).getPrice()%></td>
                        <td><%=name%></td>
                        <td>
                            <form action="updatePrice.jsp" method="post">
                                <input type="hidden" name ="restaurantId" value="<%=restaurantId%>" />
                                <input type="hidden" name ="foodId" value="<%=foods.get(i).getFoodId()%>" />
                                <input type="submit" class="btn btn-secondary" value="Update the Price" /> 
                            </form>
                        </td>
                        <td>
                            <form action="FrontController" method="post">
                                <input type="hidden" name ="action" value="deleteFood" />
                                <input type="hidden" name ="restaurantId" value="<%=restaurantId%>" />
                                <input type="hidden" name ="foodId" value="<%=foods.get(i).getFoodId()%>" />
                                <input type="submit" class="btn btn-danger" value="Delete the Item" /> 
                            </form>
                        </td>                
                    </tr>
                </tbody>
                <%}%>
            </table>
            <%
            } else {
            %>
            <p>You have not had any food in your menu.</p>
            <br/>
            <p>Please add your first item.</p>
            <%
                }%>

            <form action="AddFood.jsp" method="post">
                <input type="submit" class="btn btn-info" value="Add a food" /> 
            </form>
        </div>
        <%@ include file="Includes/footer.jsp" %> 
    </body>
</html>
