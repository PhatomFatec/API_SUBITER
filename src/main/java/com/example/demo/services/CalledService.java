package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.example.demo.dtos.CalledDTO;
import com.example.demo.entities.Called;
import com.example.demo.repositories.CalledRepository;

@Service
public class CalledService {
	
	@Autowired
	private CalledRepository repository;
	
	@PreAuthorize("isAuthenticated()")
	public List<Called> findAll(){
		return repository.findAll();
	}
	
	@PreAuthorize("hasAnyRole('ADMIN', 'SUPPORT')")
	public Called findById(Long id) {
		Optional<Called> obj = repository.findById(id);
		return obj.get();
	}
	
	@PreAuthorize("isAuthenticated()")
	public Called save(Called obj) {
		return repository.save(obj);
	}
	
	@PreAuthorize("isAuthenticated()")
	public Called update(Long id, Called obj) {
		Called newCall = findById(id);
		newCall.setTitulo(obj.getTitulo());
		newCall.setDescricao(obj.getDescricao());
		newCall.setImgUrl(obj.getImgUrl());
		newCall.setSituacao(obj.getSituacao());
		newCall.setCriacaoChamado(obj.getCriacaoChamado());
		newCall.setUser(obj.getUser());
		newCall.setProduct(obj.getProduct());
		return repository.save(newCall);
}
	
	@PreAuthorize("isAuthenticated()")
	public void delete(	Long id) {
		repository.deleteById(id);
	}
	

	public Called FromDTO(CalledDTO objDto) {
		return new Called(objDto.getId(), objDto.getTitulo(),objDto.getDescricao(), objDto.getImgUrl(),objDto.getSituacao(), objDto.getCriacaoChamado(), objDto.getUser(),objDto.getProduct());
	}
}
