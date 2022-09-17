package com.example.demo.dtos;

import java.io.Serializable;

import com.example.demo.entities.AcessType;
import com.example.demo.entities.UserSupport;

public class UserSupportDto implements Serializable{

	private static final long serialVersionUID = 1L;

	private Long id;
	private String email;
	private String password;
	private AcessType acessType;
	private String cpf;
	private String telefone;
	private String nome;
	
	public UserSupportDto() {
		
	}
	
	public UserSupportDto(UserSupport objDto) {
		this.id = objDto.getId();
		this.email = objDto.getEmail();
		this.password = objDto.getPassword();
		this.acessType = objDto.getAcessType();
		this.cpf = objDto.getCpf();
		this.telefone = objDto.getTelefone();
		this.nome = objDto.getNome();
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

	public AcessType getAcessType() {
		return acessType;
	}

	public void setAcessType(AcessType acessType) {
		this.acessType = acessType;
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
