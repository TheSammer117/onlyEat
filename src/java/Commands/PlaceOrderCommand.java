/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands;

import Daos.CartDao;
import Daos.CustomerOrderDao;
import Daos.OrderDetailDao;
import Dtos.Cart;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author zbo97
 */
public class PlaceOrderCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String forwardToJsp = null;
        int customerId = 0;
        String customerMessage = null;
        int orderId = -1;
        ArrayList<Cart> cartList = new ArrayList();
        HttpSession session = request.getSession();
        cartList = (ArrayList<Cart>) session.getAttribute("cartList");
        CustomerOrderDao cODao = new CustomerOrderDao("delivery");
        CartDao cDao = new CartDao("delivery");
        OrderDetailDao oDDao = new OrderDetailDao("delivery");
        customerMessage = request.getParameter("message");
        try {
            customerId = Integer.parseInt(request.getParameter("customerId"));
        }catch (NumberFormatException e) {
            //if the exception occur then go to the error page
            forwardToJsp = "error.jsp";
            session.setAttribute("errorMessage", "Notvaliddata");
        }
        orderId = cODao.createACustomerOrder(customerId, customerMessage);
;        if(!cartList.isEmpty()){
            for (int i = 0; i < cartList.size(); i++) {
                oDDao.createAnOrderDetailByOrderId(orderId, cartList.get(i).getFood_Id(), cartList.get(i).getQuantity());
            }
            cDao.emptyCartByCustomerId(customerId);
            forwardToJsp = "index.jsp";
            session.setAttribute("successMessage", "Thanks for your ordering, your food will be with you shortly");
        }else{
            forwardToJsp = "error.jsp";
            session.setAttribute("errorMessage", "Notvaliddata");
        }
        return forwardToJsp;
    }

}
