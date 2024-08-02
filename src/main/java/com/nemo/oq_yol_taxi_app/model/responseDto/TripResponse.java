package com.nemo.oq_yol_taxi_app.model.responseDto;

import com.nemo.oq_yol_taxi_app.model.entity.UserDriver;
import lombok.*;

import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TripResponse {

    private UserDriver driver;
    private String destinationRegion;
    private String destinationCity;
    private LocalDateTime departureTime;
    private Double pickupLatitude;
    private Double pickupLongitude;
    private Integer numberOfPassengers;
    private String passengerGender;
}
