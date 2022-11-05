package com.example.demo.services;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entities.Image;
import com.example.demo.repositories.ImageRepository;

@Service
public class ImageService {

	@Autowired
	private ImageRepository repository;
	
	@Autowired
	private RequestService reqService;
	
	
	@PreAuthorize("isAuthenticated()")
	public Image addImg(MultipartFile file, Long id) throws IOException {
		String fileName = file.getOriginalFilename();
		Image img = new Image(null, file.getBytes(),fileName, reqService.findById(id));
		return repository.save(img);
	}
	
	@PreAuthorize("isAuthenticated()")
	public List<Image> findAll(){
		return repository.findAll();
	}
	
	@PreAuthorize("hasAnyRole('ADMIN', 'SUPPORT')")
	public Image findImageById(Long id) {
		Optional<Image> obj = repository.findById(id);
		return obj.get();
	}
	
}
