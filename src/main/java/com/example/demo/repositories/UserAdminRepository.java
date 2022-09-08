package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.UserAdmin;

public interface UserAdminRepository extends JpaRepository<UserAdmin, Long> {
	
	

}
