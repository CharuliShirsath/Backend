package com.example.repository;

import com.example.model.AdminRegister;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<AdminRegister, Long> {
    AdminRegister findByUsername(String username);
}
