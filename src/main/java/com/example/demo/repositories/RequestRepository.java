package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Request;

public interface RequestRepository extends JpaRepository<Request, Long> {
	
	

}
