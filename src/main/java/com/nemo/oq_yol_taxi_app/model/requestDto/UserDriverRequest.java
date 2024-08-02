package com.nemo.oq_yol_taxi_app.model.requestDto;

import com.nemo.oq_yol_taxi_app.model.entity.Car;
import com.nemo.oq_yol_taxi_app.model.enums.Gender;
import com.nemo.oq_yol_taxi_app.model.enums.Role;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDriverRequest {
    @NotBlank(message = "Ism familiyangizni kiriting")
    private String fullName;

    @NotBlank(message = "Jinsingizni tanlang")
    private Gender gender;

    @NotBlank(message = "Telefon raqamingizni kiriting")
    @Pattern(regexp = "^\\d{2}\\d{7}$")
    private String phoneNumber;

    @NotBlank(message = "Kodni kiriting")
    @Size(min = 8, max = 12, message = "Kod eng kami 8 ta belgidan tashkil topgan bo'lishi kereak")
    private String password;

    @NotBlank
    private Role role;
    @NotBlank
    private Car car;
}
