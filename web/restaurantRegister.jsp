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
        <%@ include file = "Includes/internationalisationHeader.jsp" %>
        <%@ include file = "Includes/rHeader.jsp" %>
        <div class="container text-center mt-2" >
            <form class="form-signin" action="FrontController" method="post">
                <img width="150" height="150" class="mb-4" alt="logo" src="Images/Logo.png" />
                <table class="table table-borderless">
                    <tr>
                        <td scope="row"><input size="20" type="text" placeholder="<%=dataBundle.getString("rRegister_td1")%>" name="username"  required/></td>
                    </tr>
                    <tr>
                        <td scope="row"><input type="password" placeholder="<%=dataBundle.getString("rRegister_td2")%>" name="password"  required/></td>
                    </tr>
                    <tr>
                        <td scope="row"><input type="text" placeholder="<%=dataBundle.getString("rRegister_td3")%>" name="name"  required/></td>
                    </tr>
                    <tr>
                        <td scope="row"><input type="text" placeholder="<%=dataBundle.getString("rRegister_td4")%>" name="phone"  required/></td>
                    </tr>
                    <tr>
                        <td scope="row"><input type="text" placeholder="<%=dataBundle.getString("rRegister_td5")%>" name="street"  required/></td>
                    </tr>
                    <tr>
                        <td scope="row"><input type="text" placeholder="<%=dataBundle.getString("rRegister_td6")%>" name="town"  required/></td>
                    </tr>
                    <tr>
                        <td scope="row">
                            <select name="countyId">
                                <option><%=dataBundle.getString("rRegister_opt")%></option>
                                <% ArrayList<County> Counties = new ArrayList();
                                    CountyDao cDao = new CountyDao("delivery");
                                    Counties = cDao.getAllCounties();
                                    for (int i = 0; i < Counties.size(); i++) {
                                %>
                                <option value="<%=Counties.get(i).getCountyId()%>"><%=Counties.get(i).getName()%></option>
                                <%
                                    }
                                %>
                            </select>
                        </td>
                    </tr>
                </table>

                <input type="submit" class="btn btn-info" value="<%=dataBundle.getString("rRegister_create")%>" />
                <input type="hidden" name ="action" value="restaurantRegister" />
            </form>
        </div>
        <%@ include file="Includes/footer.jsp" %> 
    </body>
</html>
