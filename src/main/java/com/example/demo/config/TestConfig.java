package com.example.demo.config;

import java.time.Instant;
import java.util.Arrays;

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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

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
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		User u1 = new User(null, "bob@gmail.com", encoder.encode("fff"), "ROLE_SUPPORT", "23232323", "97979797", "Bob",
				"SEILAZINHO", "83787784");
		User u2 = new User(null, "asdb@gmail.com", encoder.encode("effefe"), "ROLE_CLIENT", "gggg", "464646", "Btere",
				"NUMSEI", "96586848");
		User u3 = new User(null, "test@gmail.com", encoder.encode("123"), "ROLE_ADMIN", "55555", "553535", "Gertrudes",
				"SURTO", "34234234");

		Product p1 = new Product(null, "seila", "9589658", "Barco", null, Instant.parse("2014-06-20T19:53:07Z"));

		Product p2 = new Product(null, "fiat", "9589658", "Barcao dos veio", null,
				Instant.parse("2014-06-20T19:53:07Z"));

		Equipment e1 = new Equipment(null, "camera", Instant.now(), null, "nikon", "847587358", true);

		userRepository.saveAll(Arrays.asList(u1, u2, u3));
		productRepository.saveAll(Arrays.asList(p1, p2));
		equipmentRepository.save(e1);
		Called c1 = new Called(null, null, null, null, null, null, u2, p1);
		calledRepository.save(c1);
		//Schedule sc1 = new Schedule(null, null, null, null, null, null, null, null, null, c1);
		//scheduleRepository.save(sc1);
		//sc1.setCalled(c1);
		//calledRepository.save(c1);
		

	}

}
