package com.example.demo.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="schedule")
public class Schedule implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "sc_id")
	private Long id;

	@Column(name = "sc_service_provided")
	private String serviceProvided;

	@Column(name = "sc_appointment")
	private String appointment;

	@Column(name = "sc_date")
	//@Temporal(TemporalType.DATE)
	private String date;

	@Column(name = "sc_address")
	private String address;

	@Column(name = "sc_city")
	private String city;

	@Column(name = "sc_zipcode")
	private String zipcode;

	@Column(name = "sc_state")
	private String state;

	@Column(name = "sc_register_date")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "America/Sao_Paulo")
	private Instant registerDate;

	@OneToOne
	@JoinColumn(name = "request_id", referencedColumnName = "req_id")
	private Request request;

	@ManyToMany
	@JoinTable(name = "equipment_schedule", joinColumns = @JoinColumn(name = "sc_id"), inverseJoinColumns = @JoinColumn(name = "eq_id"))
	private Set<Equipment> equipments = new HashSet<>();

	public Schedule() {
	}

	public Schedule(Long id, String serviceProvided, String appointment, String date, String address, String city,
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
		this.registerDate = Instant.now();
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

	public Instant getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Instant registerDate) {
		this.registerDate = registerDate;
	}

	public Request getRequest() {
		return request;
	}

	public void setRequest(Request request) {
		this.request = request;
	}

	public Set<Equipment> getEquipments() {
		return equipments;
	}

	public void setEquipments(Set<Equipment> equipments) {
		this.equipments = equipments;
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
		Schedule other = (Schedule) obj;
		return Objects.equals(id, other.id);
	}

}
