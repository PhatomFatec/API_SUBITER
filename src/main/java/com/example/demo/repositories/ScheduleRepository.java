package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Schedule;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
	
	

}
