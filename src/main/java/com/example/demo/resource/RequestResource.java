package com.example.demo.resource;

import java.io.IOException;
import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.dtos.RequestDTO;
import com.example.demo.entities.Image;
import com.example.demo.entities.Request;
import com.example.demo.services.ImageService;
import com.example.demo.services.RequestService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;

@CrossOrigin
@RestController
@RequestMapping(value = "/requests")
public class RequestResource {

	@Autowired
	private RequestService service;

	@Autowired
	private ImageService imgService;
	

	@ApiOperation(value = "", authorizations = { @Authorization(value = "Bearer") })
	@GetMapping
	public ResponseEntity<List<Request>> findAll() {
		List<Request> list = service.findAll();
		return ResponseEntity.ok().body(list);

	}

	@ApiOperation(value = "", authorizations = { @Authorization(value = "Bearer") })
	@GetMapping(value = "/{id}")
	public ResponseEntity<Request> findById(@PathVariable Long id) {
		Request user = service.findById(id);
		return ResponseEntity.ok().body(user);
	}

	@ApiOperation(value = "", authorizations = { @Authorization(value = "Bearer") })
	@PostMapping
	public ResponseEntity<Request> insertRequest(@RequestBody RequestDTO objDto) throws IOException {

		Request req = service.FromDTO(objDto);
		req = service.save(req);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(req.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@ApiOperation(value = "", authorizations = { @Authorization(value = "Bearer") })
	@PostMapping(value = "/upload/{id}")
	public Image insertImg(@RequestParam MultipartFile file, @PathVariable Long id) throws IOException {

		return imgService.addImg(file, id);
	}

	@ApiOperation(value = "", authorizations = { @Authorization(value = "Bearer") })
	@GetMapping(value = "/download/{id}")
	public ResponseEntity<Image> findImagById(@PathVariable Long id) {

		Image img = imgService.findImageById(id);
		return ResponseEntity.ok().body(img);

	}

	@ApiOperation(value = "", authorizations = { @Authorization(value = "Bearer") })
	@PutMapping(value = "/{id}")
	public ResponseEntity<Request> updateRequest(@PathVariable Long id, @RequestBody Request obj) {
		Request newRequest = service.update(id, obj);
		
		
		return ResponseEntity.ok().body(newRequest);
	}

	@ApiOperation(value = "", authorizations = { @Authorization(value = "Bearer") })
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
