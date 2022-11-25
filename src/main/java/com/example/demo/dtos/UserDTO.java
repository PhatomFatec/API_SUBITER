package com.example.demo.dtos;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.example.demo.entities.User;

public class UserDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String email;
	private String password;
	private String roles;
	private String cpf;
	private String foneNumber;
	private String name;
	private String corporateName;
	private String cnpj;

	public UserDTO() {

	}


	public UserDTO(User obj) {
		super();
		this.id = obj.getId();
		this.email = obj.getEmail();
		this.password = obj.getPassword();
		this.roles = obj.getRoles();
		this.cpf = obj.getCpf();
		this.foneNumber = obj.getFoneNumber();
		this.name = obj.getName();
		this.corporateName = obj.getCorporateName();
		this.cnpj = obj.getCnpj();
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	

	public String getFoneNumber() {
		return foneNumber;
	}


	public void setFoneNumber(String foneNumber) {
		this.foneNumber = foneNumber;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getCorporateName() {
		return corporateName;
	}


	public void setCorporateName(String corporateName) {
		this.corporateName = corporateName;
	}


	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

}