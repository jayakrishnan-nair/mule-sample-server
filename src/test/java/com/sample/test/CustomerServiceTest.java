package com.sample.test;

import static org.junit.Assert.*;

import javax.ws.rs.core.Response;

import org.junit.Test;

import com.raml.sample.dto.Customer;
import com.raml.sample.exceptions.CustomerAPIException;
import com.raml.sample.service.CustomerService;

/**
 * A Test-case for testing the CustomerService 
 * @author Jay
 *
 */
public class CustomerServiceTest {

	/**
	 * Test the Service method getCustomer()
	 */
	@Test
	public void testGetCustomer() {
		CustomerService service = new CustomerService();
		Response response  = service.getCustomer("1001");
		assertEquals("Should return status 200 ",200, response.getStatus());
	}
	
	/**
	 * Test the Service method getAllCustomers()
	 */
	@Test
	public void testGetAllCustomer() throws CustomerAPIException {
		CustomerService service = new CustomerService();
		Response response  = service.getAllCustomers();
		assertEquals("Should return status 200 ",200, response.getStatus());
	}
	
	/**
	 * Test the Service method addCustomer()
	 */
	@Test
	public void testAddCustomer() {
		CustomerService service = new CustomerService();
		Customer customer = new Customer();
		customer.setId("99");
		Response response  = service.addCustomer(customer);
		assertEquals("Should return status 201 ",201, response.getStatus());
	}

	/**
	 * Test the Service method updateCustomer()
	 */
	@Test
	public void testUpdateCustomer() {
		CustomerService service = new CustomerService();
		Customer customer = new Customer();
		customer.setId("99");
		Response response  = service.updateCustomer(customer,"1001");
		assertEquals("Should return status 200 ",200, response.getStatus());
	}
	
	/**
	 * Test the Service method removeCustomer()
	 */
	@Test
	public void testRemoveCustomer() {
		CustomerService service = new CustomerService();
		Response response  = service.removeCustomer("1001");
		assertEquals("Should return status 200 ",200, response.getStatus());
	}
}