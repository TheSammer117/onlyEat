<%-- 
    Document   : index
    Created on : 2019-2-5, 19:25:47
    Author     : 82509
--%>

<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="Dtos.OrderDetail"%>
<%@page import="Daos.CustomerOrderDao"%>
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
        <title>Restaurant Page</title>
    </head>
    <body>
        <div class="container text-center">
            <%@ include file = "Includes/rHeader.jsp" %>
            <%            if (loggedInUser != null) {
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
                ArrayList<OrderDetail> od = new ArrayList();
                foods = f1.getFoodByRestaurantId(restaurantId);
                FoodTypeDao ftDao = new FoodTypeDao("delivery");
                CustomerOrderDao cdDao = new CustomerOrderDao("delivery");
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            %>



            <% if (foods != null && !foods.isEmpty()) {

            %>
            <h2 class="text-left">Orders :</h2>
            <table class="table table-hover table-primary ">
                <thead>
                    <tr>
                        <th>Item Name</th>
                        <th>Quantity</th>
                        <th>Date</th>
                        <th>Confirm</th>
                    </tr>
                </thead>
                <%    for (int i = 0; i < foods.size(); i++) {
                        int foodId = foods.get(i).getFoodId();
                        od = cdDao.getOrderDetails(foodId);
                        for (int a = 0; a < od.size(); a++) {
                            int orderId = od.get(a).getOrderId();
                            int foodid = od.get(a).getFoodId();
                            int quatity = od.get(a).getQuatity();
                            Food f = new Food();
                            f = f1.getFood(restaurantId, foodid);
                %>
                <tbody>
                    <tr>
                        <td><%=f.getName()%></td>
                        <td><%=quatity%></td>
                        <td><%=sdf.format(new Date())%></td>                   
                        <td>
                            <form action="FrontController" method="post">
                                <input type="hidden" name ="action" value="confirmOrder" />
                                <input type="hidden" name ="orderId" value="<%=orderId%>" />
                                <input type="submit" class="btn btn-danger" value="Delivery" /> 
                            </form>
                        </td>
                    </tr>
                </tbody>
                <%   }

                    }%>
            </table>
            <%
            } else {
            %>
            <p class="mt-4">You have not got any order yet!!</p>
            <%
                }%>


            <% } else {
            %>
            <img width="150" height="150" class="mb-4 mt-4" alt="logo" src="Images/Logo.png" />
            <h2>Welcome!</h2>
            <p>Please <a  href="restaurantLogin.jsp">Sign In</a> to manage your restaurant</p>


            <%
                }

            %>
        </div>
        <%@ include file="Includes/footer.jsp" %> 
    </body>
</html>
