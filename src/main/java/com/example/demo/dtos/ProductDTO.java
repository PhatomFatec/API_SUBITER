package com.example.demo.dtos;

import java.io.Serializable;

import com.example.demo.entities.Product;

public class ProductDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String model;
	private String serialNumber;
	private String description;
	private String manufactureDate;

	public ProductDTO() {

	}

	public ProductDTO(Product obj) {
		super();
		this.id = obj.getId();
		this.model = obj.getModel();
		this.serialNumber = obj.getSerialNumber();
		this.description = obj.getDescription();
		this.manufactureDate = obj.getManufactureDate();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getManufactureDate() {
		return manufactureDate;
	}

	public void setManufactureDate(String manufactureDate) {
		this.manufactureDate = manufactureDate;
	}

}
