<%-- 
    Document   : index
    Created on : 2019-2-5, 19:25:47
    Author     : 82509
--%>

<%@page import="Daos.FoodTypeDao"%>
<%@page import="Dtos.Food"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Daos.FoodDao"%>
<%@page import="Dtos.Restaurant"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript" src="../jscript/Cookie.js"></script>
        <title>Restaurant Page</title>
    </head>
    <script src="Jquery/jquery-3.3.1.js"></script>
    <script src="Jquery/rememberMe.js">
    </script>
    <body>

        <%             Restaurant loggedInUser = (Restaurant) session.getAttribute("loggedInRestaurant");
            if (loggedInUser != null) {
        %>
        <a href="FrontController?action=logout">Logout</a>
        <%
        } else {
        %>
        <div>
            <p>Please login here</p>
            <%
                String sessionExpired = (String) session.getAttribute("sessionExpired");
                if (sessionExpired != null) {
                    out.println("<b>" + sessionExpired + "</b>");
                    session.removeAttribute("sessionExpired");

                }
            %>
            <form action="FrontController" method="post">
                <table>
                    <tr><td>Username: </td><td><input name="username" required size=20 type="text" id="username"/> </td></tr>
                    <tr><td>Password: </td><td> <input name="password" required size=50 type="password" id="pass"/> </td> </tr>
                    <tr><td>Remember me</td><td><input name="remember-me" type="checkbox" value="remember-me" id="remember_me"/></td></tr>
                </table>
                <input type="submit" value="Login" />
                <input type="hidden" name ="action" value="restaurantLogin" />

            </form>
            <a href="restaurantRegister.jsp">Register</a>
        </div>
        <%
            }
        %>



        <%
            if (loggedInUser != null) {
                int restaurantId = loggedInUser.getRestaurantId();
                String successMessage = (String) session.getAttribute("successMessage");
                if (successMessage != null) {
        %>
        <h3><%=successMessage%></h3>
        <%
            }
            session.removeAttribute("successMessage");
            FoodDao f1 = new FoodDao("delivery");
            ArrayList<Food> foods = new ArrayList();
            foods = f1.getFoodByRestaurantId(restaurantId);
            FoodTypeDao ftDao = new FoodTypeDao("delivery");
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
            <form action="AddFood.jsp" method="post">
              <input type="submit" value="Add the food" /> 
            </form>
        </table>
        <% }%>
    </body>
</html>
