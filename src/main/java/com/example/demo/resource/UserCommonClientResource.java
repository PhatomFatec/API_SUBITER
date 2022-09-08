package com.example.demo.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.UserCommonClient;
import com.example.demo.services.UserCommonClientService;

@RestController
@RequestMapping(value = "/UserClientCommon")
public class UserCommonClientResource {

	@Autowired
	private UserCommonClientService service;
	
	@GetMapping
	public ResponseEntity<List<UserCommonClient>> findAll() {
		List<UserCommonClient> list = service.findAll();
		return ResponseEntity.ok().body(list);

	}
	@GetMapping(value ="/{id}" )
	public ResponseEntity<UserCommonClient> findById(@PathVariable Long id){
		UserCommonClient user = service.findById(id);
		return ResponseEntity.ok().body(user);
	}

}
