<%-- 
    Document   : DisplayRestaurants
    Created on : 14-Feb-2019, 02:21:21
    Author     : samiwise
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="Dtos.Restaurant"%>
<%@page import="Daos.RestaurantDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Restaurants</title>
    </head>
    <body>
        <%@ include file = "Includes/cHeader.jsp" %>

        <h1>Restaurant List</h1>
        <%// //Get Restaurant List from session
            ArrayList<Restaurant> restaurants = (ArrayList<Restaurant>) session.getAttribute("restaurantList");
            if (restaurants != null && !restaurants.isEmpty()) {


        %>
        <table>
            <tr>
                <th>Name</th>
                <th>Phone</th>
                <th>Street</th>
                <th>Town</th>
            </tr>
            <%                for (Restaurant r : restaurants) {
            %>
            <tr>
                <td><a href="ViewMenu.jsp?restId=<%=r.getRestaurantId()%>"><%=r.getName()%></td>
                <td><%=r.getPhone()%></td>
                <td><%=r.getStreet()%></td>
                <td><%=r.getTown()%></td>
            </tr>
            <%
                    }
                } else {
                    out.println("No Restaurants found. Please try again.");
                }
            %>
        </table>
    </body>
</html>
