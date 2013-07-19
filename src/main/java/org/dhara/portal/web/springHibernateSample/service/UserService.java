package org.dhara.portal.web.springHibernateSample.service;

import org.dhara.portal.web.springHibernateSample.entity.Customer;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: harsha
 * Date: 7/9/13
 * Time: 1:06 PM
 * To change this template use File | Settings | File Templates.
 */
public interface UserService {
    public void saveOrUpdateCustomer(Customer customer);
    public List<Customer> fetchALLCustomers();
}
