package com.nemo.oq_yol_taxi_app.service.service_imp;

import com.nemo.oq_yol_taxi_app.exceptions.CustomNotFoundException;
import com.nemo.oq_yol_taxi_app.mapper.UserMapper;
import com.nemo.oq_yol_taxi_app.model.entity.UserDriver;
import com.nemo.oq_yol_taxi_app.model.requestDto.UserDriverRequest;
import com.nemo.oq_yol_taxi_app.model.responseDto.UserDriverResponse;
import com.nemo.oq_yol_taxi_app.payLoad.ApiResponse;
import com.nemo.oq_yol_taxi_app.repository.UserDriverRepository;
import com.nemo.oq_yol_taxi_app.service.interfaces.UserDriverService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserDriverServiceImp implements UserDriverService {

    private final UserDriverRepository userRepository;
    private final PasswordEncoder encoder;
    private final UserMapper mappers;

    @Override
    public ApiResponse save(UserDriverRequest user) {
        Optional<UserDriver> userByPhoneNumber = userRepository.findUserByPhoneNumber(user.getPhoneNumber());
        if (userByPhoneNumber.isPresent()) {
            return new ApiResponse("User is already exist", HttpStatus.CONFLICT);
        }
        userRepository.save(
                UserDriver.builder()
                        .fullName(user.getFullName())
                        .gender(user.getGender())
                        .phoneNumber(user.getPhoneNumber())
                        .password(encoder.encode(user.getPassword()))
                        .role(user.getRole())
                        .build()
        );
        return new ApiResponse("User is saved", HttpStatus.CREATED);
    }

    @Override
    public List<UserDriverResponse> findAll() {
        List<UserDriver> all = userRepository.findAll();
        return mappers.mapToUserDriverResponseDtoList(all);

    }

    @Override
    public UserDriverResponse findById(Long id) {
        Optional<UserDriver> byId = userRepository.findById(id);
        if (byId.isEmpty()) {
            throw new CustomNotFoundException("User not found");
        }
        UserDriver user = byId.get();
        return mappers.mapToUserDriverResponse(user);

    }

    @Override
    public ApiResponse update(UserDriverRequest userRequest, Long id) {
        Optional<UserDriver> oldUser = userRepository.findById(id);
        if (oldUser.isEmpty()) {
            throw new CustomNotFoundException("User not found");
        }
        UserDriver user = oldUser.get();
        user.setFullName(userRequest.getFullName());
        user.setPhoneNumber(userRequest.getPhoneNumber());
        user.setGender(userRequest.getGender());
        return new ApiResponse("User is updated", HttpStatus.OK);
    }


    @Override
    public ApiResponse delete(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return new ApiResponse("User is deleted", HttpStatus.OK);
        }
        throw new CustomNotFoundException("User not found");
    }

    @Override
    public String getClient(Long clientId) {
        return null;
    }


}
