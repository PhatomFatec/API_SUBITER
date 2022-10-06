package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dtos.EquipmentDTO;
import com.example.demo.entities.Equipment;
import com.example.demo.repositories.EquipmentRepository;

@Service
public class EquipmentService {
	
	@Autowired
	private EquipmentRepository repository;

	public List<Equipment> findAll() {
		return repository.findAll();
	}

	public Equipment findById(Long id) {
		Optional<Equipment> obj = repository.findById(id);
		return obj.get();
	}

	public Equipment save(Equipment obj) {
		return repository.save(obj);
	}

	public Equipment update(Long id, Equipment obj) {
		Equipment newEquipment = findById(id);
		newEquipment.setNome(obj.getNome());
		newEquipment.setNumeroDeSerie(obj.getNumeroDeSerie());
		newEquipment.setDescricao(obj.getDescricao());
		newEquipment.setDataCadastro(obj.getDataCadastro());
		newEquipment.setDataFabricacao(obj.getDataFabricacao());
		newEquipment.setDescricao(obj.getDescricao());
		return repository.save(newEquipment);
}

	public void delete(Long id) {
		repository.deleteById(id);
	}

	public Equipment FromDTO(EquipmentDTO objDto) {
		return new Equipment(objDto.getId(),objDto.getNome(),objDto.getDataCadastro(), objDto.getDataFabricacao(), objDto.getDescricao(), objDto.getNumeroDeSerie(),objDto.getDisponibilidade());
	}


}
