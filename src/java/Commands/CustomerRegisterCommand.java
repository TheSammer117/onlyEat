/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands;

import Daos.CustomerDao;
import Dtos.Customer;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author zbo97
 */
public class CustomerRegisterCommand implements Command{

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String forwardToJsp = null;
        String username = null;
        String password = null;
        String firstName = null;
        String lastName = null;
        String phone = null;
        
        username = request.getParameter("username");
        password = request.getParameter("password");
        firstName = request.getParameter("firstName");
        lastName = request.getParameter("lastName");
        phone = request.getParameter("phone");
        
        if(username != null && !username.equals("") && password != null && !password.equals("") && firstName != null && !firstName.equals("") && lastName != null && !lastName.equals("") && phone != null && !phone.equals("")){
            CustomerDao cDao = new CustomerDao("delivery");
            int newId = cDao.registerCustomer(username, password, firstName, lastName, phone);
            if(newId != -1){
                Customer c = cDao.getCustomerByUsernamePassword(username, password);
                HttpSession session = request.getSession();
                session.setAttribute("successMessage", "AccountCreadtedsuccessfully");
                session.setAttribute("loggedUser", c);
                forwardToJsp = "index.jsp";
                
            } else{
                String errorMessage = "registerError1";
                HttpSession session = request.getSession();
                session.setAttribute("errorMessage", errorMessage);
                forwardToJsp = "error.jsp";
            }
        }else{
            // One or more fields were missing
            // Send the user to the error page and inform them of this
            String errorMessage = "registerError2";
            HttpSession session = request.getSession();
            session.setAttribute("errorMessage", errorMessage);
            forwardToJsp = "error.jsp";
        }
        return forwardToJsp;
    }
    
}
