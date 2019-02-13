package com.vaadin.spring.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vaadin.spring.model.Customer;
import com.vaadin.spring.repository.CustomerRepository;
import com.vaadin.spring.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	CustomerRepository customerRepository;
	
	@Autowired
	CustomerServiceImpl(CustomerRepository customerRepository){
		this.customerRepository = customerRepository;
	}
	
	@Override
	public void SaveCustomer(Customer customer) {
		this.customerRepository.save(customer);
	}

	@Override
	public List<Customer> findAll() {
		return this.customerRepository.findAll();
	}

	@Override
	public Customer findById(long id) {
		return this.customerRepository.findById(id);
	}

	@Override
	public List<Customer> findByIdNameLastName(String filter) {
		return this.customerRepository.findByIdNameLastName(filter);
	}

}
