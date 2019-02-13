<%-- 
    Document   : customerProfile
    Created on : 13-Feb-2019, 18:40:43
    Author     : zbo97
--%>

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
        <%@ include file = "cHeader.jsp" %>
        <%            int customerId = 0;
        C_address ca = new C_address();
            try {
                customerId = Integer.parseInt(request.getParameter("customerId"));
            } catch (NumberFormatException e) {
                String errorMessage = "Wrong user";
                session.setAttribute("errorMessage", errorMessage);
                response.sendRedirect("error.jsp");
            }
            if(customerId > 0){
                C_addressDao caDao = new C_addressDao("delivery");
            ca = caDao.getCustomerAddressByCustomerId(customerId);
            }
        %>
        
        <div>
            <form action="FrontController" method="post">
                <table>
                    <tr>
                        <td>Username: </td> <td><input type="text" name="username" value="<%=loggedInUser.getUsername() %>" required/></td>
                    </tr>
                    <tr>
                        <td>First Name: </td> <td><input type="text" name="firstName" value="<%=loggedInUser.getFirstName() %>" required/></td>
                    </tr>
                    <tr>
                        <td>Last Name: </td> <td><input type="text" name="lastName" value="<%=loggedInUser.getLastName() %>" required/></td>
                    </tr>
                    <tr>
                        <td>Phone Number: </td> <td><input type="text" name="phone" value="<%=loggedInUser.getPhone()%>" required/></td>
                    </tr>
                    <tr>
                        <td>Address Line 1: </td> <td><input type="text" name="address1" value="<%= ca.getAddress1() %>" required/></td>
                    </tr>
                    <tr>
                        <td>Address Line 2: </td> <td><input type="text" name="address2" value="<%= ca.getAddress2() %>" required/></td>
                    </tr>
                    <tr>
                        <td>Address Line 3: </td> <td><input type="text" name="address3" value="<%= ca.getAddress3() %>" required/></td>
                    </tr>
                </table>
                    <input type="hidden" name ="action" value="saveUserDetails" />
                    <input type="submit" value="Save" />
            </form>
        </div>
    </body>
</html>
