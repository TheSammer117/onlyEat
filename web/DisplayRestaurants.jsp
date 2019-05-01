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
        
        <%@ include file = "Includes/internationalisationHeader.jsp" %>
        <%@ include file = "Includes/cHeader.jsp" %>
        <div class="container text-center mt-5 " >
            

            <%// //Get Restaurant List from session
                ArrayList<Restaurant> restaurants = (ArrayList<Restaurant>) session.getAttribute("restaurantList");
                if (restaurants != null && !restaurants.isEmpty()) {


            %>
            <h1 class="text-left"><%=dataBundle.getString("DispRest_h1")%> <%=(String) session.getAttribute("countyName")%></h1>
            <table class="table table-hover table-primary ">
                <%                for (Restaurant r : restaurants) {
                %>
                <tr>
                    <td >       <a class="restaurantLink" href="ViewMenu.jsp?restId=<%=r.getRestaurantId()%>">    <%=r.getName()%>    </a>    </td>
                    <td><%=dataBundle.getString("DispRest_td1")%><%=r.getPhone()%><br/>
                        <%=dataBundle.getString("DispRest_td2")%> <%=r.getStreet()%>, <%=r.getTown()%>
                    </td>
                </tr>
                <%
                    }
                } else {
                %>
                <img width="150" height="150" class="mb-4" alt="logo" src="Images/Logo.png" />
                <%
                        out.println("Sorry, our service currently is not available in your area.");
                    }
                %>
            </table>
        </div>
            <%@ include file="Includes/footer.jsp" %> 
    </body>
</html>
