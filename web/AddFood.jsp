<%-- 
    Document   : AddFood
    Created on : 2019-2-27, 22:16:58
    Author     : 82509
--%>

<%@page import="Dtos.Restaurant"%>
<%@page import="Daos.FoodTypeDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Dtos.FoodType"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Food Page</title>
    </head>
    <body>
         <%@ include file = "restaurantHeader.jsp" %>
        <%           
            if (loggedInUser != null) {
        %>

        <form action="FrontController" method="post">
            <table>
                <tr><td>Food Name: </td><td><input name="username" required size=20 type="text" id="name"/> </td></tr>
                <tr><td>Price: </td><td> <input name="password" required size=50 type="password" id="price"/> </td> </tr>
                <select name="typeId">
                    <option>Select</option>
                    <% ArrayList<FoodType> FoodTypes = new ArrayList();
                        FoodTypeDao cDao = new FoodTypeDao("delivery");
                        FoodTypes = cDao.getAllFoodType();
                        for (int i = 0; i < FoodTypes.size(); i++) {
                    %>
                    <option value="<%=FoodTypes.get(i).getTypeId()%>"><%=FoodTypes.get(i).getName()%></option>
                    <%
                        }
                    %>
                </select>
            </table>
            <input type="submit" value="Add" />
           <input type="hidden" name ="restaurantId" value="<%=loggedInUser.getRestaurantId()%>" />
            <input type="hidden" name ="action" value="addFood" />
        </form>
        <%
            }
        %>
    </body>
</html>
