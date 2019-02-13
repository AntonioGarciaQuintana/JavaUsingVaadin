package com.vaadin.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vaadin.spring.model.Product;

@Repository
public interface ProductResitory extends JpaRepository<Product, Long>{
	
	@Query("Select p from Product p where p.code = :code")
	Product GetProductByCode(@Param("code") String code);

}
