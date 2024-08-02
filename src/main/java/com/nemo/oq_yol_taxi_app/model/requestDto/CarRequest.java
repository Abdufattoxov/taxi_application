package com.nemo.oq_yol_taxi_app.model.requestDto;

import com.nemo.oq_yol_taxi_app.model.entity.Images;
import com.nemo.oq_yol_taxi_app.model.entity.UserDriver;
import com.nemo.oq_yol_taxi_app.model.enums.CarType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class CarRequest {
    private UserDriver driver;
    private String model;
    private String carNumber;
    private Images licenceImage;
    @Enumerated(EnumType.STRING)
    private CarType cartype = CarType.STANDARD;
}
