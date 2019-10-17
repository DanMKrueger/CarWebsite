package com.collabera.motors.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.collabera.motors.model.Manufacturer;

public interface ManufacturerRepository extends JpaRepository<Manufacturer, Integer>{

}
