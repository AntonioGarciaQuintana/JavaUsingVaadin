package com.vaadin.spring.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_detail_sale")
public class DetailSale {

	@Id
	@GeneratedValue
	private Long id;


	@OneToOne()
	private Product product;

	@Column(name = "number_products")
	private int numberProducts;

	@Column(name = "unit_cost")
	private BigDecimal unitCost;

	@Column(name = "sub_total")
	private BigDecimal subTotal;
	
	  public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public Product getProduct() {
	        return product;
	    }

	    public void setProduct(Product product) {
	        this.product = product;
	    }

	    public int getNumberProducts() {
	        return numberProducts;
	    }

	    public void setNumberProducts(int numberProducts) {
	        this.numberProducts = numberProducts;
	    }

	    public BigDecimal getSubTotal() {
	        return subTotal;
	    }

	    public void setSubTotal(BigDecimal subTotal) {
	        this.subTotal = subTotal;
	    }

	    public BigDecimal getUnitCost() {
	        return unitCost;
	    }

	    public void setUnitCost(BigDecimal unitCost) {
	        this.unitCost = unitCost;
	    }
}
