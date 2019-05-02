<%-- 
    Document   : DisplayMenu
    Created on : 15-Feb-2019, 11:50:46
    Author     : samiwise
--%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="Dtos.Cart"%>
<%@page import="Daos.CartDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Dtos.Food"%>
<%@page import="Daos.FoodDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu</title>
    </head>
    <body class="background2">

        <%@ include file = "Includes/internationalisationHeader.jsp" %>
        <%@ include file = "Includes/cHeader.jsp" %>
        <div class="container text-center mt-5">


            <% if (loggedInUser != null) {
                    String idVal = request.getParameter("restId");

                    if (idVal != null) {
                        int restId = 0;
                        try {
                            restId = Integer.parseInt(idVal);
                        } catch (NumberFormatException e) {
                            String errorMessage = "Text was supplied for RestaurantId (instead of a number)";
                            session.setAttribute("errorMessage", errorMessage);
                            response.sendRedirect("error.jsp");
                        }
            %>
            <div class="cart">
                <table>
                    <%
                        CartDao cDao = new CartDao("delivery");
                        FoodDao fDao = new FoodDao("delivery");
                        ArrayList<Cart> cartList = new ArrayList();
                        cartList = cDao.getCartListByCustomerId(loggedInUser.getCustomerId());
                        int foodId;
                        int quantity;
                        String foodName;
                        if (cartList.isEmpty()) {
                            out.println(dataBundle.getString("menu_th6"));
                        } else {
                            session.setAttribute("cartList", cartList);
                            for (Cart cartItem : cartList) {
                                foodId = cartItem.getFood_Id();
                                quantity = cartItem.getQuantity();
                                foodName = fDao.getFoodByFoodId(foodId).getName();

                    %>
                    <tr>
                        
                        <td><%= foodName%>    *<%= quantity%></td>
                    <form action="FrontController" method="post">
                        <input type="hidden" name ="customerId" value="<%= loggedInUser.getCustomerId()%>" />
                        <input type="hidden" name ="foodId" value="<%= foodId%>" />
                        <input type="hidden" name ="quantity" value="<%= quantity%>" />
                        <input type="hidden" name ="restaurantId" value="<%= restId%>" />
                        <input type="hidden" name ="action" value="removeFromCart" />
                        <td><input type="submit" class="btn btn-danger" value="<%=dataBundle.getString("menu_th4")%>" /></td>
                    </form>
                    </tr>
                    <tr>
                    <label>  </label>
                    </tr>
                    <tr>

                    </tr>
                    <%
                        }
                    %><a href="checkout.jsp"><%=dataBundle.getString("menu_checkout")%></a><%
    }
                    %>

                </table>
            </div>

            <hr>


            <div class="menu">
                <h1><%=dataBundle.getString("menu")%></h1>

                <%

                    FoodDao mDao = new FoodDao("delivery");
                    ArrayList<Food> menu = mDao.getFoodByRestaurantId(restId);
                    if (menu != null) {
                %>
                <table class="ml-lg-4 pl-lg-5">
                    <tr>
                        <th><%=dataBundle.getString("name")%></th>
                        <th><%=dataBundle.getString("price")%></th>
                        <th><%=dataBundle.getString("menu_th3")%></th>
                    </tr>
                    <% for (Food f : menu) {
                    %>  
               
                    <tr ><!--form for adding food to cart-->
                    <form action="FrontController" method="post">
                        <td class="pr-lg-5 pl-lg-3 py-lg-2"><%= f.getName()%></td>
                        <td class="pr-lg-5 pl-lg-3 py-lg-2"><%= f.getPrice()%></td>
                        <input type="hidden" name ="customerId" value="<%= loggedInUser.getCustomerId()%>" />
                        <input type="hidden" name ="foodId" value="<%= f.getFoodId()%>" />
                        <td class="pr-lg-5 pl-lg-3 py-lg-2"><input type="number" name ="quantity" required /></td>
                        <input type="hidden" name ="restaurantId" value="<%= restId%>" />
                        <input type="hidden" name ="action" value="addToCart" />
                        <td class=" pl-lg-3 py-lg-2"><input type="submit" class="btn btn-info" value="<%=dataBundle.getString("menu_th5")%>" /></td>
                    </form>
                    </tr>
                    <%
                        }
                    %>
                </table>

                <%
                    } else {
                        out.println("No menu found. Please try again.");
                    }


                %>


                <%                        } else {
                        out.println("No menu found. Please try again.");
                    }
                %> 
            </div>
            <%
            } else {
            %>
            <img width="150" height="150" class="mb-4" alt="logo" src="Images/Logo.png" />
            <%
                out.println("Please Login to order from menu.");
            %><a href="index.jsp"><%=dataBundle.getString("menu_index")%></a><%
                }

            %>


        </div>
            <a href="Includes/footer.jsp"></a>
    </body>
</html>
