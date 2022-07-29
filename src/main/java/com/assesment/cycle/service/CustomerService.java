package com.assesment.cycle.service;

import java.util.List;

import com.assesment.cycle.entity.Customer;

public interface CustomerService {
	Customer createCustomer(Customer customer);
	
	List<Customer> getAllCustomer();
	
	Customer getCustomerById(Integer customerId);
}
