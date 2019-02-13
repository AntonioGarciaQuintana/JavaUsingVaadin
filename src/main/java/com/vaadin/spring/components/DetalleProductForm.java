package com.vaadin.spring.components;

import java.math.BigDecimal;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.converter.StringToBigDecimalConverter;
import com.vaadin.flow.data.converter.StringToIntegerConverter;
import com.vaadin.spring.model.Product;
import com.vaadin.spring.testvaadin.MainView;

public class DetalleProductForm extends FormLayout {

	private TextField code = new TextField("Code product");
	private TextField name = new TextField("Name product");
	private TextField price = new TextField("Price product");
	private Product product;
	private MainView mainView;

	private Binder<Product> binder = new Binder<>(Product.class);

	private Button save = new Button("save");
	private Button delete = new Button("Delete");

	public DetalleProductForm(MainView mainView) {
		this.mainView = mainView;

		HorizontalLayout buttons = new HorizontalLayout(save, delete);
		save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
		
		code.setEnabled(false);
		name.setEnabled(false);
		price.setEnabled(false);

		add(code, name, price, buttons);

		
		binder.forField(this.price).withNullRepresentation("")
				.withConverter(new StringToBigDecimalConverter("Must be an amount"))
				.bind(Product::getPrice, Product::setPrice);
		binder.bindInstanceFields(this);
		setProduct(null);
	}

	public void setProduct(Product product) {
		this.product = product;
		binder.setBean(product);
		boolean enabled = product != null;
		if (enabled) {
			code.focus();
		}
	}

}
