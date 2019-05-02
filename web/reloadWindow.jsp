<%-- 
    Document   : reloadWindow
    Created on : 24-Apr-2019, 14:55:48
    Author     : zbo97
--%>

<%@page import="Dtos.OrderDetail"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="Daos.CustomerOrderDao"%>
<%@page import="Daos.FoodTypeDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Daos.FoodDao"%>
<%@page import="Daos.FoodDao"%>
<%@page import="java.util.Date"%>
<%@page import="Dtos.Food"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <%@ include file = "Includes/internationalisationHeader.jsp" %>
        <%@ include file = "Includes/rHeader.jsp" %>
        <div class="container text-center mt-5">
                     
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

            <h2 class="text-left"><%=dataBundle.getString("reload_h2")%></h2>
            <table class="table table-hover table-primary ">
                <thead>
                    <tr>
                        <th><%=dataBundle.getString("reload_th1")%></th>
                        <th><%=dataBundle.getString("reload_th2")%></th>
                        <th><%=dataBundle.getString("reload_th3")%></th>
                        <th><%=dataBundle.getString("reload_th4")%></th>
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
                                <input type="submit" class="btn btn-danger" value="<%=dataBundle.getString("reload_th5")%>" /> 
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
            <p class="mt-4"><%=dataBundle.getString("reload_p1")%></p>
            <%
                }%>


            <% } else {
            %>
            <img width="150" height="150" class="mb-4 mt-4" alt="logo" src="Images/Logo.png" />
            <h2><%=dataBundle.getString("reload_h2welcome")%></h2>
            <p><%=dataBundle.getString("reload_p2")%> <a  href="restaurantLogin.jsp"><%=dataBundle.getString("reload_p3")%></a><%=dataBundle.getString("reload_p4")%></p>


            <%
                }

            %>
        </div>
       <%=dataBundle.getString("reload_time")%> <%=new java.util.Date() %>
    </body>
</html>
