package com.nemo.oq_yol_taxi_app.repository;

import com.nemo.oq_yol_taxi_app.model.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    Optional<Car> findCarByCarNumber(String carNumber);
}
