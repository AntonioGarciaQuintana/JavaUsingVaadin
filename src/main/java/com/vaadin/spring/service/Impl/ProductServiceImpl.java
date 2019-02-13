package com.vaadin.spring.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vaadin.spring.model.Product;
import com.vaadin.spring.repository.ProductResitory;
import com.vaadin.spring.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	private ProductResitory productRepository;
	
	@Autowired
	ProductServiceImpl(ProductResitory productRepository){
		this.productRepository = productRepository;
	}
	
	@Override
	public void SaveProduct(Product product) {
		this.productRepository.save(product);
	}

	@Override
	public Product GetProductByCode(String code) {
		return this.productRepository.GetProductByCode(code);
	}

}
