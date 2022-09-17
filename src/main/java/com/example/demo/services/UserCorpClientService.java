package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dtos.UserCorpClientDto;
import com.example.demo.entities.UserCorpClient;
import com.example.demo.repositories.UserCorpClientRepository;

@Service
public class UserCorpClientService {

	@Autowired
	private UserCorpClientRepository repository;

	public List<UserCorpClient> findAll() {
		return repository.findAll();
	}

	public UserCorpClient findById(Long id) {
		Optional<UserCorpClient> obj = repository.findById(id);
		return obj.get();
	}

	public UserCorpClient insertUserCorpClient(UserCorpClient obj) {
		UserCorpClient user = repository.save(obj);
		return user;
	}

	public void delete(Long id) {
		findById(id);
		repository.deleteById(id);
	}

	public UserCorpClient update(UserCorpClient obj) {
		UserCorpClient newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repository.save(newObj);

	}

	private void updateData(UserCorpClient newObj, UserCorpClient obj) {
		newObj.setCpf(obj.getCpf());
		newObj.setEmail(obj.getEmail());
		newObj.setPassword(obj.getPassword());
		newObj.setTelefone(obj.getTelefone());
		newObj.setNome(obj.getNome());
		newObj.setRazaoSocial(obj.getRazaoSocial());
		newObj.setCnpj(obj.getCnpj());
	}

	public UserCorpClient fromDto(UserCorpClientDto obj) {
		return new UserCorpClient(obj.getId(), obj.getEmail(), obj.getPassword(), obj.getAcessType(), obj.getCpf(),
				obj.getTelefone(), obj.getNome(), obj.getRazaoSocial(), obj.getCnpj());
	}
}
