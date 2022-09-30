package com.example.springdatabasedockerpostgresql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringDatabaseDockerPostgresqlApplication {

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
