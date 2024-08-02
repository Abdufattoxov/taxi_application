package com.nemo.oq_yol_taxi_app.model.entity;

import com.nemo.oq_yol_taxi_app.model.enums.CarType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "trips")
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private UserDriver driver;
    private String destinationRegion;
    private String destinationCity;
    private LocalDateTime departureTime;
    private Double pickupLatitude;
    private Double pickupLongitude;
    private Integer numberOfPassengers;
    private String passengerGender;
    private CarType carType = CarType.STANDARD;
}
