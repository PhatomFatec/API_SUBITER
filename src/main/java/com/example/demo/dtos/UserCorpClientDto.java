package com.example.demo.dtos;

import java.io.Serializable;

import com.example.demo.entities.AcessType;
import com.example.demo.entities.UserCorpClient;

public class UserCorpClientDto implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private String email;
	private String password;
	private AcessType acessType;
	private String cpf;
	private String telefone;
	private String nome;
	private String razaoSocial;
	private String cnpj;

	public UserCorpClientDto() {
	}

	public UserCorpClientDto(UserCorpClient obj) {
		this.id = obj.getId();
		this.email = obj.getEmail();
		this.password = obj.getPassword();
		this.acessType = obj.getAcessType();
		this.cpf = obj.getCpf();
		this.telefone = obj.getTelefone();
		this.nome = obj.getNome();
		this.razaoSocial = obj.getRazaoSocial();
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

}
