package com.example.demo.entities;

import javax.persistence.Entity;

@Entity
public class UserAdmin extends User {

	private static final long serialVersionUID = 1L;
	
	public UserAdmin() {
	}

	public UserAdmin(Long id, String email, String password, Integer acessType, String cpf, String telefone,
			String nome) {
		super(id, email, password, acessType, cpf, telefone, nome);
	}
	
	
}
