package com.vaadin.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.vaadin.spring.model.Customer;

@Service
public interface CustomerService {

	void SaveCustomer(Customer customer);
	
	List<Customer> findAll();
	
	Customer findById(long id);
	
	List<Customer> findByIdNameLastName(String filter);
}
