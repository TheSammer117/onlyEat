<%-- 
    Document   : checkout
    Created on : 27-Mar-2019, 20:53:09
    Author     : zbo97
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Checkout</title>
    </head>
    <body>
        <%@ include file = "Includes/cHeader.jsp" %>
        <div class="container">
            <div class="row">
                <div class="col-md-4 order-md-2 mb-4">
                    <h4 class="d-flex justify-content-between align-items-center mb-3">
                        <span class="text-muted">Your cart</span>
                    </h4>
                    <ul class="list-group mb-3">
                        <li class="list-group-item d-flex justify-content-between ">
                            <div>
                                <h6 class="my-0">product name</h6>
                                <small class="text-muted">Brief description</small>
                            </div>
                            <span class="text-muted"> $ 12 </span>
                        </li>
                    </ul>
                </div>
                <div class="col-md-8 order-md-1">
                    <h4 class="mb-3">Shipping address</h4>
                    <form class="">
                        <div class="row">
                            <div class="col-md-6 mb-3">
                                <label>First name</label>
                                <input type="text" class="form-control" id="firstname" required>
                            </div>
                            <div class="col-md-6 mb-3">
                                <label>Last name</label>
                                <input type="text" class="form-control" id="lastname" required>
                            </div>
                        </div>
                        <div class="mb-3">
                            <label>Address</label>
                            <input type="text" class="form-control" id="address" required>
                        </div>
                        <hr class="mb-4">
                        <h4 class="mb-3"> Payment</h4>
                        <div class="d-block my-3">
                            <div class="custom-control custom-radio">
                                <input id="credit" name="paymentMethod" type="radio" class="custom-control-input" checked required >
                                <label class="custom-control-label">Credit card</label>
                            </div>
                            <div class="custom-control custom-radio">
                                <input id="debit" name="paymentMethod" type="radio" class="custom-control-input" required >
                                <label class="custom-control-label">Debit card</label>
                            </div>
                            <div class="custom-control custom-radio">
                                <input id="paypal" name="paymentMethod" type="radio" class="custom-control-input" required >
                                <label class="custom-control-label">PayPal</label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6 mb-3">
                                <label>Name on card</label>
                                <input type="text" class="form-control" required>
                            </div>
                            <div class="col-md-6 mb-3">
                                <label>Credit card number</label>
                                <input type="text" class="form-control" required>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-3 mb-3">
                                <label>Expiration</label>
                                <input type="text" class="form-control" required>
                            </div>
                            <div class="col-md-3 mb-3">
                                <label>CVV</label>
                                <input type="text" class="form-control" required="">
                            </div>
                            <hr class="mb-4">
                            <input type="submit" class="btn btn-primary btn-lg btn-block" value="Continue">
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <%@ include file="Includes/footer.jsp" %> 
    </body>
</html>
