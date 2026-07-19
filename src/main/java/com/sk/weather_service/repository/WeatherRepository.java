package com.sk.weather_service.repository;

import com.sk.weather_service.entity.Weather;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WeatherRepository extends MongoRepository<Weather, Long> {


    Optional<Weather> findByCity(String city);
}
