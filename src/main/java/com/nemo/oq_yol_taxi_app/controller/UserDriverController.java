package com.nemo.oq_yol_taxi_app.controller;

import com.nemo.oq_yol_taxi_app.model.requestDto.UserDriverRequest;
import com.nemo.oq_yol_taxi_app.model.responseDto.UserDriverResponse;
import com.nemo.oq_yol_taxi_app.payLoad.ApiResponse;
import com.nemo.oq_yol_taxi_app.service.service_imp.UserDriverServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("api/v1/driver")
public class UserDriverController {
    private final UserDriverServiceImp userDriverServiceImp;

    @GetMapping("/{id}")
    public ResponseEntity<UserDriverResponse> getDriver(@PathVariable Long id) {
        return ResponseEntity.ok(userDriverServiceImp.findById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserDriverResponse>> getAll() {
        return ResponseEntity.ok(userDriverServiceImp.findAll());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ApiResponse> updateDriver(@PathVariable Long id, @RequestBody UserDriverRequest driverRequest) {
        return ResponseEntity.ok(userDriverServiceImp.update(driverRequest, id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse> deleteDriver(@PathVariable Long id){
        return ResponseEntity.ok(userDriverServiceImp.delete(id));
    }




}
