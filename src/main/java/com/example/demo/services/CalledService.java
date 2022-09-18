package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dtos.CalledDTO;
import com.example.demo.dtos.ProductDTO;
import com.example.demo.entities.Called;
import com.example.demo.entities.Product;
import com.example.demo.repositories.CalledRepository;

@Service
public class CalledService {
	
	@Autowired
	private CalledRepository repository;
	
	public List<Called> findAll(){
		return repository.findAll();
	}
	
	public Called findById(Long id) {
		Optional<Called> obj = repository.findById(id);
		return obj.get();
	}
	
	public Called save(Called obj) {
		return repository.save(obj);
	}
	
	public Called update(Long id, Called obj) {
		Called newCall = findById(id);
		newCall.setTitulo(obj.getTitulo());
		newCall.setDescricao(obj.getDescricao());
		newCall.setImgUrl(obj.getImgUrl());
		newCall.setDataChamado(obj.getDataChamado());
		newCall.setUser(obj.getUser());
		newCall.setProduct(obj.getProduct());
		return repository.save(newCall);
}
	
	public void delete(	Long id) {
		repository.deleteById(id);
	}
	

	public Called FromDTO(CalledDTO objDto) {
		return new Called(objDto.getId(), objDto.getTitulo(),objDto.getDescricao(), objDto.getImgUrl(), objDto.getDataChamado(), objDto.getUser(),objDto.getProduct());
	}
}
