package com.example.demo.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.dtos.CommentDTO;
import com.example.demo.entities.Comment;
import com.example.demo.services.CommentService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;

@CrossOrigin
@RestController
@RequestMapping(value = "/comments")
public class CommentResource {

	@Autowired
	private CommentService service;

	@ApiOperation(value = "", authorizations = { @Authorization(value = "Bearer") })
	@GetMapping
	public ResponseEntity<List<Comment>> findAll() {
		List<Comment> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@ApiOperation(value = "", authorizations = { @Authorization(value = "Bearer") })
	@PostMapping
	public ResponseEntity<Comment> insertComment(@RequestBody CommentDTO obj) {
		Comment comm = service.FromDTO(obj);
		comm = service.save(comm);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(comm.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@ApiOperation(value = "", authorizations = { @Authorization(value = "Bearer") })
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
