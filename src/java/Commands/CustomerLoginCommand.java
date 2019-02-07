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
public class CustomerLoginCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String forwardToJsp = null;

        // Get the username and password information that the user
        // entered into the form on the previous page
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (username != null && password != null && !username.equals("") && !password.equals("")) {
            CustomerDao cDao = new CustomerDao("delivery");
            Customer c = cDao.getCustomerByUsernamePassword(username, password);
            if (c != null) {
                HttpSession session = request.getSession();
                session.setAttribute("loggedInUser", c);
                forwardToJsp = "index.jsp";
            } else {
                // The username and/or password didn't match someone in the database
                // Send the user to the error page and inform them of this
                String errorMessage = "Nouserfoundmatchingthosedetails";
                HttpSession session = request.getSession();
                session.setAttribute("errorMessage", errorMessage);
                forwardToJsp = "error.jsp";
            }
        }else {
            // The username and/or password was missing
            // Send the user to the error page and inform them of this
            String errorMessage = "loginError";
            HttpSession session = request.getSession();
            session.setAttribute("errorMessage", errorMessage);
            forwardToJsp = "error.jsp";
        }
        return forwardToJsp;
    }

}
