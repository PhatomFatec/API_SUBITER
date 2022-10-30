package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	public User findByEmail(String email);

	public List<User> findByNameContains(String name);

	public User findByNameAndPassword(String name, String password);


}
