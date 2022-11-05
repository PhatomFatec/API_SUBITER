package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.example.demo.dtos.RequestDTO;
import com.example.demo.entities.Request;
import com.example.demo.repositories.RequestRepository;

@Service
public class RequestService {

	@Autowired
	private RequestRepository repository;

	@PreAuthorize("isAuthenticated()")
	public List<Request> findAll() {
		return repository.findAll();
	}

	@PreAuthorize("hasAnyRole('ADMIN', 'SUPPORT')")
	public Request findById(Long id) {
		Optional<Request> obj = repository.findById(id);
		return obj.get();
	}

	@PreAuthorize("isAuthenticated()")
	public Request save(Request obj) {
		return repository.save(obj);
	}

	@PreAuthorize("isAuthenticated()")
	public Request update(Long id, Request obj) {
		Request newRequest = findById(id);
		newRequest.setTitle(obj.getTitle());
		newRequest.setDescription(obj.getDescription());
		newRequest.setImgUrl(obj.getImgUrl());
		newRequest.setStatus(obj.getStatus());
		newRequest.setRequestDate(obj.getRequestDate());
		newRequest.setUser(obj.getUser());
		newRequest.setProduct(obj.getProduct());
		return repository.save(newRequest);
	}

	@PreAuthorize("isAuthenticated()")
	public void delete(Long id) {
		repository.deleteById(id);
	}
	

	public Request FromDTO(RequestDTO objDto) {
		return new Request(objDto.getId(), objDto.getTitle(), objDto.getDescription(), objDto.getImgUrl(),
				objDto.getStatus(), objDto.getUser(), objDto.getProduct());
	}
}
