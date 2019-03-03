/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import Dtos.Customer;

/**
 *
 * @author d00189969
 */
public interface CustomerDaoInterface {
    public int registerCustomer(String username, String password, String firstName, String lastName, String phone);
    public Customer getCustomerByUsernamePassword(String username, String password);
    public String getHashedPasswordByUsername(String username);
    public int updateCustomerProfile(int customerId, String username, String firstName, String lastName, String phone);
}
