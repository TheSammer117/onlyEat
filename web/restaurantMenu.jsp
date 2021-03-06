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
              <%@ include file = "Includes/internationalisationHeader.jsp" %>
        <div class="container" >
        <%@ include file = "Includes/rHeader.jsp" %>
            <%            int restaurantId = loggedInUser.getRestaurantId();
                FoodDao f1 = new FoodDao("delivery");
                ArrayList<Food> foods = new ArrayList();
                foods = f1.getFoodByRestaurantId(restaurantId);
                FoodTypeDao ftDao = new FoodTypeDao("delivery");
            %>

            <h2><%=dataBundle.getString("rMenu_h1")%></h2>
            <%
                if (foods != null && !foods.isEmpty()) {
            %>
            <table class="table table-hover table-primary ">
                <thead>
                    <tr>
                        <th><%=dataBundle.getString("rMenu_th1")%></th>
                        <th><%=dataBundle.getString("rMenu_name")%></th>
                        <th><%=dataBundle.getString("rMenu_price")%></th>
                        <th><%=dataBundle.getString("rMenu_th4")%></th>
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
                                <input type="submit" class="btn btn-secondary" value="<%=dataBundle.getString("rMenu_update")%>" /> 
                            </form>
                        </td>
                        <td>
                            <form action="FrontController" method="post">
                                <input type="hidden" name ="action" value="deleteFood" />
                                <input type="hidden" name ="restaurantId" value="<%=restaurantId%>" />
                                <input type="hidden" name ="foodId" value="<%=foods.get(i).getFoodId()%>" />
                                <input type="submit" class="btn btn-danger" value="<%=dataBundle.getString("rMenu_delete")%>" /> 
                            </form>
                        </td>                
                    </tr>
                </tbody>
                <%}%>
            </table>
            <%
            } else {
            %>
            <p><%=dataBundle.getString("rMenu_p1")%></p>
            <br/>
            <p><%=dataBundle.getString("rMenu_p2")%></p>
            <%
                }%>

            <form action="AddFood.jsp" method="post">
                <input type="submit" class="btn btn-info" value="<%=dataBundle.getString("rMenu_add")%>" /> 
            </form>
        </div>
        <%@ include file="Includes/footer.jsp" %> 
    </body>
</html>
