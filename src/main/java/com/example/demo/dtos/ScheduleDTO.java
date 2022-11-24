package com.example.demo.dtos;

import java.io.Serializable;

import com.example.demo.entities.Request;
import com.example.demo.entities.Schedule;

public class ScheduleDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String serviceProvided;
	private String appointment;
	private String date;
	private String address;
	private String city;
	private String zipcode;
	private String state;
	private Request request;

	public ScheduleDTO() {

	}

	public ScheduleDTO(Schedule obj) {
		super();
		this.id = obj.getId();
		this.serviceProvided = obj.getServiceProvided();
		this.appointment = obj.getAppointment();
		this.date = obj.getDate();
		this.address = obj.getAddress();
		this.city = obj.getCity();
		this.zipcode =obj.getZipcode();
		this.state = obj.getState();
		this.request = obj.getRequest();
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
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