package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.UserCorpClient;

public interface UserCorpClientRepository extends JpaRepository<UserCorpClient, Long> {
	
	

}
