package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.UserCommonClient;

public interface UserCommonClientRepository extends JpaRepository<UserCommonClient, Long> {
	
	

}
