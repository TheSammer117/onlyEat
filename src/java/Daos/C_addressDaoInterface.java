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
}
