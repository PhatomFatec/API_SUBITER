package com.example.demo.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtos.UserCorpClientDto;
import com.example.demo.entities.UserCorpClient;
import com.example.demo.services.UserCorpClientService;

@RestController
@RequestMapping(value = "/userCorp")
public class UserCorpClientResource {

	@Autowired
	private UserCorpClientService service;
	
	@GetMapping
	public ResponseEntity<List<UserCorpClient>> findAll() {
		List<UserCorpClient> list = service.findAll();
		return ResponseEntity.ok().body(list);

	}
	@GetMapping(value ="/{id}" )
	public ResponseEntity<UserCorpClient> findById(@PathVariable Long id){
		UserCorpClient user = service.findById(id);
		return ResponseEntity.ok().body(user);
	}
	
	@PostMapping
	public ResponseEntity<UserCorpClient> insert(@RequestBody UserCorpClientDto obj) {
		UserCorpClient userCorp = service.fromDto(obj);
		userCorp = service.insertUserCorpClient(userCorp);
		// URI uri =
		// ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return new ResponseEntity<>(userCorp, HttpStatus.CREATED);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<UserCorpClient> update(@PathVariable Long id, @RequestBody UserCorpClientDto obj) {
		UserCorpClient object = service.fromDto(obj);
		object.setId(id);
		object = service.update(object);
		return ResponseEntity.noContent().build();
	}

}
