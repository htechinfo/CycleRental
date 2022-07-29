package com.assesment.cycle.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assesment.cycle.entity.Customer;
import com.assesment.cycle.exception.CustomerNotFoundException;
import com.assesment.cycle.repository.CustomerRepository;
import com.assesment.cycle.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository repository;
	
	@Override
	public Customer createCustomer(Customer customer) {
		return repository.save(customer);
	}

	@Override
	public List<Customer> getAllCustomer() {
		return repository.findAll();
	}

	@Override
	public Customer getCustomerById(Integer customerId) {
		Optional<Customer> optionalCustomer = repository.findById(customerId);
		return optionalCustomer.orElseThrow(CustomerNotFoundException::new);
	}

}
