package com.example.demo.config;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.demo.entities.AcessType;
import com.example.demo.entities.Called;
import com.example.demo.entities.Product;
import com.example.demo.entities.UserAdmin;
import com.example.demo.entities.UserCommonClient;
import com.example.demo.entities.UserCorpClient;
import com.example.demo.repositories.CalledRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.repositories.UserAdminRepository;
import com.example.demo.repositories.UserCommonClientRepository;
import com.example.demo.repositories.UserCorpClientRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserAdminRepository userAdminRepository;

	@Autowired
	private UserCommonClientRepository userCommonClientRepository;

	@Autowired
	private UserCorpClientRepository userCorpRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CalledRepository calledRepository;

	@Override
	public void run(String... args) throws Exception {
		UserCommonClient u1 = new UserCommonClient(null, "bob@gmail.com", "fff", AcessType.ADMIN, "23232323", "97979797", "Bob");
		UserAdmin u2 = new UserAdmin(null, "asdb@gmail.com", "effefe", AcessType.CLIENT, "gggg", "464646", "Btere");
		UserCorpClient userCorp1 = new UserCorpClient(null, "FFF@gmail.com", "123", AcessType.SUPPORT, "55555", "553535", "Gertrudes",
				"gertrudes comercio", "34234234");


		Product p1 = new Product(null, "Vw", "4g4535dd", "Barcao dos novo", Instant.parse("2019-06-20T19:53:07Z"),
				Instant.now(), u1);

		Called c1 = new Called(null, "BO", "bo no casco do barcao", "imagem.png", Instant.now(), u1, p1);
		
		
		
		userCorpRepository.save(userCorp1);
		userCommonClientRepository.save(u1);
		userAdminRepository.save(u2);
		productRepository.save(p1);
		calledRepository.save(c1);

	}

}
