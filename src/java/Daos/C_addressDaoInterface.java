/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import Dtos.C_address;

/**
 *
 * @author zbo97
 */
public interface C_addressDaoInterface {
    public C_address getCustomerAddressByCustomerId(int customerId);
    public int addCustomerAddress(int customerId, String address1, String address2, String address3);
    public int updateCustomerAddress(int customerId, String address1, String address2, String address3);
}
