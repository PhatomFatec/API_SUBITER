package com.example.demo.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
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
	private Integer acessType;
	private String cpf;
	private String telefone;
	private String nome;

	@OneToMany(mappedBy = "user")
	@JsonIgnore
	private Set<Product> products = new HashSet<>();
	
	@OneToMany(mappedBy = "user")
	@JsonIgnore
	private Set<Called> calleds = new HashSet<>();

	public User() {
	}

	public User(Long id, String email, String password, AcessType acessType, String cpf, String telefone, String nome) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		setAcessType(acessType);
		this.cpf = cpf;
		this.telefone = telefone;
		this.nome = nome;

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

	public Set<Product> getProducts() {
		return products;
	}


	public AcessType getAcessType() {
		return AcessType.valueOf(acessType);
	}

	public void setAcessType(AcessType acessType) {
		if (acessType != null) {
			this.acessType = acessType.getCode();
		}
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
		User other = (User) obj;
		return Objects.equals(id, other.id);
	}

}
