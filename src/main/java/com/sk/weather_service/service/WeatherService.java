package com.sk.weather_service.service;


import com.sk.weather_service.entity.Weather;
import com.sk.weather_service.repository.WeatherRepository;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WeatherService {

    private final WeatherRepository weatherRepository;

    public WeatherService(WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
    }


    @Cacheable(value = "weather", key = "#city")
    public String getWeatherByCity(String city) {
        System.out.println("Fetching weather for city : "+city);
        Optional<Weather> weather = weatherRepository.findByCity(city);
        return weather.map(Weather::getForecast).orElse("Weather data not available for city : "+city);
    }

    public Weather addNewWeather(Weather weather) {
        return weatherRepository.save(weather);
    }

    public List<Weather> getAllWeather() {
        return weatherRepository.findAll();
    }

    @CachePut(value = "weather", key = "#city")
    public String updateWeather(String city, String updateWeather) {
        weatherRepository.findByCity(city).ifPresent(x -> {
            x.setForecast(updateWeather);
            weatherRepository.save(x);
        });
        return updateWeather;
    }
}
