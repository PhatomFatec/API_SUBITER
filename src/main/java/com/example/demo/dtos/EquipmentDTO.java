package com.example.demo.dtos;

import java.io.Serializable;

import com.example.demo.entities.Equipment;

public class EquipmentDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String description;
	private String name;
	private String serialNumber;
	private Boolean availability;

	public EquipmentDTO() {

	}

	public EquipmentDTO(Equipment obj) {
		this.id = obj.getId();
		this.description = obj.getDescription();
		this.name = obj.getName();
		this.serialNumber = obj.getSerialNumber();
		this.availability = obj.getAvailability();

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public Boolean getAvailability() {
		return availability;
	}

	public void setAvailability(Boolean availability) {
		this.availability = availability;
	}
}
