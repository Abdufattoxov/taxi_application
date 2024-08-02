package com.nemo.oq_yol_taxi_app.controller;

import com.nemo.oq_yol_taxi_app.model.requestDto.UserClientRequest;
import com.nemo.oq_yol_taxi_app.model.responseDto.UserClientResponse;
import com.nemo.oq_yol_taxi_app.payLoad.ApiResponse;
import com.nemo.oq_yol_taxi_app.service.service_imp.UserClientServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/v1/client")
public class UserClientController {
    private final UserClientServiceImp userClientServiceImp;

    @GetMapping("/{id}")
    public ResponseEntity<UserClientResponse> getOne(@PathVariable Long id) {
        return ResponseEntity.ok(userClientServiceImp.findOne(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserClientResponse>> getAll() {
        return ResponseEntity.ok(userClientServiceImp.findAll());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ApiResponse> updateClient(@RequestBody UserClientRequest clientRequest, @PathVariable Long id) {
        return ResponseEntity.ok(userClientServiceImp.update(clientRequest, id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse> deleteClient(@PathVariable Long id) {
        return ResponseEntity.ok(userClientServiceImp.delete(id));
    }
}
