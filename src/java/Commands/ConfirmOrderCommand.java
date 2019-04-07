/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands;

import Daos.CustomerOrderDao;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 82509
 */
public class ConfirmOrderCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String forwardToJsp = null;
        int orderId = 0;
        try {
            orderId = Integer.parseInt(request.getParameter("orderId"));
        } catch (NumberFormatException e) {
            forwardToJsp = "error.jsp";
            HttpSession session = request.getSession();
            session.setAttribute("errorMessage", "Notvaliddata");
        }
        if (orderId != 0) {
            CustomerOrderDao cDao = new CustomerOrderDao("delivery");
            int a = 0;
            a = cDao.FinishOrder(orderId);
            if (a != -1) {
                HttpSession session = request.getSession();
                session.setAttribute("successChange", "Finish the Order");
                forwardToJsp = "restaurantIndex.jsp";
            }
        } else {
            forwardToJsp = "error.jsp";
            HttpSession session = request.getSession();
            session.setAttribute("errorMessage", "Notvaliddata");
        }
        return forwardToJsp;
    }
}
