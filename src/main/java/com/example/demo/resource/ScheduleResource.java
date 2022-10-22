package com.example.demo.resource;

import java.net.URI;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.dtos.ScheduleDTO;
import com.example.demo.entities.Product;
import com.example.demo.entities.Schedule;
import com.example.demo.services.ScheduleService;

@CrossOrigin

@RestController
@RequestMapping(value = "/schedule")
public class ScheduleResource {

	@Autowired
	private ScheduleService service;
	
	@GetMapping
	public ResponseEntity<List<Schedule>> findAll() {
		List<Schedule> list = service.findAll();
		return ResponseEntity.ok().body(list);

	}
	@GetMapping(value = "/{id}")
	public ResponseEntity<Schedule> findById(@PathVariable Long id) {
		Schedule sch = service.findById(id);
		return ResponseEntity.ok().body(sch);
	} 
	
	@PostMapping
	public ResponseEntity<Schedule> insert(@RequestBody ScheduleDTO objDto) {
		Schedule obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();

	}
	@PutMapping(value= "/{id}")
	public ResponseEntity<Schedule> updateSchedule(@PathVariable Long id, @RequestBody Schedule obj){
		Schedule newSc = service.update(id, obj);
		return ResponseEntity.ok().body(newSc);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
