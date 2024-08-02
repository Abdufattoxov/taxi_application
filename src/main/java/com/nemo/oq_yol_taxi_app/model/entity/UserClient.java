package com.nemo.oq_yol_taxi_app.model.entity;

import com.nemo.oq_yol_taxi_app.model.enums.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserClient implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "name")
    @NotBlank(message = "Ismingizni kiriting")
    private String name;

    @Column(name = "surname")
    @NotBlank(message = "Familyangizni kiriting")
    private String surname;

    @Column(name = "phone_number", unique = true)
    @NotBlank(message = "Telefon raqamni kiriting")
    @Pattern(regexp = "^[0,9]{2}[0,9]{7}$")
    private String phoneNumber;

    @NotBlank(message = "Password must not be blank")
    @Size(min = 8, max = 12, message = "Kod eng kami 8 ta belgida iborat bo'lishi kerak")
    private String password;

    @Column(name = "role")
    private Role role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_"+role));
    }

    @Override
    public String getUsername() {
        return phoneNumber;
    }
}
