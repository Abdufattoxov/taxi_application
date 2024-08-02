package com.nemo.oq_yol_taxi_app.model.requestDto;

import com.nemo.oq_yol_taxi_app.model.enums.Role;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserClientRequest {

    @NotBlank(message = "Ismingizni kiriting")
    private String name;

    @NotBlank(message = "Familyangizni kiriting")
    private String surname;

    @NotBlank(message = "Telefon raqamni kiriting")
    @Pattern(regexp = "^[0,9]{2}[0,9]{7}$")
    private String phoneNumber;

    @NotBlank(message = "Password must not be blank")
    @Size(min = 8, max = 12, message = "Kod eng kami 8 ta belgida iborat bo'lishi kerak")
    private String password;
}
