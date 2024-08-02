package com.nemo.oq_yol_taxi_app.repository;

import com.nemo.oq_yol_taxi_app.model.entity.UserClient;
import com.nemo.oq_yol_taxi_app.model.responseDto.UserClientResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserClientRepository extends JpaRepository<UserClient, Long> {
    Optional<UserClient> findByPhoneNumber(String phoneNumber);
}
