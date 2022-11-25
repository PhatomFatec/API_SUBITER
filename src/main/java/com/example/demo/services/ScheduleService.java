package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.example.demo.dtos.ScheduleDTO;
import com.example.demo.entities.Equipment;
import com.example.demo.entities.Schedule;
import com.example.demo.repositories.EquipmentRepository;
import com.example.demo.repositories.ScheduleRepository;

@Service
public class ScheduleService {

	@Autowired
	private ScheduleRepository repository;

	@Autowired
	private EquipmentRepository repositoryEquip;

	@PreAuthorize("hasAnyRole('ADMIN', 'SUPPORT')")
	public List<Schedule> findAll() {
		return repository.findAll();
	}

	@PreAuthorize("hasAnyRole('ADMIN', 'SUPPORT')")
	public Schedule findById(Long id) {
		Optional<Schedule> obj = repository.findById(id);
		return obj.get();
	}

	@PreAuthorize("hasAnyRole('ADMIN', 'SUPPORT')")
	public Schedule insert(Schedule obj) {
		
		return repository.save(obj);
	}

	@PreAuthorize("hasAnyRole('ADMIN', 'SUPPORT')")
	public Schedule addEquip(Long idSchedule, Long idEquip) {

		Schedule sche = repository.findById(idSchedule).get();
		Equipment equip = repositoryEquip.findById(idEquip).get();
		sche.getEquipments().add(equip);
		return repository.save(sche);

	}

	@PreAuthorize("hasAnyRole('ADMIN', 'SUPPORT')")
	public Schedule update(Long id, Schedule obj) {
		Schedule newSc = findById(id);
		newSc.setServiceProvided(obj.getServiceProvided());
		newSc.setAppointment(obj.getAppointment());
		newSc.setDate(obj.getDate());
		newSc.setAddress(obj.getAddress());
		newSc.setCity(obj.getCity());
		newSc.setZipcode(obj.getZipcode());
		newSc.setState(obj.getState());
		return repository.save(newSc);
	}

	@PreAuthorize("hasAnyRole('ADMIN', 'SUPPORT')")
	public void delete(Long id) {
		repository.deleteById(id);
	}

	public Schedule fromDTO(ScheduleDTO objDto) {
		return new Schedule(objDto.getId(), objDto.getServiceProvided(), objDto.getAppointment(), objDto.getDate(),
				objDto.getAddress(), objDto.getCity(), objDto.getState(), objDto.getZipcode(), objDto.getRequest());
	}

}
