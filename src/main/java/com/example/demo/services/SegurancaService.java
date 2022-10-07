package com.example.demo.services;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.demo.entities.User;

public interface SegurancaService extends UserDetailsService{

	public List<User> findAll();
	public User findById(Long id);
	public User insert(User obj);
	public void delete(Long id);
	public User update(Long id, User obj);
	
}
