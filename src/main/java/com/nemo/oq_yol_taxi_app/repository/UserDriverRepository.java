package com.nemo.oq_yol_taxi_app.repository;

import com.nemo.oq_yol_taxi_app.model.entity.UserDriver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDriverRepository extends JpaRepository<UserDriver, Long> {
    Optional<UserDriver> findUserByPhoneNumber(String phoneNumber);
}
