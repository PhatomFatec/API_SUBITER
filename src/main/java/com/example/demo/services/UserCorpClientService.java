package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.UserCorpClient;
import com.example.demo.repositories.UserCorpClientRepository;

@Service
public class UserCorpClientService {
	
	@Autowired
	private UserCorpClientRepository repository;
	
	public List<UserCorpClient> findAll(){
		return repository.findAll();
	}
	
	public UserCorpClient findById(Long id) {
		Optional<UserCorpClient> obj = repository.findById(id);
		return obj.get();
	}
}
