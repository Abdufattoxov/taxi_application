package com.nemo.oq_yol_taxi_app.model.entity;

import com.nemo.oq_yol_taxi_app.model.enums.CarType;
import jakarta.persistence.*;
import lombok.*;

import java.awt.*;

@Entity
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private User driver;

    private String model;
    private String carNumber;

    @OneToOne
    private Images licenceImage;

    @Enumerated(EnumType.STRING)
    private CarType cartype = CarType.STANDARD;



}
