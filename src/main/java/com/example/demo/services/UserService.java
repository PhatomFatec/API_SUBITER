package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.dtos.UserDTO;
import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;

@Service
public class UserService implements SegurancaService {

	@Autowired
	private UserRepository repository;

	private PasswordEncoder encoder = new BCryptPasswordEncoder();

	@Override
	@PreAuthorize("hasRole('ADMIN')")
	public List<User> findAll() {
		return repository.findAll();
	}

	@Override
	@PreAuthorize("hasRole('ADMIN')")
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.get();
	}

	@Override
	@PreAuthorize("hasRole('ADMIN')")
	public User insert(User obj) {
		if (obj.getNome() == null || obj.getNome().trim().isEmpty() ||

				obj.getRoles() == null || obj.getRoles().trim().isEmpty()) {
			throw new IllegalArgumentException("Algum atributo em branco!");
		}
		obj.setPassword(encoder.encode(obj.getPassword()));
		return repository.save(obj);
	}

	@Override
	@PreAuthorize("hasRole('ADMIN')")
	public void delete(Long id) {
		findById(id);
		repository.deleteById(id);
	}

	@Override
	@PreAuthorize("hasRole('ADMIN')")
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

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = repository.findByEmail(username);
		if (user == null) {
			throw new UsernameNotFoundException("Usuário não encontrado!");
		}
		return org.springframework.security.core.userdetails.User.builder().username(username)
				.password(user.getPassword()).authorities(user.getRoles()).build();
	}
}
