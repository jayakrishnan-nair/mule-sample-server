package com.sample.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.raml.sample.data.CustomerDAO;
import com.raml.sample.data.impl.CustomerDAOImpl;
import com.raml.sample.dto.Customer;
import com.raml.sample.exceptions.CustomerExistsException;
import com.raml.sample.exceptions.CustomerNotFoundException;

/**
 * A Test-case for testing the DAO 
 * @author Jay
 *
 */
public class CustomerDAOTest {

	/**
	 * Test the DAO method getAllCustomers()
	 */
	@Test
	public void testGetAllCustomers(){
		CustomerDAO customerDAO = new CustomerDAOImpl();
		List<Customer>  customers = customerDAO.getAllCustomers();
		assertNotEquals("Should not return value 0 ",0, customers.size());
	}

	/**
	 * Test the DAO method getCustomer()
	 */
	@Test
	public void testGetCustomer() throws CustomerNotFoundException {
		CustomerDAO customerDAO = new CustomerDAOImpl();
		Customer customer = customerDAO.getCustomer("1001");
		assertEquals("Should return 1001 ","1001", customer.getId());
	}

	/**
	 * Test the DAO method addCustomer()
	 */
	@Test
	public void testAddCustomer() throws CustomerExistsException {
		CustomerDAO customerDAO = new CustomerDAOImpl();
		Customer customer = new Customer();
		customer.setId("99");
		assertEquals("Should return true ",true, customerDAO.addCustomer(customer));
	}

	/**
	 * Test the DAO method removeCustomer()
	 */
	@Test
	public void testRemoveCustomer() throws CustomerNotFoundException {
		CustomerDAO customerDAO = new CustomerDAOImpl();
		Customer customer = new Customer();
		customer.setId("1001");
		assertEquals("Should return true ",true, customerDAO.removeCustomer("1001"));
	}

	/**
	 * Test the DAO method updateCustomer()
	 */
	@Test
	public void testUpdateCustomer() throws CustomerNotFoundException {
		CustomerDAO customerDAO = new CustomerDAOImpl();
		Customer customer = new Customer();
		customer.setId("1001");
		assertEquals("Should return true ",true, customerDAO.updateCustomer(customer,"1001"));
	}
}