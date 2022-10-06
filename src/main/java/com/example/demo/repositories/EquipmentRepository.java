package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Equipment;

public interface EquipmentRepository extends JpaRepository<Equipment, Long> {
		

	}


