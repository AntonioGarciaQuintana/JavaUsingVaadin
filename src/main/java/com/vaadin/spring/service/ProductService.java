package com.vaadin.spring.service;

import org.springframework.stereotype.Service;

import com.vaadin.spring.model.Product;

@Service
public interface ProductService {

	void SaveProduct(Product product);
	
	Product GetProductByCode(String code);
}
