//Business Logic Here
package com.drivex.carinventory.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.drivex.carinventory.model.Car;
import com.drivex.carinventory.repository.CarRepository;

@Service
public class CarService {

    private final CarRepository carRepository;

    // Constructor Injection (BEST PRACTICE)
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    // Get all cars
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    // Save new car
    public Car saveCar(Car car) {
        return carRepository.save(car);
    }

    // Get car by id
    public Car getCarById(Long id) {
        return carRepository.findById(id).orElse(null);
    }

    // Delete car
    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }
    
 // Total number of cars
    public long getTotalCars() {
        return carRepository.count();
    }

    // Total inventory value
    public double getTotalInventoryValue() {
        return carRepository.findAll()
                .stream()
                .mapToDouble(Car::getPrice)
                .sum();
    }

    // Average car price
    public double getAveragePrice() {
        return carRepository.findAll()
                .stream()
                .mapToDouble(Car::getPrice)
                .average()
                .orElse(0);
    }

}



