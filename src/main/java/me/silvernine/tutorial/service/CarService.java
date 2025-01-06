package me.silvernine.tutorial.service;

import me.silvernine.tutorial.dto.CarRequest;
import me.silvernine.tutorial.dto.CarResponse;
import me.silvernine.tutorial.entity.Car;
import me.silvernine.tutorial.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;

    // 차량 등록
    public CarResponse registerCar(CarRequest request, Principal principal) {
        Car car = Car.builder()
                .carName(request.getCarName())
                .carNumber(request.getCarNumber())
                .ownerUsername(principal.getName())
                .build();
        Car savedCar = carRepository.save(car);

        return CarResponse.builder()
                .id(savedCar.getId())
                .carName(savedCar.getCarName())
                .carNumber(savedCar.getCarNumber())
                .ownerUsername(savedCar.getOwnerUsername())
                .build();
    }

    // 사용자 차량 목록 조회
    public List<CarResponse> getUserCars(Principal principal) {
        return carRepository.findByOwnerUsername(principal.getName()).stream()
                .map(car -> CarResponse.builder()
                        .id(car.getId())
                        .carName(car.getCarName())
                        .carNumber(car.getCarNumber())
                        .ownerUsername(car.getOwnerUsername())
                        .build())
                .collect(Collectors.toList());
    }

    // 차량 단건 조회
    public CarResponse getCarById(Long id) {
        Car car = carRepository.findById(id).orElseThrow(() -> new RuntimeException("Car not found"));
        return CarResponse.builder()
                .id(car.getId())
                .carName(car.getCarName())
                .carNumber(car.getCarNumber())
                .ownerUsername(car.getOwnerUsername())
                .build();
    }

    // 차량 전체 조회
    public List<CarResponse> getAllCars() {
        return carRepository.findAll().stream()
                .map(car -> CarResponse.builder()
                        .id(car.getId())
                        .carName(car.getCarName())
                        .carNumber(car.getCarNumber())
                        .ownerUsername(car.getOwnerUsername())
                        .build())
                .collect(Collectors.toList());
    }
}
