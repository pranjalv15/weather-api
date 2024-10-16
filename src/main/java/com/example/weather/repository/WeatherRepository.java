package com.example.weather.repository;
import java.time.LocalDate;


import com.example.weather.model.WeatherInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface WeatherRepository extends JpaRepository<WeatherInfo, String> {
    Optional<WeatherInfo> findByPincodeAndDate(String pincode, LocalDate date);
}
