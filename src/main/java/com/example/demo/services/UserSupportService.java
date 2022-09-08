package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.UserSupport;
import com.example.demo.repositories.UserSupportRepository;

@Service
public class UserSupportService {
	
	@Autowired
	private UserSupportRepository repository;
	
	public List<UserSupport> findAll(){
		return repository.findAll();
	}
	
	public UserSupport findById(Long id) {
		Optional<UserSupport> obj = repository.findById(id);
		return obj.get();
	}
}
