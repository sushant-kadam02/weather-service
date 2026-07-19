package com.sk.weather_service.controller;

import com.sk.weather_service.entity.Weather;
import com.sk.weather_service.service.CacheInspectionManager;
import com.sk.weather_service.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    WeatherService weatherService;

    @Autowired
    CacheInspectionManager cacheInspectionManager;

    @GetMapping
    public String getWeather(@RequestParam String city) {
        String weatherByCity = weatherService.getWeatherByCity(city);
        return weatherByCity;
    }

    @GetMapping("/cacheData")
    public String getCacheData(@RequestParam String cacheName) {
        return cacheInspectionManager.getCacheContents(cacheName);
    }

    @PostMapping
    public Weather addWeather(@RequestBody Weather weather) {
        return weatherService.addNewWeather(weather);
    }

    @GetMapping("/all")
    public List<Weather> getAllWeather() {
        return weatherService.getAllWeather();
    }

    @PutMapping("/{city}")
    public String updateWeather(@PathVariable String city, @RequestParam String updateWeather) {
                return weatherService.updateWeather(city, updateWeather);
    }

    @DeleteMapping("/{city}")
    public String deleteByCity(@PathVariable String city) {
        weatherService.deleteByCity(city);
        return city +" record deleted.";
    }
}
