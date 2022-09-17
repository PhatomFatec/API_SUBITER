package com.example.demo.entities;

import javax.persistence.Entity;

@Entity
public class UserCorpClient extends User {

	private static final long serialVersionUID = 1L;

	private String razaoSocial;
	private String cnpj;

	public UserCorpClient() {
	}

	public UserCorpClient(Long id, String email, String password,  AcessType acessType, String cpf, String telefone,
			String nome, String razaoSocial, String cnpj) {
		super(id, email, password, acessType, cpf, telefone, nome);
		this.razaoSocial = razaoSocial;
		this.cnpj = cnpj;
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
