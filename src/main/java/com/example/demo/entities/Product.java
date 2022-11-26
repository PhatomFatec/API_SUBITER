package com.example.demo.entities;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="product")
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "prod_id")
	private Long id;
	
	@Column(name = "prod_model")
	private String model;
	
	@Column(name = "prod_serial")
	private String serialNumber;
	
	@Column(name = "prod_description")
	private String description;
	
	@Column(name = "prod_manufacture_date")
	private String manufactureDate;

	@Column(name = "prod_register_date")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "America/Sao_Paulo")
	private LocalDate registerDate;

	@JsonIgnore
	@OneToMany(mappedBy ="product")
	private Set<Request> requests = new HashSet<>();

	public Product() {
	}

	
	public Product(Long id, String model, String serialNumber, String description, String manufactureDate) {
		super();
		this.id = id;
		this.model = model;
		this.serialNumber = serialNumber;
		this.description = description;
		this.manufactureDate = manufactureDate;
		this.registerDate = LocalDate.now();
	}


	public Set<Request> getRequests() {
		return requests;
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


	public LocalDate getRegisterDate() {
		return registerDate;
	}


	public void setRegisterDate(LocalDate registerDate) {
		this.registerDate = registerDate;
	}


	public void setRequests(Set<Request> requests) {
		this.requests = requests;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(id, other.id);
	}
}
