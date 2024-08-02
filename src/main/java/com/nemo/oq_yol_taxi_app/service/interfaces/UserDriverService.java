package com.nemo.oq_yol_taxi_app.service.interfaces;

import com.nemo.oq_yol_taxi_app.model.requestDto.UserDriverRequest;
import com.nemo.oq_yol_taxi_app.model.responseDto.UserDriverResponse;
import com.nemo.oq_yol_taxi_app.payLoad.ApiResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserDriverService {
    ApiResponse save(UserDriverRequest user);
    List<UserDriverResponse> findAll();
    UserDriverResponse findById(Long id);
    ApiResponse update(UserDriverRequest userRequest, Long id);
    ApiResponse delete(Long id);
    String getClient(Long id);

}
