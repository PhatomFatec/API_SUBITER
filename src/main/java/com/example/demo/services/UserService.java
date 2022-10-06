package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dtos.UserDTO;
import com.example.demo.entities.Schedule;
import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public List<User> findAll() {
		return repository.findAll();
	}

	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.get();
	}

	public User insert(User obj) {
		return repository.save(obj);
	}

	public void delete(Long id) {
		findById(id);
		repository.deleteById(id);
	}

	public User update(Long id, User obj) {
		User newUser = findById(id);
		newUser.setCpf(obj.getCpf());
		newUser.setEmail(obj.getEmail());
		newUser.setPassword(obj.getPassword());
		newUser.setRoles(obj.getRoles());
		newUser.setTelefone(obj.getTelefone());
		newUser.setNome(obj.getNome());
		newUser.setRazaoSocial(obj.getRazaoSocial());
		newUser.setCnpj(obj.getCnpj());
		return repository.save(newUser);
	}

	public User fromDto(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getEmail(), objDto.getPassword(), objDto.getRoles(), objDto.getCpf(),
				objDto.getTelefone(), objDto.getNome(), objDto.getRazaoSocial(), objDto.getCnpj());
	}

}
