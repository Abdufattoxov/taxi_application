package com.nemo.oq_yol_taxi_app.service.service_imp;

import com.nemo.oq_yol_taxi_app.exceptions.CustomAlreadyExistException;
import com.nemo.oq_yol_taxi_app.exceptions.CustomNotFoundException;
import com.nemo.oq_yol_taxi_app.mapper.CarMapper;
import com.nemo.oq_yol_taxi_app.model.entity.Car;
import com.nemo.oq_yol_taxi_app.model.requestDto.CarRequest;
import com.nemo.oq_yol_taxi_app.model.responseDto.CarResponse;
import com.nemo.oq_yol_taxi_app.payLoad.ApiResponse;
import com.nemo.oq_yol_taxi_app.repository.CarRepository;
import com.nemo.oq_yol_taxi_app.service.interfaces.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class CarServiceImp implements CarService {
    private final CarRepository carRepository;
    private final CarMapper carMapper;

    @Override
    public ApiResponse createCar(CarRequest carRequest) {
        Optional<Car> car = carRepository.findCarByCarNumber(carRequest.getCarNumber());
        if (car.isPresent()) {
            throw new CustomAlreadyExistException("Car already exist with this number: " + carRequest.getCarNumber());
        }
            Car savingCar = carMapper.mapCarRequestToCar(carRequest);
            carRepository.save(savingCar);
            return new ApiResponse("Car is saved", HttpStatus.CREATED);

    }


    @Override
    public ApiResponse update(CarRequest carRequest, Long id) {
        Optional<Car> car = carRepository.findById(id);
        if(car.isEmpty()){
            throw new CustomNotFoundException("Car not found with this id: "+id);
        }
        Car savingCar = carMapper.mapCarRequestToCar(carRequest);
        carRepository.save(savingCar);

        return new ApiResponse("Car is updated successfully", HttpStatus.OK);
    }

    @Override
    public ApiResponse delete(Long id) {
        Optional<Car> car = carRepository.findById(id);
        if(car.isEmpty()){
            throw new CustomNotFoundException("Car not found with this id: "+id);
        }
        carRepository.deleteById(id);
        return new ApiResponse("Car is deleted successfully", HttpStatus.NO_CONTENT);
    }

    @Override
    public CarResponse getOne(Long id) {
        Optional<Car> existCar = carRepository.findById(id);
        if(existCar.isEmpty()){
            throw new CustomNotFoundException("Car not found with this id: "+id);
        }
        CarResponse carResponse = carMapper.mapCarToCarResponse(existCar.get());
        return carResponse;
    }

    @Override
    public List<CarResponse> getAll() {
        List<Car> cars = carRepository.findAll();
        List<CarResponse>  carsResponse = carMapper.mapCarsToCarResponse(cars);
        return carsResponse;
    }
}
