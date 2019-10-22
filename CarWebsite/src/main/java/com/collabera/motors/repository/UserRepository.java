package com.collabera.motors.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.collabera.motors.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
