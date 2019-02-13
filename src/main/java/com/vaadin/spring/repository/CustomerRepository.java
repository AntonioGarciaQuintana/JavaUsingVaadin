package com.vaadin.spring.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vaadin.spring.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
	List<Customer> findByLastNameStartsWithIgnoreCase(String lastName);
	
	@Query("Select c from Customer c where c.id = :id")
	Customer findById(@Param("id") long id);
	
	@Query("Select c from Customer c "
			+ "where c.firstName LIKE CONCAT('%', :filter ,'%') "
			+ "or c.lastName LIKE CONCAT('%',:filter,'%') ")
	List<Customer> findByIdNameLastName(@Param("filter") String filter);
}
