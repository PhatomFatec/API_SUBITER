package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dtos.ScheduleDTO;
import com.example.demo.entities.Product;
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
	public Schedule insert(Schedule obj) {
		return repository.save(obj);
	}
	
	public Schedule update(Long id, Schedule obj) {
		Schedule newSc = findById(id);
		newSc.setServicoPrestado(obj.getServicoPrestado());
		newSc.setHorario(obj.getHorario());
		newSc.setData(obj.getData());
		newSc.setEndereco(obj.getEndereco());
		newSc.setCidade(obj.getCidade());
		newSc.setCep(obj.getCep());
		newSc.setEstado(obj.getEstado());
		return repository.save(newSc);
}
	
	public void delete(	Long id) {
		repository.deleteById(id);
	}

	public Schedule fromDTO(ScheduleDTO objDto) {
		return new Schedule(objDto.getId(), objDto.getServicoPrestado(), objDto.getHorario(), objDto.getData(),objDto.getEndereco(), objDto.getCidade(),objDto.getEstado(),objDto.getCep(), objDto.getCriacaoChamado());
	}

}
