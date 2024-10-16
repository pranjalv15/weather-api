package com.example.weather.controller;

import com.example.weather.model.WeatherInfo;
import com.example.weather.service.WeatherService;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;

@RestController
@RequestMapping("/api/weather")
public class WeatherController {
    private final WeatherService service;

    public WeatherController(WeatherService service) {
        this.service = service;
    }

    @GetMapping
    public WeatherInfo getWeather(
            @RequestParam String pincode,
            @RequestParam String for_date) {
        LocalDate date = LocalDate.parse(for_date);
        return service.getWeatherInfo(pincode, date);
    }
}
