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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.dtos.ScheduleDTO;
import com.example.demo.entities.Schedule;
import com.example.demo.services.EquipService;
import com.example.demo.services.ScheduleService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;

@CrossOrigin
@RestController
@RequestMapping(value = "/schedule")
public class ScheduleResource {

	@Autowired
	private ScheduleService service;

	@Autowired
	private EquipService serviceEquip;

	@ApiOperation(value = "", authorizations = { @Authorization(value = "Bearer") })
	@GetMapping
	public ResponseEntity<List<Schedule>> findAll() {
		List<Schedule> list = service.findAll();
		return ResponseEntity.ok().body(list);

	}

	@ApiOperation(value = "", authorizations = { @Authorization(value = "Bearer") })
	@GetMapping(value = "/{id}")
	public ResponseEntity<Schedule> findById(@PathVariable Long id) {
		Schedule sch = service.findById(id);
		return ResponseEntity.ok().body(sch);
	}

	@ApiOperation(value = "", authorizations = { @Authorization(value = "Bearer") })
	@PostMapping
	public ResponseEntity<Schedule> insert(@RequestBody ScheduleDTO objDto) {
		Schedule obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();

	}

	@ApiOperation(value = "", authorizations = { @Authorization(value = "Bearer") })
	@PutMapping(value = "/{idSchedule}/addequips/{idEquip}")
	public ResponseEntity<Schedule> insertEquip(@PathVariable Long idSchedule, @PathVariable Long idEquip) {

		Schedule sche = service.addEquip(idSchedule, idEquip);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(sche.getId()).toUri();
		return ResponseEntity.created(uri).build();

	}

	@ApiOperation(value = "", authorizations = { @Authorization(value = "Bearer") })
	@PutMapping(value = "/{id}")
	public ResponseEntity<Schedule> updateSchedule(@PathVariable Long id, @RequestBody Schedule obj) {
		Schedule newSc = service.update(id, obj);
		return ResponseEntity.ok().body(newSc);
	}

	@ApiOperation(value = "", authorizations = { @Authorization(value = "Bearer") })
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
