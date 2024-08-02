package com.nemo.oq_yol_taxi_app.model.entity;

import com.nemo.oq_yol_taxi_app.model.enums.Gender;
import com.nemo.oq_yol_taxi_app.model.enums.Role;
import jakarta.annotation.ManagedBean;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.List;

@Entity
@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class UserDriver implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "full_name")
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
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @OneToOne
    private Car car;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of( new SimpleGrantedAuthority("ROLE_"+role.name()));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return fullName;
    }
}
