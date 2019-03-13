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
        <%@ include file = "Includes/rHeader.jsp" %>
        <div class="container text-center">
            <%            if (loggedInUser != null) {
            %>

            <h2 class="text-left">You can add an item form your restaurant: </h2>
            <form action="FrontController" method="post">
                <table class="table table-borderless mt-lg-5">
                    <tr><td scope="row">Item Name: <input name="name" required size="14" type="text"/> </td></tr>
                    <tr><td scope="row">Price: <input name="price" required size="20"  type="number"/> </td> </tr>
                    <tr><td scope="row"><select name="typeId">
                                <option>Select a type of the item</option>
                                <% ArrayList<FoodType> FoodTypes = new ArrayList();
                                    FoodTypeDao cDao = new FoodTypeDao("delivery");
                                    FoodTypes = cDao.getAllFoodType();
                                    for (int i = 0; i < FoodTypes.size(); i++) {
                                %>
                                <option value="<%=FoodTypes.get(i).getTypeId()%>"><%=FoodTypes.get(i).getName()%></option>
                                <%
                                    }
                                %>
                            </select></td> </tr>
                </table> 


                <input type="hidden" name ="restaurantId" value="<%=loggedInUser.getRestaurantId()%>" />
                <input type="submit" class="btn btn-secondary" value="Add" />
                <input type="hidden" name ="action" value="addFood" />
            </form>
            <%
                }
            %>
        </div>
        <%@ include file="Includes/footer.jsp" %> 
    </body>
</html>
