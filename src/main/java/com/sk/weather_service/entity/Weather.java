package com.sk.weather_service.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("weather")
public class Weather {

    @Id
    private String id;
    private String city;
    private String forecast;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getForecast() {
        return forecast;
    }

    public void setForecast(String forecast) {
        this.forecast = forecast;
    }

    public Weather(String id, String city, String forecast) {
        this.id = id;
        this.city = city;
        this.forecast = forecast;
    }

    public Weather() {}

}
