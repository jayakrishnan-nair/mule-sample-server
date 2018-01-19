package com.raml.sample.data;

import java.util.List;

import com.raml.sample.dto.Customer;
import com.raml.sample.exceptions.CustomerExistsException;
import com.raml.sample.exceptions.CustomerNotFoundException;

/**
 * The CustmerDAO interface. This will be implemented by concrete DAO classes
 * @author Jay
 *
 */
public interface CustomerDAO {
	public List<Customer> getAllCustomers();
	public Customer getCustomer(String id) throws CustomerNotFoundException;
	public boolean addCustomer(Customer customer) throws CustomerExistsException;
	public boolean removeCustomer(String id) throws CustomerNotFoundException;
	public boolean updateCustomer(Customer customer, String id) throws CustomerNotFoundException;
}
