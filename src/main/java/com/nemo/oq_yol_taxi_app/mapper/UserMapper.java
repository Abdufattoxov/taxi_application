package com.nemo.oq_yol_taxi_app.mapper;

import com.nemo.oq_yol_taxi_app.model.entity.UserClient;
import com.nemo.oq_yol_taxi_app.model.entity.UserDriver;
import com.nemo.oq_yol_taxi_app.model.enums.Role;
import com.nemo.oq_yol_taxi_app.model.requestDto.UserClientRequest;
import com.nemo.oq_yol_taxi_app.model.responseDto.UserClientResponse;
import com.nemo.oq_yol_taxi_app.model.responseDto.UserDriverResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class UserMapper {
    private final PasswordEncoder encoder;
    public UserDriverResponse mapToUserDriverResponse(UserDriver user){
        return UserDriverResponse.builder()
                .id(user.getId())
                .fullName(user.getFullName())
                .phoneNumber(user.getPhoneNumber())
                .gender(user.getGender())
                .role(user.getRole())
                .build();
    }


    public List<UserDriverResponse>  mapToUserDriverResponseDtoList(List<UserDriver> users){
        if(users.isEmpty()){
            return Collections.emptyList();
        }
        return users.stream()
                .map(this::mapToUserDriverResponse)
                .collect(Collectors.toList());
    }


    //UserClient Class
    public UserClient mapToUserClient(UserClientRequest userClientRequest) {
        return UserClient.builder()
                .name(userClientRequest.getName())
                .surname(userClientRequest.getSurname())
                .phoneNumber(userClientRequest.getPhoneNumber())
                .password(encoder.encode(userClientRequest.getPassword()))
                .role(Role.CLIENT)
                .build();
    }

    public UserClientResponse maptoUserClientResponse(UserClient user) {
        return UserClientResponse.builder()
                .name(user.getName())
                .surname(user.getSurname())
                .phoneNumber(user.getPhoneNumber())
                .build();
    }

    public List<UserClientResponse> mapToUserClientResponseList(List<UserClient> all) {
        return all.stream()
                .map(this::maptoUserClientResponse)
                .collect(Collectors.toList());
    }
}
