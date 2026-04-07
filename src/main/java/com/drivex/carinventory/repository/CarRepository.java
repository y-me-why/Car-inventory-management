package com.drivex.carinventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.drivex.carinventory.model.Car;

public interface CarRepository extends JpaRepository<Car, Long> {

}
