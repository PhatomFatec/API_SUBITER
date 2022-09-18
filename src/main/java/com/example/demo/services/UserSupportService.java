package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dtos.UserSupportDto;
import com.example.demo.entities.UserSupport;
import com.example.demo.repositories.UserSupportRepository;

@Service
public class UserSupportService {

	@Autowired
	private UserSupportRepository repository;

	public List<UserSupport> findAll() {
		return repository.findAll();
	}

	public UserSupport findById(Long id) {
		Optional<UserSupport> obj = repository.findById(id);
		return obj.get();
	}


	public UserSupport insertUserSupport(UserSupport obj) {
		UserSupport user = repository.save(obj);
		return user;
	}

	public void delete(Long id) {
		findById(id);
		repository.deleteById(id);
	}

	public UserSupport update(UserSupport obj) {
		UserSupport newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repository.save(newObj);

	}

	private void updateData(UserSupport newObj, UserSupport obj) {
		newObj.setCpf(obj.getCpf());
		newObj.setEmail(obj.getEmail());
		newObj.setPassword(obj.getPassword());
		newObj.setTelefone(obj.getTelefone());
		newObj.setNome(obj.getNome());
	}

	public UserSupport fromDto(UserSupportDto obj) {
		return new UserSupport(obj.getId(), obj.getEmail(), obj.getPassword(), obj.getAcessType(), obj.getCpf(),
				obj.getTelefone(), obj.getNome());

	}
}
