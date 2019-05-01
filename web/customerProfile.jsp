<%-- 
    Document   : customerProfile
    Created on : 13-Feb-2019, 18:40:43
    Author     : zbo97
--%>

<%@page import="Daos.CustomerDao"%>
<%@page import="Dtos.C_address"%>
<%@page import="Daos.C_addressDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>My Profile</title>
    </head>
    <body>
        <%@ include file = "Includes/internationalisationHeader.jsp" %>
        <%@ include file = "Includes/cHeader.jsp" %>
        <div class="container text-center">
            <%            int customerId = 0;
                C_address ca = new C_address();
                try {
                    customerId = Integer.parseInt(request.getParameter("customerId"));
                } catch (NumberFormatException e) {
                    String errorMessage = "Wrong user";
                    session.setAttribute("errorMessage", errorMessage);
                    response.sendRedirect("error.jsp");
                }
                if (customerId > 0) {
                    C_addressDao caDao = new C_addressDao("delivery");
                    ca = caDao.getCustomerAddressByCustomerId(customerId);
                }
            %>

            <div>
                <form action="FrontController" method="post">
                    <table class="table table-borderless">
                        <tr>
                            <td><%=dataBundle.getString("cProfile_td1")%></td> <td><input type="text" name="username" value="<%=loggedInUser.getUsername()%>" required/></td>
                        </tr>
                        <tr>
                            <td><%=dataBundle.getString("cProfile_td2")%></td> <td><input type="text" name="firstName" value="<%=loggedInUser.getFirstName()%>" required/></td>
                        </tr>
                        <tr>
                            <td><%=dataBundle.getString("cProfile_td3")%></td> <td><input type="text" name="lastName" value="<%=loggedInUser.getLastName()%>" required/></td>
                        </tr>
                        <tr>
                            <td><%=dataBundle.getString("cProfile_td4")%> </td> <td><input type="text" name="phone" value="<%=loggedInUser.getPhone()%>" required/></td>
                        </tr>
                        <%
                            if (ca.getAddressId() <= 0) {
                        %>
                        <h2 class="text-left">Please tell us your address</h2>
                        <tr>
                            <td><%=dataBundle.getString("cProfile_td5")%> </td> <td><input type="text" name="address1" placeholder="We haven't got your address" required/></td>
                        </tr>
                        <tr>
                            <td><%=dataBundle.getString("cProfile_td6")%> </td> <td><input type="text" name="address2" placeholder="We haven't got your address" required/></td>
                        </tr>
                        <tr>
                            <td><%=dataBundle.getString("cProfile_td7")%> </td> <td><input type="text" name="address3" placeholder="We haven't got your address" required/></td>
                        </tr>

                        <%
                        } else {
                        %>
                        <tr>
                            <td><%=dataBundle.getString("cProfile_td5")%> </td> <td><input type="text" name="address1" value="<%= ca.getAddress1()%>" required/></td>
                        </tr>
                        <tr>
                            <td><%=dataBundle.getString("cProfile_td6")%> </td> <td><input type="text" name="address2" value="<%= ca.getAddress2()%>" required/></td>
                        </tr>
                        <tr>
                            <td><%=dataBundle.getString("cProfile_td7")%> </td> <td><input type="text" name="address3" value="<%= ca.getAddress3()%>" required/></td>
                        </tr>
                        <%}%>
                    </table>
                    <input type="hidden" name ="action" value="saveCustomerProfile" />
                    <input type="hidden" name ="customerId" type="text" value="<%= loggedInUser.getCustomerId()%>" />
                    <input type="submit" class="btn btn-info" value="Save" />
                </form>
            </div>
        </div>
        <%@ include file="Includes/footer.jsp" %> 
    </body>
</html>
