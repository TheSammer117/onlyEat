<%-- 
    Document   : index
    Created on : 06-Feb-2019, 18:39:49
    Author     : zbo97
--%>

<%@page import="Dtos.County"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Daos.CountyDao"%>
<%@page import="Dtos.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
        <link rel="stylesheet" href="Styles/bootstrap-4.3.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="Styles/bootstrap-4.3.1/css/custom.css">
    </head>
    <body class="background2">
        
        <%@ include file = "Includes/internationalisationHeader.jsp" %>
        <%@ include file = "Includes/cHeader.jsp" %>
        <div class="container text-center mt-5 ">
            <%            String successMessage = (String) session.getAttribute("successMessage");
                if (successMessage != null) {
            %>
            <h3><%=successMessage%></h3>
            <%
                }
                session.removeAttribute("successMessage");

            %>

            <%                CountyDao cDao = new CountyDao("delivery");
                ArrayList<County> countries = new ArrayList();
                countries = cDao.getAllCounties();
            %>
            <form action="FrontController" method="post">
                <select class="custom-select mt-10" name="selectedCountyId" required>
                    <option selected><%=dataBundle.getString("index_select")%></option>
                    <%
                        for (int i = 0; i < countries.size(); i++) {
                    %>
                    <option value="<%=countries.get(i).getCountyId()%>"><%=countries.get(i).getName()%></option>

                    <%
                        }
                    %>
                </select>
                <input type="submit" class="btn btn-info  mt-5" value="<%=dataBundle.getString("index_button") %>" />
                <input type="hidden" name ="action" value="viewRestaurants" />
            </form>
        </div>
        <%@ include file="Includes/footer.jsp" %> 
    </body>
</html>
