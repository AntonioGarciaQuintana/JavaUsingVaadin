package com.vaadin.spring.testvaadin;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.KeyDownEvent;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.Grid.SelectionMode;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.provider.Query;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;
import com.vaadin.spring.components.DetalleProductForm;
import com.vaadin.spring.model.Customer;
import com.vaadin.spring.model.Product;
import com.vaadin.spring.service.CustomerService;
import com.vaadin.spring.service.ProductService;

@Route
public class MainView extends VerticalLayout {

	private final CustomerService customerService;
	private final ProductService productService;

	final Grid<Product> grid;
	TextField filterTxt = new TextField();

	TextField totalTf = new TextField();
	Button cancelSaleBtn = new Button("Cancel Sale");

	private DetalleProductForm detailProduct = new DetalleProductForm(this);

	public MainView(CustomerService customerService, ProductService productService) {
		this.customerService = customerService;
		this.productService = productService;

		this.grid = new Grid<>(Product.class);
		this.grid.setSelectionMode(SelectionMode.MULTI);

		this.grid.addComponentColumn(product -> {
			Button button = new Button("Delete");
			button.addClickListener(click ->
			removeProduct(product));
			return button;
		});

		filterTxt.setWidth("250px");
		filterTxt.setPlaceholder("Search product by code");
		filterTxt.addKeyDownListener(com.vaadin.flow.component.Key.ENTER,
				(ComponentEventListener<KeyDownEvent>) keyDownEvent -> AddProductToGrid());

		Button searchBtn = new Button(VaadinIcon.SEARCH.create());
		searchBtn.addClickListener(e -> AddProductToGrid());
		// searchBtn.setIconAfterText();
		HorizontalLayout filtering = new HorizontalLayout();
		filtering.add(filterTxt, searchBtn);

		HorizontalLayout footer = new HorizontalLayout();
		footer.add(cancelSaleBtn, totalTf);
		footer.setAlignSelf(Alignment.START, cancelSaleBtn);
		footer.setAlignSelf(Alignment.END, totalTf);

		setSizeFull();

		/*
		 * grid.asSingleSelect().addValueChangeListener(event -> { Dialog dialog = new
		 * Dialog(); this.detailProduct.setProduct(event.getValue());
		 * dialog.add(this.detailProduct);
		 * 
		 * dialog.setWidth("800px"); dialog.setHeight("150px"); dialog.open();
		 * 
		 * });
		 */
		add(filtering, grid, footer);
	}

	private void AddProductToGrid() {
		String valueCode = filterTxt.getValue();
		Product product = this.productService.GetProductByCode(valueCode);

		if (product != null) {
			List<Product> products = new ArrayList<Product>();
			products = this.grid.getDataProvider().fetch(new Query<>()).collect(Collectors.toList());
			products.add(product);
			this.grid.setItems(products);
			this.filterTxt.clear();
			SumTotal(products);
		} else {
			Notification.show("El Producto no fue encontrado");
		}
	}

	private void SumTotal(List<Product> productList) {
		BigDecimal total = BigDecimal.ZERO;

		for (Product product : productList) {
			total = total.add(product.getPrice());
		}
		;

		totalTf.setValue(total.toString());
	}

	private void removeProduct(Product product) {
		List<Product> products = new ArrayList<Product>();
		products = this.grid.getDataProvider().fetch(new Query<>()).collect(Collectors.toList());
		products.remove(product);
		this.grid.setItems(products);
		SumTotal(products);
		Notification.show("The product: " + product.getName() + " was deleted");
	}
}
