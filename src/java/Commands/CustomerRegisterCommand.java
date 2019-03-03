/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands;

import Daos.CustomerDao;
import Dtos.Customer;
import Hashing.Encrypting;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        String securedPassword = null;
        
        username = request.getParameter("username");
        password = request.getParameter("password");
        firstName = request.getParameter("firstName");
        lastName = request.getParameter("lastName");
        phone = request.getParameter("phone");
        
        if(username != null && !username.equals("") && password != null && !password.equals("") && firstName != null && !firstName.equals("") && lastName != null && !lastName.equals("") && phone != null && !phone.equals("")){
            try {
                securedPassword = Encrypting.generatePasswordHash(password);
            } catch (NoSuchAlgorithmException ex) {
                String errorMessage = "EncryptError";
                HttpSession session = request.getSession();
                session.setAttribute("errorMessage", errorMessage);
                forwardToJsp = "error.jsp";
            } catch (InvalidKeySpecException ex) {
                String errorMessage = "EncryptError";
                HttpSession session = request.getSession();
                session.setAttribute("errorMessage", errorMessage);
                forwardToJsp = "error.jsp";
            }
            CustomerDao cDao = new CustomerDao("delivery");
            int newId = cDao.registerCustomer(username, securedPassword, firstName, lastName, phone);
            if(newId != -1){
                Customer c = cDao.getCustomerByUsernamePassword(username, securedPassword);
                HttpSession session = request.getSession();
                session.setAttribute("successMessage", "AccountCreadtedsuccessfully");
                session.setAttribute("loggedInUser", c);
                forwardToJsp = "index.jsp";
                
            } else{
                String errorMessage = "registerError1" + securedPassword;
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
