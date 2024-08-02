package com.nemo.oq_yol_taxi_app.service.interfaces;

import com.nemo.oq_yol_taxi_app.model.requestDto.CarRequest;
import com.nemo.oq_yol_taxi_app.model.responseDto.CarResponse;
import com.nemo.oq_yol_taxi_app.payLoad.ApiResponse;

import java.util.List;

public interface CarService {
    ApiResponse createCar(CarRequest carRequest);

    ApiResponse update(CarRequest carRequest, Long id);
    ApiResponse delete(Long id);

    CarResponse getOne(Long id);
    List<CarResponse> getAll();

}
