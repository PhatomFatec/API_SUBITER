package com.example.demo.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtos.UserSupportDto;
import com.example.demo.entities.UserSupport;
import com.example.demo.services.UserSupportService;

@CrossOrigin

@RestController

@RequestMapping(value = "/UserSupport")
public class UserSupportResource {

	@Autowired
	private UserSupportService service;
	
	@GetMapping
	public ResponseEntity<List<UserSupport>> findAll() {
		List<UserSupport> list = service.findAll();
		return ResponseEntity.ok().body(list);

	}
	@GetMapping(value ="/{id}" )
	public ResponseEntity<UserSupport> findById(@PathVariable Long id){
		UserSupport user = service.findById(id);
		return ResponseEntity.ok().body(user);
	}
	@PostMapping
	public ResponseEntity<UserSupport> insert(@RequestBody UserSupportDto obj) {
		UserSupport sche = service.fromDto(obj);
		sche = service.insertUserSupport(sche);
		// URI uri =
		// ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return new ResponseEntity<>(sche, HttpStatus.CREATED);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<UserSupport> update(@PathVariable Long id, @RequestBody UserSupportDto obj) {
		UserSupport object = service.fromDto(obj);
		object.setId(id);
		object = service.update(object);
		return ResponseEntity.noContent().build();
	}

}
