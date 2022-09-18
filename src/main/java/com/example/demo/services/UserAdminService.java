package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dtos.UserAdminDto;
import com.example.demo.entities.UserAdmin;
import com.example.demo.repositories.UserAdminRepository;

@Service
public class UserAdminService {

	@Autowired
	private UserAdminRepository repository;

	public List<UserAdmin> findAll() {
		return repository.findAll();
	}

	public UserAdmin findById(Long id) {
		Optional<UserAdmin> obj = repository.findById(id);
		return obj.get();
	}
	public UserAdmin insertUserAdmin(UserAdmin obj) {
		UserAdmin sche = repository.save(obj);
		return sche;
	}
	
	public void delete(Long id) {
		findById(id);
		repository.deleteById(id);
	}
	
	public UserAdmin update(UserAdmin obj) {
		UserAdmin newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repository.save(newObj);
		
	}

	private void updateData(UserAdmin newObj, UserAdmin obj) {
		newObj.setCpf(obj.getCpf());
		newObj.setEmail(obj.getEmail());
		newObj.setPassword(obj.getPassword());
		newObj.setTelefone(obj.getTelefone());
		newObj.setNome(obj.getNome());
	}

	public UserAdmin fromDto(UserAdminDto obj) {
		return new UserAdmin(obj.getId(), obj.getEmail(), obj.getPassword(), obj.getAcessType(), obj.getCpf(),
				obj.getTelefone(), obj.getNome());
	}
}
