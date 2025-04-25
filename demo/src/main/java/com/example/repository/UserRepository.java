package com.example.repository;

import com.example.model.UserRegister;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserRegister, Long> {
    UserRegister findByEmail(String email);
    UserRegister findByUsername(String username);
}
