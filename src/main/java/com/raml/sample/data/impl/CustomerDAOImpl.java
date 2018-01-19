package com.raml.sample.data.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.raml.sample.data.CustomerDAO;
import com.raml.sample.dto.Customer;
import com.raml.sample.exceptions.CustomerExistsException;
import com.raml.sample.exceptions.CustomerNotFoundException;

/**
 * The Implementation class for fetching/updating/deleting customer data from database.
 * This implements the CustomerDAO interface
 * @author Jay
 *
 */
public class CustomerDAOImpl implements CustomerDAO{

	Logger log = Logger.getLogger(CustomerDAOImpl.class);
	
    /**
     * Get all customers.
     * @return List<Customer> - The list of all customers.
     */
	public List<Customer> getAllCustomers()
    {
		List<Customer> customers = new ArrayList<Customer>();
		try{
			//return all customers from DB. Here the DTO is populated with sample data
	        Customer customer = new Customer();
	        customer.setId("1001");
	        customer.setFirstName("Jay");
	        customer.setLastName("krish");
	        customer.setStreetAddress("76 Albert Road");
	        customer.setPostCode("2135");
	        customer.setArea("Strathfeild");
	        customers.add(customer);
	        log.info("Successfully returning :"+customers);
		}finally{
			//close DB resources
		}
        return customers;
    }

    /**
     * Get a customer.
     * @param id - The customer id.
     * @return customer - The customer entity.
     */
	
	public Customer getCustomer(String id) throws CustomerNotFoundException 
    {
        Customer customer = new Customer();
		try{
			if(!isCustomerExists(id)){//A test method. This is not needed. This is done , to show exceptional conditions
				throw new CustomerNotFoundException("Customer not found");
			}else{
				//return a customers from DB. Here the DTO is populated with sample data
		        customer.setId(id);
		        customer.setFirstName("Jay");
		        customer.setLastName("krish");
		        customer.setStreetAddress("76 Albert Road");
		        customer.setPostCode("2135");
		        customer.setArea("Strathfeild");
			}
		}finally{
			//close DB resources
		}
        return customer;
    }
	
    /**
     * Add a customer.
     * @param customer - The customer entity.
     * @return true, if successfully added. else false.
     */
	public boolean addCustomer(Customer customer) throws CustomerExistsException{
		try{
			if(isCustomerExists(customer.getId())){//A test method. This is not needed. This is done , to show exceptional conditions
				throw new CustomerExistsException("Customer Already exists");
			}else{
				//Create a customer in DB
			}
		}finally{
			//close DB resources
		}
		return true;
	}
	
    /**
     * Delete a customer.
     * @param id - The customer id.
     * @return true, if successfully deleted. else false.
     */
	public boolean removeCustomer(String id) throws CustomerNotFoundException{
		try{
			if(!isCustomerExists(id)){//A test method. This is not needed. This is done , to show exceptional conditions
				throw new CustomerNotFoundException("Customer not found");
			}else{
				//remove a customer in DB
			}
		}finally{
			//close DB resources
		}
		return true;
	}
	
    /**
     * Update a customer.
     * @param customer - The customer entity.
     * @param id - The customer id.
     * @return true, if successfully added. else false.
     */
	public boolean updateCustomer(Customer customer, String id) throws CustomerNotFoundException{
		try{
			
			if(!isCustomerExists(id)){//A test method. This is not needed. This is done , to show exceptional conditions
				throw new CustomerNotFoundException("Customer not found");
			}else{
				//update a customer in DB
			}
		}finally{
			//close DB resources
		}
		return true;
	}
	
    /**
     * A test method. This is not needed. This is done , to show exceptional conditions
     * It simply checks if id is < 1000 , which assumes the customer does not exist.
     * @param id - The customer id.
     * @return true, if customer exists. else false.
     */
	
	public boolean isCustomerExists(String id){
		if(Integer.parseInt(id)<1000){
			return false;
		}
		return true;
	}
}