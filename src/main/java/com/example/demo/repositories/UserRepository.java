package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	public User findByEmail(String email);

	public List<User> findByNomeContains(String nome);

	public User findByNomeAndPassword(String nome, String password);

	// @Query("select u from User u where u.nome = ?1")
	// public User buscarPorNome(String nome);

	// @Query("select u from User u where u.nome = ?1 and u.senha = ?2")
	// public User buscarPorNomeESenha(String nome, String senha);

}
