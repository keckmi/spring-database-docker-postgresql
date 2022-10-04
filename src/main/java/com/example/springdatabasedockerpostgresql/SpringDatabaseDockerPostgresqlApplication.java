package com.example.springdatabasedockerpostgresql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class SpringDatabaseDockerPostgresqlApplication {

	//zu JPA Query Language
	//Repository initiieren in eine beliebeige Bean
	@RestController
	public class CityController {
		@Autowired
		CityRepository cityRepository;

		//nach Programmausführung einsehbar unter http://localhost:8080/berlin
		@GetMapping("/berlin")
		public City berlin() {
			return cityRepository.findByName("Berlin");
		}
		//nach Programmausführung einsehbar unter http://localhost:8080/duesseldorf
		@GetMapping("/duesseldorf")
		public City duesseldorf() {
			return cityRepository.findByName("Duesseldorf");
		}
		//nach Programmausführung einsehbar unter http://localhost:8080/winnenden
		@GetMapping("/winnenden")
		public City winnenden() {
			return cityRepository.findByName("Winnenden");
		}

	}

	public static void main(String[] args) {

		ConfigurableApplicationContext applicationContext =
				SpringApplication.run(SpringDatabaseDockerPostgresqlApplication.class, args);


		City berlin = new City();
		berlin.setName("Berlin");
		berlin.setCapital(true);

		City duesseldorf = new City();
		duesseldorf.setCapital(false);
		duesseldorf.setName("Duesseldorf");

		City winnenden = new City();
		winnenden.setCapital(false);
		winnenden.setName("Winnenden");

		CityRepository cityRepository = applicationContext.getBean(CityRepository.class);
		cityRepository.save(berlin);
		cityRepository.save(duesseldorf);
		cityRepository.save(winnenden);

	}

}
