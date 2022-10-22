package com.example.demo.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String email;
	private String password;
	private String roles;
	private String cpf;
	private String telefone;
	private String nome;
	private String razaoSocial;
	private String cnpj; 

	@JsonIgnore
	@OneToMany(mappedBy = "user")
	private Set<Called> calleds = new HashSet<>();

	public User() {
	}

	public User(Long id, String email, String password, String roles, String cpf, String telefone, String nome,
			String razaoSocial, String cnpj) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.roles = roles;
		this.cpf = cpf;
		this.telefone = telefone;
		this.nome = nome;
		this.razaoSocial = razaoSocial;
		this.cnpj = cnpj;
	}


	public Set<Called> getCalleds() {
		return calleds;
	}



	public void setCalleds(Set<Called> calleds) {
		this.calleds = calleds;
	}







	public String getRoles() {
		return roles;
	}



	public void setRoles(String roles) {
		this.roles = roles;
	}



	public String getRazaoSocial() {
		return razaoSocial;
	}



	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}



	public String getCnpj() {
		return cnpj;
	}



	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}



	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
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

}
