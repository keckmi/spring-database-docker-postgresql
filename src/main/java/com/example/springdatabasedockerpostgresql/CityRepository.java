package com.example.springdatabasedockerpostgresql;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository //Damit Spring sraus Kontext erzeugt, den wir in Bean reintun oder autowiren können
public interface CityRepository extends CrudRepository<City, Long> {

    //JPA Query Language
    //SELECT 1 From cities WHERE name = x
    City findByName(String name);
}
