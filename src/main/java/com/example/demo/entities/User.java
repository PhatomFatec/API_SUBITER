package com.example.demo.entities;

import java.io.Serializable;
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
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="users")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "u_id")
	private Long id;
	
	@NotBlank(message = "O campo email não pode estar em branco")
	@Column(unique=true, name = "u_email")
	private String email;
	
	@NotBlank(message = "O campo password não pode estar em branco")
	@Column(name = "u_password")
	private String password;
	
	@NotBlank(message = "O campo roles não pode estar em branco")
	@Column(name = "u_roles")
	private String roles;
	
	@NotBlank(message = "O campo cpf não pode estar em branco")
	@Column(name = "u_cpf")
	private String cpf;
	
	@Column(name = "u_foneNumber")
	private String foneNumber;
	
	@NotBlank(message = "O campo name não pode estar em branco")
	@Column(name = "u_name")
	private String name;
	
	@Column(name = "u_corporate_name")
	private String corporateName;
	
	@Column(name = "u_cnpj")
	private String cnpj;

	@JsonIgnore
	@OneToMany(mappedBy = "user")
	private Set<Request> requests = new HashSet<>();

	public User() {
	}

	public User(Long id, String email, String password, String roles, String cpf, String foneNumber, String name,
			String corporateName, String cnpj) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.roles = roles;
		this.cpf = cpf;
		this.foneNumber = foneNumber;
		this.name = name;
		this.corporateName = corporateName;
		this.cnpj = cnpj;
	}

	public Set<Request> getRequests() {
		return requests;
	}

	public void setRequests(Set<Request> requests) {
		this.requests = requests;
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
