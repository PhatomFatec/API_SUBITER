package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.example.demo.dtos.CommentDTO;
import com.example.demo.entities.Comment;
import com.example.demo.repositories.CommentRepository;

@Service
public class CommentService {

	@Autowired
	private CommentRepository repository;

	@PreAuthorize("hasAnyRole('ADMIN', 'SUPPORT', 'CLIENT')")
	public List<Comment> findAll() {
		return repository.findAll();
	}

	@PreAuthorize("hasAnyRole('ADMIN', 'SUPPORT', 'CLIENT')")
	public Comment save(Comment obj) {
		return repository.save(obj);
	}

	@PreAuthorize("hasAnyRole('ADMIN', 'SUPPORT', 'CLIENT')")
	public void delete(Long id) {
		repository.deleteById(id);
	}

	public Comment FromDTO(CommentDTO objDto) {
		return new Comment(objDto.getId(), objDto.getComment(), objDto.getUser(),objDto.getRequest());
	}
}