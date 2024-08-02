package com.nemo.oq_yol_taxi_app.model.responseDto;

import com.nemo.oq_yol_taxi_app.model.enums.Gender;
import com.nemo.oq_yol_taxi_app.model.enums.Role;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDriverResponse {
    private Long id;
    private String fullName;
    private String phoneNumber;
    private Gender gender;
    private Role role;
}
