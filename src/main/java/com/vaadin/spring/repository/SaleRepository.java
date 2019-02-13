package com.vaadin.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vaadin.spring.model.Sale;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {

}
