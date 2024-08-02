package com.nemo.oq_yol_taxi_app.mapper;

import com.nemo.oq_yol_taxi_app.model.entity.Car;
import com.nemo.oq_yol_taxi_app.model.requestDto.CarRequest;
import com.nemo.oq_yol_taxi_app.model.responseDto.CarResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CarMapper {

    public Car mapCarRequestToCar(CarRequest carRequest) {
        return Car.builder()
                .driver(carRequest.getDriver())
                .carNumber(carRequest.getCarNumber())
                .model(carRequest.getModel())
                .licenceImage(carRequest.getLicenceImage())
                .cartype(carRequest.getCartype())
                .build();
    }

    public CarResponse mapCarToCarResponse(Car car) {
        return CarResponse.builder()
                .driver(car.getDriver())
                .model(car.getModel())
                .carNumber(car.getCarNumber())
                .build();
    }

    public List<CarResponse> mapCarsToCarResponse(List<Car> cars) {
        List<CarResponse> carResponses = cars.stream().map(this::mapCarToCarResponse).toList();
        return carResponses;
    }
}
