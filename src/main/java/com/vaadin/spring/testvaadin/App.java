package com.vaadin.spring.testvaadin;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.vaadin.spring.model.Customer;
import com.vaadin.spring.model.Product;
import com.vaadin.spring.service.CustomerService;
import com.vaadin.spring.service.ProductService;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@ComponentScan(value = { "com.vaadin" })
@EnableJpaRepositories(basePackages = { "com.vaadin.spring.repository" })
@EntityScan(value = { "com.vaadin.spring.model" })
public class App {

	private static final Logger log = LoggerFactory.getLogger(App.class);

	public static void main(String[] args) {
		SpringApplication.run(App.class);
	}

	@Bean
	public CommandLineRunner loadData(CustomerService customerService, ProductService productService) {
		return (args) -> {
			/*// save customer
			customerService.SaveCustomer(new Customer("Jack", "Bauer"));
			customerService.SaveCustomer(new Customer("Chloe", "O'Brian"));
			customerService.SaveCustomer(new Customer("Kim", "Bauer"));
			customerService.SaveCustomer(new Customer("David", "Palmer"));
			customerService.SaveCustomer(new Customer("Michelle", "Dessler"));

			//save products
			/*productService.SaveProduct(new Product("1111", "leche yaqui", new BigDecimal("1254.36"), false));
			productService.SaveProduct(new Product("2222", "Maizoro", new BigDecimal("15.65"), false));
			productService.SaveProduct(new Product("3333", "Chetos", new BigDecimal("49.45"), false));
			productService.SaveProduct(new Product("4444", "Coca-cola", new BigDecimal("25.25"), false));
			productService.SaveProduct(new Product("5555", "Barritas bimbo", new BigDecimal("49.92"), false));*/
		};
	}
}
