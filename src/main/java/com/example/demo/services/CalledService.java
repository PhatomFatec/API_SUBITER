package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Called;
import com.example.demo.repositories.CalledRepository;

@Service
public class CalledService {
	
	@Autowired
	private CalledRepository repository;
	
	public List<Called> findAll(){
		return repository.findAll();
	}
	
	public Called findById(Long id) {
		Optional<Called> obj = repository.findById(id);
		return obj.get();
	}
}
