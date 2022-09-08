package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.UserAdmin;
import com.example.demo.repositories.UserAdminRepository;

@Service
public class UserAdminService {
	
	@Autowired
	private UserAdminRepository repository;
	
	public List<UserAdmin> findAll(){
		return repository.findAll();
	}
	
	public UserAdmin findById(Long id) {
		Optional<UserAdmin> obj = repository.findById(id);
		return obj.get();
	}
}
