package me.silvernine.tutorial.controller;

import me.silvernine.tutorial.dto.CarRequest;
import me.silvernine.tutorial.dto.CarResponse;
import me.silvernine.tutorial.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/cars")
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;

    // 차량 등록
    @PostMapping
    public ResponseEntity<CarResponse> registerCar(@RequestBody CarRequest request, Principal principal) {
        return ResponseEntity.ok(carService.registerCar(request, principal));
    }

    // 사용자 차량 목록 조회
    @GetMapping("/user")
    public ResponseEntity<List<CarResponse>> getUserCars(Principal principal) {
        return ResponseEntity.ok(carService.getUserCars(principal));
    }

    // 차량 단건 조회
    @GetMapping("/{id}")
    public ResponseEntity<CarResponse> getCarById(@PathVariable Long id) {
        return ResponseEntity.ok(carService.getCarById(id));
    }

    // 차량 전체 조회
    @GetMapping
    public ResponseEntity<List<CarResponse>> getAllCars() {
        return ResponseEntity.ok(carService.getAllCars());
    }
}
