/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands;

import Daos.C_addressDao;
import Daos.CustomerDao;
import Dtos.C_address;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author zbo97
 */
public class SaveCustomerProfileCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String forwardToJsp = null;
        int customerId = 0;
        String username = request.getParameter("username");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String phone = request.getParameter("phone");
        String address1 = request.getParameter("address1");
        String address2 = request.getParameter("address2");
        String address3 = request.getParameter("address3");
        try {
            //numberFormatException may occur when parse string to int
            customerId = Integer.parseInt(request.getParameter("customerId"));
        } catch (NumberFormatException e) {
            //if the exception occur then go to
            forwardToJsp = "error.jsp";
            HttpSession session = request.getSession();
            session.setAttribute("errorMessage", "Notvaliddata");
        }
        if (customerId > 0 && username != null && !username.equals("") && firstName != null && !firstName.equals("") && lastName != null && !lastName.equals("") && phone != null && !phone.equals("") && address1 != null && !address1.equals("")) {
            C_addressDao cADao = new C_addressDao("delivery");
            CustomerDao cDao = new CustomerDao("delivery");
            C_address cA = new C_address();
            cA = cADao.getCustomerAddressByCustomerId(customerId);
            if (cA.getCustomerId() > 0 && cA.getAddressId() > 0 && cA.getAddress1() != null) {

                cDao.updateCustomerProfile(customerId, username, firstName, lastName, phone);
                cADao.updateCustomerAddress(customerId, address1, address2, address3);
                HttpSession session = request.getSession();
                session.setAttribute("successMessage", "Detailschangedsuccessfully");
                forwardToJsp = "index.jsp";
            } else {
                cDao.updateCustomerProfile(customerId, username, firstName, lastName, phone);
                int newId = cADao.addCustomerAddress(customerId, address1, address2, address3);
                HttpSession session = request.getSession();
                session.setAttribute("successMessage", "Detailschangedsuccessfully");
                forwardToJsp = "index.jsp";
            }
        } else {
            forwardToJsp = "error.jsp";
            HttpSession session = request.getSession();
            session.setAttribute("errorMessage", "Notvaliddata");
        }
        return forwardToJsp;
    }

}
