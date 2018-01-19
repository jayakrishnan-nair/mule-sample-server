package com.raml.sample.service;

import java.util.List;


import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.log4j.Logger;

import com.raml.sample.data.CustomerDAO;
import com.raml.sample.data.impl.CustomerDAOImpl;
import com.raml.sample.dto.Customer;
import com.raml.sample.exceptions.CustomerExistsException;
import com.raml.sample.exceptions.CustomerNotFoundException;

@Path("/services")

public class CustomerService {
	
	Logger log = Logger.getLogger(CustomerService.class);
	
    @GET
    @Path("/customers")
    /**
     * Get all customers.
     * @return Response - The HTTP Response, in JSON with status (200 -OK, 417 - General Error)
     */
    public Response getAllCustomers()
    {
    	CustomerDAO customerDAO = new CustomerDAOImpl();
        try {
        	List<Customer> customers = customerDAO.getAllCustomers();
        	log.info(customers);
        	return Response.status(Status.OK)
        			.type(MediaType.APPLICATION_JSON)
        			.entity(customers)
        			.build();
		} catch (Exception e) {
			log.error(e.getMessage());
			return Response.status(Status.EXPECTATION_FAILED)
					.type(MediaType.APPLICATION_JSON)
					.build();
		}
    }

    /**
     * Get one customer by ID
     * @param id - The customer ID
     * @return Response - The HTTP Response, in JSON with status (200 -OK, 417 - General Error, 404 - Not found)
     */
    @GET
    @Path("/customers/{id}")
    public Response getCustomer(@PathParam("id") String id)
    {
    	CustomerDAO customerDAO = new CustomerDAOImpl();
        try {
        	Customer customer = customerDAO.getCustomer(id);
			log.info("Successfully getting customer");
			return Response.status(Status.OK)
        			.type(MediaType.APPLICATION_JSON)
        			.entity(customer)
        			.build();
		} catch (CustomerNotFoundException e) {
			log.error(e.getMessage());
			return Response.status(Status.NOT_FOUND)
					.type(MediaType.APPLICATION_JSON)
					.build();
		}catch (Exception e) {
			log.error(e.getMessage());
			return Response.status(Status.EXPECTATION_FAILED)
					.type(MediaType.APPLICATION_JSON)
					.build();
		}
    }
    /**
     * Add a customer.
     * @param  customer - The Customer JSON (Object)
     * @return Response - The HTTP Response, in JSON with status (201 - Created Ok, 409 - Conflict (Already exists),417 - General Error)
     */
    @POST
    @Path("/customers")
    public Response addCustomer(Customer customer)
    {
    	CustomerDAO customerDAO = new CustomerDAOImpl();
        try {
			customerDAO.addCustomer(customer);
			log.info("Successfully added customer");
			return Response.status(Status.CREATED)
        			.type(MediaType.APPLICATION_JSON)
        			.build();
		} catch (CustomerExistsException e) {
			log.error(e.getMessage());
			return Response.status(Status.CONFLICT)
					.type(MediaType.APPLICATION_JSON)
					.build();
		}catch (Exception e) {
			log.error(e.getMessage());
			return Response.status(Status.EXPECTATION_FAILED)
					.type(MediaType.APPLICATION_JSON)
					.build();
		}
    }
    
    /**
     * Update a customer.
     * @param  customer - The Customer JSON(Object)
     * @param id - Customer ID
     * @return Response - The HTTP Response, in JSON with status (200 -OK, 404 - customer not found, 417 - General Error)
     */
    
    @PUT
    @Path("/customers/{id}")
    public Response updateCustomer(Customer customer, @PathParam("id") String id)
    {
    	CustomerDAO customerDAO = new CustomerDAOImpl();
        try {
			customerDAO.updateCustomer(customer,id);
			log.info("Successfully updated customer");
			return Response.status(Status.OK)
        			.type(MediaType.APPLICATION_JSON)
        			.build();
		} catch (CustomerNotFoundException e) {
			log.error(e.getMessage());
			return Response.status(Status.NOT_FOUND)
					.type(MediaType.APPLICATION_JSON)
					.build();
		}catch (Exception e) {
			log.error(e.getMessage());
			return Response.status(Status.EXPECTATION_FAILED)
					.type(MediaType.APPLICATION_JSON)
					.build();
		}
    }
    
    /**
     * Delete a customer.
     * @param id - Customer ID
     * @return Response - The HTTP Response, in JSON with status (200 -OK, 404 - customer not found, 417 - General Error)
     */
    
    @DELETE
    @Path("/customers/{id}")
    public Response removeCustomer(@PathParam("id") String id)
    {
    	CustomerDAO customerDAO = new CustomerDAOImpl();
        try {
			customerDAO.removeCustomer(id);
			log.info("Successfully updated customer");
			return Response.status(Status.OK)
        			.type(MediaType.APPLICATION_JSON)
        			.build();
		} catch (CustomerNotFoundException e) {
			log.error(e.getMessage());
			return Response.status(Status.NOT_FOUND)
					.type(MediaType.APPLICATION_JSON)
					.build();
		}catch (Exception e) {
			log.error(e.getMessage());
			return Response.status(Status.EXPECTATION_FAILED)
					.type(MediaType.APPLICATION_JSON)
					.build();
		}
    }
}