package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.example.demo.dtos.EquipDTO;
import com.example.demo.entities.Equip;
import com.example.demo.repositories.EquipRepository;

@Service
public class EquipService {

	@Autowired
	private EquipRepository repository;

	@PreAuthorize("hasAnyRole('ADMIN', 'SUPPORT')")
	public List<Equip> findAll() {
		return repository.findAll();
	}

	@PreAuthorize("hasAnyRole('ADMIN', 'SUPPORT')")
	public Equip findById(Long id) {
		Optional<Equip> obj = repository.findById(id);
		return obj.get();
	}

	@PreAuthorize("hasAnyRole('ADMIN', 'SUPPORT')")
	public Equip save(Equip obj) {
		return repository.save(obj);
	}

	@PreAuthorize("hasAnyRole('ADMIN', 'SUPPORT')")
	public Equip update(Long id, Equip obj) {
		Equip newObj = findById(id);
		newObj.setDescricao(obj.getDescricao());
		newObj.setDisponibilidade(obj.getDisponibilidade());
		newObj.setNome(obj.getNome());
		newObj.setNumeroDeSerie(obj.getNumeroDeSerie());
		return repository.save(newObj);
	}

	@PreAuthorize("hasAnyRole('ADMIN', 'SUPPORT')")
	public void delete(Long id) {
		repository.deleteById(id);
	}

	public Equip FromDTO(EquipDTO objDto) {
		return new Equip(objDto.getId(), objDto.getDescricao(), objDto.getNome(), objDto.getNumeroDeSerie(),
				objDto.getDisponibilidade());
	}
}
