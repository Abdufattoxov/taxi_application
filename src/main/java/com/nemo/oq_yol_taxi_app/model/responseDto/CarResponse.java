package com.nemo.oq_yol_taxi_app.model.responseDto;

import com.nemo.oq_yol_taxi_app.model.entity.UserDriver;
import lombok.*;

import java.io.Serial;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CarResponse {
    private UserDriver driver;
    private String model;
    private String carNumber;
}
