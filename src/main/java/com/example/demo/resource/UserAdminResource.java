package com.example.demo.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.UserAdmin;
import com.example.demo.services.UserAdminService;

@RestController
@RequestMapping(value = "/userAdmin")
public class UserAdminResource {

	@Autowired
	private UserAdminService service;
	
	@GetMapping
	public ResponseEntity<List<UserAdmin>> findAll() {
		List<UserAdmin> list = service.findAll();
		return ResponseEntity.ok().body(list);

	}
	@GetMapping(value ="/{id}" )
	public ResponseEntity<UserAdmin> findById(@PathVariable Long id){
		UserAdmin user = service.findById(id);
		return ResponseEntity.ok().body(user);
	}

}
