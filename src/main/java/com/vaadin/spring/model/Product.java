package com.vaadin.spring.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tbl_product")
public class Product {

	@Id
    @GeneratedValue( strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "code")
	private String code;

	@Column(name = "name")
	private String name;

	@Min(1)
	@Column(name = "price")
	private BigDecimal price;

	@NotNull
	@Column(name = "delete_product", columnDefinition = "bit default 'false'")
	private Boolean delete;

	Product() {
	}

	public Boolean isDelete() {
		return delete;
	}

	public Product(String code, String name, BigDecimal price, Boolean delete) {
		this.code = code;
		this.name = name;
		this.price = price;
		this.delete = delete;
	}

	public void setDelete(Boolean delete) {
		this.delete = delete;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

}
