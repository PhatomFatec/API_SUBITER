package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Schedule;
import com.example.demo.repositories.ScheduleRepository;

@Service
public class ScheduleService {
	
	@Autowired
	private ScheduleRepository repository;
	
	public List<Schedule> findAll(){
		return repository.findAll();
	}
	
	public Schedule findById(Long id) {
		Optional<Schedule> obj = repository.findById(id);
		return obj.get();
	}
}
