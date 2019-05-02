<%-- 
    Document   : checkout
    Created on : 27-Mar-2019, 20:53:09
    Author     : zbo97
--%>

<%@page import="Daos.C_addressDao"%>
<%@page import="Dtos.C_address"%>
<%@page import="Daos.FoodDao"%>
<%@page import="Dtos.Cart"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Checkout</title>
    </head>
    <body>
         <%@ include file = "Includes/internationalisationHeader.jsp" %>
        <%@ include file = "Includes/cHeader.jsp" %>
        <%            ArrayList<Cart> cartList = new ArrayList();
            cartList = (ArrayList<Cart>) session.getAttribute("cartList");
            FoodDao fDao = new FoodDao("delivery");
            String foodName = null;
            double price = 0.0;
            double total = 0.0;
            if (cartList != null) {
        %>
        <div class="container mt-5">
            <div class="row">
                <div class="col-md-4 order-md-2 mb-4">
                    <h4 class="d-flex justify-content-between align-items-center mb-3">
                        <span class="text-muted"><%=dataBundle.getString("checkout_span")%></span>
                    </h4>
                    <ul class="list-group mb-3">
                        <%
                            for (int i = 0; i < cartList.size(); i++) {
                                foodName = fDao.getFoodByFoodId(cartList.get(i).getFood_Id()).getName();
                                price = fDao.getFoodByFoodId(cartList.get(i).getFood_Id()).getPrice();
                                total = total + price;
                        %>

                        <li class="list-group-item d-flex justify-content-between ">
                            <div>
                                <h6 class="my-0"><%=foodName%></h6>
                                <small class="text-muted"><%=dataBundle.getString("checkout_small")%></small>
                            </div>
                            <span class="text-muted"> € <%=price%></span>
                        </li>                    
                        <%}
                        %>

                        <li class="list-group-item d-flex justify-content-between">
                            <span>Total (Euro)</span>
                            <strong> € <%=total%></strong>
                        </li>
                    </ul>
                </div>
                <div class="col-md-8 order-md-1">
                    <h4 class="mb-3"><%=dataBundle.getString("menu_checkout")%></h4>
                    <form action="FrontController" method="post" class="">
                        <div class="row">
                            <div class="col-md-6 mb-3">
                                <label><%=dataBundle.getString("checkout_label1")%></label>
                                <input type="text" class="form-control" id="firstname" required>
                            </div>
                            <div class="col-md-6 mb-3">
                                <label><%=dataBundle.getString("checkout_label2")%></label>
                                <input type="text" class="form-control" id="lastname" required>
                            </div>
                        </div>
                        
                        <hr class="mb-4">
                        <h4 class="mb-3"> <%=dataBundle.getString("checkout_h4b")%></h4>
                        <div class="d-block my-3">
                            <div class="custom-control custom-radio">
                                <input id="credit" name="paymentMethod" type="radio" class="custom-control-input" checked required >
                                <label class="custom-control-label"><%=dataBundle.getString("checkout_label4")%></label>
                            </div>
                            <div class="custom-control custom-radio">
                                <input id="debit" name="paymentMethod" type="radio" class="custom-control-input" required >
                                <label class="custom-control-label"><%=dataBundle.getString("checkout_label5")%></label>
                            </div>
                            <div class="custom-control custom-radio">
                                <input id="paypal" name="paymentMethod" type="radio" class="custom-control-input" required >
                                <label class="custom-control-label"><%=dataBundle.getString("checkout_label6")%></label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6 mb-3">
                                <label><%=dataBundle.getString("checkout_label7")%></label>
                                <input type="text" class="form-control" required>
                            </div>
                            <div class="col-md-6 mb-3">
                                <label><%=dataBundle.getString("checkout_label8")%></label>
                                <input type="text" class="form-control" required>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-3 mb-3">
                                <label><%=dataBundle.getString("checkout_label9")%></label>
                                <input type="text" class="form-control" required>
                            </div>
                            <div class="col-md-3 mb-3">
                                <label>CVV</label>
                                <input type="text" class="form-control" required="">
                            </div>
                            <% int customerId = loggedInUser.getCustomerId();
                                C_address ca = new C_address();

                                C_addressDao caDao = new C_addressDao("delivery");
                                ca = caDao.getCustomerAddressByCustomerId(customerId);

                                if (ca.getAddressId() <= 0) {

                            %>
                            <a class="nav-link" href="customerProfile.jsp?customerId=<%=loggedInUser.getCustomerId()%>"> <%=dataBundle.getString("checkout_label11")%> </a>
                            <%
                            } else {
                            %>
                            <hr class="mb-4">
                            <input type="hidden" name ="action" value="placeOrder" />
                            <input type="hidden" name ="customerId" value="<%= customerId%>" />
                            <input type="submit" class="btn btn-primary btn-lg btn-block" value="<%=dataBundle.getString("checkout_label12")%>">
                        </div>
                        <%
                            }
                        %>

                        <div class="mb-10">
                            <label><%=dataBundle.getString("checkout_label10")%></label>
                            <input type="text" class="form-control" name="message">
                        </div>
                    </form>
                </div>
            </div>
        </div>


        <%
        } else {
        %>
        <div class="container mt-5">
            <img width="150" height="150" class="mb-4" alt="logo" src="Images/Logo.png" />
            <%
                out.println("You do not have anything in your cart.");
            %><a href="index.jsp"><%=dataBundle.getString("checkout_index")%></a></div><%
                }
            %>



    </body>
    <%@ include file="Includes/footer.jsp" %> 
</html>
