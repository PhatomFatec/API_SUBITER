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

import com.example.demo.dtos.EquipmentDTO;
import com.example.demo.entities.Equipment;
import com.example.demo.services.EquipmentService;

@CrossOrigin

@RestController
@RequestMapping(value = "/equipments")

public class EquipmentResource {

	@Autowired
	
	private EquipmentService service;
	
	@GetMapping
	public ResponseEntity<List<Equipment>> findAll() {
		List<Equipment> list = service.findAll();
		return ResponseEntity.ok().body(list);

	}
	@GetMapping(value ="/{id}" )
	public ResponseEntity<Equipment> findById(@PathVariable Long id){
		Equipment equi = service.findById(id);
		return ResponseEntity.ok().body(equi);
	}
	
	@PostMapping
	public ResponseEntity<Equipment> insertEquipment(@RequestBody 	EquipmentDTO objDto) {
		Equipment equip = service.FromDTO(objDto);
		equip = service.save(equip);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(equip.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value= "/{id}")
	public ResponseEntity<Equipment> updateEquipment(@PathVariable Long id, @RequestBody Equipment obj){
		Equipment newEquipment = service.update(id, obj);
		return ResponseEntity.ok().body(newEquipment);
	}
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	
}
