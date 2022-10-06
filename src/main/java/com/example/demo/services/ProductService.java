package com.example.demo.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dtos.ProductDTO;
import com.example.demo.entities.Product;
import com.example.demo.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;

	public List<Product> findAll() {
		return repository.findAll();
	}

	public Product findById(Long id) {
		Optional<Product> obj = repository.findById(id);
		return obj.get();
	}

	public Product save(Product obj) {
		return repository.save(obj);
	}

	public Product update(Long id, Product obj) {
		Product newProd = findById(id);
		newProd.setModelo(obj.getModelo());
		newProd.setNumeroDeSerie(obj.getNumeroDeSerie());
		newProd.setDescricao(obj.getDescricao());
		newProd.setDataFabricacao(obj.getDataFabricacao());
		return repository.save(newProd);
}

	public void delete(Long id) {
		repository.deleteById(id);
	}

	public Product FromDTO(ProductDTO objDto) {
		return new Product(objDto.getId(), objDto.getModelo(), objDto.getNumeroDeSerie(), objDto.getDescricao(),
				objDto.getDataFabricacao(), objDto.getDataCadastro());
	}

}
