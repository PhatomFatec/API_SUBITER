package com.example.demo.config;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.demo.entities.Called;
import com.example.demo.entities.Equipment;
import com.example.demo.entities.Product;
import com.example.demo.entities.Schedule;
import com.example.demo.entities.User;
import com.example.demo.repositories.CalledRepository;
import com.example.demo.repositories.EquipmentRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.repositories.ScheduleRepository;
import com.example.demo.repositories.UserRepository;

@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner {

	@Autowired
	private CalledRepository calledRepository;

	@Autowired
	private EquipmentRepository equipmentRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ScheduleRepository scheduleRepository;

	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {

		User u1 = new User(null, "bob@gmail.com", "fff", "SUPPORT", "23232323", "97979797", "Bob", "SEILAZINHO",
				"83787784");
		User u2 = new User(null, "asdb@gmail.com", "effefe", "CLIENT", "gggg", "464646", "Btere", "NUMSEI", "96586848");
		User u3 = new User(null, "FFF@gmail.com", "123", "ADMIN", "55555", "553535", "Gertrudes", "SURTO", "34234234");

		Product p1 = new Product(null, "seila", "9589658", "Barco", null, Instant.parse("2014-06-20T19:53:07Z"));

		Product p2 = new Product(null, "fiat", "9589658", "Barcao dos veio", null,
				Instant.parse("2014-06-20T19:53:07Z"));

		Called c1 = new Called(null, "problema", "no casco", "imagem.png", "em andamento", Instant.now(), u2, p2);
		Called c2 = new Called(null, "problema", "no casco", "imagem.png", "em andamento", Instant.now(), u1, p2);
		Called c3 = new Called(null, "problema", "no casco", "imagem.png", "em andamento", Instant.now(), u3, p1);

		Equipment e1 = new Equipment(null, "camera", Instant.now(), null, "nikon", "847587358", true);
		
		Schedule sc = new Schedule(null,"concerto","12h",null,"rua saitama", "sjc", "739262","sp",Instant.now());

		userRepository.save(u2);
		productRepository.save(p2);
		productRepository.save(p1);
		equipmentRepository.save(e1);
		calledRepository.save(c1);
		scheduleRepository.save(sc);
		
		
	
		
		

	}

}
