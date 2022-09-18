package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dtos.UserCommonClientDto;
import com.example.demo.entities.UserCommonClient;
import com.example.demo.repositories.UserCommonClientRepository;

@Service
public class UserCommonClientService {

	@Autowired
	private UserCommonClientRepository repository;

	public List<UserCommonClient> findAll() {
		return repository.findAll();
	}

	public UserCommonClient findById(Long id) {
		Optional<UserCommonClient> obj = repository.findById(id);
		return obj.get();
	}


	public UserCommonClient insertUserCommonClient(UserCommonClient obj) {
		UserCommonClient user = repository.save(obj);
		return user;
	}

	public void delete(Long id) {
		findById(id);
		repository.deleteById(id);
	}

	public UserCommonClient update(UserCommonClient obj) {
		UserCommonClient newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repository.save(newObj);

	}

	private void updateData(UserCommonClient newObj, UserCommonClient obj) {
		newObj.setCpf(obj.getCpf());
		newObj.setEmail(obj.getEmail());
		newObj.setPassword(obj.getPassword());
		newObj.setTelefone(obj.getTelefone());
		newObj.setNome(obj.getNome());
	}

	public UserCommonClient fromDto(UserCommonClientDto obj) {
		return new UserCommonClient(obj.getId(), obj.getEmail(), obj.getPassword(), obj.getAcessType(), obj.getCpf(),
				obj.getTelefone(), obj.getNome());

	}
}
