package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.UserCommonClient;
import com.example.demo.repositories.UserCommonClientRepository;

@Service
public class UserCommonClientService {
	
	@Autowired
	private UserCommonClientRepository repository;
	
	public List<UserCommonClient> findAll(){
		return repository.findAll();
	}
	
	public UserCommonClient findById(Long id) {
		Optional<UserCommonClient> obj = repository.findById(id);
		return obj.get();
	}
}
