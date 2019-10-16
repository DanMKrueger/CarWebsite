package com.collabera.motors.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.collabera.motors.model.Car;

public interface CarRepository extends JpaRepository<Car, Integer>{

}
