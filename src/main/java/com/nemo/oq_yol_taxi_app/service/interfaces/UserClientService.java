package com.nemo.oq_yol_taxi_app.service.interfaces;

import com.nemo.oq_yol_taxi_app.model.requestDto.UserClientRequest;
import com.nemo.oq_yol_taxi_app.model.responseDto.UserClientResponse;
import com.nemo.oq_yol_taxi_app.payLoad.ApiResponse;

import java.util.List;

public interface UserClientService {
    ApiResponse save(UserClientRequest userClientRequest);
    ApiResponse update(UserClientRequest userClientRequest, Long id);
    UserClientResponse findOne(Long id);
    ApiResponse delete(Long id);
    List<UserClientResponse> findAll();
}
