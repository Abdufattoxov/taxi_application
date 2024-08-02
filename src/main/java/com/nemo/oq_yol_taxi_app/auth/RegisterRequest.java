package com.nemo.oq_yol_taxi_app.auth;

import com.nemo.oq_yol_taxi_app.model.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private String fullName;
    private String password;
    private String phoneNumber;
    private Gender gender;

}
