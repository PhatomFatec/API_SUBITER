package com.example.demo.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.dtos.CalledDTO;
import com.example.demo.entities.Called;
import com.example.demo.services.CalledService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;

@CrossOrigin
@RestController
@RequestMapping(value = "/calleds")
public class CalledResource {

	@Autowired
	private CalledService service;
	
	@ApiOperation(value = "", authorizations = { @Authorization(value="Bearer") })
	@GetMapping
	public ResponseEntity<List<Called>> findAll() {
		List<Called> list = service.findAll();
		return ResponseEntity.ok().body(list);

	}
	
	@ApiOperation(value = "", authorizations = { @Authorization(value="Bearer") })
	@GetMapping(value ="/{id}" )
	public ResponseEntity<Called> findById(@PathVariable Long id){
		Called user = service.findById(id);
		return ResponseEntity.ok().body(user);
	}
	
	@ApiOperation(value = "", authorizations = { @Authorization(value="Bearer") })
	@PostMapping
	public ResponseEntity<Called> insertCalled(@RequestBody CalledDTO objDto) {
		Called call = service.FromDTO(objDto);
		call = service.save(call);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(call.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@ApiOperation(value = "", authorizations = { @Authorization(value="Bearer") })
	@PutMapping(value= "/{id}")
	public ResponseEntity<Called> updateCalled(@PathVariable Long id, @RequestBody Called obj){
		Called newCall = service.update(id, obj);
		return ResponseEntity.ok().body(newCall);
	}
	
	@ApiOperation(value = "", authorizations = { @Authorization(value="Bearer") })
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
