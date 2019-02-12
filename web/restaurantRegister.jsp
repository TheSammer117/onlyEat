<%-- 
    Document   : restaurantRegister
    Created on : 2019-2-6, 17:46:38
    Author     : 82509
--%>

<%@page import="Daos.CountyDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Dtos.County"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
    </head>
    <body>

        <form action="FrontController" method="post">
            <table>
                <tr>
                    <td>Username: </td> <td><input type="text" name="username"  required/></td>
                </tr>
                <tr>
                    <td>Password: </td> <td><input type="password" name="password"  required/></td>
                </tr>
                <tr>
                    <td>Name: </td> <td><input type="text" name="name"  required/></td>
                </tr>
                <tr>
                    <td>Phone Number: </td> <td><input type="text" name="phone"  required/></td>
                </tr>
                <tr>
                    <td>Phone Number: </td> <td><input type="text" name="phone"  required/></td>
                </tr>
                <tr>
                    <td>Street: </td> <td><input type="text" name="street"  required/></td>
                </tr>
                <tr>
                    <td>Town: </td> <td><input type="text" name="town"  required/></td>
                </tr>
            </table>
            <select name="countyId">
                <option>Select</option>
                <% ArrayList<County> Counties = new ArrayList();
                    CountyDao cDao = new CountyDao("delivery");
                    Counties = cDao.getAllCounties();
                    for (int i = 0; i < Counties.size(); i++) {
                %>
                <option value="<%=Counties.get(i).getCountyId()%>"><%=Counties.get(i).getName()%> Counties</option>
                <%
                    }
                %>
            </select>
            <input type="submit" value="RestaurantRegister" />
            <input type="hidden" name ="action" value="restaurantRegister" />
        </form>


    </body>
</html>
