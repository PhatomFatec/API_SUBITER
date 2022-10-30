package com.example.demo.dtos;

import java.io.Serializable;
import java.util.Date;

import com.example.demo.entities.Request;

public class ScheduleDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String serviceProvided;
	private String appointment;
	private Date date;
	private String address;
	private String city;
	private String zipcode;
	private String state;
	private Request request;

	public ScheduleDTO() {

	}

	public ScheduleDTO(Long id, String serviceProvided, String appointment, Date date, String address, String city,
			String zipcode, String state, Request request) {
		super();
		this.id = id;
		this.serviceProvided = serviceProvided;
		this.appointment = appointment;
		this.date = date;
		this.address = address;
		this.city = city;
		this.zipcode = zipcode;
		this.state = state;
		this.request = request;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getServiceProvided() {
		return serviceProvided;
	}

	public void setServiceProvided(String serviceProvided) {
		this.serviceProvided = serviceProvided;
	}

	public String getAppointment() {
		return appointment;
	}

	public void setAppointment(String appointment) {
		this.appointment = appointment;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Request getRequest() {
		return request;
	}

	public void setRequest(Request request) {
		this.request = request;
	}

}