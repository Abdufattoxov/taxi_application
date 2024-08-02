package com.nemo.oq_yol_taxi_app.service.service_imp;

import com.nemo.oq_yol_taxi_app.exceptions.CustomNotFoundException;
import com.nemo.oq_yol_taxi_app.mapper.UserMapper;
import com.nemo.oq_yol_taxi_app.model.entity.UserClient;
import com.nemo.oq_yol_taxi_app.model.requestDto.UserClientRequest;
import com.nemo.oq_yol_taxi_app.model.responseDto.UserClientResponse;
import com.nemo.oq_yol_taxi_app.payLoad.ApiResponse;
import com.nemo.oq_yol_taxi_app.repository.UserClientRepository;
import com.nemo.oq_yol_taxi_app.service.interfaces.UserClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserClientServiceImp implements UserClientService {
    private final UserClientRepository userClientRepository;
    private final PasswordEncoder encoder;
    private final UserMapper mapper;

    @Override
    public ApiResponse save(UserClientRequest userClientRequest) {
        Optional<UserClient> userClient = userClientRepository.findByPhoneNumber(userClientRequest.getPhoneNumber());
        if (userClient.isEmpty()) {
            return new ApiResponse("User is already exist", HttpStatus.CONFLICT);
        }
        UserClient user = mapper.mapToUserClient(userClientRequest);
        userClientRepository.save(user);
        return new ApiResponse("User is saved", HttpStatus.CREATED);
    }

    @Override
    public ApiResponse update(UserClientRequest userClientRequest, Long id) {
        Optional<UserClient> byId = userClientRepository.findById(id);
        if (byId.isEmpty()) {
            return new ApiResponse("User is not exist with id: " + id, HttpStatus.NOT_FOUND);
        }
        UserClient user = byId.get();
        user.setName(userClientRequest.getName());
        user.setSurname(userClientRequest.getSurname());
        user.setPhoneNumber(userClientRequest.getPhoneNumber());
        user.setPassword(encoder.encode(userClientRequest.getPassword()));

        userClientRepository.save(user);
        return new ApiResponse("User is updated successfully", HttpStatus.OK);
    }

    @Override
    public UserClientResponse findOne(Long id) {
        UserClient user = userClientRepository.findById(id).orElseThrow(() -> new CustomNotFoundException("User not found"));
        return mapper.maptoUserClientResponse(user);
    }

    @Override
    public ApiResponse delete(Long id) {
        if (userClientRepository.existsById(id)) {
            userClientRepository.deleteById(id);
            return new ApiResponse("User is deleted", HttpStatus.OK);
        }
        throw new CustomNotFoundException("User not found");
    }

    @Override
    public List<UserClientResponse> findAll() {
        List<UserClient> all = userClientRepository.findAll();
        return mapper.mapToUserClientResponseList(all);
    }
}
