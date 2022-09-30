package com.example.springdatabasedockerpostgresql;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository //Damit Spring sraus Kontext erzeugt, den wir in Bean reintun oder autowiren können
public interface CityRepository extends CrudRepository<City, Long> {
}
