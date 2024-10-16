package com.example.weather.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import java.time.LocalDate;

@Entity
public class WeatherInfo {
    @Id
    private String pincode;

    private double latitude;
    private double longitude;
    
    @Column(name = "weather_data", columnDefinition = "TEXT")
    private String weatherData;

    private LocalDate date;

    // Getters and Setters
}
