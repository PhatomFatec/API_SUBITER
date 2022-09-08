package com.example.demo.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Schedule;
import com.example.demo.services.ScheduleService;

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
	@GetMapping(value ="/{id}" )
	public ResponseEntity<Schedule> findById(@PathVariable Long id){
		Schedule user = service.findById(id);
		return ResponseEntity.ok().body(user);
	}

}
