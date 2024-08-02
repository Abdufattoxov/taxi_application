package com.nemo.oq_yol_taxi_app.model.responseDto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserClientResponse {
    private String name;
    private String surname;
    private String phoneNumber;
}
