package com.example.weather.service;

import com.example.weather.model.WeatherInfo;
import com.example.weather.repository.WeatherRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.time.LocalDate;
import java.util.Optional;


@Service
public class WeatherService {
    private final WeatherRepository repository;
    private final RestTemplate restTemplate = new RestTemplate();

    public WeatherService(WeatherRepository repository) {
        this.repository = repository;
    }

    public WeatherInfo getWeatherInfo(String pincode, LocalDate date) {
        Optional<WeatherInfo> cachedInfo = repository.findByPincodeAndDate(pincode, date);
        if (cachedInfo.isPresent()) {
            return cachedInfo.get();
        }

        // Fetch Latitude/Longitude (Replace with actual API call)
        double lat = 18.5204;  // Example for Pune
        double lon = 73.8567;

        // Fetch Weather Data (Replace with actual API call)
        String weatherData = fetchWeatherFromAPI(lat, lon);

        WeatherInfo weatherInfo = new WeatherInfo();
        weatherInfo.setPincode(pincode);
        weatherInfo.setLatitude(lat);
        weatherInfo.setLongitude(lon);
        weatherInfo.setWeatherData(weatherData);
        weatherInfo.setDate(date);

        repository.save(weatherInfo);
        return weatherInfo;
    }

    private String fetchWeatherFromAPI(double lat, double lon) {
        String url = String.format(
            "https://api.openweathermap.org/data/2.5/weather?lat=%f&lon=%f&appid=YOUR_API_KEY", 
            lat, lon);
        return restTemplate.getForObject(url, String.class);
    }
}
