<%-- 
    Document   : DisplayMenu
    Created on : 15-Feb-2019, 11:50:46
    Author     : samiwise
--%>
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
    <body>
       
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
                            out.println("No item in your cart, please select one from the menu");
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
                        <td><input type="submit" class="btn btn-info" value="Remove" /></td>
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
            <hr>


            <div class="menu">
                <h1><%=dataBundle.getString("menu")%></h1>

                <%            

                        FoodDao mDao = new FoodDao("delivery");
                        ArrayList<Food> menu = mDao.getFoodByRestaurantId(restId);
                        if (menu != null) {
                %>
                <table>
                    <tr>
                        <th><%=dataBundle.getString("name")%></th>
                        <th><%=dataBundle.getString("price")%></th>
                        <th><%=dataBundle.getString("menu_th3")%></th>
                    </tr>
                    <% for (Food f : menu) {
                    %>  
                    <tr><!--form for adding food to cart-->
                    <form action="FrontController" method="post">
                        <td><%= f.getName()%></td>
                        <td><%= f.getPrice()%></td>
                        <input type="hidden" name ="customerId" value="<%= loggedInUser.getCustomerId()%>" />
                        <input type="hidden" name ="foodId" value="<%= f.getFoodId()%>" />
                        <td><input type="number" name ="quantity"  /></td>
                        <input type="hidden" name ="restaurantId" value="<%= restId%>" />
                        <input type="hidden" name ="action" value="addToCart" />
                        <td><input type="submit" class="btn btn-info" value="Add to cart" /></td>
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
    </body>
</html>
